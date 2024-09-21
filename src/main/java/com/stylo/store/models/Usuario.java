package com.stylo.store.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "correo")
  private String correo;

  @Column(name = "contrasena")
  private String contrasena;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "apellido")
  private String apellido;

  @Column(name = "sexo")
  private char sexo;

  // Constructor por defecto
  public Usuario() {
  }

  // Constructor con parámetros
  public Usuario(String correo, String contrasena, String nombre, String apellido, char sexo) {
    this.correo = correo;
    this.contrasena = contrasena;
    this.nombre = nombre;
    this.apellido = apellido;
    this.sexo = sexo;
  }
  // Getters y Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }
  public String getContrasena() {
    return contrasena;
  }
  public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
  }
  public String getNombre(){
    return nombre;
  }
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String getApellido(){
    return apellido;
  }
  public void setApellido(String apellido){
    this.apellido = apellido;
  }
  public char getSexo(){
    return sexo;
  }
  public void setSexo(char sexo){
    this.sexo = sexo;
  }
}
