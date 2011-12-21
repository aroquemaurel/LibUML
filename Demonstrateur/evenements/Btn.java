package evenements;

import ihm.FenetreDemo;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author satenske
 */
public class Btn extends JButton implements MouseListener {
    protected FenetreDemo fenetre;

    public Btn(String p_nomImage, FenetreDemo p_fenetre){
        /* on transforme p_nomImage pour obtenir le lien de l'image en question */
		super(new ImageIcon(new String("images/btn_").
            concat(p_nomImage).
            concat(new String(".jpg"))));
        
        this.fenetre = p_fenetre;
		super.setOpaque(false);
		super.setBorderPainted(false);
		super.setPreferredSize(new Dimension(25,25));
		super.setFocusPainted(false);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
    }

    public void mouseEntered(MouseEvent event) { }

    public void mouseExited(MouseEvent event) { }

    public void mousePressed(MouseEvent event) { }

    public void mouseReleased(MouseEvent event) { }


}
