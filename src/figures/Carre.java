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
    private Point m_position;
    private double m_largeur;
    private double m_longueur;
    private JGraph m_graph;
    private DefaultGraphCell m_cellule = new DefaultGraphCell();

    /**
     * Constructeur du Carre
     * @param p_position la m_position du carré
     * @param p_largeur la m_largeur du carré
     * @param p_longueur la m_longueur du carré
     * @param p_graph le m_graph sur lequel le carré doit être positionner
     */
    public Carre(Point p_position, double p_largeur, double p_longueur, JGraph p_graph) {
		m_position = p_position;
		m_largeur = p_largeur;
		m_longueur = p_longueur;
		m_graph = p_graph;
    }
    /**
     * Permet d'afficher sur le m_graph le carré courant
     */
    public void afficher(){
        this.creerCellule(Color.BLACK);
        m_graph.getGraphLayoutCache().insert(m_cellule);
    }

    /**
     * Créer une m_cellule à partir de la m_position et de la taille du carré
     * @param name chaine de caractère s'affichant dans le carré
     * @param p_couleurFond Couleur de fond du carré
     */
    private void creerCellule(Color p_couleurFond) {
        m_cellule.getAttributes();

        // dessine le carré
        GraphConstants.setBounds(m_cellule.getAttributes(),
                    new Rectangle2D.Double(m_position.x, m_position.y, m_largeur, m_longueur)
								);

        // couleur de fond
        if (p_couleurFond != null) {
            GraphConstants.setOpaque(m_cellule.getAttributes(), true);
            GraphConstants.setBackground(m_cellule.getAttributes(), p_couleurFond);
        }

        // met une bordure noir
        GraphConstants.setBorderColor(m_cellule.getAttributes(), Color.black);

        /* Ajouter un port => n'a rien à faire ici */
        DefaultPort port = new DefaultPort();

        m_cellule.add(port);
        port.setParent(m_cellule);
    }
}
