package com.stylo.store.models;

import java.sql.Date;
import java.time.LocalDate;

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
  private LocalDate fechaInicio;

  // Relacion UsuarioSucursal con Sucursal n a 1
  @ManyToOne
  @JoinColumn(name = "sucursal_id")
  @JsonIgnoreProperties({"usuarioSucursales","empresa","direccion"})
  private Sucursal sucursal;// se tiene que poner lo mismo en mappedBy en la otra entidad, en este caso "sucursal"

  // Relacion UsuarioSucursal con Usuario n a 1
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  @JsonIgnoreProperties({"usuarioSucursales","rol"})
  private Usuario usuario;

  // Contructor por defecto
  public UsuarioSucursal() {}

  // Constructor con parametros
  public UsuarioSucursal(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public LocalDate getFechaInicio() {
    return fechaInicio;
  }
  public void setFechaInicio(LocalDate fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public Sucursal getSucursal() {
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
  }

  public Usuario getUsuario() {
    return usuario;
  }
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}