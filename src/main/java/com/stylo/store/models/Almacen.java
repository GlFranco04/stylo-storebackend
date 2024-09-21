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
  @JsonIgnoreProperties({"almacenes","empresa","direccion"})
  private Sucursal sucursal;

  // Relacion Almacen con Inventario 1 a n
  @OneToMany(mappedBy = "almacen", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<Inventario> inventarios;

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

  public Set<Inventario> getInventarios(){
    return inventarios;
  }

  public void setInventarios(Set<Inventario> inventarios){
    this.inventarios = inventarios;
  }

}
