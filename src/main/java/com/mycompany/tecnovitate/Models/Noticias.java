/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author dykeo
 */
public class Noticias {
    private int id;
    private String titulo;
    private String descrip;
    private String noticia; 
    private Categorias categoria;
    private String path1;
    private String path2;
    private String path3;
    private String pathv;
    private int estado;
    private int likes;
    private int dislikes;
    private Date fecha;
    private Usuario User;
    private String cambio;

    public Noticias(String titulo, String descrip, String noticia, Categorias categoria, String path1, String path2, String path3, String pathv, Usuario User) {
        this.titulo = titulo;
        this.descrip = descrip;
        this.noticia = noticia;
        this.categoria = categoria;
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.pathv = pathv;
        this.User = User;
    }

    public Noticias(int id, String titulo, String descrip, String noticia, Categorias categoria, String path1, String path2, String path3, String pathv, int estado, int likes, int dislikes, Date fecha, Usuario User) {
        this.id = id;
        this.titulo = titulo;
        this.descrip = descrip;
        this.noticia = noticia;
        this.categoria = categoria;
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.pathv = pathv;
        this.estado = estado;
        this.likes = likes;
        this.dislikes = dislikes;
        this.fecha = fecha;
        this.User = User;
    }

    public Noticias(int id, String titulo, String descrip, String noticia, Categorias categoria, String path1, String path2, String path3, String pathv, int estado, int likes, int dislikes, Date fecha, Usuario User, String cambio) {
        this.id = id;
        this.titulo = titulo;
        this.descrip = descrip;
        this.noticia = noticia;
        this.categoria = categoria;
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.pathv = pathv;
        this.estado = estado;
        this.likes = likes;
        this.dislikes = dislikes;
        this.fecha = fecha;
        this.User = User;
        this.cambio = cambio;
    }

    public Noticias(int id, String titulo, String descrip, String noticia, Categorias categoria, String path1, String path2, String path3, String pathv) {
        this.id = id;
        this.titulo = titulo;
        this.descrip = descrip;
        this.noticia = noticia;
        this.categoria = categoria;
        this.path1 = path1;
        this.path2 = path2;
        this.path3 = path3;
        this.pathv = pathv;
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

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getPath1() {
        return path1;
    }

    public void setPath1(String path1) {
        this.path1 = path1;
    }

    public String getPath2() {
        return path2;
    }

    public void setPath2(String path2) {
        this.path2 = path2;
    }

    public String getPath3() {
        return path3;
    }

    public void setPath3(String path3) {
        this.path3 = path3;
    }

    public String getPathv() {
        return pathv;
    }

    public void setPathv(String pathv) {
        this.pathv = pathv;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUser() {
        return User;
    }

    public void setUser(Usuario User) {
        this.User = User;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
    
    
}
