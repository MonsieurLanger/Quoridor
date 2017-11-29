/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Modèle.Regle;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author Eddine Langer
 */
public class Game_IHM extends JFrame{
  private Menu_Accueil accueilPanel;
  private Menu_Choix choixPanel;
  private Menu_Configuration configPanel;
  private Menu_Jeu jeuPanel;
  private Menu_Joueur joueurPanel;
  private Menu_Lobby lobbyPanel;
  
  private Plateau_IHM monPlato;
  
  public static  ArrayList<Regle> rules;

 private GridBagConstraints c;
  
    public Game_IHM() {
        rules =new ArrayList<Regle>();
        rules.add(new Regle(1,"Règle par défault","Chaque Joueur commence au debut de sa frontière. Votre objectif est de traverser le no man's land avant son adversaire.\n"
                +"Vous disposez de plusieurs barrières afin de ralentir votre rival et ainsi gagner l'avantage. Le jeu se joue par tour et à chaque tour vous aurez le choix entre avancer dans une case adjacente ou poser une barrière.\n"
                +"Vous avez la possibilité de sauter par dessus votre adversaire si celui-ci se trouve devant vous ou ,exceptionnelement dans cette situation, vous deplacer en diagonale si aucune barrière se trouve sur la trajectoire.\n \n"));  
        rules.add(new Regle(2,"Les Pièges","Vous disposez d'une liste de pièges que vous pouvez poser sur le terrain de jeu afin de ralentir votre adversaire.\n"
                + "Des boosts ou pièges peuvent apparaître sur le terrain, il vous suffit de passer dessus pour les récuperer et les utiliser sur votre rival pour prendre l'avantage.\n \n"));
        //Construction générale de la fenêtre
        this.setTitle("Koridunor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        init();
        c.gridx = 0;
        c.gridy = 0;
      
       
       this.add(accueilPanel, c);
      //  this.add(partiePanel, c);
       //this.add(joueurPanel, c);
        //this.add(configPanel,c);
        c.gridx = 1;
        c.gridy = 0;
        monPlato.setVisible(true);
        this.add(monPlato, c);
        this.pack();
        this.setVisible(true);
        this.repaint();
    }
    private void init() {
        c = new GridBagConstraints();
        monPlato = new Plateau_IHM();
        monPlato.setPreferredSize(new Dimension(700, 700));
        monPlato.setLayout(new GridBagLayout());
        accueilPanel = new Menu_Accueil(this);
        choixPanel=new Menu_Choix(this);
        configPanel=new Menu_Configuration(this);
        joueurPanel=new Menu_Joueur(this);
        jeuPanel=new Menu_Jeu(this);
        
        accueilPanel.setPreferredSize(new Dimension(400, 700));
        this.setLayout(new GridBagLayout());
    }
    
       public void actualisation() {
       
        this.revalidate();
        this.repaint();
    }

    void afficheChoix(Object t) {
        if(t==accueilPanel){
            this.remove(accueilPanel);
        }
        if(t==configPanel){
            this.remove(configPanel);
        }
        if(t==joueurPanel){
            this.remove(joueurPanel);
        }
        
        c.gridx = 0;
        c.gridy = 0;

        this.add(choixPanel, c);
        this.setVisible(true);
        actualisation();
    }
    
    void afficheAccueil(Object t) {
        this.remove(choixPanel);
        c.gridx = 0;
        c.gridy = 0;

        this.add(accueilPanel, c);
        this.setVisible(true);

        actualisation();
    }
    
    
    
     void afficheLobby() {
        this.remove(joueurPanel);
        c.gridx = 0;
        c.gridy = 0;

        this.add(accueilPanel, c);
        this.setVisible(true);

        actualisation();
    }
    
    
     void afficheConfig(Object t) {
        if(t==choixPanel){
            this.remove(choixPanel);
         }
        else{
            System.out.println("Nono");
        }
        
        c.gridx = 0;
        c.gridy = 0;
        this.add(configPanel, c);  
        
       
        this.setVisible(true);
        
        actualisation();
    }
     
    void afficheJoueur(Object t) {
        if(t==choixPanel){
           this.remove(choixPanel);
        }
        if(t==configPanel){
           this.remove(configPanel);
       }
      
        c.gridx = 0;
        c.gridy = 0;

        this.add(joueurPanel, c);
        this.setVisible(true);

        actualisation();
    }
    
     void afficheJeu(Object t) {
        if(t==joueurPanel){
           this.remove(joueurPanel);
        }
       
      
        c.gridx = 0;
        c.gridy = 0;

        this.add(jeuPanel, c);
        this.setVisible(true);

        actualisation();
    }
}
