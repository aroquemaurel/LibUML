package evenements.btn;

import ihm.FenetreAjoutClasse;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JDialog;

/**
 *
 * @author satenske
 */
public class BoutonFenetres extends JButton implements MouseListener {
    private JDialog fenetre;
    
    public BoutonFenetres(FenetreAjoutClasse p_fenetre, String p_texte){
        super(p_texte);
        this.fenetre = p_fenetre;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
