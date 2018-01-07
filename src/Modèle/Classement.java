/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.Arrays;

/**
 *
 * @author Eddine Langer
 */
public class Classement {

    private Player joueurclass[];
    private int i;

    public Classement() {
//        joueurclass[0]=new Joueur("moi",Couleur.BLEU,20);
//        joueurclass[1]=new Joueur("LUI",Couleur.ROUGE,15);
//        joueurclass[2]=new Joueur("ELLE",Couleur.ORANGE,33);
    }

    public void addjoueur(Player joueur) {
        int i = joueurclass.length;
        joueurclass[i] = joueur;
    }

    public void trie() {
        Arrays.sort(joueurclass);
    }

    public void afficheclass() {
        for (i = 0; i < joueurclass.length; i++) {
            System.out.println(joueurclass[i]);
        }
    }

}
