package com.example.Store.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class ValidacionMarca {
    public boolean validarNombreMarca(String nombreMarca)throws Exception{
        // evaluo si el nombre coincide con la expresion

        if (nombreMarca.length()>50){
            throw new Exception("el nombre ingresado tiene mas de 50 caracteres");
        }

        if (nombreMarca.length()==0){
            throw new Exception("el nombre ingresado no puede estar vacio");
        }

        return true;
    }

    public boolean validarNit(String nit)throws Exception{
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex,nit)){
            throw new Exception("El nit ingresado solo puede tener numeros");
        }
        if (nit.length()==0){
            throw new Exception("el nit ingresado no puede estar vacio");
        }

        if (nit.length()>10){
            throw new Exception("la longitud del nit no debe superar los 10 digitos");
        }
        return true;
    }

    public boolean validarAno(LocalDate ano)throws Exception{
        if (ano==null){
            throw new Exception("la fecha no puede estar vacia");
        }

        return true;
    }
}
