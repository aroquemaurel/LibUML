package evenements;

import ihm.FenetreDemo;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
* Cette superclasse Btn permet de gérer l'ensemble des boutons utilisés par le démonstrateur.
*/
public class Btn extends JButton implements MouseListener {
	/**
	 * La fenêtre dans laquelle apparait le bouton
	 */
    protected FenetreDemo fenetre;

    /* paramètres des boutons */
    private void parametrerBtn(){
		super.setOpaque(false);
		super.setBorderPainted(false);
		super.setPreferredSize(new Dimension(25,25));
		super.setFocusPainted(false);
		this.addMouseListener(this);
    }

    /**
    * Constructeur de la classe Btn qui est appellé par les classes filles.
    * @param p_nomImage nom de l'image utilisé pour le graphique du bouton.
    * @param p_fenetre nom de la fenêtre dans laquelle apparait le bouton
    */
    public Btn(String p_nomImage, FenetreDemo p_fenetre){
        /* on transforme p_nomImage pour obtenir le lien de l'image en question */
		super(new ImageIcon("images/btn_".
			concat(p_nomImage).
			concat(".jpg")));

		this.fenetre = p_fenetre;
		this.parametrerBtn();
    }

    /**
    * Cette méthode permet de gérer l'action de clic avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
    }

    /**
    * Cette méthode permet de gérer l'action d'entrée avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseEntered(MouseEvent event) { }

    /**
    * Cette méthode permet de gérer l'action de sortie avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseExited(MouseEvent event) { }

    /**
    * Cette méthode permet de gérer l'action de pression avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mousePressed(MouseEvent event) { }

    /**
    * Cette méthode permet de gérer l'action de release avec la souris.
    * @param event évènement en cours
    */
    @Override
    public void mouseReleased(MouseEvent event) { }
    
}
