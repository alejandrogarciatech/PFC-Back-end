package com.pfc.revisiones.app.inventario.security;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorityJsonCreator {

    public SimpleGrantedAuthorityJsonCreator(@JsonProperty("authority") String rol){}

}
