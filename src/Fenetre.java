import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import org.jgraph.JGraph;
import org.jgraph.graph.GraphModel;
import org.jgraph.graph.DefaultGraphModel;


public class Fenetre extends JFrame{
    private JPanel panneauPrincipal = new JPanel();
    private JButton btnCarre = new JButton("b");
    private GraphModel model = new DefaultGraphModel();
    private JGraph graph = new JGraph(model);
    private JScrollPane PanneauGraph = new JScrollPane(this.graph);
    private CarreListener cListener = new CarreListener(this.graph, this);

    public Fenetre(){
       this.setTitle("Démonstrateur de la bibliothèque UML");
       this.setSize(600, 650);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void afficherFenetre(){
       this.graph.setCloneable(true);
       this.graph.setInvokesStopCellEditing(true);
       this.graph.setJumpToDefaultPort(true);
        /* un simple bouton pour la préparation à faire le démonstrateur,
         * on verra plus tard comment serons les boutons, et ou on les feras.
         */
       this.panneauPrincipal.add(this.btnCarre);
       this.btnCarre.addMouseListener(cListener);
       this.PanneauGraph.addMouseListener(cListener);

       this.setContentPane(this.panneauPrincipal);

       
       this.panneauPrincipal.add(this.PanneauGraph);

       this.PanneauGraph.setPreferredSize(new Dimension(500, 500));

       this.setVisible(true);

    }
    
    public static void main(String[] args) {
       Fenetre fenetre = new Fenetre();
       fenetre.afficherFenetre();
     }

    public class CarreListener extends JButton implements MouseListener{
        private JGraph graph;
        private Point positionSouris;
        private JFrame fenetre;
        public CarreListener(JGraph p_graph, JFrame p_fenetre){
            this.graph = p_graph;
            this.fenetre = p_fenetre;
            this.addMouseListener(this);
        }

        public void mouseExited(MouseEvent event){
            
        }
        public void mouseClicked(MouseEvent event){

        }
        public void mouseEntered(MouseEvent event){

        }
        public void mousePressed(MouseEvent event){

        }
        public void mouseReleased(MouseEvent event) {
            calculerCoordonneSourisGraph();
           Carre carre1 = new Carre(this.positionSouris,90, 100, this.graph);
            carre1.afficher();
        }

        private void calculerCoordonneSourisGraph(){
            PointerInfo pointer = MouseInfo.getPointerInfo();
            this.positionSouris = pointer.getLocation();

            this.positionSouris.setLocation(
                        this.positionSouris.getX() - this.fenetre.getX() - 90,
                        this.positionSouris.getY() - this.fenetre.getY() - 100
                    );
        }
    }
}