package com.uisrael.veciapp.Entidades;

public class tipo_negocio {
    private Integer id_tnegocio;
    private  String Descripcion;

    public tipo_negocio(){

    }

    public tipo_negocio(Integer id_tnegocio, String descripcion) {
        this.id_tnegocio = id_tnegocio;
        Descripcion = descripcion;
    }

    public Integer getId_tnegocio() {
        return id_tnegocio;
    }

    public void setId_tnegocio(Integer id_tnegocio) {
        this.id_tnegocio = id_tnegocio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
