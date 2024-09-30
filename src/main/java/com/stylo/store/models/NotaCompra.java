package com.stylo.store.models;

import java.time.LocalDate;
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
@Table(name = "nota_compra")
public class NotaCompra {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fecha_venta")
  private LocalDate fechaVenta;

  @Column(name = "total")
  private double total;

  @Column(name = "estado")
  private String estado;

  // Relacion NotaCompra con DetalleCompra 1 a n
  @OneToMany(mappedBy = "notaCompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<DetalleCompra> detalleCompras;

  // Relacion NotaCompra con Sucursal n a 1
  @ManyToOne
  @JoinColumn(name = "sucursal_id")
  @JsonIgnoreProperties("notasCompras")
  private Sucursal sucursal;

  // Constructor por defecto
  public NotaCompra() {
  }

  // Constructor con parámetros
  public NotaCompra(LocalDate fechaVenta, double total, String estado) {
    this.fechaVenta = fechaVenta;
    this.total = total;
    this.estado = estado;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public LocalDate getFechaVenta() {
    return fechaVenta;
  }
  public void setFechaVenta(LocalDate fechaVenta) {
    this.fechaVenta = fechaVenta;
  }
  public double getTotal() {
    return total;
  }
  public void setTotal(double total) {
    this.total = total;
  }

  public String getEstado(){
    return estado;
  }

  public void setEstado(String estado){
    this.estado = estado;
  }
  
  public Set<DetalleCompra> getDetalleCompras() {
    return detalleCompras;
  }

  public void setDetalleCompras(Set<DetalleCompra> detalleCompras) {
    this.detalleCompras = detalleCompras;
  }

  public Sucursal getSucursal() {
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
  }
   
}
