package evenements.btn;

import ihm.fenetreInterdiction.FenetreInterdiction;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 */
public class BtnJeNeLeFeraisPlus extends JButton implements MouseListener {
    private FenetreInterdiction fenetreInterdiction;
    
    public BtnJeNeLeFeraisPlus(FenetreInterdiction p_fenetreInterdiction){
        super("Je ne le ferais plus, c'est promis");
        this.fenetreInterdiction = p_fenetreInterdiction;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.fenetreInterdiction.setVisible(false);
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
