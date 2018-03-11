/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Valentin
 */
//Desi clasa Activitate contine un singur String, am preferat sa o creez separat pentru decuplare
//Pe parcurs putem adauga si alte campuri activitatii, cum ar fi durata, pret, etc
public class Activitate {
    private String nume;

    public Activitate(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    
}
