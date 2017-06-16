package com.personal.security.example.validation;

import com.personal.security.example.validation.constraint.FieldsMatchConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldsMatchConstraint.class)
@Documented
public @interface FieldsMatch {

    String message() default "Fields do not match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String first();

    String second();

    @Target({TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        FieldsMatch[] value();
    }
}
