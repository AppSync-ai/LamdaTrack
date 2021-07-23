package com.mt.lamdatrack.Rate.helper;

import com.mt.lamdatrack.Rate.internal.StringUtil;
import com.mt.lamdatrack.Rate.nodes.Attribute;
import com.mt.lamdatrack.Rate.nodes.Attributes;
import com.mt.lamdatrack.Rate.select.NodeTraversor;
import com.mt.lamdatrack.Rate.select.NodeVisitor;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import androidx.annotation.Nullable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import java.util.regex.Pattern;

import static javax.xml.transform.OutputKeys.METHOD;

/**
 * Helper class to transform a {@link com.mt.lamdatrack.Rate.nodes.Document} to a {@link Document org.w3c.dom.Document},
 * for integration with toolsets that use the W3C DOM.
 */
public class W3CDom {
    protected DocumentBuilderFactory factory;

    public W3CDom() {
        factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
    }

    /**
     * Converts a jsoup DOM to a W3C DOM
     *
     * @param in jsoup Document
     * @return W3C Document
     */
    public static Document convert(com.mt.lamdatrack.Rate.nodes.Document in) {
        return (new W3CDom().fromJsoup(in));
    }

    /**
     * Serialize a W3C document to a String. Provide Properties to define output settings including if HTML or XML. If
     * you don't provide the properties ({@code null}), the output will be auto-detected based on the content of the
     * document.
     *
     * @param doc Document
     * @param properties (optional/nullable) the output properties to use. See {@link
     *     Transformer#setOutputProperties(Properties)} and {@link OutputKeys}
     * @return Document as string
     * @see #OutputHtml
     * @see #OutputXml
     * @see OutputKeys#ENCODING
     * @see OutputKeys#OMIT_XML_DECLARATION
     * @see OutputKeys#STANDALONE
     * @see OutputKeys#STANDALONE
     * @see OutputKeys#DOCTYPE_PUBLIC
     * @see OutputKeys#DOCTYPE_PUBLIC
     * @see OutputKeys#CDATA_SECTION_ELEMENTS
     * @see OutputKeys#INDENT
     * @see OutputKeys#MEDIA_TYPE
     */
    public static String asString(Document doc, @Nullable Map<String, String> properties) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            if (properties != null)
                transformer.setOutputProperties(propertiesFromMap(properties));

