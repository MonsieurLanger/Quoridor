package Graphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Graphique.Ressources.GetIHMRessources;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
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
    private JPanel verticalWall;
    private JPanel horizontalWall;
    private JPanel actionsPannel;
    private JPanel boardCentredPanel;

    private JLayeredPane layeredPane;
    private JLabel pieceDeplaced;
    private TypeCaseIHM typePieceDeplaced;

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
        this.actionsPannel = new JPanel(new GridLayout(1, 5));
        this.actionsPannel.addMouseListener(this);
        this.actionsPannel.addMouseMotionListener(this);

        this.verticalWall = new JPanel();
        this.verticalWall.add(new CaseContentIHM("wall_v.jpg"));
        this.horizontalWall = new JPanel();
        this.horizontalWall.add(new CaseContentIHM("wall_h.jpg"));

        this.actionsPannel.add(new JPanel());
        this.actionsPannel.add(this.verticalWall);
        this.actionsPannel.add(new JPanel());
        this.actionsPannel.add(this.horizontalWall);
        this.actionsPannel.add(new JPanel());

        // Ajout des composants au continer
        this.add(infosPanel, BorderLayout.NORTH);
        this.add(boardCentredPanel, BorderLayout.CENTER);
        this.add(actionsPannel, BorderLayout.SOUTH);
    }

    private void updateSubComponentsSize() {
        int maxHeight = (int) (this.getSize().height * 0.85);
        this.layeredPane.setMaximumSize(new Dimension(maxHeight, maxHeight));
        this.layeredPane.setMinimumSize(new Dimension(maxHeight, maxHeight));
        this.layeredPane.setPreferredSize(new Dimension(maxHeight, maxHeight));
        this.board.setBounds(0, 0, maxHeight, maxHeight);
        maxHeight = this.getSize().height;
        if (this.actionsPannel != null) {
            this.actionsPannel.setPreferredSize(new Dimension(this.getSize().width - 1, maxHeight / 10));
            this.actionsPannel.setMaximumSize(new Dimension(this.getSize().width - 1, maxHeight / 10));
            this.actionsPannel.setMaximumSize(new Dimension(this.getSize().width - 1, maxHeight / 10));
        }
        if (this.verticalWall != null) {
            this.verticalWall.setBounds(0, 0, maxHeight / 60, maxHeight / 60);
        }
        if (this.horizontalWall != null) {
            this.horizontalWall.setBounds((maxHeight / 60) * 4, 0, maxHeight / 60, maxHeight / 60);
        }
        this.repaint();
        this.revalidate();
    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        pieceDeplaced = null;

        Component c = this.board.findComponentAt(me.getX(), me.getY());
        if (c != null && c instanceof CaseContentIHM) {
            CaseIHM currentCase = (CaseIHM) c.getParent();
            currentCase.setUse(false);
            pieceDeplaced = (CaseContentIHM) c;
            pieceDeplaced.setLocation(me.getX(), me.getY());
            pieceDeplaced.setSize(pieceDeplaced.getWidth(), pieceDeplaced.getHeight());
            this.typePieceDeplaced = currentCase.getType();
            layeredPane.add(pieceDeplaced, JLayeredPane.DRAG_LAYER);
        }

        c = this.actionsPannel.findComponentAt(me.getX(), me.getY());
        if (c != null && c instanceof CaseContentIHM) {
            JPanel parent = (JPanel) c.getParent();
            if (parent.equals(this.horizontalWall)) {
                pieceDeplaced = new CaseContentIHM("wall_h.jpg");
                this.typePieceDeplaced = TypeCaseIHM.HORIZNTAL_WALL;
            }
            if (parent.equals(this.verticalWall)) {
                pieceDeplaced = new CaseContentIHM("wall_v.jpg");;
                this.typePieceDeplaced = TypeCaseIHM.VERTICAL_WALL;
            }
            pieceDeplaced.setLocation(0, 0);
            pieceDeplaced.setSize(50, 50);
            layeredPane.add(pieceDeplaced, JLayeredPane.DRAG_LAYER);
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        if (pieceDeplaced == null) {
            return;
        }

        pieceDeplaced.setVisible(false);

        int X = me.getLocationOnScreen().x - this.board.getLocationOnScreen().x;
        int Y = me.getLocationOnScreen().y - this.board.getLocationOnScreen().y;

        Component c = this.board.findComponentAt(X, Y);

        if (c instanceof CaseIHM) {
            CaseIHM caseCourrante = (CaseIHM) c;
            caseCourrante.setUse(true);
            caseCourrante.setFocus(false);
        }

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
        if (pieceDeplaced == null) {
            return;
        }

        int X = me.getLocationOnScreen().x - this.board.getLocationOnScreen().x;
        int Y = me.getLocationOnScreen().y - this.board.getLocationOnScreen().y;
        pieceDeplaced.setLocation(X, Y);

        Component c = this.board.findComponentAt(X, Y);

        if (c instanceof CaseIHM) {
            CaseIHM caseCourrante = (CaseIHM) c;
            int x = caseCourrante.getCoords().getX();
            int y = caseCourrante.getCoords().getY();
            this.board.resetFocusedCases();
            if (caseCourrante.getType() == this.typePieceDeplaced) {
                this.board.setFocusOnCase(x, y);
                switch (this.typePieceDeplaced) {
                    case HORIZNTAL_WALL:
                        this.board.setFocusOnCase(x + 1, y);
                        this.board.setFocusOnCase(x + 2, y);
                        break;
                    case VERTICAL_WALL:
                        this.board.setFocusOnCase(x, y + 1);
                        this.board.setFocusOnCase(x, y + 2);
                        break;
                }
            }
        }
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
