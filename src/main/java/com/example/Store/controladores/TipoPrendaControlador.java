package com.example.Store.controladores;

import com.example.Store.Servicios.TipoPrendaServicio;
import com.example.Store.modelos.TipoPrenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping ("storeapi/v1/tipoPrenda")
public class TipoPrendaControlador {

    @Autowired
    TipoPrendaServicio tipoPrendaServicio;

    @PostMapping

    public ResponseEntity<?> guardarTipoPrenda(@RequestBody TipoPrenda datosTipoPrenda) {

        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendaServicio.guardarTipoPrenda(datosTipoPrenda));

        } catch (Exception error) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }
    }


    @GetMapping
    public ResponseEntity<?> consultarTipoPrenda() {
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendaServicio.buscarTodosLosTipoPrenda());

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

    public ResponseEntity<?> buscarTipoPrendaPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendaServicio.buscarTipoPrendaPorId(id));

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

