/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


public class Locatie {
    private String nume;
    private int pret;
    private List<Activitate> listaActivitati;
    private Oras oras;
    private Perioada perioada;
    
        public static class Builder{
        private Locatie instance = new Locatie();
        
        public Builder setNume(String nume){
            instance.nume = nume;
            return this;
        }
            public Builder setPret(int pret){
            instance.pret = pret;
            return this;
        }
        
         public Builder setActivitati(List<Activitate> listaActivitati){
            instance.listaActivitati = listaActivitati;
            return this;
        }
        
         public Builder setPerioada(Perioada perioada){
            instance.perioada = perioada;
            return this;
        }
          public Builder setOras(Oras oras){
            instance.oras = oras;
            return this;
        }
        
        
        public Locatie build(){
            return instance;
          }
      }
        //Getteri pentru campuri
    public String getNume() {
        return nume;
    }

    public int getPret() {
        return pret;
    }

    public List<Activitate> getListaActivitati() {
        return listaActivitati;
    }

    public Oras getOras() {
        return oras;
    }

    public Perioada getPerioada() {
        return perioada;
    }
    
    
    //setteri ce ne folosesc cand vrem sa schimbam valorile campurilor

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setListaActivitati(List<Activitate> listaActivitati) {
        this.listaActivitati = listaActivitati;
    }

    public void setOras(Oras oras) {
        this.oras = oras;
    }

    public void setPerioada(Perioada perioada) {
        this.perioada = perioada;
    }
    
    
}