            if (doc.getDoctype() != null) {
                DocumentType doctype = doc.getDoctype();
                if (!StringUtil.isBlank(doctype.getPublicId()))
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
                if (!StringUtil.isBlank(doctype.getSystemId()))
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());
                    // handle <!doctype html> for legacy dom. TODO: nicer if <!doctype html>
                else if (doctype.getName().equalsIgnoreCase("html")
                    && StringUtil.isBlank(doctype.getPublicId())
                    && StringUtil.isBlank(doctype.getSystemId()))
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "about:legacy-compat");
            }

            transformer.transform(domSource, result);
            return writer.toString();

        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }

    static Properties propertiesFromMap(Map<String, String> map) {
        Properties props = new Properties();
        props.putAll(map);
        return props;
    }

    /** Canned default for HTML output. */
    public static HashMap<String, String> OutputHtml() {
        return methodMap("html");
    }

    /** Canned default for XML output. */
    public static HashMap<String, String> OutputXml() {
        return methodMap("xml");
    }

    private static HashMap<String, String> methodMap(String method) {
        HashMap<String, String> map = new HashMap<>();
        map.put(METHOD, method);
        return map;
    }

    /**
     * Convert a jsoup Document to a W3C Document.
     *
     * @param in jsoup doc
     * @return w3c doc
     */
    public Document fromJsoup(com.mt.lamdatrack.Rate.nodes.Document in) {
        Validate.notNull(in);
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            DOMImplementation impl = builder.getDOMImplementation();
            Document out;

            out = builder.newDocument();
            com.mt.lamdatrack.Rate.nodes.DocumentType doctype = in.documentType();
            if (doctype != null) {
                DocumentType documentType = impl.createDocumentType(doctype.name(), doctype.publicId(), doctype.systemId());
                out.appendChild(documentType);
            }
            out.setXmlStandalone(true);

            convert(in, out);
            return out;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Converts a jsoup document into the provided W3C Document. If required, you can set options on the output document
     * before converting.
     *
     * @param in jsoup doc
     * @param out w3c doc
     * @see com.mt.lamdatrack.Rate.helper.W3CDom#fromJsoup(com.mt.lamdatrack.Rate.nodes.Document)
     */
    public void convert(com.mt.lamdatrack.Rate.nodes.Document in, Document out) {
        if (!StringUtil.isBlank(in.location()))
            out.setDocumentURI(in.location());

        com.mt.lamdatrack.Rate.nodes.Element rootEl = in.child(0); // skip the #root node
        NodeTraversor.traverse(new W3CBuilder(out), rootEl);
    }

    /**
     * Serialize a W3C document to a String. The output format will be XML or HTML depending on the content of the doc.
     *
     * @param doc Document
     * @return Document as string
     * @see W3CDom#asString(Document, Map)
     */
    public String asString(Document doc) {
        return asString(doc, null);
    }

    /**
     * Implements the conversion by walking the input.
     */
    protected static class W3CBuilder implements NodeVisitor {
        private static final String xmlnsKey = "xmlns";
        private static final String xmlnsPrefix = "xmlns:";

        private final Document doc;
        private final Stack<HashMap<String, String>> namespacesStack = new Stack<>(); // stack of namespaces, prefix => urn
        private Node dest;

        public W3CBuilder(Document doc) {
            this.doc = doc;
            this.namespacesStack.push(new HashMap<>());
            this.dest = doc;
        }

        public void head(com.mt.lamdatrack.Rate.nodes.Node source, int depth) {
            namespacesStack.push(new HashMap<>(namespacesStack.peek())); // inherit from above on the stack
            if (source instanceof com.mt.lamdatrack.Rate.nodes.Element) {
                com.mt.lamdatrack.Rate.nodes.Element sourceEl = (com.mt.lamdatrack.Rate.nodes.Element) source;

                String prefix = updateNamespaces(sourceEl);
                String namespace = namespacesStack.peek().get(prefix);
                String tagName = sourceEl.tagName();

                /* Tag names in XML are quite, but less, permissive than HTML. Rather than reimplement the validation,
                we just try to use it as-is. If it fails, insert as a text node instead. We don't try to normalize the
                tagname to something safe, because that isn't going to be meaningful downstream. This seems(?) to be
                how browsers handle the situation, also. https://github.com/jhy/jsoup/issues/1093 */
                try {
                    Element el = namespace == null && tagName.contains(":") ?
                        doc.createElementNS("", tagName) : // doesn't have a real namespace defined
                        doc.createElementNS(namespace, tagName);
                    copyAttributes(sourceEl, el);
                    dest.appendChild(el);
                    dest = el; // descend
                } catch (DOMException e) {
                    dest.appendChild(doc.createTextNode("<" + tagName + ">"));
                }
            } else if (source instanceof com.mt.lamdatrack.Rate.nodes.TextNode) {
                com.mt.lamdatrack.Rate.nodes.TextNode sourceText = (com.mt.lamdatrack.Rate.nodes.TextNode) source;
                Text text = doc.createTextNode(sourceText.getWholeText());
                dest.appendChild(text);
            } else if (source instanceof com.mt.lamdatrack.Rate.nodes.Comment) {
                com.mt.lamdatrack.Rate.nodes.Comment sourceComment = (com.mt.lamdatrack.Rate.nodes.Comment) source;
                Comment comment = doc.createComment(sourceComment.getData());
                dest.appendChild(comment);
            } else if (source instanceof com.mt.lamdatrack.Rate.nodes.DataNode) {
                com.mt.lamdatrack.Rate.nodes.DataNode sourceData = (com.mt.lamdatrack.Rate.nodes.DataNode) source;
                Text node = doc.createTextNode(sourceData.getWholeData());
                dest.appendChild(node);
            } else {
                // unhandled
                // not that doctype is not handled here - rather it is used in the initial doc creation
            }
        }

        public void tail(com.mt.lamdatrack.Rate.nodes.Node source, int depth) {
            if (source instanceof com.mt.lamdatrack.Rate.nodes.Element && dest.getParentNode() instanceof Element) {
                dest = dest.getParentNode(); // undescend. cromulent.
            }
            namespacesStack.pop();
        }

        private static final Pattern attrKeyReplace = Pattern.compile("[^-a-zA-Z0-9_:.]");
        private static final Pattern attrKeyValid = Pattern.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");

        private void copyAttributes(com.mt.lamdatrack.Rate.nodes.Node source, Element el) {
            for (Attribute attribute : source.attributes()) {
                // valid xml attribute names are: ^[a-zA-Z_:][-a-zA-Z0-9_:.]
                String key = attrKeyReplace.matcher(attribute.getKey()).replaceAll("");
                if (attrKeyValid.matcher(key).matches())
                    el.setAttribute(key, attribute.getValue());
            }
        }

        /**
         * Finds any namespaces defined in this element. Returns any tag prefix.
         */
        private String updateNamespaces(com.mt.lamdatrack.Rate.nodes.Element el) {
            // scan the element for namespace declarations
            // like: xmlns="blah" or xmlns:prefix="blah"
            Attributes attributes = el.attributes();
            for (Attribute attr : attributes) {
                String key = attr.getKey();
                String prefix;
                if (key.equals(xmlnsKey)) {
                    prefix = "";
                } else if (key.startsWith(xmlnsPrefix)) {
                    prefix = key.substring(xmlnsPrefix.length());
                } else {
                    continue;
                }
                namespacesStack.peek().put(prefix, attr.getValue());
            }

            // get the element prefix if any
            int pos = el.tagName().indexOf(':');
            return pos > 0 ? el.tagName().substring(0, pos) : "";
        }

    }
}
