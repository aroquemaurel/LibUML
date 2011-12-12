/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import ihm.FenetreDemo;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author satenske
 */
public class Btn extends JButton implements MouseListener {
    protected FenetreDemo fenetre;

    public Btn(String p_lienImage, FenetreDemo p_fenetre){
		/* à utiliser lorsque ce sera le
		 * lien de l'image qui passera en paramètre
		 Provisoirement, c'est juste du texte
		 TODO images pour les boutons */
	//	super(new ImageIcon(p_lienImage));
		super(p_lienImage);
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

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {
    }


}
