package ihm;

import com.mxgraph.view.mxGraph;
import ihm.Menu.Menu;
import ihm.Menu.MenuDroite;
import ihm.Menu.MenuGauche;
import ihm.Menu.MenuHaut;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Classe concernant tout ce qui est l'affichage de la fenetre
 *
 *
 * @author satenske
 */
public class FenetreDemo extends JFrame {
    private final mxGraph graph;
    private final JPanel panneauPrincipal;
    private final Menu menuGauche;
    private final Menu menuDroite;
     
    private final PanneauGraph panneauGraph;
    
    private final MenuHaut menuHaut;
    
    public FenetreDemo(){
        this.panneauPrincipal = new JPanel();
        this.graph = new mxGraph();
        this.panneauGraph = new PanneauGraph(this.graph);
        this.menuGauche = new MenuGauche(200,600);
        this.menuDroite = new MenuDroite(200,600);      
        this.menuHaut = new MenuHaut(1000,20);    
        
         /* un zoli hello wolrd */
         Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();
        Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80,
                        30);
        Object v2 = graph.insertVertex(parent, null, "World!", 240, 150,
                        80, 30);
        graph.insertEdge(parent, null, "Edge", v1, v2);
        graph.getModel().endUpdate();
        /* Fin du hello world */

    }
    
    public void parametrerFenetre(){
        this.setTitle("Démonstrateur de la bibliothèque");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    public void afficherFenetre(){
        this.parametrerFenetre();      
        this.ajouterBoutons();
        this.ajouterPanneaux();

        this.setContentPane(this.panneauPrincipal);      
        this.setVisible(true);
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
    
    /**
     * Méthode principale
     * @param args
     */
    public static void main(String[] args) {
       FenetreDemo fenetre = new FenetreDemo();
       fenetre.afficherFenetre();
    }


}





