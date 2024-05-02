package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionTipoPrenda {
    public boolean validarNombre(String nombre)throws Exception{
        if (nombre.length()==0){
            throw new Exception("el tipo de prenda no puede estar vacio");
        }
        if (nombre.length()>=80){
            throw new Exception("el tipo de prenda no puede tener mas de 80 caracteres");
        }
        String regex="^[a-zA-Z ]+$";
        // evaluo si el nombre coincide con la expresion
        if (!ValidarPatron.evaluarPatron(regex,nombre)){
            throw new Exception("revisa el el tipo de prenda ingresado ya que solo puede tener letras y espacios");
        }
        return true;
    }
}
