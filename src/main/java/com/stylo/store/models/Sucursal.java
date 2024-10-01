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
import jakarta.persistence.OneToOne;
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

  // Relacion Sucursal con Inventario 1 a n
  @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonIgnore
  private Set<Inventario> inventarios;

  // Relacion Sucursal con Empresa n a 1
  @ManyToOne
  @JoinColumn(name = "empresa_id")
  @JsonIgnoreProperties("sucursales")
  private Empresa empresa;

  // Relacion Sucursal con Direccion 1 a 1
  @OneToOne
  @JoinColumn(name = "direccion_id")
  @JsonIgnoreProperties("sucursal")
  private Direccion direccion;

  // Relacion Sucursal con UsuarioSucursal 1 a n
  @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<UsuarioSucursal> usuarioSucursales;

  // Relacion Sucursal con NotaVenta 1 a n
  @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonIgnore
  private Set<NotaVenta> notasVentas;

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

  public Set<Inventario> getInventarios(){
    return inventarios;
  }
  public void setInventarios(Set<Inventario> inventarios){
    this.inventarios = inventarios;
  }

  public Empresa getEmpresa() {
    return empresa;
  }
  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public Direccion getDireccion() {
    return direccion;
  }

  public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
  }

  public Set<UsuarioSucursal> getUsuarioSucursales() {
    return usuarioSucursales;
  }

  public void setUsuarioSucursales(Set<UsuarioSucursal> usuarioSucursales) {
    this.usuarioSucursales = usuarioSucursales;
  }

  public Set<NotaVenta> getNotasVentas() {
    return notasVentas;
  }

  public void setNotasVentas(Set<NotaVenta> notasVentas) {
    this.notasVentas = notasVentas;
  }

}
