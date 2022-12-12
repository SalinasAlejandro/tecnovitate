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
public class Usuario {
    private int idUsua;
    private String nombre_Usua;
    private String email;
    private String contraseña;
    private String redes;
    private String path;
    private String descripcion;
    private int tipo;

    public Usuario() {
    }

    public Usuario(int idUsua) {
        this.idUsua = idUsua;
    }

    public Usuario(String email, String contraseña) {
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario(int idUsua, String nombre_Usua, String email, String redes, String path, String descripcion, int tipo) {
        this.idUsua = idUsua;
        this.nombre_Usua = nombre_Usua;
        this.email = email;
        this.redes = redes;
        this.path = path;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    

    public Usuario(int idUsua, String nombre_Usua, String email, String contraseña) {
        this.idUsua = idUsua;
        this.nombre_Usua = nombre_Usua;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario(String nombre_Usua, String email, String contraseña) {
        this.nombre_Usua = nombre_Usua;
        this.email = email;
        this.contraseña = contraseña;
    }

    public Usuario(int idUsua, String nombre_Usua, String email, String contraseña, String redes, String path, String descripcion, int tipo) {
        this.idUsua = idUsua;
        this.nombre_Usua = nombre_Usua;
        this.email = email;
        this.contraseña = contraseña;
        this.redes = redes;
        this.path = path;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    
    

    public int getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(int idUsua) {
        this.idUsua = idUsua;
    }

    public String getNombre_Usua() {
        return nombre_Usua;
    }

    public void setNombre_Usua(String nombre_Usua) {
        this.nombre_Usua = nombre_Usua;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRedes() {
        return redes;
    }

    public void setRedes(String redes) {
        this.redes = redes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
