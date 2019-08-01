package com.uisrael.veciapp.Entidades;

public class usuario {
    private Integer id_usuario;
    private String correo;
    private String t_usuario;
    private  String clave;

    public usuario(){
    }

    public usuario(Integer id_usuario, String correo, String t_usuario, String clave) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.t_usuario = t_usuario;
        this.clave = clave;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getT_usuario() {
        return t_usuario;
    }

    public void setT_usuario(String t_usuario) {
        this.t_usuario = t_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
