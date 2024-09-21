package com.stylo.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stylo.store.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long>{
  // Metodos personalizados si se necesitan
}
