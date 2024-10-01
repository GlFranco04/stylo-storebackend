package com.stylo.store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "inventario_disponible")
  private Long inventarioDisponible;

  // Relacion Inventario con Sucursal n a 1
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "sucursal_id")
  @JsonIgnoreProperties({"inventarios","direccion","empresa"})
  private Sucursal sucursal;

  // Relacion Inventario con DetalleProducto n a 1
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "detalle_producto_id")
  @JsonIgnoreProperties({"inventario"})
  private DetalleProducto detalleProducto;

  // getters and setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Long getInventarioDisponible(){
    return inventarioDisponible;
  }
  public void setInventarioDisponible(Long inventarioDisponible){
    this.inventarioDisponible = inventarioDisponible;
  }

  public Sucursal getSucursal(){
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal){
    this.sucursal = sucursal;
  }

  public DetalleProducto getDetalleProducto(){
    return detalleProducto;
  }

  public void setDetalleProducto(DetalleProducto detalleProducto){
    this.detalleProducto = detalleProducto;
  }

}
