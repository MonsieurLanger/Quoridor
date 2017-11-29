/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author Eddine Langer
 */
public abstract class Menu extends JPanel implements ActionListener,MouseListener{
    protected Game_IHM parentPanel;
    protected  GridBagConstraints c;
    
    public Menu(Game_IHM gIHM){
        this.setSize(400,700);
        parentPanel=gIHM;
        this.addMouseListener(this);
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
    
    }
    protected void initButtonListener(){};
    
}
