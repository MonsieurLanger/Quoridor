/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Modèle.ColorPlayer;
import Modèle.Game;
import Modèle.Player;

/**
 *
 * @author Eddine Langer
 */
public class Main {
     public static void main(String[] args) {
        //Chargement des images
        Game g=new Game(new Player("Joueur 1", ColorPlayer.BLEU),new Player("Joueur 2",ColorPlayer.ROUGE),null);
         System.out.println(g);
        Game_IHM game=new Game_IHM();
                
    }
}
