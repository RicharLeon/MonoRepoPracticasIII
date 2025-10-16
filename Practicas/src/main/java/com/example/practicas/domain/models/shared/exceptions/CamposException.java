package com.example.practicas.domain.models.shared.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CamposException extends RuntimeException {

    private List<String> erroresCampos;
    public CamposException(String message, List<String> erroresCampos) {
        super(message);
        this.erroresCampos = erroresCampos;
    }
}
