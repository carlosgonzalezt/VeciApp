package com.uisrael.veciapp.Entidades;

public class perfil_usuario {
    private Integer id_datos_us;
    private Integer id_usuario;
    private String nombre;
    private String apellidos;

    public perfil_usuario(){

    }

    public perfil_usuario(Integer id_datos_us, Integer id_usuario, String nombre, String apellidos) {
        this.id_datos_us = id_datos_us;
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Integer getId_datos_us() {
        return id_datos_us;
    }

    public void setId_datos_us(Integer id_datos_us) {
        this.id_datos_us = id_datos_us;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


}
