package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Empresa;
import com.stylo.store.repositories.EmpresaRepository;

@Service
public class EmpresaService {
  @Autowired
  private EmpresaRepository empresaRepository;

  // Obtener todas las empresas
  public List<Empresa> getAllEmpresas() {
    return empresaRepository.findAll();
  }
  // Obtener una empresa por id
  public Optional<Empresa> getEmpresaById(Long id) {
    return empresaRepository.findById(id);
  }

  // Guardar o actualizar una empresa
  public Empresa saveEmpresa(Empresa empresa) {
    return empresaRepository.save(empresa);
  }

  // Eliminar una empresa
  public void deleteEmpresa(Long id) {
    empresaRepository.deleteById(id);
  }

}
