package com.stylo.store.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rolPermiso")
public class RolPermiso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fechaAsignacion")
  private Date fechaAsignacion;

  // Constructor por defecto
  public RolPermiso() {
  }

  // Constructor con parametros
  public RolPermiso(Date fechaAsignacion) {
    this.fechaAsignacion = fechaAsignacion;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Date getFechaAsignacion() {
    return fechaAsignacion;
  }
  
  public void setFechaAsignacion(Date fechaAsignacion) {
    this.fechaAsignacion = fechaAsignacion;
  }
}
