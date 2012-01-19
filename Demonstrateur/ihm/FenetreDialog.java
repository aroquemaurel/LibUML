package ihm;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 */
public class FenetreDialog extends JDialog {
    public FenetreDialog(FenetreDemo p_fenetre, String p_titre) {
        super(p_fenetre, p_titre);
    }
    public void afficherFenetre(){
        this.setVisible(true);
    }
}
