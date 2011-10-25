import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import org.jgraph.JGraph;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.DefaultGraphModel;

/**
 * 
 * 
 * @author satenske
 */
public class Fenetre extends JFrame{
    private JPanel panneauPrincipal = new JPanel();
    private JButton btnCarre = new JButton(new ImageIcon("img/carre.jpg"));
    private GraphModel model = new DefaultGraphModel();
    private JGraph graph = new JGraph(model);
    private JScrollPane PanneauGraph = new JScrollPane(this.graph);
    private EvenementBtnCarre listenerBtnCarre = new EvenementBtnCarre(this.graph, this);
    private EvenementCarre listenerCarre =  new EvenementCarre(this.graph, this);
    public Fenetre(){
       this.setTitle("Démonstrateur de la bibliothèque UML");
       this.setSize(600, 650);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       graph.setGridVisible(true);
       graph.setGridSize(10);
    }

    public void afficherFenetre(){
       this.graph.setCloneable(true);
       this.graph.setInvokesStopCellEditing(true);
       this.graph.setJumpToDefaultPort(true);
        /* un simple bouton pour la préparation à faire le démonstrateur,
         * on verra plus tard comment serons les boutons, et ou on les feras.
         */
       this.panneauPrincipal.add(this.btnCarre);
       this.btnCarre.addMouseListener(listenerBtnCarre);
       this.PanneauGraph.addMouseListener(listenerBtnCarre);

       this.graph.addMouseListener(listenerCarre);
       this.setContentPane(this.panneauPrincipal);
       
       this.panneauPrincipal.add(this.PanneauGraph);

       this.PanneauGraph.setPreferredSize(new Dimension(500, 500));

       this.setVisible(true);

    }
    
    public static void main(String[] args) {
       Fenetre fenetre = new Fenetre();   
       fenetre.afficherFenetre();
     }
}