package ihm.menu;

import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author satenske
 */
public class MenuHaut extends JMenuBar {
    private final JMenu fichier;
    private final JMenu inserer;

    private final JMenuItem enregistrer;
    private final JMenuItem ouvrir;
    private final JMenuItem exporter;
    private final JMenuItem quitter;
    private final JMenuItem carre;

    private final FenetreDemo fenetre;

    public MenuHaut(int p_largeurPanneau, int p_longueurPanneau, FenetreDemo p_fenetre){
        this.fenetre = p_fenetre;

        this.setPreferredSize(new Dimension(p_largeurPanneau, p_longueurPanneau));
        this.fichier = new JMenu("Fichier");
        this.inserer = new JMenu("Insérer");

        this.enregistrer = new JMenuItem("Enregistrer");
        this.ouvrir = new JMenuItem("Ouvrir");
        this.exporter = new JMenuItem("Exporter");
        this.quitter = new JMenuItem("Quitter");
        this.carre = new JMenuItem("Carré");
    }

    public void ajouterObjetsGraphiques(){
        this.fichier.add(this.enregistrer);
        this.fichier.add(this.ouvrir);
        this.fichier.add(this.exporter);
        this.fichier.add(this.quitter);
        this.inserer.add(this.carre);

        this.add(this.fichier);
        this.add(this.inserer);
    }
}
