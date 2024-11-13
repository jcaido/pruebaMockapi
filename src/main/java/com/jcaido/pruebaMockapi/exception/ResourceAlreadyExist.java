package com.jcaido.pruebaMockapi.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
@Getter
@Setter
public class ResourceAlreadyExist extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public ResourceAlreadyExist(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s con %s %s no se encuentra", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
