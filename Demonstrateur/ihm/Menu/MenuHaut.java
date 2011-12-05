/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm.Menu;

import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author satenske
 */
public class MenuHaut extends JMenuBar {
    /* Pour le menu */
    private JMenu fichier;
    private JMenu inserer;
    
    private JMenuItem enregistrer;
    private JMenuItem ouvrir;
    private JMenuItem exporter;
    private JMenuItem quitter;
    private JMenuItem carre;

    public MenuHaut(int p_largeurPanneau, int p_longueurPanneau){
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
