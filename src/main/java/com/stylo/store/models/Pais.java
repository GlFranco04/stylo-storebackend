package com.stylo.store.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "nombre")
  private String nombre;

  // Relacion Pais con Ciudad 1 a n
  @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Ciudad> ciudades;

  // Constuctor por defecto
  public Pais() {}

  // Constructor con parámetros
  public Pais(String nombre) {
    this.nombre = nombre;
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

  public Set<Ciudad> getCiudades(){
    return ciudades;
  }
  public void setCiudades(Set<Ciudad> ciudades){
    this.ciudades = ciudades;
  }
}
