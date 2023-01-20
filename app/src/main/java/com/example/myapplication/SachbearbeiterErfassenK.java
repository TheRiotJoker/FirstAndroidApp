package com.example.myapplication;
public class SachbearbeiterErfassenK {
    public void erfasseSachbearbeiter(String name, String passwort, boolean isAdmin) throws IllegalArgumentException {
        Sachbearbeiter s = new Sachbearbeiter(name, passwort, isAdmin);
    }
}
