package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stylo.store.models.NotaCompra;

public interface NotaCompraRepository extends JpaRepository<NotaCompra,Long>{
    
}
