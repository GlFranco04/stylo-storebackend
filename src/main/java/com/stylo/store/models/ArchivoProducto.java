package com.stylo.store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "archivoProducto")
public class ArchivoProducto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // Relacion ArchivoProducto con Archivo n a 1
  @ManyToOne
  @JoinColumn(name = "archivo_id")
  @JsonIgnoreProperties("archivoProductos")
  private Archivo archivo;

  // Relacion ArchivoProducto con DetalleProducto n a 1
  @ManyToOne
  @JoinColumn(name = "detalle_producto_id")
  @JsonIgnoreProperties({"archivoProductos","producto","talla"})
  private DetalleProducto detalleProducto;

  // Contructor por defecto
  public ArchivoProducto() {
  }

  // Constructor con parametros
  public ArchivoProducto(Long id) {
    this.id = id;
  }

  // Getters y setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Archivo getArchivo() {
    return archivo;
  }
  public void setArchivo(Archivo archivo) {
    this.archivo = archivo;
  }

  public DetalleProducto getDetalleProducto() {
    return detalleProducto;
  }
  public void setDetalleProducto(DetalleProducto detalleProducto) {
    this.detalleProducto = detalleProducto;
  }
}
