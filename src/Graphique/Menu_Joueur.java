/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Modèle.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Eddine Langer
 */
public class Menu_Joueur extends Menu{
private JLabel labelJoueur;
private JTextField nomJoueur;

private JLabel couleur;
private JLabel nomCouleur;
private JButton droite;
private JButton gauche;

private JLabel imagePion;
private JButton pret;
private JButton annuler;
private Color tabColor[]={Color.BLEU,Color.JAUNE,Color.ORANGE,Color.NOIR,Color.ROUGE,Color.VERT,Color.VIOLET};
private int indColor;
private int session;
    public Menu_Joueur(Game_IHM gIHM) {
        super(gIHM);
        session=1;
        c.insets = new Insets(15, 15, 15, 15);
        labelJoueur = new JLabel("Nom du Joueur :");
        labelJoueur.setPreferredSize(new Dimension(100, 50));
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=1;
        this.add(labelJoueur,c);
        
        nomJoueur = new JTextField();
        nomJoueur.setColumns(10);
        nomJoueur.setPreferredSize(new Dimension(200, 50));
        c.gridx=1;
        c.gridy=0;
        c.gridwidth=2;
        this.add(nomJoueur,c);
        
        couleur = new JLabel("Couleur du Pion : ");
        couleur.setPreferredSize(new Dimension(100, 50));
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=3;
        this.add(couleur,c);
        
        gauche = new JButton("<");
        gauche.setPreferredSize(new Dimension(50, 50));
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=1;
        this.add(gauche,c);
        gauche.setEnabled(false);
        indColor=0;
        nomCouleur = new JLabel(tabColor[indColor].toString());
        //nomCouleur.setHorizontalAlignment();
        
        nomCouleur.setPreferredSize(new Dimension(115, 50));
        c.gridx=1;
        c.gridy=2;
        c.gridwidth=1;
        this.add(nomCouleur,c);
        
        
        
        droite = new JButton(">");
        droite.setPreferredSize(new Dimension(50, 50));
        c.gridx=2;
        c.gridy=2;
        c.gridwidth=1;
        this.add(droite,c);
        
        imagePion = new JLabel(new ImageIcon(getClass().getResource("Ressources/bluePion.png")));
 
        imagePion.setPreferredSize(new Dimension(50, 100));
        c.gridx=0;
        c.gridy=3;
        c.gridwidth=3;
        this.add(imagePion,c);
        
        pret = new JButton("Prêt");
        pret.setPreferredSize(new Dimension(200,50));
        c.gridx=0;
        c.gridy=4;
        c.gridwidth=3;
        this.add(pret,c);
        
        annuler = new JButton("Annuler");
        annuler.setPreferredSize(new Dimension(200,50));
        c.gridx=0;
        c.gridy=5;
        c.gridwidth=3;
        this.add(annuler,c);
        initText();
        initButtonListener();
        this.setVisible(true);
    }

@Override
    protected void initButtonListener() {
        super.initButtonListener(); //To change body of generated methods, choose Tools | Templates.
        pret.addActionListener(this);
        annuler.addActionListener(this);
        nomJoueur.addActionListener(this);
        gauche.addActionListener(this);
        droite.addActionListener(this);
    
    }
    
    private void actuImage(){
        
        switch(tabColor[indColor]) {
           case BLEU:
               imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/bluePion.png")));
               break;
           case JAUNE:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/yellowPion.png")));
                break;
           case ORANGE:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/orangePion.png")));
                break;
           case NOIR:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/noirPion.png")));
                break;
           case ROUGE:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/redPion.png")));
                break;
           case VERT:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/greenPion.png")));
                break;
           case VIOLET:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/violetPion.png")));
                break;
           default:
                break;
       }
       
        
        
    }
    
