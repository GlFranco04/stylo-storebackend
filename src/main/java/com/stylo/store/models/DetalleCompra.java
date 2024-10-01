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
@Table(name = "detalle_compra")
public class DetalleCompra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name ="cantidad")
  private int cantidad;

  @Column(name = "subtotal")
  private double subtotal;

  // Relacion DetalleCompra con NotaCompra n a 1
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "nota_compra_id")
  @JsonIgnoreProperties({"detalleCompras","sucursal"})
  private NotaCompra notaCompra;

  // Relacion DetalleVenta con DetalleProducto n a 1
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "detalle_producto_id")
  @JsonIgnoreProperties({"detalleCompras","producto","talla"})
  private DetalleProducto detalleProducto;

  // Constructor por defect
  public DetalleCompra() {
  }

  // Constructor con parametros
  public DetalleCompra(int cantidad, double subtotal) {
    this.cantidad = cantidad;
    this.subtotal = subtotal;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
  
  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }

  public NotaCompra getNotaCompra() {
    return notaCompra;
  }
  
  public void setNotaCompra(NotaCompra notaCompra) {
    this.notaCompra = notaCompra;
  }

  public DetalleProducto getDetalleProducto() {
    return detalleProducto;
  }

  public void setDetalleProducto(DetalleProducto detalleProducto) {
    this.detalleProducto = detalleProducto;
  }   
}