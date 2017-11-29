/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author Eddine Langer
 */
public class Menu_Choix extends Menu{
    private JButton join;
    private JButton create;
    private JButton backAcc;
    public Menu_Choix(Game_IHM gIHM) {
        super(gIHM);
        c.insets = new Insets(30, 30, 30, 30);

        join = new JButton("Rejoindre une partie");
        join.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=0;
        this.add(join,c);
        
        create = new JButton("Créer une partie");
        create.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=1;
        this.add(create,c);
        
        backAcc = new JButton("Retour");
        backAcc.setPreferredSize(new Dimension(200, 50));
        c.gridx=0;
        c.gridy=2;
        this.add(backAcc,c);
        
        initButtonListener();
        this.setVisible(true);
    }

    @Override
    protected void initButtonListener() {
        join.addActionListener(this);
        create.addActionListener(this);
        backAcc.addActionListener(this);
    }

    
    
    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            
        Object src=ae.getSource();
        if(src==backAcc){
            System.out.println("afficheChoix menu choix");
            this.parentPanel.afficheAccueil(this);
        }
        else if(src==join){
            System.out.println("afficheChoix2");
            this.parentPanel.afficheJoueur(this);
        }
        else if(src==create){
            System.out.println("afficheChoix3 ");
            this.parentPanel.afficheConfig(this);
        }
    }
    
}
