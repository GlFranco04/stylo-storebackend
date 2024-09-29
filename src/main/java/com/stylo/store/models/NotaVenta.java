package com.stylo.store.models;

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
import java.time.LocalDate;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="nota_venta")
public class NotaVenta {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fecha_venta")
  private LocalDate fechaVenta;

  @Column(name = "total")
  private double total;

  // Relacion NotaVenta con Usuario n a 1
  @ManyToOne
  @JoinColumn(name = "usuario_id")
  @JsonIgnoreProperties("notasVentas")
  private Usuario usuario;

  // Relacion NotaVenta con DetalleVenta 1 a n
  @OneToMany(mappedBy = "notaVenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonIgnore
  private Set<DetalleVenta> detalleVentas;

  // Relacion NotaVenta con Sucursal n a 1
  @ManyToOne
  @JoinColumn(name = "sucursal_id")
  @JsonIgnoreProperties("notasVentas")
  private Sucursal sucursal;

  // Constructor por defecto
  public NotaVenta() {
  }

  // Constructor con parámetros
  public NotaVenta(LocalDate fechaVenta, double total) {
    this.fechaVenta = fechaVenta;
    this.total = total;
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
  
  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Set<DetalleVenta> getDetalleVentas() {
    return detalleVentas;
  }

  public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
    this.detalleVentas = detalleVentas;
  }

  public Sucursal getSucursal() {
    return sucursal;
  }

  public void setSucursal(Sucursal sucursal) {
    this.sucursal = sucursal;
  }

}
