/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plukodgyakorlo2;

import java.io.EOFException;
import java.io.FileInputStream;
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

    TermekKodParos egytermek;
    TermekKodParos mastermek;
    TermekKodParos nincsistermek = new TermekKodParos("nincs adat", "nincs adat");
    ArrayList<TermekKodParos> termeklista;
    String[] termeknevTomb;
    String[] termekkodTomb;

    int veletlenTermeklistaIndex;
    ArrayList<TermekKodParos> minitermeklista;
    int minilistaMeret = 0;

    public void minilistaFeltolto() {

        minitermeklista = new ArrayList<>();
        if (minilistaMeret == 0) {
            minitermeklista.add(nincsistermek);
        } else {

            for (int i = 0; i < minilistaMeret; i++) {
                sorszamkivaszto();
                egytermek = new TermekKodParos(termeklista.get(veletlenTermeklistaIndex).getTermeknev(),
                        termeklista.get(veletlenTermeklistaIndex).getTermekkod());
                minitermeklista.add(egytermek);

            }
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

    public void termekHozzaadasAListahoz() {
        termeklista.add(egytermek);

    }

    public void termekValtoztato(TermekKodParos regiTermekadatok, TermekKodParos javitottTermekadatok) {
        termeklista.remove(regiTermekadatok);
        termeklista.add(javitottTermekadatok);
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
        termeklista = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream("src\\segedlet\\TermekKodparos.dat");
            ObjectInputStream inputObject = new ObjectInputStream(file);

            boolean tartmegafile = true;
            while (tartmegafile) {
                try {

                    termeklista.add((TermekKodParos) inputObject.readObject());

                } catch (EOFException e) {
                    tartmegafile = false;
                }
            }
            inputObject.close();
        } catch (IOException ex) {
            Logger.getLogger(Adatkikerdezo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Adatkikerdezo.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (termeklista.isEmpty()) {

            termeklista.add(nincsistermek);
        }

    }

}
