package evenements;

import ihm.FenetreDemo;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * superClasse btn
 */
public class Btn extends JButton implements MouseListener {
    protected FenetreDemo fenetre;

	/* paramètres des boutons */
	private void parametrerBtn(){
		super.setOpaque(false);
		super.setBorderPainted(false);
		super.setPreferredSize(new Dimension(25,25));
		super.setFocusPainted(false);
        this.addMouseListener(this);
	}

	/* Constructeur appellé par les classes filles */
    public Btn(String p_nomImage, FenetreDemo p_fenetre){
        /* on transforme p_nomImage pour obtenir le lien de l'image en question */
		super(new ImageIcon("images/btn_".
            concat(p_nomImage).
            concat(".jpg")));

        this.fenetre = p_fenetre;
		this.parametrerBtn();
    }

	@Override
    public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
    }

	@Override
    public void mouseEntered(MouseEvent event) { }

	@Override
    public void mouseExited(MouseEvent event) { }

	@Override
    public void mousePressed(MouseEvent event) { }

	@Override
    public void mouseReleased(MouseEvent event) { }


}
