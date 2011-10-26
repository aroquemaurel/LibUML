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
    private JGraph m_graph;
    private DefaultGraphCell m_SourceCelluleARelier;
    private DefaultGraphCell m_DestinationCelluleARelier;
    private DefaultGraphCell m_celluleActuelle;
    private boolean m_deuxiemeClic = false;
    private JFrame m_fenetre;
    /**
     * Constructeur de l'évenement
     * @param p_graph Graph sur lequel est le carré
     * @param p_fenetre m_fenetre dans laquelle est le m_graph
     */
    public EvenementCarre(JGraph p_graph, JFrame p_fenetre) {
        m_graph = p_graph;
        m_fenetre = p_fenetre;
    }

    public void mouseExited(MouseEvent event){}

    public void mouseClicked(MouseEvent event){}

    public void mouseEntered(MouseEvent event){}

    public void mousePressed(MouseEvent event){}

    public void mouseReleased(MouseEvent event) {
        /* On récupère l'objet sur lequel on clique */
      Point position = event.getPoint();
      m_celluleActuelle = (DefaultGraphCell)m_graph.getFirstCellForLocation(position.x, position.y);

       /* Actuellement, on peut séléctionner une fleche pour créer une fleche pointant sur une fleche
        * moyen, à voir comment on peut savoir si on est sur une fleche ou sur autre chose
        */
        if(this.m_celluleActuelle != null){
			/* premier clic, source deuxième clic destination */
            if(!m_deuxiemeClic) {
                m_fenetre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                m_SourceCelluleARelier = m_celluleActuelle;
            } else {
                m_fenetre.setCursor(Cursor.getDefaultCursor());
                m_DestinationCelluleARelier = m_celluleActuelle;
                Fleche fleche = new Fleche(m_SourceCelluleARelier, m_DestinationCelluleARelier, m_graph);
                fleche.tracerFleche();
                m_fenetre.setCursor(Cursor.getDefaultCursor());
                m_graph.removeMouseListener(this);
            }

            m_deuxiemeClic = !m_deuxiemeClic;
        }
    }
}
