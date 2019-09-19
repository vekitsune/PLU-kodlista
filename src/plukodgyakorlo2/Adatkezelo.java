/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plukodgyakorlo2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Verosffy
 */
public class Adatkezelo {

    private TermekKodParos egytermek;
    private TermekKodParos mastermek;
    private TermekKodParos nincsistermek = new TermekKodParos("nincs adat", "nincs adat");
    private ArrayList<TermekKodParos> termeklista;
    private String[] termeknevTomb;
    private String[] termekkodTomb;

    private int veletlenTermeklistaIndex;
    private int kivalasztottTermekIndex;
    private ArrayList<TermekKodParos> minitermeklista;
    private int minilistaMeret = 0;

    public void termekAdatJavitas(TermekKodParos regiAdat, TermekKodParos ujAdat) {
        termeklista.remove(regiAdat);
        termeklista.add(ujAdat);
        listaElmento();
        termeklista.removeAll(termeklista);
        listafeltolto();

    }

    public void minilistaFeltolto() {

        minitermeklista = new ArrayList<>();

        for (int i = 0; i < minilistaMeret; i++) {
            sorszamkivaszto();
            egytermek = new TermekKodParos(termeklista.get(veletlenTermeklistaIndex).getTermeknev(),
                    termeklista.get(veletlenTermeklistaIndex).getTermekkod());
            minitermeklista.add(egytermek);

        }
    }

    public void termeknevTombFeltolto() {
        termeknevTomb = new String[termeklista.size()];
        for (int i = 0; i < termeklista.size(); i++) {
            termeknevTomb[i] = termeklista.get(i).getTermeknev();
        }
    }

    public void termekkodFeltolto() {
        termekkodTomb = new String[termeklista.size()];
        for (int i = 0; i < termeklista.size(); i++) {
            termekkodTomb[i] = termeklista.get(i).getTermekkod();

        }
    }

    public void listaElmento() {

        try {
            FileOutputStream file = new FileOutputStream("src\\segedlet\\TermekKodparos.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (int i = 0; i < termeklista.size(); i++) {
                outputFile.writeObject(termeklista.get(i));
            }
            outputFile.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void ujtermekletrehozo(String termeknev, String termekkod) {
        egytermek = new TermekKodParos(termeknev, termekkod);
    }

    public void sorszamkivaszto() {

        int letszam = termeklista.size();
        if (letszam == 0) {
            veletlenTermeklistaIndex = -1;
        } else {

            Random rd = new Random();

            veletlenTermeklistaIndex = rd.nextInt(letszam);
        }
    }

    public void listafeltolto() {
        termeklista = new ArrayList<TermekKodParos>();

        try {
            FileInputStream file = new FileInputStream("src\\segedlet\\TermekKodparos.dat");
            ObjectInputStream inputObject = new ObjectInputStream(file);

            boolean tartmegafile = true;
            while (tartmegafile) {
                try {

                    termeklista.add((TermekKodParos) inputObject.readObject());
                } catch (EOFException e) {
                    tartmegafile = !tartmegafile;

                } catch (Exception f) {
                    JOptionPane.showMessageDialog(null, "Gond  a jobs.dat fileban");
                }
            }
            inputObject.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ioexeption gond a jobs-dat fileban");
        }
//                } catch (EOFException e) {
//                    tartmegafile = false;
//                }catch (FileNotFoundException e){
//                    
//                }catch(ClassNotFoundException e){
//                    
//                }
//            }
//            inputObject.close();
//        } catch (IOException ex) {
//            Logger.getLogger(Adatkikerdezo.class.getName()).log(Level.SEVERE, null, ex);
//        } 

    }

    public TermekKodParos getEgytermek() {
        return egytermek;
    }

    public void setEgytermek(TermekKodParos egytermek) {
        this.egytermek = egytermek;
    }

    public TermekKodParos getMastermek() {
        return mastermek;
    }

    public void setMastermek(TermekKodParos mastermek) {
        this.mastermek = mastermek;
    }

    public TermekKodParos getNincsistermek() {
        return nincsistermek;
    }

    public void setNincsistermek(TermekKodParos nincsistermek) {
        this.nincsistermek = nincsistermek;
    }

    public ArrayList<TermekKodParos> getTermeklista() {
        return termeklista;
    }

    public void setTermeklista(ArrayList<TermekKodParos> termeklista) {
        this.termeklista = termeklista;
    }

    public String[] getTermeknevTomb() {
        return termeknevTomb;
    }

    public void setTermeknevTomb(String[] termeknevTomb) {
        this.termeknevTomb = termeknevTomb;
    }

    public String[] getTermekkodTomb() {
        return termekkodTomb;
    }

    public void setTermekkodTomb(String[] termekkodTomb) {
        this.termekkodTomb = termekkodTomb;
    }

    public int getVeletlenTermeklistaIndex() {
        return veletlenTermeklistaIndex;
    }

    public void setVeletlenTermeklistaIndex(int veletlenTermeklistaIndex) {
        this.veletlenTermeklistaIndex = veletlenTermeklistaIndex;
    }

    public int getKivalasztottTermekIndex() {
        return kivalasztottTermekIndex;
    }

    public void setKivalasztottTermekIndex(int kivalasztottTermekIndex) {
        this.kivalasztottTermekIndex = kivalasztottTermekIndex;
    }

    public ArrayList<TermekKodParos> getMinitermeklista() {
        return minitermeklista;
    }

    public void setMinitermeklista(ArrayList<TermekKodParos> minitermeklista) {
        this.minitermeklista = minitermeklista;
    }

    public int getMinilistaMeret() {
        return minilistaMeret;
    }

    public void setMinilistaMeret(int minilistaMeret) {
        this.minilistaMeret = minilistaMeret;
    }

}
