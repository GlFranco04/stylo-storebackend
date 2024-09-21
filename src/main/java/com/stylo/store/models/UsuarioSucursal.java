package com.stylo.store.models;

import java.sql.Date;

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
@Table(name = "usuarioSucursal")
public class UsuarioSucursal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fechaInicio")
  private Date fechaInicio;

  // Relacion UsuarioSucursal con Sucursal n a 1
  @ManyToOne
  @JoinColumn(name = "sucursal_id")
  @JsonIgnoreProperties({"usuarioSucursales","empresa","direccion"})
  private Sucursal sucursal;// se tiene que poner lo mismo en mappedBy en la otra entidad, en este caso "sucursal"

  // Contructor por defecto
  public UsuarioSucursal() {}

  // Constructor con parametros
  public UsuarioSucursal(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Date getFechaInicio() {
    return fechaInicio;
  }
  public void setFechaInicio(Date fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Sucursal getSucursal() {
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
  }
}