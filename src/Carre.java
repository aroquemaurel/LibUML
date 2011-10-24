import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgraph.JGraph;



/**
 *
 * @author satenske
 */
public class Carre implements Figure {
    private Point position;
    private double largeur;
    private double longueur;
    private JGraph graph;
    private DefaultGraphCell cellule = new DefaultGraphCell();

    public Carre(Point p_position, double p_largeur, double p_longueur, JGraph p_graph){
        this.position = p_position;
        this.largeur = p_largeur;
        this.longueur = p_longueur;
        this.graph = p_graph;
    }

    public void afficher(){
        this.cellule = this.creerCellule("Hello", Color.BLACK);
        this.graph.getGraphLayoutCache().insert(this.cellule);
    }

    private DefaultGraphCell creerCellule(String name, Color p_couleurFond) {
        DefaultGraphCell cellule = new DefaultGraphCell(name);
        cellule.getAttributes();

        // dessine le carré
        GraphConstants.setBounds(cellule.getAttributes(),
            new Rectangle2D.Double(
                this.position.getX(),
                this.position.getY(),
                this.largeur, this.longueur)
                );

        // couleur de fond
        if (p_couleurFond != null) {
            GraphConstants.setOpaque(cellule.getAttributes(), true);
            GraphConstants.setBackground(cellule.getAttributes(), p_couleurFond);
        }

        // met une bordure noir
        GraphConstants.setBorderColor(cellule.getAttributes(), Color.black);

        /* C'était dans le code de base que j'avais, à voire l'utilité:
         * peut être pour pouvoir fixer des flêches sur les carrés?
         */
        // Add a Port
        //DefaultPort port = new DefaultPort();
        //cellule.add(port);
       //port.setParent(cellule);


        return cellule;
    }
}
