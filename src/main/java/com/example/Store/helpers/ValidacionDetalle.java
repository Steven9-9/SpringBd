package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionDetalle {
    public boolean validarCostoTotal(Integer costoTotal)throws Exception{
        if (costoTotal<0){
            throw new Exception("el costo total solo puede ser positivo");
        }
        if (costoTotal==0){
            throw new Exception("el costo total debe ser diferente de 0");
        }
        if (costoTotal==null){
            throw new Exception("el costo total no puede estar vacio");
        }
        String numeroString = String.valueOf(costoTotal); // Convertir el Integer a una cadena

        for (char c : numeroString.toCharArray()) {
            if (!Character.isDigit(c)) { // Verificar si el carácter no es un dígito
                throw new Exception("El número contiene caracteres no numéricos");
            }
        }
        return true;
    }
    public boolean validarCantidadProductos(Integer cantidadProductos)throws Exception{
        if (cantidadProductos<0){
            throw new Exception("el numero solo puede ser positivo");
        }
        String numeroString = String.valueOf(cantidadProductos); // Convertir el Integer a una cadena

        for (char c : numeroString.toCharArray()) {
            if (!Character.isDigit(c)) { // Verificar si el carácter no es un dígito
                throw new Exception("El número contiene caracteres no numéricos");
            }
        }

        return true;
    }

}
