package com.edilmer.examen.Models;

/**
 * Created by edil ch on 26/04/2017.
 */

public class User {
    private String name;
    private String username;
    private String email;
    //cadena
    public String getName() {
        return name;
    }
    //Escoger un nombre
    public void setName(String name) {
        this.name = name;
    }
    //obtener el nombre de usuario
    public String getUsername() {
        return username;
    }
    //Nombre de usuario
    public void setUsername(String username) {
        this.username = username;
    }
    //cadena
    public String getEmail() {
        return email;
    }
    //escoger un mail
    public void setEmail(String email) {
        this.email = email;
    }
}