package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionProducto {
    public boolean validarNombre(String nombre)throws Exception{
        if (nombre.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (nombre.length()>60){
            throw new Exception("El nombre no puede tener mas de 60 caracteres");
        }
        String regex="^[a-zA-Z ]+$";
        // evaluo si el nombre coincide con la expresion
        if (ValidarPatron.evaluarPatron(nombre,regex)){
            throw new Exception("revisa el nombre ingresado ya que solo puede tener letras y espacios");
        }
        return true;
    }
    public boolean validarReferencia(String referencia)throws Exception{
        if (referencia.length()==0){
            throw new Exception("La referencia no puede estar vacio");
        }
        if (referencia.length()>14){
            throw new Exception("la referencia no puede tener mas de 14 caracteres");
        }

        return true;
    }

    public boolean validarTalla(String talla)throws Exception{
        if (talla.length()==0){
            throw new Exception("La talla no puede estar vacia");
        }
        if (talla.length()>3){
            throw new Exception("la talla no puede tener mas de 3 caracteres");
        }

        return true;
    }
    public boolean validarCantidadBodega(Integer cantidadBodega)throws Exception{
        if (cantidadBodega<0){
            throw new Exception("la cantidad en bodega no puede ser un numero negativo");
        }
        String numeroString = String.valueOf(cantidadBodega); // Convertir el Integer a una cadena

        for (char c : numeroString.toCharArray()) {
            if (!Character.isDigit(c)) { // Verificar si el carácter no es un dígito
                throw new Exception("El número contiene caracteres no numéricos");
            }
        }
        return true;
    }
    public boolean validPrecioUnitario(Integer precioUnitario)throws Exception{
        if (precioUnitario<0){
            throw new Exception("El precio unitario no puede ser un numero negativo");
        }
        if (precioUnitario==0){
            throw new Exception("El precio unitario no puede ser cero");
        }
        String numeroString = String.valueOf(precioUnitario); // Convertir el Integer a una cadena

        for (char c : numeroString.toCharArray()) {
            if (!Character.isDigit(c)) { // Verificar si el carácter no es un dígito
                throw new Exception("El número contiene caracteres no numéricos");
            }
        }

        return true;
    }
    public boolean validarDescripcion(String descripcion)throws Exception{
        if (descripcion.length()==0){
            throw new Exception("La descripcion no puede estar vacia");
        }
        if (descripcion.length()>100){
            throw new Exception("La descripcion no puede tener mas de 100 caracteres");
        }
        return true;
    }
    public boolean validarFotografia(String fotografia)throws Exception{
        if (fotografia.length()==0){
            throw new Exception("La fotografia no puede estar vacia");
        }
        if (fotografia.length()>255){
            throw new Exception("La fotografia no puede tener mas de 255 caracteres");
        }
        return true;
    }
}
