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
        Position pos1 = new Position(30, 45);
        Position pos2 = new Position(100, 180);
        Position pos3 = new Position(340, 500);
        Carre carre1 = new Carre(pos1, 90, 100, this.graph);
        Carre carre2 = new Carre(pos2, 90, 100, this.graph);
        Carre carre3 = new Carre(pos3, 90, 100, this.graph);
        
        this.graph.setCloneable(true);
        this.graph.setInvokesStopCellEditing(true);
        this.graph.setJumpToDefaultPort(true);
        /* un simple bouton pour la préparation à faire le démonstrateur,
         * on verra plus tard comment serons les boutons, et ou on les feras.
         */
        this.panneauPrincipal.add(this.btnCarre);
       this.btnCarre.addMouseListener(cListener);
       this.PanneauGraph.addMouseListener(cListener);
        /* on affiche des carrés, histoire de... */
       // carre1.afficher();
     //   carre2.afficher();
     //   carre2.afficher();
     //   carre2.afficher();
    //    carre2.afficher();
    //    carre3.afficher();
            System.out.println(this.getX());
            System.out.println(this.getY());
       
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
        private Position positionSouris;
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

            System.out.println(this.graph.getX());
            System.out.println(this.graph.getY());
            System.out.println(location.getX());
            System.out.println(location.getY());
            Carre carre1 = new Carre(new Position(
                        location.getX() - this.fenetre.getX() - 90, 
                        location.getY() - this.fenetre.getY() - 100),
                     90, 100, this.graph);
            carre1.afficher();
        }

        private void coordonneSourisGraph(){
            Point coordonnees;
            PointerInfo pointer = MouseInfo.getPointerInfo();
            coordonnees = pointer.getLocation();

            coordonnees.setLocation(coordonnees.getX() - this.fenetre.getX() - 90,
                                    coordonnees.getY() - this.fenetre.getY() - 100);
        }
    /*    private JGraph graph;
        public CarreListener(JGraph p_graph){
            this.graph = p_graph;
        }
        public void actionPerformed(ActionEvent e){
            Position pos1 = new Position(30, 45);
        Position pos2 = new Position(100, 180);
        Position pos3 = new Position(340, 500);
        Carre carre1 = new Carre(pos1, 90, 100, this.graph);
            carre1.afficher();
        }*/
    }
}