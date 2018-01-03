/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

/**
 *
 * @author Eddine Langer
 */
public class Player {

    private String pseudo;
    private Color colorPlayer;
    private int winner;
    private boolean configured;

    public Player(String pseudo, Color colorPlyer) {
        this.pseudo = pseudo;
        this.colorPlayer = colorPlyer;
        this.configured = false;
    }

    public void setConfigured(boolean configured) {
        this.configured = configured;
    }

    public boolean isConfigured() {
        return configured;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Color getColorPlyer() {
        return colorPlayer;
    }

    public void setColorPlyer(Color colorPlyer) {
        this.colorPlayer = colorPlyer;
    }

    @Override
    public String toString() {
        return "Player{" + "pseudo=" + pseudo + ", colorPlayer=" + colorPlayer + '}';
    }

}
