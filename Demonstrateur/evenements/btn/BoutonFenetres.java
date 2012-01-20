package evenements.btn;

import ihm.fenetreClasses.FenetreAjoutMethode;
import ihm.fenetreClasses.FenetreDialog;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author satenske
 */
public class BoutonFenetres extends JButton implements MouseListener {
    private FenetreAjoutMethode fenetre;
    
    public BoutonFenetres(FenetreAjoutMethode p_fenetre, String p_texte){
        super(p_texte);
        this.fenetre = p_fenetre;
        this.addMouseListener(this);
    }

    public FenetreAjoutMethode getFenetre(){
        return (this.fenetre);
    }
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
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
