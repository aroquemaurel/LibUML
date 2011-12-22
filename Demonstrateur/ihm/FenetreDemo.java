package ihm;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;
import eltGraphique.CasUtilisation;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.LienContinu;
import eltGraphique.ligne.fleche.FlecheContinue;
import ihm.menu.BarreOutilsDessin;
import ihm.menu.Menu;
import ihm.menu.MenuDroite;
import ihm.menu.MenuHaut;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 *
 *
 * @author satenske
 */
public class FenetreDemo extends JFrame {
    private static final int HAUTEUR_FENETRE =
		(int) (Toolkit.getDefaultToolkit().getScreenSize().height - 
                       Toolkit.getDefaultToolkit().getScreenSize().height*0.05);
    private static final int LARGEUR_FENETRE =
		Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int HAUTEUR_MENUBAR = 20;
    private static final int HAUTEUR_ZONEDETRAVAIL = HAUTEUR_FENETRE - HAUTEUR_MENUBAR - 80;

    private static final int LARGEUR_MENUGAUCHE = 100;
    private static final int LARGEUR_TABLEAUDROITE = 500;
    private static final int LARGEUR_GRAPH =
                        LARGEUR_FENETRE - LARGEUR_MENUGAUCHE - LARGEUR_TABLEAUDROITE - 30;

    private final JPanel panneauPrincipal;
    private final BarreOutilsDessin toolbar;
    private final Menu menuDroite;

    private final PanneauGraph panneauGraph;

    private final MenuHaut menuHaut;

    private void ajouterPanneaux() {
        this.panneauPrincipal.add(this.menuHaut);
        this.panneauPrincipal.add(this.toolbar);
        this.panneauPrincipal.add(this.panneauGraph);
        this.panneauPrincipal.add(this.menuDroite.getPanneau());
    }

    private void ajouterBoutons(){
        this.menuHaut.ajouterObjetsGraphiques();
        this.toolbar.ajouterObjetsGraphiques();
        this.menuDroite.ajouterObjetsGraphiques();
    }

    private void parametrerFenetre(){
        this.setTitle("Démonstrateur de la bibliothèque");
        this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }


    public FenetreDemo(){
        this.panneauPrincipal = new JPanel();
        this.toolbar = new BarreOutilsDessin(new Dimension(LARGEUR_FENETRE, 30), this);
        this.panneauGraph = new PanneauGraph(LARGEUR_GRAPH, HAUTEUR_ZONEDETRAVAIL);
        this.menuDroite = new MenuDroite(LARGEUR_TABLEAUDROITE, HAUTEUR_ZONEDETRAVAIL, this);
        this.menuHaut = new MenuHaut(LARGEUR_FENETRE, HAUTEUR_MENUBAR, this);
    }

    public void afficherFenetre(){
        this.parametrerFenetre();
        this.ajouterBoutons();
        this.ajouterPanneaux();

        this.setContentPane(this.panneauPrincipal);
        this.setVisible(true);
    }

    public PanneauGraph getPanneauGraph(){
        return (this.panneauGraph);
    }

    /**
     * Méthode principale
     * @param args
     */
    public static void main(String[] args) {
       FenetreDemo fenetre = new FenetreDemo();
       fenetre.afficherFenetre();
       
       // TODO -- à intégrer dans le démonstrateur. Actuellement juste des tests
       // TODO bis -- Rédiger les JUnit. 
       // TODO ter -- Créer les différents styles de flêches
       CasUtilisation useCase1 = new CasUtilisation(fenetre.getPanneauGraph().getGraph(), "test 1");
       CasUtilisation useCase2 = new CasUtilisation(fenetre.getPanneauGraph().getGraph(), "test 2");    

       useCase1.creer();
       useCase2.creer();
       Lien monLien = new FlecheContinue(
           useCase1, useCase2, fenetre.getPanneauGraph().getGraph(), "SPECIALISATION");
       monLien.creer();
    }

}






