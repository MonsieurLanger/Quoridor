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
    private ColorPlayer colorPlayer;
    private int winner;
    

    public Player(String pseudo, ColorPlayer colorPlyer) {
        this.pseudo = pseudo;
        this.colorPlayer = colorPlyer;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ColorPlayer getColorPlyer() {
        return colorPlayer;
    }

    public void setColorPlyer(ColorPlayer colorPlyer) {
        this.colorPlayer = colorPlyer;
    }

    @Override
    public String toString() {
        return "Player{" + "pseudo=" + pseudo + ", colorPlayer=" + colorPlayer + '}';
    }
    
    
}
