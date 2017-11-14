package Graphique;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author MOREL Charles
 */
public class Board_IHM extends JPanel {

    private List<List<CaseIHM>> boadCases;

    public Board_IHM() {
        this.setLayout(new GridBagLayout());
        this.generateBoard();
        this.boadCases.get(0).get(0).setUse(true);
        this.boadCases.get(0).get(1).setUse(true);
        this.boadCases.get(0).get(1).setFocus(true);
    }

    private void generateBoard() {
        // On remet à zéro le damier
        this.removeAll();
        this.boadCases = new ArrayList<List<CaseIHM>>();
        for (int i = 0; i < 17; i++) {
            this.boadCases.add(new ArrayList<CaseIHM>());
        }

        //On crée nos différents conteneurs de couleur différente
        this.setLayout(new GridBagLayout());

        //L'objet servant à positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < 289; i++) {
            gbc.gridx = i % 17;
            gbc.gridy = i / 17;
            if (gbc.gridx == 16) {
                gbc.gridwidth = GridBagConstraints.REMAINDER;
            } else {
                gbc.gridwidth = 1;
            }
            CaseIHM currentCase = null;
            if ((i / 17) % 2 == 0) {
                gbc.weighty = 4;
                gbc.weightx = (i % 2 == 1 ? 1 : 4);
                currentCase = (i % 2 == 1 ? new CaseIHM(TypeCaseIHM.VERTICAL_WALL) : new CaseIHM(TypeCaseIHM.PIECE));
            } else {
                gbc.weightx = 1;
                gbc.weighty = 1;
                currentCase = (i % 2 == 1 ? new CaseIHM(TypeCaseIHM.HORIZNTAL_WALL) : new CaseIHM(TypeCaseIHM.CENTRAL_WALL));
            }
            this.add(currentCase, gbc);
            this.boadCases.get(gbc.gridx).add(currentCase);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(this.getParent().getSize().height, this.getParent().getSize().height);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(this.getParent().getSize().height, this.getParent().getSize().height);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(this.getParent().getSize().height, this.getParent().getSize().height);
    }

}
