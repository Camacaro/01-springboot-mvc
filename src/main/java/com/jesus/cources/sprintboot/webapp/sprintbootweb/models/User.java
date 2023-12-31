package com.jesus.cources.sprintboot.webapp.sprintbootweb.models;

public class User {

    private String name;
    private String lastname;
    private String email;

    /**
     * Este vacío sirve para el setter del post en request
     */
    public User() {

    }

    public User(String name, String lastname, String email) {
        // Se puede user varios constructores, con la sobrecarga del constructor (método)
        this(name, lastname);
        this.email = email;
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
