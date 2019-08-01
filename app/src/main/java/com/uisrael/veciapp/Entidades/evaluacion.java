package com.uisrael.veciapp.Entidades;

public class evaluacion {
    private Integer id_evaluacion;
    private Integer id_negocio;
    private Integer clasificacion;
    private String comentario;

    public evaluacion(){

    }

    public evaluacion(Integer id_evaluacion, Integer id_negocio, Integer clasificacion, String comentario) {
        this.id_evaluacion = id_evaluacion;
        this.id_negocio = id_negocio;
        this.clasificacion = clasificacion;
        this.comentario = comentario;
    }

    public Integer getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(Integer id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
    }

    public Integer getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(Integer id_negocio) {
        this.id_negocio = id_negocio;
    }

    public Integer getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
