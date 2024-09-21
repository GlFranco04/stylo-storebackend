package com.stylo.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarioSucursal")
public class UsuarioSucursal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fechaInicio")
  private String fechaInicio;

  // Contructor por defecto
  public UsuarioSucursal() {}

  // Constructor con parametros
  public UsuarioSucursal(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getFechaInicio() {
    return fechaInicio;
  }
  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }
}