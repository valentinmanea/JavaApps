/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Activitate;
import model.Locatie;

/**
 *
 * @author Valentin
 */
public class MainService {
     
    private MainService(){ 
        
    
    }
    /*Ne folosim de proprietatea class loaderului care ne asigura
      existenta unei singure instante 
    */
    private static final class SingletonHolder{
        private static final MainService INSTANCE = new MainService(); 
    }
    public static MainService getInstance(){
        return SingletonHolder.INSTANCE;

    }
    //metoda pentru a gasi locatia dupa nume in lista de locatii
    public Locatie getLocatie(List<Locatie> listaLocatii,String nume){
        for(Locatie locatie:listaLocatii){
            if(locatie.getNume().equals(nume)){
                return locatie;
            }
        }
        return null;  
    }
    //metoda pentru a gasi top 5 locatii valabile in anumita perioada ordonate dupa cost.
    public List<Locatie> getTopLocatii(List<Locatie> listaLocatii,LocalDate startDate,LocalDate endDate){
        //sortez lista de locatii si o salvez in alta in ordine crescatoare
        List<Locatie> listaLocatiiSortata = new ArrayList<>(); 
        //Caut locatiile care au liber pe toata perioada A-B
        //Si le adaug in listaLocatiiSortata pe care o sa o sortez dupa ce o incarc
        for(Locatie locatie:listaLocatii){
            //daca data de incepput a locatiei curente este mai recenta ca data introdusa
            //si data finala a locatiei curente este dupa data introdusa ca parametru
            //Se va adauga locatia in lista cea noua 
             
            if((locatie.getPerioada().getFirstDate().isBefore(startDate))&&(locatie.getPerioada().getEndDate().isAfter(endDate))){
                listaLocatiiSortata.add(locatie);
                 
            }
        }
        //Sortare dupa cost
        Collections.sort(listaLocatiiSortata, new Comparator<Locatie>(){
            public int compare (Locatie locatie1, Locatie locatie2 ){
                return locatie1.getPret()-locatie2.getPret();
            }
        });
//        for(int i = 0; i < listaLocatiiSortata.size()-1;i++){
//            System.out.println("Pozitia "+i+listaLocatiiSortata.get(i).getNume()+" pretul:"+listaLocatiiSortata.get(i).getPret());
//        }
//        System.out.println();
       
        return listaLocatiiSortata;
    }
    
    public Locatie getCheapestLocation(List<Locatie> list,Activitate activitate){
        //cautam cea mai ieftina locatie unde se poate practica o anume activitate aleasa de client
        Locatie locatieIeftina = new Locatie.Builder()          //Ne cream o instanta de locatie unde vom salva cea mai ieftina
                .setPret(list.get(0).getPret()) 
                .setNume(list.get(0).getNume())
                .setOras(list.get(0).getOras())                  //Toate campurile vor fi initializate cu valorile campurilor al primei locatii din lista
                .setPerioada(list.get(0).getPerioada())
                .setActivitati(list.get(0).getListaActivitati())
                .build();

        for(int i = 1;i<list.size()-1;i++){ // incepem de la 1 deoarece in locatieIeftina e salvata pprima locatie
                //Calculam numarul de zile in care locatia i are disponibilitate
                long zile =DAYS.between(list.get(i).getPerioada().getEndDate(),list.get(i).getPerioada().getFirstDate()); 
                //Cautam daca locatia cu numarul i are printre activitati si activitatea cauta de client
                //Si daca o gaseste modificam valoarea variabilei de control isPresent
                boolean isPresent = false;
                for(int j = 0;j < list.get(i).getListaActivitati().size()-1;j++)  {
                    if( list.get(i).getListaActivitati().get(j).getNume().equals(activitate.getNume())){
                        isPresent = true;
                    }
                 }
                if((locatieIeftina.getPret()>list.get(i).getPret()) && (zile>=10) && (isPresent)){ //daca pretul locatiei curente este mai mic comparativ cu pretul din locatieIeftina
                    locatieIeftina.setPret(list.get(i).getPret());                  //si numarul de zile este mai mare ca 10 
                    locatieIeftina.setNume(list.get(i).getNume());                  //si in acelasi timp activitatea se regaseste printre activitatile locatiei atunci  locatiaIeftina va fi locatia curenta din iteratie    
                    locatieIeftina.setOras(list.get(i).getOras());
                    locatieIeftina.setListaActivitati(list.get(i).getListaActivitati());
                    locatieIeftina.setPerioada(list.get(i).getPerioada());
                }
        }
        return locatieIeftina;
    }   
}
