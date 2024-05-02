package com.example.Store.Servicios;
import com.example.Store.Repositorios.DetalleRepositorio;
import com.example.Store.helpers.ValidacionDetalle;
import com.example.Store.modelos.Detalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleServicio {

    @Autowired
    ValidacionDetalle validacionDetalle;
    @Autowired
    DetalleRepositorio detalleRepositorio;

    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception{

        if(!validacionDetalle.validarCostoTotal(datosDetalle.getCostoTotal())){

            throw new IllegalArgumentException("Costo invalido");

        }

        if(!validacionDetalle.validarCantidadProductos(datosDetalle.getCantidadProductos())){

            throw new IllegalArgumentException("Producto invalido");

        }


        try {
            return detalleRepositorio.save(datosDetalle);
        } catch (Exception e) {
            throw new Exception("Error al guardar Tipo  Prenda: " + e.getMessage());
        }

    }


    public Detalle buscarDetallePorId(Integer idDetalle)throws  Exception{
        try{

            if(detalleRepositorio.findById(idDetalle).isPresent()){

                return detalleRepositorio.findById(idDetalle).get();


            }else{

                throw new Exception("pedido no encontrado");

            }

        }catch (Exception error){


            throw new Exception(error.getMessage());


        }


    }


    public List<Detalle> buscarTodosLosDetalle ()throws Exception{

        try{

            return detalleRepositorio.findAll();



        }catch (Exception error){

            throw new Exception(error.getMessage());

        }

    }


    public Detalle modificarDetalle(){

        return null;

    }

    public boolean eliminarDetalle  (){

        return true;

    }




}






