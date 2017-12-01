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
    private Color colorPlyer;

    public Player(String pseudo, Color colorPlyer) {
        this.pseudo = pseudo;
        this.colorPlyer = colorPlyer;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Color getColorPlyer() {
        return colorPlyer;
    }

    public void setColorPlyer(Color colorPlyer) {
        this.colorPlyer = colorPlyer;
    }
    
    
}
