package figures;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultPort;

/**
* Classe Carre. Permet de déssiner des carrés
* @author satenske
*/
public class Carre implements Figure {
    private Point position;
    private double largeur;
    private double longueur;
    private JGraph graph;
    private DefaultGraphCell cellule = new DefaultGraphCell();

    /**
     * Constructeur du Carre
     * @param p_position la position du carré
     * @param p_largeur la largeur du carré
     * @param p_longueur la longueur du carré
     * @param p_graph le graph sur lequel le carré doit être positionner
     */
    public Carre(Point p_position, double p_largeur, double p_longueur, JGraph p_graph){
        this.position = p_position;
        this.largeur = p_largeur;
        this.longueur = p_longueur;
        this.graph = p_graph;
    }
    /**
     * Permet d'afficher sur le graph le carré courant
     */
    public void afficher(){
        this.creerCellule("Yatta", Color.BLACK);
        this.graph.getGraphLayoutCache().insert(this.cellule);
    }

    /**
     * Créer une cellule à partir de la position et de la taille du carré
     * @param name chaine de caractère s'affichant dans le carré
     * @param p_couleurFond Couleur de fond du carré
     */
    private void creerCellule(String name, Color p_couleurFond) {
        this.cellule.getAttributes();

        // dessine le carré
        GraphConstants.setBounds(this.cellule.getAttributes(),
                    new Rectangle2D.Double(
                        this.position.getX(),
                        this.position.getY(),
                        this.largeur, this.longueur)
                    );

        // couleur de fond
        if (p_couleurFond != null) {
            GraphConstants.setOpaque(this.cellule.getAttributes(), true);
            GraphConstants.setBackground(this.cellule.getAttributes(), p_couleurFond);
        }

        // met une bordure noir
        GraphConstants.setBorderColor(this.cellule.getAttributes(), Color.black);


        /* Ajouter un port => n'a rien à faire ici */
        DefaultPort port = new DefaultPort();

        this.cellule.add(port);
        port.setParent(this.cellule);
    }
}
