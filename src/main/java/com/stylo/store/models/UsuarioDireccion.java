package com.stylo.store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_direccion")
public class UsuarioDireccion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fechaCreacion")
  private String fechaCreacion;

  // Relacion UsuarioDireccion con Direccion n a 1
  @ManyToOne
  @JoinColumn(name = "direccion_id")
  @JsonIgnoreProperties({"usuarioDirecciones","ciudad"})
  private Direccion direccion;

  // Constructor por defecto
  public UsuarioDireccion() {
  }
  // Constructor con paramtros
  public UsuarioDireccion(String fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getFechaCreacion() {
    return fechaCreacion;
  }
  public void setFechaCreacion(String fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Direccion getDireccion() {
    return direccion;
  }
  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

}
