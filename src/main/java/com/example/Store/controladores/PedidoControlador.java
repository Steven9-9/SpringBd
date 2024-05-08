package com.example.Store.controladores;

import com.example.Store.Servicios.PedidoServicio;
import com.example.Store.modelos.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/pedido")
public class PedidoControlador {

    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping

    public ResponseEntity<?> guardarPedido(@RequestBody Pedido datosPedido) {

        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.guardarPedido(datosPedido));

        } catch (Exception error) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }
    }


    @GetMapping
    public ResponseEntity<?> consultarPedido() {
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.buscarTodosLosPedido());

        } catch (Exception error) {

            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);


        }
    }
    @GetMapping("{id}")

    public ResponseEntity<?> buscarPedidoPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.buscarPedidoPorId(id));

        } catch (Exception error) {

            Map<String, Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message", error.getMessage());

            return ResponseEntity

                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
}




