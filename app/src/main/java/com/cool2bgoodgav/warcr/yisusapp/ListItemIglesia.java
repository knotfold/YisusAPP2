package com.cool2bgoodgav.warcr.yisusapp;


/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemIglesia {

    private String IdIgleisa;
    private String NombreIglesia;
    private String TelefonoIglesia;
    private String imageUrlIglesia;
    private String HMisaIglesia;
    private String HConfesion;
    private String HOficinaIglesia;
    private String AvisoSemIglesia;
    private String UbicacionIglesia;

    public ListItemIglesia(String idIgleisa, String nombreIglesia, String telefonoIglesia,
                           String imageUrlIglesia, String HMisaIglesia, String HConfesion, String HOficinaIglesia,
                           String avisoSemIglesia,  String ubicacionIglesia) {
        IdIgleisa = idIgleisa;
        NombreIglesia = nombreIglesia;
        TelefonoIglesia = telefonoIglesia;
        this.imageUrlIglesia = imageUrlIglesia;
        this.HMisaIglesia = HMisaIglesia;
        this.HConfesion = HConfesion;
        this.HOficinaIglesia = HOficinaIglesia;
        AvisoSemIglesia = avisoSemIglesia;

        UbicacionIglesia = ubicacionIglesia;
    }

    public ListItemIglesia(String idIgleisa, String nombreIglesia, String imageUrlIglesia, String ubicacionIglesia) {
        IdIgleisa = idIgleisa;
        NombreIglesia = nombreIglesia;
        this.imageUrlIglesia = imageUrlIglesia;
        UbicacionIglesia = ubicacionIglesia;
    }

    public String getIdIgleisa() {
        return IdIgleisa;
    }

    public String getNombreIglesia() {
        return NombreIglesia;
    }

    public String getTelefonoIglesia() {
        return TelefonoIglesia;
    }

    public String getImageUrlIglesia() {
        return imageUrlIglesia;
    }

    public String getHMisaIglesia() {
        return HMisaIglesia;
    }

    public String getHConfesion() {
        return HConfesion;
    }

    public String getHOficinaIglesia() {
        return HOficinaIglesia;
    }

    public String getAvisoSemIglesia() {
        return AvisoSemIglesia;
    }


    public String getUbicacionIglesia() {
        return UbicacionIglesia;
    }
}