package com.stylo.store.models;

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
import jakarta.persistence.OneToOne;
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

  // Relacion Direccion con Sucursal 1 a 1
  @OneToOne(mappedBy = "direccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Sucursal sucursal;

  // Relacion Direccion con Usuario n a 1
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  @JsonIgnoreProperties("direcciones")
  private Usuario usuario;

  // Relacion Direccion con Ciudad n a 1
  @ManyToOne
  @JoinColumn(name = "ciudad_id")
  @JsonIgnoreProperties({"direccionespais"})
  private Ciudad ciudad;

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
  
  public Sucursal getSucursal() {
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
  }

  public Ciudad getCiudad() {
    return ciudad;
  }
  
  public void setCiudad(Ciudad ciudad) {
    this.ciudad = ciudad;
  }

  public Usuario getUsuario() {
    return usuario;
  }
  
  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}