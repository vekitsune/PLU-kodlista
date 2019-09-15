/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plukodgyakorlo2;

import java.io.*;

/**
 *
 * @author Verosffy
 */
public class TermekKodParos implements Serializable{
    private String termeknev;
    private String termekkod;
    String kategoria;
    int elofordulasAListaban;

    public TermekKodParos(String termeknev, String termekkod) {
        this.termeknev = termeknev;
        this.termekkod = termekkod;
    }
    public boolean egyformae(TermekKodParos termekKOdParos){
        if(this.termeknev.equalsIgnoreCase(termekKOdParos.termeknev)&&
                this.termekkod==termekKOdParos.termekkod){
            return true;
        }else{
            return false;
        }
    }

    public String getTermekkod() {
        return termekkod;
    }

    public void setTermekkod(String termekkod) {
        this.termekkod = termekkod;
    }

    public String getTermeknev() {
        return termeknev;
    }

    public void setTermeknev(String termeknev) {
        this.termeknev = termeknev;
    }
    
    
}