    private void goTo(Color c){
        indColor=0;
       while(tabColor[indColor]!=c){
           indColor++;
       }
        if(tabColor[indColor]==Color.BLEU){
            gauche.setEnabled(false);
        }
        else {
            gauche.setEnabled(true);
        }
      
        if(tabColor[indColor]==Color.VIOLET){
            droite.setEnabled(false);
        }
        else {
            droite.setEnabled(true);
        }
        nomCouleur.setText(tabColor[indColor].toString());
        System.out.println(tabColor[indColor].toString()+ " goTo()");
        
        actuImage();
        tabColor[indColor].setTaken(false);
    
    }
    private void actuImageP(Color c){
        System.out.println("la couleur " + c + imagePion);
        switch(c) {
           case BLEU:
               imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/bluePion.png")));
               break;
           case JAUNE:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/yellowPion.png")));
                break;
           case ORANGE:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/orangePion.png")));
                break;
           case NOIR:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/noirPion.png")));
                break;
           case ROUGE:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/redPion.png")));
                break;
           case VERT:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/greenPion.png")));
                break;
           case VIOLET:
                imagePion.setIcon(new ImageIcon(getClass().getResource("Ressources/violetPion.png")));
                break;
           default:
                break;
       }
       
        
        
    }
    private void initText(){
         majColor();
          if(this.parentPanel.myGame.getPlayer1().isConfigured()==false ){
              nomJoueur.setText(this.parentPanel.myGame.getPlayer1().getPseudo());
              System.out.println(this.parentPanel.myGame.getPlayer1().getColorPlyer());
              //actuImageP(this.parentPanel.myGame.getPlayer1().getColorPlyer());
              
              goTo(this.parentPanel.myGame.getPlayer1().getColorPlyer());
              
              this.parentPanel.myGame.getPlayer1().setConfigured(true);
              session=1;
             //System.out.println("INIT1");
              
          }
          else if(this.parentPanel.myGame.getPlayer2().isConfigured()==false){
              nomJoueur.setText(this.parentPanel.myGame.getPlayer2().getPseudo());
              //actuImageP(this.parentPanel.myGame.getPlayer2().getColorPlyer());
              goTo(this.parentPanel.myGame.getPlayer2().getColorPlyer());
                
              this.parentPanel.myGame.getPlayer2().setConfigured(true);
              session=2;
              //System.out.println("INIT12");
          }
          else if(this.parentPanel.myGame.getPlayer3()!=null && this.parentPanel.myGame.getPlayer3().isConfigured()==false && this.parentPanel.myGame.getNbJoueur()>2){
              nomJoueur.setText("Joueur 3");
              goTo(this.parentPanel.myGame.getPlayer3().getColorPlyer());
              //actuImageP(this.parentPanel.myGame.getPlayer3().getColorPlyer());

              this.parentPanel.myGame.getPlayer3().setConfigured(true);
              session=3;
             // System.out.println("INIT3");
          }
          else if(this.parentPanel.myGame.getPlayer4()!=null &&this.parentPanel.myGame.getPlayer4().isConfigured()==false && this.parentPanel.myGame.getNbJoueur()>2){
              nomJoueur.setText("Joueur 4");
              goTo(this.parentPanel.myGame.getPlayer4().getColorPlyer());
              //actuImageP(this.parentPanel.myGame.getPlayer4().getColorPlyer());

              this.parentPanel.myGame.getPlayer4().setConfigured(true);
              session=4;
              //System.out.println("INIT4");
          }
                 

    }
    private void majColor(){
        System.out.println("MAJCOLOR");
        for(int i=0;i<tabColor.length;i++){
            if(tabColor[i]==this.parentPanel.myGame.getPlayer1().getColorPlyer()||tabColor[i]==this.parentPanel.myGame.getPlayer2().getColorPlyer()){
                    tabColor[i].setTaken(true);
            }
            else{
                    tabColor[i].setTaken(false);
            }

        }
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       

        //System.out.println("Le Pseudo " + nomJoueur.getText());
       Object src=ae.getSource();
       
       
       
       
       if(src==annuler){
            this.parentPanel.afficheChoix(this);
        }
       if(src==pret){
//            this.parentPanel
           //System.out.println(" La Session " + session);
        switch (session) {
            case 1: 
                this.parentPanel.myGame.getPlayer1().setPseudo(nomJoueur.getText());
                this.parentPanel.myGame.getPlayer1().setColorPlyer(tabColor[indColor]);
                break;
            case 2:  
                this.parentPanel.myGame.getPlayer2().setPseudo(nomJoueur.getText());
                this.parentPanel.myGame.getPlayer2().setColorPlyer(tabColor[indColor]);
                break;
            case 3:  
                this.parentPanel.myGame.getPlayer3().setPseudo(nomJoueur.getText());
                this.parentPanel.myGame.getPlayer3().setColorPlyer(tabColor[indColor]);
                break;
            case 4:  
                this.parentPanel.myGame.getPlayer4().setPseudo(nomJoueur.getText());
                this.parentPanel.myGame.getPlayer4().setColorPlyer(tabColor[indColor]);
                break;
            default:
                break;
        }
            
            if(session==1 || session==3){
               initText();
               this.parentPanel.afficheJoueur(this);
               //System.out.println("IF");

            }
            else{
                this.parentPanel.afficheJeu(this);
                
                
                this.parentPanel.myGame.getPlayer1().setConfigured(false);
                this.parentPanel.myGame.getPlayer2().setConfigured(false);
                initText();
                //System.out.println("ELSE");

                 
            }
            
            
       }
       
      
       if(src==gauche){
            if(tabColor[indColor]!=Color.BLEU){
              
               
                indColor--;
                
                nomCouleur.setText(tabColor[indColor].toString());
                if(tabColor[indColor]==Color.BLEU){
                    gauche.setEnabled(false);
                }
                if(tabColor[indColor]==Color.VERT){
                    droite.setEnabled(true);
                }
                
                
                actuImage();
                
                if(tabColor[indColor].getTaken()==true){
                    pret.setEnabled(false);
                }
                else{
                    pret.setEnabled(true);
                }
            }
            
        }
       if(src==droite){
            if(tabColor[indColor]!=Color.VIOLET){
                indColor++;
                nomCouleur.setText(tabColor[indColor].toString());
                if(tabColor[indColor]==Color.JAUNE){
                    gauche.setEnabled(true);
              
                }
                if(tabColor[indColor]==Color.VIOLET){
                    droite.setEnabled(false);
                }
                 actuImage();
                  
                
                if(tabColor[indColor].getTaken()==true){
                    pret.setEnabled(false);
                }
                else{
                    pret.setEnabled(true);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
