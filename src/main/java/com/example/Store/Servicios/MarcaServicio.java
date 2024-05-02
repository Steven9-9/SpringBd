package com.example.Store.Servicios;
import com.example.Store.Repositorios.MarcaRepositorio;
import com.example.Store.helpers.ValidacionMarca;
import com.example.Store.modelos.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarcaServicio {

    @Autowired
    ValidacionMarca validacionMarca;

    @Autowired
    MarcaRepositorio marcaRepositorio;


    public Marca guardarMarca (Marca datosMarca) throws  Exception{

        if(!validacionMarca.validarNombreMarca(datosMarca.getNombreMarca())){


            throw new IllegalArgumentException("Marca no valida");

        }

        if(!validacionMarca.validarNit(datosMarca.getNit())){

            throw new IllegalArgumentException("Nit no valido");

        }

        if(!validacionMarca.validarAno(datosMarca.getAnoCreacion())){

            throw new IllegalArgumentException("Año no valido");

        }


        try {
            return marcaRepositorio.save(datosMarca);
        } catch (Exception e) {
            throw new Exception("Error al guardar Tipo  Prenda: " + e.getMessage());
        }

    }

    public Marca  buscarMarcaPorId(Integer idMarca)throws  Exception{
        try{

            if(marcaRepositorio.findById(idMarca).isPresent()){

                return marcaRepositorio.findById(idMarca).get();


            }else{

                throw new Exception("pedido no encontrado");

            }

        }catch (Exception error){


            throw new Exception(error.getMessage());


        }


    }

    public List<Marca > buscarTodosLasMarca ()throws Exception {

        try {

            return marcaRepositorio.findAll();


        } catch (Exception error) {

            throw new Exception(error.getMessage());

        }
    }

    public Marca  modificarMarca  (){

        return null;

    }

    public boolean eliminarMarca  (){

        return true;

    }


}
