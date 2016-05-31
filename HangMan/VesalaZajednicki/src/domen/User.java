/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author Hachiko
 */
public class User implements Serializable{
    private String email;
    private String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void proveriLozinku() throws Exception{
        if(password.isEmpty()) throw new Exception("Lozinka je prazna");
        Character c = password.toCharArray()[0];
        if(!Character.isAlphabetic(c)) throw new Exception("Prvi karakter lozinke mora biti slovo");
        for (int i = 1; i < password.length(); i++) {
            c = password.toCharArray()[i];
            if (Character.isDigit(c)) return;
        }
        throw new Exception("Lozinka mora sadrzati bar jedan broj");
    }
    
    public void proveriEmail() throws Exception{
        if(email.isEmpty()) throw new Exception("Email je prazan");
        for (int i = 0; i < email.length(); i++) {
            Character c = email.toCharArray()[i];
            if('@' == c) return;
        }
        throw new Exception("Email mora sadrzati @");
    }
    
    public void logIn() throws Exception{
        proveriEmail();
        proveriLozinku();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof User) {
            User u = (User) obj;
            return u.getEmail().equals(this.email);
        }
        return false;
    }
    
    

}
