package com.uisrael.veciapp.Entidades;

public class negocio {
    private Integer id_negocio;
    private Integer id_usuario;
    private Integer id_tnegocio;
    private String nom_negocio;
    private String logo;
    private String coordenadas;

    public negocio(){

    }

    public negocio(Integer id_negocio, Integer id_usuario, Integer id_tnegocio, String nom_negocio, String logo, String coordenadas) {
        this.id_negocio = id_negocio;
        this.id_usuario = id_usuario;
        this.id_tnegocio = id_tnegocio;
        this.nom_negocio = nom_negocio;
        this.logo = logo;
        this.coordenadas = coordenadas;
    }

    public Integer getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(Integer id_negocio) {
        this.id_negocio = id_negocio;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_tnegocio() {
        return id_tnegocio;
    }

    public void setId_tnegocio(Integer id_tnegocio) {
        this.id_tnegocio = id_tnegocio;
    }

    public String getNom_negocio() {
        return nom_negocio;
    }

    public void setNom_negocio(String nom_negocio) {
        this.nom_negocio = nom_negocio;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
}
