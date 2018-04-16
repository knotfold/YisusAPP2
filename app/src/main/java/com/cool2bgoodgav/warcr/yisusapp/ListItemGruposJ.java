package com.cool2bgoodgav.warcr.yisusapp;


/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemGruposJ {

    private String IdG;
    private String IdP;
    private String nombreGrupo;
    private String horarioGrupo;
    private String imagenGrupo;
    private String ubicacionIglesia;
    private String nombreIglesia;
    private String nomreCoordinador;
    private String telefonoCoordinador;
    private String mailCoordinador;

    public ListItemGruposJ(String idG, String nombreGrupo, String imagenGrupo,  String idP, String nombreIglesia) {
        IdG = idG;
        this.nombreGrupo = nombreGrupo;
        this.imagenGrupo = imagenGrupo;
        IdP = idP;
        this.nombreIglesia = nombreIglesia;
    }

    public ListItemGruposJ(String idG, String nombreGrupo, String horarioGrupo, String imagenGrupo,
                           String ubicacionIglesia, String nombreIglesia, String nomreCoordinador, String telefonoCoordinador,
                           String mailCoordinador) {
        IdG = idG;
        this.nombreGrupo = nombreGrupo;
        this.horarioGrupo = horarioGrupo;
        this.imagenGrupo = imagenGrupo;
        this.ubicacionIglesia = ubicacionIglesia;
        this.nombreIglesia = nombreIglesia;
        this.nomreCoordinador = nomreCoordinador;
        this.telefonoCoordinador = telefonoCoordinador;
        this.mailCoordinador = mailCoordinador;
    }

    public String getIdG() {
        return IdG;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public String getHorarioGrupo() {
        return horarioGrupo;
    }

    public String getImagenGrupo() {
        return imagenGrupo;
    }

    public String getUbicacionIglesia() {
        return ubicacionIglesia;
    }

    public String getNombreIglesia() {
        return nombreIglesia;
    }

    public String getNomreCoordinador() {
        return nomreCoordinador;
    }

    public String getTelefonoCoordinador() {
        return telefonoCoordinador;
    }

    public String getMailCoordinador() {
        return mailCoordinador;
    }

    public String getIdP() {
        return IdP;
    }
}