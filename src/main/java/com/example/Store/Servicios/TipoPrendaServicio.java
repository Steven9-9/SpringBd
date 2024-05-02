package com.example.Store.Servicios;

import com.example.Store.Repositorios.TipoPrendaRepositorio;
import com.example.Store.helpers.ValidacionTipoPrenda;
import com.example.Store.modelos.TipoPrenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class TipoPrendaServicio {

    @Autowired
    ValidacionTipoPrenda validacionTipoPrenda;
    @Autowired
    TipoPrendaRepositorio tipoPrendaRepositorio;

    public TipoPrenda guardarTipoPrenda (TipoPrenda datosTipoPrenda) throws Exception {

 if (!validacionTipoPrenda.validarNombre(datosTipoPrenda.getNombre())){

     throw new IllegalArgumentException("Nombres inválidos");

 }

        try {
            return tipoPrendaRepositorio.save(datosTipoPrenda);
        } catch (Exception e) {
            throw new Exception("Error al guardar Tipo  Prenda: " + e.getMessage());
        }

    }

    public TipoPrenda buscarTipoPrendaPorId(Integer idTipoPrenda)throws Exception{

        try{
            if(tipoPrendaRepositorio.findById(idTipoPrenda).isPresent()){

                return tipoPrendaRepositorio.findById(idTipoPrenda).get();

            }else{

                throw new Exception("Tipo Prenda no hayada");

            }

        }catch (Exception error){


            throw new Exception(error.getMessage());


        }


    }

    public  List<TipoPrenda> buscarTodosLosTipoPrenda() throws Exception{

        try{

            return tipoPrendaRepositorio.findAll();



        }catch (Exception error){

            throw new Exception(error.getMessage());

        }

    }


    public TipoPrenda modificarTipoPrenda (){

        return null;

    }

    public boolean eliminarTipoPrenda (){

        return true;

    }
}
