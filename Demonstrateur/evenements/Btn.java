/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import ihm.FenetreDemo;
import java.awt.Color;
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

    public Btn(String p_string, FenetreDemo p_fenetre){
		super(new ImageIcon(p_string));
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
