package Graphique;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author MOREL Charles <charles.morel@cpe.fr>
 */
public class CaseIHM extends JPanel {

    private TypeCaseIHM type;

    public CaseIHM(TypeCaseIHM type) {
        this.type = type;
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        if (type == TypeCaseIHM.PIECE) {
            this.setBackground(Color.white);
        } else {
            this.setBackground(Color.gray);
        }
    }

}
