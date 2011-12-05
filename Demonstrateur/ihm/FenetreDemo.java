package ihm;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;
import ihm.Menu.Menu;
import ihm.Menu.MenuDroite;
import ihm.Menu.MenuGauche;
import ihm.Menu.MenuHaut;
import java.util.Hashtable;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 *
 *
 * @author satenske
 */
public class FenetreDemo extends JFrame {
    private static final int HAUTEUR_FENETRE = 700;
    private static final int LARGEUR_FENETRE = 1200;
    private static final int HAUTEUR_MENUBAR = 20;
    private static final int HAUTEUR_ZONEDETRAVAIL = HAUTEUR_FENETRE - HAUTEUR_MENUBAR - 50;
    
    private static final int LARGEUR_MENUGAUCHE = 100;
    private static final int LARGEUR_TABLEAUDROITE = 500;    
    private static final int LARGEUR_GRAPH = 
                        LARGEUR_FENETRE - LARGEUR_MENUGAUCHE - LARGEUR_TABLEAUDROITE - 30;
    
    private final mxGraph graph;
    private final JPanel panneauPrincipal;
    private final Menu menuGauche;
    private final Menu menuDroite;
     
    private final PanneauGraph panneauGraph;
    
    private final MenuHaut menuHaut;
    
    public FenetreDemo(){
        this.panneauPrincipal = new JPanel();
        this.graph = new mxGraph();
        this.menuGauche = new MenuGauche(LARGEUR_MENUGAUCHE, HAUTEUR_ZONEDETRAVAIL);
        this.panneauGraph = new PanneauGraph(LARGEUR_GRAPH, HAUTEUR_ZONEDETRAVAIL, this.graph);
        this.menuDroite = new MenuDroite(LARGEUR_TABLEAUDROITE, HAUTEUR_ZONEDETRAVAIL);      
        this.menuHaut = new MenuHaut(LARGEUR_FENETRE, HAUTEUR_MENUBAR);    

        /* un zoli hello wolrd */
       /*  Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
                        30);
        Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
                        80, 30);
        graph.insertEdge(parent, null, "Edge", v1, v2);
        graph.getModel().endUpdate();
        /* Fin du hello world */
        this.creerLesStyle();
        Object parent = graph.getDefaultParent();
        this.graph.getModel().beginUpdate();
    	this.graph.insertVertex(parent, null, "Acteur", 20, 20, 75, 100, "ACTEUR");
        this.graph.insertVertex(parent, null, "UseCase", 30, 30,150, 75, "USECASE");
        this.graph.insertVertex(parent, null, "Morceau de classe", 40, 40, 120, 30);
        this.graph.getModel().endUpdate();

    }
    
    public void afficherFenetre(){
        this.parametrerFenetre();      
        this.ajouterBoutons();
        this.ajouterPanneaux();

        this.setContentPane(this.panneauPrincipal);      
        this.setVisible(true);
    }
	private void creerLesStyle() {
		mxStylesheet stylesheet =
		    this.graph.getStylesheet();
		Hashtable<String, Object> style =
		    new Hashtable<String, Object>();
		/* Ateur */
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ACTOR);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("ACTEUR", style);
		/* UseCase */
		style = null;
		style = new Hashtable<String, Object>();
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("USECASE", style);
	}
    
    private void ajouterPanneaux() {
        this.panneauPrincipal.add(this.menuHaut);
        this.panneauPrincipal.add(this.menuGauche.getPanneau());
        this.panneauPrincipal.add(this.panneauGraph);
        this.panneauPrincipal.add(this.menuDroite.getPanneau());
    }
    
    private void ajouterBoutons(){
        this.menuHaut.ajouterObjetsGraphiques();
        this.menuGauche.ajouterObjetsGraphiques();
        this.menuDroite.ajouterObjetsGraphiques();
    }
    
    private void parametrerFenetre(){
        this.setTitle("Démonstrateur de la bibliothèque");
        this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
        
    /**
     * Méthode principale
     * @param args
     */
    public static void main(String[] args) {
       FenetreDemo fenetre = new FenetreDemo();
       fenetre.afficherFenetre();
    }

}






