package com.mt.lamdatrack.Rate.internal;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@TypeQualifierDefault(ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)

/**
 Indicates return types are not nullable, unless otherwise specified by @Nullable.
 @see javax.annotation.ParametersAreNonnullByDefault
 */
public @interface ReturnsAreNonnullByDefault {
}
