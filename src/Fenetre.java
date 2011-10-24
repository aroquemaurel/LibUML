import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.jgraph.JGraph;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.DefaultGraphModel;


public class Fenetre extends JFrame{
    private JPanel panneau = new JPanel();
    private JButton btnCarre = new JButton("mon bouton");
    private GraphModel model = new DefaultGraphModel();
    private JGraph graph = new JGraph(model);
    
    public Fenetre(){
        this.setTitle("Démonstrateur de la bibliothèque UML");
        this.setSize(400, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void afficherFenetre(){
        Position pos1 = new Position(30, 45);
        Position pos2 = new Position(100, 180);
        Position pos3 = new Position(140, 80);
        Carre carre1 = new Carre(pos1, 90, 100, this.graph);
        Carre carre2 = new Carre(pos2, 90, 100, this.graph);
        Carre carre3 = new Carre(pos3, 90, 100, this.graph);
        
        this.graph.setCloneable(true);
        this.graph.setInvokesStopCellEditing(true);
        this.graph.setJumpToDefaultPort(true);
        
        /* un simple bouton pour la préparation à faire le démonstrateur,
         * on verra plus tard comment serons les boutons, et ou on les feras.
         */
        this.panneau.add(this.btnCarre);

        /* on affiche des carrés, histoire de... */
        carre1.afficher();
        carre2.afficher();
        carre2.afficher();
        carre2.afficher();
        carre2.afficher();
        carre3.afficher();

       
       this.setContentPane(this.panneau);
       this.panneau.add(new JScrollPane(this.graph));
       this.setVisible(true);
    }
    
    public static void main(String[] args) {
       Fenetre fenetre = new Fenetre();
       fenetre.afficherFenetre();
     }
}