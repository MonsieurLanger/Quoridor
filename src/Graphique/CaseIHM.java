package Graphique;

import Graphique.Ressources.GetIHMRessources;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class CaseIHM extends JPanel {

    private TypeCaseIHM type;
    private boolean isUsed;
    private boolean isFocused;

    public CaseIHM(TypeCaseIHM type) {
        this.type = type;
        this.isUsed = false;
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        this.updateCase();
    }

    private void updateCaseColor() {
        if (!this.isFocused) {
            if (type == TypeCaseIHM.PIECE) {
                this.setBackground(Color.white);
            } else {
                this.setBackground(Color.gray);
            }
        } else if (this.isUsed) {
            this.setBackground(Color.red);
        } else {
            this.setBackground(Color.yellow);
        }
    }

    private void updateContent() {
        this.removeAll();
        if (this.isUsed) {
            JLabel caseContent = new JLabel();
            switch (this.type) {
                case PIECE:
                    caseContent = new CaseContentIHM("piece.png");
                    break;
                case HORIZNTAL_WALL:
                    caseContent = new CaseContentIHM("wall_h.jpg");
                    break;
                case VERTICAL_WALL:
                    caseContent = new CaseContentIHM("wall_w.jpg");
                    break;
                default:
                    break;
            }
            this.add(caseContent);
        }
    }

    public void setUse(boolean isUsed) {
        this.isUsed = isUsed;
        this.updateCase();
    }

    public void setFocus(boolean isFocused) {
        this.isFocused = isFocused;
        this.updateCase();
    }

    private void updateCase() {
        this.updateCaseColor();
        this.updateContent();
        this.revalidate();
    }
}
