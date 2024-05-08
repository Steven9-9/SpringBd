package com.example.Store.modelos;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @Column(name = "fechaYHora",nullable = false)
    private LocalDate fechaYHora; // no vacio y formato internacional

 @ManyToOne
 @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario")
    Usuario usuario;

    public Pedido() {
    }

    public Pedido(Integer id, LocalDateTime fechaYHora) {
        this.id_pedido = id;
        fechaYHora = fechaYHora;
    }

    public LocalDate getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDate fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}
