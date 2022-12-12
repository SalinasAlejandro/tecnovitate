/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tecnovitate.Models;

/**
 *
 * @author dykeo
 */
public class Favs {
    private int id;
    private int idUser;
    private Noticias idNoti;

    public Favs(int idUser, Noticias idNoti) {
        this.idUser = idUser;
        this.idNoti = idNoti;
    }

    public Favs(int id, int idUser, Noticias idNoti) {
        this.id = id;
        this.idUser = idUser;
        this.idNoti = idNoti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Noticias getIdNoti() {
        return idNoti;
    }

    public void setIdNoti(Noticias idNoti) {
        this.idNoti = idNoti;
    }
    
}
