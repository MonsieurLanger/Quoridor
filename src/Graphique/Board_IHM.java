package Graphique;

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
        this.setLayout(null);
        this.generateBoard();
        this.boadCases.get(0).get(8).setUse(true);
        this.boadCases.get(16).get(8).setUse(true);
    }

    private void generateBoard() {
        // On remet à zéro le damier
        this.removeAll();
        this.boadCases = new ArrayList<List<CaseIHM>>();
        for (int i = 0; i < 17; i++) {
            this.boadCases.add(new ArrayList<CaseIHM>());
        }

        //L'objet servant à positionner les composants
        for (int i = 0; i < 289; i++) {
            int x = i % 17;
            int y = i / 17;
            CaseIHM currentCase = new CaseIHM(x, y);
            this.add(currentCase);
            this.boadCases.get(y).add(currentCase);
        }
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        for (List<CaseIHM> listeCases : this.boadCases) {
            for (CaseIHM caseCourrante : listeCases) {
                caseCourrante.updateSize(width, height);
            }
        }
    }

}
