package com.stylo.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "inventario_disponible")
  private Long inventarioDisponible;

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

}
