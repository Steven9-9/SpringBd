package com.example.Store.helpers;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuario {
    public boolean validarNombres(String nombres)throws Exception{
        if (nombres.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (nombres.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }
        String regex="^[a-zA-Z ]+$";
        // evaluo si el nombre coincide con la expresion
        if (!ValidarPatron.evaluarPatron(regex,nombres)){
            throw new Exception("revisa el nombre ingresado ya que solo puede tener letras y espacios");
        }
        return true;
    }
    public boolean validarCedula(String cedula)throws Exception{
        if (cedula.length()==0){
            throw new Exception("la longitud de la cedula no puede ser cero");
        }
        if (cedula.length()>12){
            throw new Exception("la longitud de la cedula no puede ser mayor a 12");
        }
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex,cedula)){
            throw new Exception("El nit ingresado solo puede tener numeros");
        }
        return true;
    }
    public boolean validarCorreo(String correo)throws Exception{
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!ValidarPatron.evaluarPatron(regex,correo)){
            throw new Exception("correo no cumple con el formato adecuado");
        }
        if (correo.length()==0){
            throw new Exception("la longitud del correo no puede ser cero");
        }

        return true;
    }
    public boolean validarSexo(String sexo)throws Exception{
        if (sexo.length()==0){
            throw new Exception("la longitud del sexo no puede ser cero");
        }
        if (sexo.length()>1){
            throw new Exception("la longitud del sexo no puede ser mayor a 1");
        }
        if (!sexo.toLowerCase().equals("m") && !sexo.toLowerCase().equals("f")){
            throw new Exception("el valor del sexo solo puede ser m o f");
        }
        return true;
    }
    public boolean validarCodigoPostal(String codigoPostal)throws Exception{
        if (codigoPostal.length()==0){
            throw new Exception("la longitud del codigo postal no puede ser cero");
        }
        if (codigoPostal.length()>6){
            throw new Exception("la longitud del codigo postal no puede ser mayor a 6");
        }
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex,codigoPostal)){
            throw new Exception("El codigo postal ingresado solo puede tener numeros");
        }
        return true;
    }


}
