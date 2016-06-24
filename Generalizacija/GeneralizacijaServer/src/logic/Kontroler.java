/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domen.User;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Hachiko
 */
public class Kontroler {
    private static Kontroler instance;
    private List<String> gradovi;
    private List<String> timovi;
    private List<String> predmeti;
    private List<User> korisnici;

    public Kontroler() {
    gradovi = new LinkedList<>();
    
    gradovi.add("Beograd");
    gradovi.add("Novi Sad");
    gradovi.add("Nis");
    gradovi.add("Leskovac");
    gradovi.add("Pariz");
    gradovi.add("London");
    gradovi.add("Lisabon");
    
    timovi = new LinkedList<>();
    
    timovi.add("Mancherster United");
    timovi.add("Liverpool");
    timovi.add("Chelsea");
    timovi.add("Zvezda");
    timovi.add("Partizan");
    timovi.add("OFK Beograd");
    timovi.add("Radnicki");
    
    predmeti = new LinkedList<>();
    
    predmeti.add("Matematika");
    predmeti.add("Osnove organizacije");
    predmeti.add("Projektovanje softvera");
    predmeti.add("Softverski paterni");
    
    korisnici = new LinkedList<>();
    }
    
    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public List<String> getGradovi() {
        return gradovi;
    }

    public List<String> getTimovi() {
        return timovi;
    }

    public List<String> getPredmeti() {
        return predmeti;
    }

    public List<User> getKorisnici() {
        return korisnici;
    }
    
    public void dodajUsera(User u) throws Exception{
        for (User user : korisnici) {
            if(user.equals(u)) throw new Exception("Korisnik je vec ulogovan");
        }
        korisnici.add(u);
    }
    
    public void obrisiUsera(User u){
        korisnici.remove(u);
    }
    
}
