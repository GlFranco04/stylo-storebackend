package com.stylo.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "ubicacion")
  private String ubicacion;

  @Column(name = "edificio")
  private String edificio;
  
  // Constructor por defecto
  public Direccion() { }

  // Constructor con parámetros
  public Direccion(String nombre, String ubicacion, String edificio) {
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.edificio = edificio;
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
  
  public String getEdificio() {
    return edificio;
  }
  
  public void setEdificio(String edificio) {
    this.edificio = edificio;
  }
  
}