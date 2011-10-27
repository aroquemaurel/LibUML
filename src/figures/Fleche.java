package figures;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.GraphConstants;

/**
 *
 * @author satenske
 */
public class Fleche {
    private ElementGraphique sourceFleche;
    private ElementGraphique destinationFleche;
    private JGraph graph;
    
    public Fleche(ElementGraphique p_sourceFleche, 
		  ElementGraphique p_destinationFleche, JGraph p_graph) {
        this.sourceFleche = p_sourceFleche;
        this.destinationFleche = p_destinationFleche;
        this.graph = p_graph;
    }

    public void tracerFleche(){
        DefaultEdge edge = new DefaultEdge();
        edge.setSource(this.sourceFleche);
        edge.setTarget(this.destinationFleche);

        int arrow = GraphConstants.ARROW_CLASSIC;

        GraphConstants.setLineEnd(edge.getAttributes(), arrow);
        GraphConstants.setEndFill(edge.getAttributes(), false);

        this.graph.getGraphLayoutCache()
			.insertEdge(edge, this.sourceFleche, this.destinationFleche);
    }

}
