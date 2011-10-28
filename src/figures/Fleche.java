package figures;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.GraphConstants;

/**
 *
 * @author satenske
 */
public class Fleche {
    private ElementGraphique m_sourceFleche;
    private ElementGraphique m_destinationFleche;
    private JGraph m_graph;

    public Fleche(ElementGraphique p_sourceFleche, ElementGraphique p_destinationFleche, JGraph p_graph) {
        m_sourceFleche = p_sourceFleche;
        m_destinationFleche = p_destinationFleche;
        m_graph = p_graph;
    }

    public void tracerFleche(){
        DefaultEdge edge = new DefaultEdge();
        int arrow = GraphConstants.ARROW_TECHNICAL;


        edge.setSource(m_sourceFleche);
        edge.setTarget(m_destinationFleche);


        GraphConstants.setLineEnd(edge.getAttributes(), arrow);
        GraphConstants.setEndFill(edge.getAttributes(), false);

		m_graph.getGraphLayoutCache()
			.insertEdge(edge, m_sourceFleche, m_destinationFleche);
    }
}
