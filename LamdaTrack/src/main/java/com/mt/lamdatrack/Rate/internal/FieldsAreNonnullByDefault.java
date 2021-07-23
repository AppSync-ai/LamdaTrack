package com.mt.lamdatrack.Rate.internal;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@TypeQualifierDefault(ElementType.FIELD)
@Retention(value = RetentionPolicy.CLASS)

/**
 Indicates that fields types are not nullable, unless otherwise specified by @Nullable.
 @see javax.annotation.ParametersAreNonnullByDefault
 */
public @interface FieldsAreNonnullByDefault {
}
