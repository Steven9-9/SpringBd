package com.example.Store.controladores;
import com.example.Store.Servicios.DetalleServicio;
import com.example.Store.modelos.Detalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/detalle")
public class DetalleControlador {

    @Autowired
    DetalleServicio detalleServicio;

    @PostMapping

    public ResponseEntity<?> guardarDetalle(@RequestBody Detalle datosDetalle) {

        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(detalleServicio.guardarDetalle(datosDetalle));

        } catch (Exception error) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }
    }

    @GetMapping
    public ResponseEntity<?> consultarDetalle() {
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(detalleServicio.buscarTodosLosDetalle());

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
                    .body(detalleServicio.buscarDetallePorId(id));

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

