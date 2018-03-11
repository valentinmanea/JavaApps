/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

/**
 *
 * @author Valentin
 */
public class Perioada {
    private LocalDate firstDate;
    private LocalDate endDate;

  
    public Perioada(LocalDate firstDate, LocalDate endDate) {
        this.firstDate = firstDate;
        this.endDate = endDate;
    }
    
/*//Metoda ce are scop calcularea zilelor dintre doua date.
    public long getDays(LocalDate ld1,LocalDate ld2){
        return DAYS.between(ld1, ld2);
    }*/

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
}
