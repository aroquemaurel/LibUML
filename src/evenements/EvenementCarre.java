package evenements;

import figures.Fleche;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;

/**
 * Classe EvenementCarre. Concerne tous les évenements qui se passe sur un carré.
 * @author satenske
 */
public class EvenementCarre implements MouseListener {
    private JGraph graph;
    private DefaultGraphCell SourceCelluleARelier;
    private DefaultGraphCell DestinationCelluleARelier;
    private DefaultGraphCell celluleActuelle;
    private boolean deuxiemeClic = false;
    private JFrame fenetre;
    /**
     * Constructeur de l'évenement
     * @param p_graph Graph sur lequel est le carré
     * @param p_fenetre fenetre dans laquelle est le graph
     */
    public EvenementCarre(JGraph p_graph, JFrame p_fenetre) {
        this.graph = p_graph;
        this.fenetre = p_fenetre;
    }

    public void mouseExited(MouseEvent event){}

    public void mouseClicked(MouseEvent event){}

    public void mouseEntered(MouseEvent event){}
    
    public void mousePressed(MouseEvent event){}
    
    public void mouseReleased(MouseEvent event) {
        /* On récupère l'objet sur lequel on clique */
      Point position = event.getPoint();
      this.celluleActuelle = (DefaultGraphCell)this.graph.getFirstCellForLocation(position.x, position.y);

       /* Actuellement, on peut séléctionner une fleche pour créer une fleche pointant sur une fleche
        * moyen, à voir comment on peut savoir si on est sur une fleche ou sur autre chose
        */
        if(this.celluleActuelle != null){
            if(!deuxiemeClic) {
                this.fenetre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                this.SourceCelluleARelier = this.celluleActuelle;
            } else {
                this.fenetre.setCursor(Cursor.getDefaultCursor());
                this.DestinationCelluleARelier = this.celluleActuelle;
                Fleche fleche = new Fleche(this.SourceCelluleARelier, this.DestinationCelluleARelier, this.graph);
                fleche.tracerFleche();
                this.fenetre.setCursor(Cursor.getDefaultCursor());
                 this.graph.removeMouseListener(this);
            }

            deuxiemeClic = !deuxiemeClic;
        }
    }
}
