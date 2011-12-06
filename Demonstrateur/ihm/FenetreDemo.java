package ihm;

import com.mxgraph.util.mxConstants;
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
    
    private final JPanel panneauPrincipal;
    private final Menu menuGauche;
    private final Menu menuDroite;
     
    private final PanneauGraph panneauGraph;
    
    private final MenuHaut menuHaut;
    
   private void creerLesStyle() {
		mxStylesheet stylesheet =
		    this.getPanneauGraph().getGraph().getStylesheet();
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
        this.creerLesStyle();
    }
            
    
    public FenetreDemo(){
        this.panneauPrincipal = new JPanel();
        this.menuGauche = new MenuGauche(LARGEUR_MENUGAUCHE, HAUTEUR_ZONEDETRAVAIL, this);
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
    }

}






