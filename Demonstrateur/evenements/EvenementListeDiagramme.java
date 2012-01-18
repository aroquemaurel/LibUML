package evenements;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 */
public class EvenementListeDiagramme implements ActionListener {
    private JComboBox liste;
    private final int AUCUNE_CONTRAINTE = 0;
    private final int DIAGRAMME_DE_CAS_UTILISATION = 1;
    private final int DIAGRAMME_DE_CLASSE = 2;
    private final int DIAGRAMME_DE_SEQUENCE = 3;
    
    
    
    public EvenementListeDiagramme(JComboBox p_liste){
        this.liste = p_liste;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (this.liste.getSelectedIndex()){
            case AUCUNE_CONTRAINTE:
                break;
            case DIAGRAMME_DE_CAS_UTILISATION:
                break;
            case DIAGRAMME_DE_CLASSE:
                break;
            case DIAGRAMME_DE_SEQUENCE:
                break;
            default:
                ;
        }
    }
    
}
