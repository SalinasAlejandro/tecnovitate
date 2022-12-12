/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Models;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author dykeo
 */
public class Comentarios {
    private int id;
    private Usuario idUsua;
    private Date fecha;
    private String comentario;
    private int idNoticia;
    private int likes;
    private int dislikes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(Usuario idUsua) {
        this.idUsua = idUsua;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(int idNoticia) {
        this.idNoticia = idNoticia;
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

    public Comentarios(Usuario idUsua, String comentario, int idNoticia) {
        this.idUsua = idUsua;
        this.comentario = comentario;
        this.idNoticia = idNoticia;
    }

    public Comentarios(int id, Usuario idUsua, Date fecha, String comentario, int idNoticia, int likes, int dislikes) {
        this.id = id;
        this.idUsua = idUsua;
        this.fecha = fecha;
        this.comentario = comentario;
        this.idNoticia = idNoticia;
        this.likes = likes;
        this.dislikes = dislikes;
    }
    
    
    
}
