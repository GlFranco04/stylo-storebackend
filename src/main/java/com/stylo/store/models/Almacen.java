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
@Table(name = "almacen")
public class Almacen {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  // Relacion Almacen con Sucursal n a 1
  @ManyToOne
  @JoinColumn(name = "sucursal_id")
  @JsonIgnoreProperties("almacenes")
  private Sucursal sucursal;

  //Constructor por defecto
  public Almacen() {
  }
  // Constructor con parametro
  public Almacen(String nombre) {
    this.nombre = nombre;
  }

  // Getters and setters
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

  public Sucursal getSucursal(){
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal){
    this.sucursal = sucursal;
  }

}
