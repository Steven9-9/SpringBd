package com.example.Store.Repositorios;
import com.example.Store.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
}
