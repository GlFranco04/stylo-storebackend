package com.stylo.store.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "nombre")
  private String nombre;

  // Relacion Ciudad con Pais n a 1
  @ManyToOne
  @JoinColumn(name = "pais_id")
  @JsonIgnoreProperties("ciudades")
  private Pais pais;

  // Relacion Ciudad con Direccion 1 a n
  @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Direccion> direcciones;

  // Constructor por defecto
  public Ciudad() {
  }

  // Constructor con parametros
  public Ciudad(String nombre) {
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

  public Pais getPais() {
    return pais;
  }
  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public Set<Direccion> getDirecciones() {
    return direcciones;
  }
  public void setDirecciones(Set<Direccion> direcciones) {
    this.direcciones = direcciones;
  }

}
