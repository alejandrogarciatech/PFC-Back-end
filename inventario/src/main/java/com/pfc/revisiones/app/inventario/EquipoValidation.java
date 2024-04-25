package com.pfc.revisiones.app.inventario;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pfc.revisiones.app.inventario.entities.Equipo;

@Component
public class EquipoValidation implements Validator{

    @Override
    public boolean supports(@SuppressWarnings("null") Class<?> clazz) {
        return Equipo.class.isAssignableFrom(clazz);
    }

    @SuppressWarnings("null")
    @Override
    public void validate(Object target, Errors errors) {
        Equipo equipo = (Equipo) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", null, "es requerido");
        if (equipo.getUbicacion() == null || equipo.getUbicacion().isBlank()) {
            errors.rejectValue("ubicacion", null, "es requerido, por favor");
        }

        if (equipo.getTipoProducto() == null) {
            errors.rejectValue("tipoProducto", null, "no puede ser nulo");
        } else if (equipo.getTipoProducto() < 500){
            errors.rejectValue("tipoProducto", null, "el valor ha de ser mayor o igual a 500");
        }
    }

}
