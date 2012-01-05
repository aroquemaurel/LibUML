package ihm.menu;

import evenements.menu.fichier.MenuFichier;
import evenements.menu.fichier.MenuFichierEnregistrer;
import evenements.menu.fichier.MenuFichierExporter;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Menu contenant la barre de menu (Fichier, Insérer, ...)
 */
public class BarreMenus extends JMenuBar {
	private Dimension dimension;

	private void parametrerBarreMenus(){
        this.setPreferredSize(this.dimension);
	}
	/* Construit la barre de menu */
    public BarreMenus(Dimension p_dimension){
		this.dimension = p_dimension;
		this.parametrerBarreMenus();
    }

    public void ajouterObjetsGraphiques(){
		/* Menu fichier */
/*        JMenu fichier = new JMenu("Fichier");*/
		JMenu fichier = new JMenu ("Fichier");
        MenuFichierEnregistrer enregistrer = new MenuFichierEnregistrer("Enregistrer");
//        MenuFichierOuvrir ouvrir = new MenuFichierOuvrir("Ouvrir");
        MenuFichierExporter exporter = new MenuFichierExporter ("Exporter");
        JMenuItem quitter = new JMenuItem("Quitter");

        fichier.add(enregistrer);
//        fichier.add(ouvrir);
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
