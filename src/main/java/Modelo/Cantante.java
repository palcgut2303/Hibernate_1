/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author manana
 */
public class Cantante {
    
    private int numcan;
    private String nombre;
    private String nacionalidad;
    private int edad;
    //private List<Album> albumes;

    public Cantante() {
    }

    public Cantante(int numcan, String nombre, String nacionalidad, int edad) {
        this.numcan = numcan;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }
    
    
    public int getNumcan() {
        return numcan;
    }

    public void setNumcan(int numcan) {
        this.numcan = numcan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   /* public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }*/
    
    
    
    
    
}
