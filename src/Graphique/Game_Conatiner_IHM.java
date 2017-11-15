package Graphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Graphique.Ressources.GetIHMRessources;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLayeredPane;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class Game_Conatiner_IHM extends JPanel implements MouseListener, MouseMotionListener, ComponentListener {

    private JLabel gameTimer;
    private JLabel currentPlayerTimer;
    private JLabel currentPlayerName;
    private Board_IHM board;
    private JLabel verticalWall;
    private JLabel horizontalWall;
    private JPanel boardCentredPanel;

    JLayeredPane layeredPane;
    private JLabel piece;
    private int xAdjustment;
    private int yAdjustment;

    public Game_Conatiner_IHM() {
        // Mise en place de la mise en page
        super(new BorderLayout());
        this.addComponentListener(this);

        // Initialisation de la partie supérieure du JPanel
        JPanel infosPanel = new JPanel(new GridLayout(1, 3));
        this.gameTimer = new JLabel("Temps de jeu: 00:00");
        this.currentPlayerTimer = new JLabel("Temps restant joueur: 00:00");
        this.currentPlayerName = new JLabel("Joueur corrant: John");
        infosPanel.add(this.gameTimer);
        infosPanel.add(this.currentPlayerTimer);
        infosPanel.add(this.currentPlayerName);

        // Initialisation du plateau de jeu
        this.boardCentredPanel = new JPanel();
        this.board = new Board_IHM();
        layeredPane = new JLayeredPane();

        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
        layeredPane.add(this.board, JLayeredPane.DEFAULT_LAYER);
        boardCentredPanel.add(layeredPane, BorderLayout.CENTER);

        this.updateSubComponentsSize();

        // Initalisation de la partie basse du JPanel
        JPanel actionsPannel = new JPanel(new GridLayout(1, 5));
        this.verticalWall = new JLabel(GetIHMRessources.getIconFromRessources("wall_v.jpg"));
        actionsPannel.add(this.verticalWall);
        this.horizontalWall = new JLabel(GetIHMRessources.getIconFromRessources("wall_h.jpg"));
        actionsPannel.add(this.horizontalWall);

        // Ajout des composants au continer
        this.add(infosPanel, BorderLayout.NORTH);
        this.add(boardCentredPanel, BorderLayout.CENTER);
        this.add(actionsPannel, BorderLayout.SOUTH);
    }

    private void updateSubComponentsSize() {
        int maxHeight = this.boardCentredPanel.getSize().height;
        layeredPane.setMaximumSize(new Dimension(maxHeight, maxHeight));
        layeredPane.setMinimumSize(new Dimension(maxHeight, maxHeight));
        layeredPane.setPreferredSize(new Dimension(maxHeight, maxHeight));
        this.board.setBounds(0, 0, maxHeight, maxHeight);
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        piece = null;
        Component c = this.board.findComponentAt(me.getX(), me.getY());
        if (c == null || !(c instanceof CaseIHM)) {
            return;
        }
        
       CaseIHM currentCase = (CaseIHM) c;
       currentCase.setFocus(true);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (piece == null) {
            return;
        }
        piece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.updateSubComponentsSize();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}
