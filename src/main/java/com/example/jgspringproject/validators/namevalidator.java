package com.example.jgspringproject.validators;

import com.example.jgspringproject.models.Userid;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

;import java.util.Objects;

public class namevalidator implements Validator {

    @Override//Wspierana klasa
    public boolean supports(Class<?> aClass) {
        return Userid.class.isAssignableFrom(aClass);
    }

    @Override//Logika związana z poprawnością danych w obiekcie
    public void validate(Object o, Errors errors) {

        var user = (Userid) o;
        if (Objects.equals(user.getName(), user.getSurname())) {
            errors.rejectValue("name", "Samedataa");
        }
    }
}
