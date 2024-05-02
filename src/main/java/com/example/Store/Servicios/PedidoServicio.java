package com.example.Store.Servicios;
import com.example.Store.Repositorios.PedidoRepositorio;
import com.example.Store.helpers.ValidacionPedido;
import com.example.Store.modelos.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoServicio {



    @Autowired
    ValidacionPedido validacionPedido;
    @Autowired
    PedidoRepositorio pedidoRepositorio;


    public Pedido guardarPedido(Pedido datosPedido) throws Exception{

        if(!validacionPedido.validarFechaYHora(datosPedido.getFechaYHora())){

            throw new Exception("Fecha y hora no valida");

        }

        try {

            return pedidoRepositorio.save(datosPedido);
        }catch(Exception e){

            throw new Exception("Error al guardar la fecha: " + e.getMessage());

        }

        }



    public Pedido buscarPedidoPorId(Integer idPedido) throws  Exception{
        try{

            if(pedidoRepositorio.findById(idPedido).isPresent()){

                return pedidoRepositorio.findById(idPedido).get();


            }else{

                throw new Exception("pedido no encontrado");

            }

        }catch (Exception error){


            throw new Exception(error.getMessage());


        }


    }


    public List<Pedido> buscarTodosLosPedido ()throws Exception{

        try{

            return pedidoRepositorio.findAll();



        }catch (Exception error){

            throw new Exception(error.getMessage());

        }
    }


    public Pedido modificarPedido (){

        return null;

    }

    public boolean eliminarPedido (){

        return true;

    }
}
