package com.personal.security.example.validation.constraint;

import com.personal.security.example.model.dto.NewUserDto;
import com.personal.security.example.validation.FieldsMatch;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.nonNull;

public class FieldsMatchConstraint implements ConstraintValidator<FieldsMatch, NewUserDto> {

    private String first;
    private String second;

    @Override
    public void initialize(final FieldsMatch constraint) {
        first = constraint.first();
        second = constraint.second();
    }

    @Override
    public boolean isValid(final NewUserDto newUserDto, final ConstraintValidatorContext context) {
        if (newUserDto == null) {
            return false;
        }

        try {
            final String firstProperty = BeanUtils.getProperty(newUserDto, first);
            final String secondProperty = BeanUtils.getProperty(newUserDto, second);

            return nonNull(firstProperty) && firstProperty.equals(secondProperty);
        } catch (Exception ignored) {
        }

        return false;
    }

}
