package com.cenfotec.examen3.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//con esto spring sabe que se tiene que guardar en bd
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)



    private long id;
    private String nombre;
    private String apellido1;
    private String apellido2;

    private String posicion;
    private String piernaDominante; //(zurdo, derecho o ambidextro)
    private String fechaNacimiento;//(guardela como fecha.. evite usar el date de sql. Ojo)
    private double estatura;// (cms)
    private double peso;
    private boolean estado;//activo o inactivo (true o false)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posición) {
        this.posicion = posición;
    }

    public String getPiernaDominante() {
        return piernaDominante;
    }

    public void setPiernaDominante(String piernaDominante) {
        this.piernaDominante = piernaDominante;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
