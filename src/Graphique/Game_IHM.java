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
import Graphique.Game_Core.Game_Conatiner_IHM;
import Modèle.ColorPlayer;
import Modèle.Game;
import Modèle.Player;

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
  public Game myGame;
  private JPanel monPlato;
  
  

 private GridBagConstraints c;
  
    public Game_IHM() {
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
        myGame=new Game(new Player("Joueur 1", ColorPlayer.BLEU),new Player("Joueur 2",ColorPlayer.ROUGE),null);

        monPlato = new JPanel();
        monPlato.setPreferredSize(new Dimension(700, 700));
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
        if(t==choixPanel){
            this.remove(choixPanel);
        }
        if(t==jeuPanel){
            this.remove(jeuPanel);
            this.remove(monPlato);
        }
        monPlato = new JPanel();
        monPlato.setPreferredSize(new Dimension(700, 700));
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
           this.remove(monPlato);
        }
       if(t==configPanel){
           this.remove(configPanel);
           this.remove(monPlato);
       }
      
        c.gridx = 0;
        c.gridy = 0;

        this.add(jeuPanel, c);
        
       c.gridx=1;
       c.gridy=0;
       monPlato=new Game_Conatiner_IHM();
       this.add(monPlato,c);
      // Game_Conatiner_IHM tmp =  (Game_Conatiner_IHM) monPlato;
       
       monPlato.setPreferredSize(new Dimension(700, 700));

     // tmp.updateSubComponentsSize();
     // monPlato.repaint();
     //  monPlato.revalidate();
       
       this.setVisible(true);

       actualisation();
    }
}
