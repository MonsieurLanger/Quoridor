/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;

/**
 *
 * @author Eddine Langer
 */
public class Game {
    private Player p1;
    private Player p2;
    private Player p3;
    private Player p4;
    //potentiellement d'autres joueurs
    private Player pcourant;
    private boolean online;
    private int nbJoueur;
    
    private Board myBoard;
    private boolean jouable;
    private ArrayList<Regle> rules;

    public Game(Player p1, Player p2, Board myBoard) {
        this.p1 = p1;
        this.p2 = p2;
        this.pcourant=this.p1;
        
        this.jouable=false;
        this.myBoard = myBoard; 
        myBoard.init_Board();
        myBoard.affiche();
        rules =new ArrayList<Regle>();
        rules.add(new Regle(1,"Règle par défault","\"DEROULEMENT D'UNE PARTIE:\"\n" 
           + "Chaque tour, le joueur choisit entre déplacer son pion ou poser une barrière (jusqu'à ce qu'il n'y en ait plus).\"\n\n" 
           +"DEPLACEMENT DES PIONS:\n"
           + "Les pions se déplacent d'une case (horizontalement ou verticalement), en avant ou en arrière.\nLes barrières doivent être contournées.\"\n\n" 
                + "POSE DES BARRIERES:\n" +
             "Une barrière doit être posée sur deux intercases (grises) adjacentes et alignées horizontalement ou verticalement.\"\n"
+             "Elle ne peut pas complètement bloquer l'accès de l'adversaire à sa ligne de but.\"\n\n" +
            "FACE A FACE:\n" +
            "Quand 2 pions sont sur des cases voisines (sans barrière entre les 2), le joueur dont c'est le tour peut sauter son adversaire.\"\n" +
            "S'il y a une barrière derrière l'adversaire, le joueur peut se placer à droite ou à gauche de son adversaire.\"\n\n" +
             "FIN DE LA PARTIE:\"\n" +
             "Le premier joueur qui atteind une des cases de la ligne opposée à son départ gagne la partie.\n\n"
        +"DEROULEMENT D'UNE PARTIE:\n"
            + "Chaque tour, le joueur choisit entre déplacer son pion ou poser une barrière (jusqu'à ce qu'il n'y en ait plus).\n"
            + "DEPLACEMENT DES PIONS:\n"
            + "Les pions se déplacent d'une case (horizontalement ou verticalement), en avant ou en arrière.\nLes barrières doivent être contournées.\n\n"
            + "POSE DES BARRIERES:\n"
            + "Une barrière doit être posée sur deux intercases (grises) adjacentes et alignées horizontalement ou verticalement.\n"
            + "Elle ne peut pas complètement bloquer l'accès de l'adversaire à sa ligne de but.\n\n"
            + "FACE A FACE:\n"
            + "Quand 2 pions sont sur des cases voisines (sans barrière entre les 2), le joueur dont c'est le tour peut sauter son adversaire (1 seul adversaire sauté par tour).\n"
            + "S'il y a une barrière derrière l'adversaire, le joueur peut se placer à droite ou à gauche de son adversaire.\n\n"
            + "FIN DE LA PARTIE:\n"
            + "Le premier joueur qui atteind une des cases de la ligne opposée à son départ gagne la partie."
        
    
        ));  
        rules.add(new Regle(2,"Les Pièges","Vous disposez d'une liste de pièges que vous pouvez poser sur le terrain de jeu afin de ralentir votre adversaire.\n"
                + "Des boosts ou pièges peuvent apparaître sur le terrain, il vous suffit de passer dessus pour les récuperer et les utiliser sur votre rival pour prendre l'avantage.\n \n"
        
        
        
        
        
        ));
        
       
        
    }
    
    @Override
    public String toString() {
        return "Game{" + "p1=" + p1 + ", p2=" + p2 + '}';
    }

    public void setJouable(boolean jouable) {
        this.jouable = jouable;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isOnline() {
        return online;
    }

    public int getNbJoueur() {
        return nbJoueur;
    }

    public void setNbJoueur(int nbJoueur) {
        this.nbJoueur = nbJoueur;
    }

    public boolean isJouable() {
        return jouable;
    }
    
    public void switchPlayer(){
        if(pcourant==p1){
            pcourant=p2;
        }
        else if(pcourant==p2){
            pcourant=p1;
        }
    }

    public ArrayList<Regle> getRules() {
        return rules;
    }
    
    public void setNomPlayerP1(String nomP1){
      
     p1.setPseudo(nomP1);
    }
    
    public void setNomPlayerP2(String nomP2){
     p2.setPseudo(nomP2);
    }
    
    public void setColorPlayerP1(Color cP1){
     p1.setColorPlyer(cP1);
    }
    
    public void setColorPlayerP2(Color cP2){
     p2.setColorPlyer(cP2);
    }
    
    public Player getPlayer1(){
        if(p1!=null){
                return p1;
        }
        
        return null;
    }
    public Player getPlayer2(){
     if(p2!=null){
                return p2;
        }
        
        return null;
    }
    public Player getPlayer3(){
         if(p3!=null){
                return p3;
        }
        
        return null;
    }
    public Player getPlayer4(){
     if(p4!=null){
                return p4;
        }
        
        return null;
    }
    
    
    public void afficherJoueur(){
    
        System.out.println("Les Joueurs sont :" + p1 +p2);
        
        if(nbJoueur==4){
            System.out.println(""+ p3 +p4);
        }
    
    } 
}
