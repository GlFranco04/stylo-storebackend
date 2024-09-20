package com.stylo.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "nombre")
  private String nombre;

  @Column(name = "esta_activo")
  private boolean estaActivo;

  //Contructor por defecto
  public Sucursal() {}
  // Contructor con parametros
  public Sucursal(String nombre, boolean estaActivo) {
    this.nombre = nombre;
    this.estaActivo = estaActivo;
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
  public boolean isEstaActivo() {
    return estaActivo;
  }
  public void setEstaActivo(boolean estaActivo) {
    this.estaActivo = estaActivo;
  }

}
