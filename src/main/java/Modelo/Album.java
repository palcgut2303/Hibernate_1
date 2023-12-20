/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "album")
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "numalbum")
    private int id;

    private String titulo;
    private String autor;
    private int precio;
    private String categoria;
    
    
    public Album() {
    }

    public Album(int id, String titulo, String autor, int precio, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.categoria = categoria;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Album{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", precio=" + precio + ", categoria=" + categoria + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.titulo);
        hash = 71 * hash + Objects.hashCode(this.autor);
        hash = 71 * hash + this.precio;
        hash = 71 * hash + Objects.hashCode(this.categoria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.precio != other.precio) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

  
    
    
    
}
