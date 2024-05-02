package com.example.Store.Servicios;

import com.example.Store.Repositorios.ProductoRepositorio;
import com.example.Store.helpers.ValidacionProducto;
import com.example.Store.modelos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio {

    @Autowired
    ValidacionProducto validacionProducto;
    @Autowired
    ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto datosProducto) throws Exception{

        if(!validacionProducto.validarNombre(datosProducto.getNombreProducto())){

            throw new IllegalArgumentException("Nombres inválidos");

        }

        if(!validacionProducto.validarReferencia(datosProducto.getReferencia())){

            throw  new IllegalArgumentException("Referencia invalida");

        }


        if(!validacionProducto.validarTalla(datosProducto.getTalla())){

            throw new IllegalArgumentException("Talla no valida");

        }
        if(!validacionProducto.validarCantidadBodega(datosProducto.getCantidadBodega())){

            throw new IllegalArgumentException("Cantidad inavlida");

        }

        if(!validacionProducto.validPrecioUnitario(datosProducto.getPrecioUnitario())){


            throw new IllegalArgumentException("Precio no valido");

        }

        if(!validacionProducto.validarDescripcion(datosProducto.getDescripcion())){

            throw new IllegalArgumentException("Descripcion invalida");

        }

        if(!validacionProducto.validarFotografia(datosProducto.getFotografia())){

            throw new IllegalArgumentException("Foto invalida");

        }


        try {
            return productoRepositorio.save(datosProducto);
        } catch (Exception e) {
            throw new Exception("Error al guardar Tipo  Prenda: " + e.getMessage());
        }


    }

    public Producto buscarProductoPorId(Integer idProducto) throws  Exception{

        try{

            if(productoRepositorio.findById(idProducto).isPresent()){

                return productoRepositorio.findById(idProducto).get();


            }else{

                throw new Exception("prenda no encontrada");

            }

        }catch (Exception error){


            throw new Exception(error.getMessage());


        }


    }



    public List<Producto> buscarTodosLosProducto ()throws Exception{

        try{

            return productoRepositorio.findAll();



        }catch (Exception error){

            throw new Exception(error.getMessage());

        }

    }


    public Producto modificarProducto (){

        return null;

    }

    public boolean eliminarProducto (){

        return true;

    }



}
