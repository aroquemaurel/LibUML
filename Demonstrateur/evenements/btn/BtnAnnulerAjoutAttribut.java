package evenements.btn;

import ihm.fenetreClasses.FenetreAjoutAttribut;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author satenske
 */
public class BtnAnnulerAjoutAttribut extends JButton implements MouseListener {
    private FenetreAjoutAttribut fenetre;
    public BtnAnnulerAjoutAttribut(FenetreAjoutAttribut p_fenetre) {
        super("Je ne veut plus !");
        this.fenetre = p_fenetre;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        this.fenetre.setVisible(false);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
