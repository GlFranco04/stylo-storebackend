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
@Table(name = "detalle_venta")
public class DetalleVenta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name ="cantidad")
  private int cantidad;

  @Column(name = "subtotal")
  private double subtotal;

  // Relacion DetalleVenta con NotaVenta n a 1
  @ManyToOne
  @JoinColumn(name = "nota_venta_id")
  @JsonIgnoreProperties("detalleVentas")
  private NotaVenta notaVenta;

  // Relacion DetalleVenta con DetalleProducto n a 1
  @ManyToOne
  @JoinColumn(name = "detalle_producto_id")
  @JsonIgnoreProperties({"detalleVentas"})
  private DetalleProducto detalleProducto;

  // Constructor por defect
  public DetalleVenta() {
  }

  // Constructor con parametros
  public DetalleVenta(int cantidad, double subtotal) {
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

  public NotaVenta getNotaVenta() {
    return notaVenta;
  }
  
  public void setNotaVenta(NotaVenta notaVenta) {
    this.notaVenta = notaVenta;
  }

  public DetalleProducto getDetalleProducto() {
    return detalleProducto;
  }

  public void setDetalleProducto(DetalleProducto detalleProducto) {
    this.detalleProducto = detalleProducto;
  }

}
