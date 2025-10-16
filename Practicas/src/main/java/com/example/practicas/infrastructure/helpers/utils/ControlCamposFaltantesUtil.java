package com.example.practicas.infrastructure.helpers.utils;

import com.example.practicas.domain.models.shared.exceptions.CamposException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

public class ControlCamposFaltantesUtil {

    private ControlCamposFaltantesUtil() {
        throw new IllegalArgumentException();
    }

    public static final void validarPropiedades(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<String> errores = bindingResult.getAllErrors()
                    .stream()
                    .map( ObjectError::getDefaultMessage)
                    .toList();
            throw new CamposException("No cumple validación de campos", errores);
        }
    }

}
