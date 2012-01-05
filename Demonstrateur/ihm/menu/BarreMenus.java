package ihm.menu;

import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu contenant la barre de menu (Fichier, Insérer, ...)
 */
public class BarreMenus extends JMenuBar {
	/* Construit la barre de menu */
    public BarreMenus(Dimension p_dimension){
        this.setPreferredSize(p_dimension);
    }

    public void ajouterObjetsGraphiques(){
		/* Menu fichier */
        JMenu fichier = new JMenu("Fichier");
        JMenuItem enregistrer = new JMenuItem("Enregistrer");
        JMenuItem ouvrir = new JMenuItem("Ouvrir");
        JMenuItem exporter = new JMenuItem("Exporter");
        JMenuItem quitter = new JMenuItem("Quitter");

        fichier.add(enregistrer);
        fichier.add(ouvrir);
        fichier.add(exporter);
        fichier.add(quitter);

		/* Menu insérer */
        JMenu inserer = new JMenu("Insérer");
        JMenuItem carre = new JMenuItem("Carré");

        inserer.add(carre);

        add(fichier);
        add(inserer);
    }
}
