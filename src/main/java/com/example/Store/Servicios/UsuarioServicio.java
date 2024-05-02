package com.example.Store.Servicios;
import com.example.Store.Repositorios.UsuarioRepositorio;
import com.example.Store.helpers.ValidacionUsuario;
import com.example.Store.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {


    //en los servicios debo inyectar las dependencias  de las validaciones - las consultas o repositorios

    @Autowired
    ValidacionUsuario validacionUsuario;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    public  Usuario guardarUsuario(Usuario datosUsuario) throws Exception {
        // Validar nombres
        if (!validacionUsuario.validarNombres(datosUsuario.getNombres())) {
            throw new IllegalArgumentException("Nombres inválidos");
        }

        // Validar cédula
        if (!validacionUsuario.validarCedula(datosUsuario.getCedula())) {
            throw new IllegalArgumentException("Cédula inválida");
        }

        // Validar correo
        if (!validacionUsuario.validarCorreo(datosUsuario.getCorreo())) {
            throw new IllegalArgumentException("Correo inválido");
        }

        // Validar sexo
        if (!validacionUsuario.validarSexo(datosUsuario.getSexo())) {
            throw new IllegalArgumentException("Sexo inválido");
        }

        // Validar código postal
        if (!validacionUsuario.validarCodigoPostal(datosUsuario.getCodigoPostal())) {
            throw new IllegalArgumentException("Código postal inválido");
        }

        // Si todas las validaciones pasan, guardar el usuario
        try {
            return usuarioRepositorio.save(datosUsuario);
        } catch (Exception e) {
            throw new Exception("Error al guardar usuario: " + e.getMessage());
        }
    }

    public Usuario buscarUsuariPorId(Integer idUsuario) throws Exception{

        try{

            if(usuarioRepositorio.findById(idUsuario).isPresent()){

              return usuarioRepositorio.findById(idUsuario).get();


            }else{

                throw new Exception("Usuario no encontrado");

            }

        }catch (Exception error){


            throw new Exception(error.getMessage());


        }


    }


    public List<Usuario> buscarTodosLosUsuarios() throws Exception{

try{

    return usuarioRepositorio.findAll();



}catch (Exception error){

    throw new Exception(error.getMessage());

}

    }


    public Usuario modificarUsuario(){

        return null;

    }

    public boolean eliminarUsuario(){

        return true;

    }



}
