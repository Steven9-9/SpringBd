package com.example.Store.controladores;

import com.example.Store.Servicios.UsuarioServicio;
import com.example.Store.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("storeapi/v1/usuario")
public class UsuarioControlador {

    //el controlador debe crear un metodo por cada servicio programado
    @Autowired
    UsuarioServicio usuarioServicio;

    //metodo para guardar

    @PostMapping

    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datosUsuario) {

        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.guardarUsuario(datosUsuario));

        } catch (Exception error) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());


        }

    }

    @GetMapping
    public ResponseEntity<?> consultarUsuarios() {
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarTodosLosUsuarios());

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

        public ResponseEntity<?> buscarUsusarioPorId (@PathVariable Integer id){
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(usuarioServicio.buscarUsuariPorId(id));

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


