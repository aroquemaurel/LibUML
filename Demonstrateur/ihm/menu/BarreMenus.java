package ihm.menu;

import evenements.menu.fichier.MenuFichierEnregistrer;
import evenements.menu.fichier.MenuFichierExporter;
import evenements.menu.fichier.MenuFichierOuvrir;
import evenements.menu.fichier.MenuFichierQuitter;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * Menu contenant la barre de menu (Fichier, Insérer, ...)
 */
public class BarreMenus extends JMenuBar {
    /**
     * Dimension de la barre de menu
     */
    private final Dimension dimension;

    /** 
     * Paramètres de la barre de menus 
     */
    private void parametrerBarreMenus(){
        this.setPreferredSize(this.dimension);
    }

    /** 
     * Construit la barre de menu 
     */
    public BarreMenus(Dimension p_dimension){
        this.dimension = p_dimension;
        this.parametrerBarreMenus();
    }

    /** 
     * Ajout les objets grpahiques dans la barre de menu 
     */
    public void ajouterObjetsGraphiques(){
        /* Menu fichier */
        JMenu fichier = new JMenu ("Fichier");
        MenuFichierEnregistrer enregistrer = new MenuFichierEnregistrer("Enregistrer");
        MenuFichierOuvrir ouvrir = new MenuFichierOuvrir("Ouvrir");
        MenuFichierExporter exporter = new MenuFichierExporter ("Exporter");
        MenuFichierQuitter quitter = new MenuFichierQuitter("Quitter");
        fichier.add(enregistrer);
        fichier.add(ouvrir);
        fichier.add(exporter);
        fichier.add(quitter);

        add(fichier);
    }
}
