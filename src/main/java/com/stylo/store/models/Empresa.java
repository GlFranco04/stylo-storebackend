package com.stylo.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "empresa")
  private String nombre;

  @Column(name = "correo")
  private String correo;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "propietario")
  private String propietario;

  // Constructor por defecto
  public Empresa() {
  }

  // Contructor con parametros
  public Empresa(String nombre, String correo, String telefono, String propietario) {
    this.nombre = nombre;
    this.correo = correo;
    this.telefono = telefono;
    this.propietario = propietario;
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
  
  public String getCorreo() {
    return correo;
  }
  
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  
  public String getTelefono() {
    return telefono;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getPropietario() {
    return propietario;
  }
  
  public void setPropietario(String propietario) {
    this.propietario = propietario;
  }

}
