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
        rules =new ArrayList<Regle>();
        rules.add(new Regle(1,"Règle par défault","Chaque Joueur commence au debut de sa frontière. Votre objectif est de traverser le no man's land avant son adversaire.\n"
                +"Vous disposez de plusieurs barrières afin de ralentir votre rival et ainsi gagner l'avantage. Le jeu se joue par tour et à chaque tour vous aurez le choix entre avancer dans une case adjacente ou poser une barrière.\n"
                +"Vous avez la possibilité de sauter par dessus votre adversaire si celui-ci se trouve devant vous ou ,exceptionnelement dans cette situation, vous deplacer en diagonale si aucune barrière se trouve sur la trajectoire.\n \n"));  
        rules.add(new Regle(2,"Les Pièges","Vous disposez d'une liste de pièges que vous pouvez poser sur le terrain de jeu afin de ralentir votre adversaire.\n"
                + "Des boosts ou pièges peuvent apparaître sur le terrain, il vous suffit de passer dessus pour les récuperer et les utiliser sur votre rival pour prendre l'avantage.\n \n"));
        
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
    
    public void setColorPlayerP1(ColorPlayer cP1){
     p1.setColorPlyer(cP1);
    }
    
    public void setColorPlayerP2(ColorPlayer cP2){
     p2.setColorPlyer(cP2);
    }
}
