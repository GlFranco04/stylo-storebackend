package com.stylo.store.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "archivo")
public class Archivo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "ubicacion")
  private String ubicacion;

  @Column(name = "tipo")
  private String tipo;
  
  @Column(name = "fechaSubida")
  private LocalDate fechaSubida;

  // Relacion Archivo con ArchivoProducto 1 a n
  @OneToMany(mappedBy = "archivo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<ArchivoProducto> archivoProductos;

  // Constructor por defecto
  public Archivo() { }
  
  // Constructor con parámetros
  public Archivo(String nombre, String ubicacion, String tipo, LocalDate fechaSubida) {
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.tipo = tipo;
    this.fechaSubida = fechaSubida;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getUbicacion() {
    return ubicacion;
  }
  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }
  public String getTipo() {
    return tipo;
  }
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  public LocalDate getFechaSubida() {
    return fechaSubida;
  }
  public void setFechaSubida(LocalDate fechaSubida) {
    this.fechaSubida = fechaSubida;
  }

  public Set<ArchivoProducto> getArchivoProductos() {
    return archivoProductos;
  }
  public void setArchivoProductos(Set<ArchivoProducto> archivoProductos) {
    this.archivoProductos = archivoProductos;
  }

}
