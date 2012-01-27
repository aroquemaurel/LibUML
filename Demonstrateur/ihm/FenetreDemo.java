package ihm;

import diagramme.Diagramme;
import evenements.EvenementCelluleSelectionne;
import ihm.menu.BarreMenus;
import ihm.menu.BarreOutilsDessin;
import ihm.menu.PanneauDroite;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 */
public class FenetreDemo extends JFrame {
	/* Déclaration des paramètres de la fenêtre */
    private final int HAUTEUR_FENETRE =
		(int) (Toolkit.getDefaultToolkit().getScreenSize().height -
                       Toolkit.getDefaultToolkit().getScreenSize().height*0.05);
    private final int LARGEUR_FENETRE =
		Toolkit.getDefaultToolkit().getScreenSize().width;
    private final static int HAUTEUR_MENUBAR = 20;
    private final int HAUTEUR_ZONEDETRAVAIL = HAUTEUR_FENETRE - HAUTEUR_MENUBAR - 80;

    private final static int LARGEUR_MENUGAUCHE = 100;
    private final static int LARGEUR_TABLEAUDROITE = 500;
    private final int LARGEUR_GRAPH =
                        LARGEUR_FENETRE - LARGEUR_MENUGAUCHE - LARGEUR_TABLEAUDROITE - 30;

    private final JPanel panneauPrincipal; //panneau principal dans lequel est contenu les autres panneaux
    private final BarreOutilsDessin toolbar; //barre contenant les outils
    private final PanneauDroite menuDroite; // Menu avec le tableau

    private final PanneauGraph panneauGraph; // panneau contenant le graph

    private final BarreMenus menuHaut; // Barre des menus (fichier, insérer, ...)
    
    private final BoiteDialogueDiagramme fenetreChoixDiagramme;

    /**
     * Paramètre la fenêtre
     */
    private void parametrerFenetre(){
        this.setTitle("Démonstrateur de la bibliothèque");
        this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * Ajoute les différents panneau dans le panneau principal
     */
    private void ajouterPanneaux() {
        this.panneauPrincipal.add(this.menuHaut);
        this.panneauPrincipal.add(this.toolbar);
        this.panneauPrincipal.add(this.panneauGraph);
        this.panneauPrincipal.add(this.menuDroite);
    }

    /**
     * ajouter les différents boutons dans les différents panneaux 
     */
    private void ajouterBoutons(){
        this.menuHaut.ajouterObjetsGraphiques();
        this.toolbar.ajouterObjetsGraphiques();
        this.menuDroite.ajouterObjetsGraphiques();
    }

    /**
     * Construit la fenêtre de démonstration 
     */
    public FenetreDemo() {
        this.panneauPrincipal = new JPanel();
        this.toolbar = new BarreOutilsDessin(new Dimension(LARGEUR_FENETRE, 30), this);
        this.panneauGraph = new PanneauGraph(LARGEUR_GRAPH, HAUTEUR_ZONEDETRAVAIL);

        EvenementCelluleSelectionne evenement = new EvenementCelluleSelectionne(this);
        this.panneauGraph.getGraphControl().addMouseListener(evenement);
        this.menuDroite = new PanneauDroite(new Dimension(LARGEUR_TABLEAUDROITE, HAUTEUR_ZONEDETRAVAIL), this);
        this.menuHaut = new BarreMenus(new Dimension(LARGEUR_FENETRE, HAUTEUR_MENUBAR));
        this.fenetreChoixDiagramme = new BoiteDialogueDiagramme(this);
    }

    /**
     * Afficher la fenêtre 
     */
    public void afficherFenetre(){
        this.parametrerFenetre();
        this.ajouterBoutons();
        this.ajouterPanneaux();

        this.setContentPane(this.panneauPrincipal);
        this.setVisible(true);
    }

    /**
     * Retourne le panneau contenant le graph 
     * 
     * @return Le panneau contenant le graphe
     */
    public PanneauGraph getPanneauGraph(){
        return (this.panneauGraph);
    }

    /**
     * Retourne le panneau contenant tous les autres panneaux 
     * 
     * @return Le panneau principal
     */ 
    public JPanel getPanneauPrincipal(){
        return (this.panneauPrincipal);
    }
   
    /**
     * Retourne le panneau de droite contenant le tableau de la classe 
     * @return Le panneau de droite
     */
    public PanneauDroite getPanneauDroite(){
        return (this.menuDroite);
    }

    /**
     * Retour la fenêtre permettant de choisir le diagramme
     * @return La fenêtre permettant de choisir le type de diagramme
     */
    public BoiteDialogueDiagramme getFenetreChoixDiagramme(){
        return (this.fenetreChoixDiagramme);
    }
    
    /**
    * Méthode principale
    */
    public static void main(String[] args) {
       FenetreDemo fenetre = new FenetreDemo();
       fenetre.getPanneauGraph().initialiserDiagramme(new Diagramme());
     
       fenetre.afficherFenetre();
       
      fenetre.getFenetreChoixDiagramme().afficherBoiteDialogue();
    }

}
