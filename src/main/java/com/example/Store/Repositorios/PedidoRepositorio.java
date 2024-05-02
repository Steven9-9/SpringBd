package com.example.Store.Repositorios;
import com.example.Store.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {
}
