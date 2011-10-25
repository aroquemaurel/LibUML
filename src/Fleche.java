import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;

/**
 *
 * @author satenske
 */
public class Fleche {
    private DefaultGraphCell sourceFleche;
    private DefaultGraphCell destinationFleche;
    private JGraph graph;
    
    public Fleche(DefaultGraphCell p_sourceFleche, DefaultGraphCell p_destinationFleche, JGraph p_graph) {
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
        GraphConstants.setEndFill(edge.getAttributes(), true);

        this.graph.getGraphLayoutCache().insert(this.sourceFleche);
        this.graph.getGraphLayoutCache().insert(this.destinationFleche);
        this.graph.getGraphLayoutCache().insert(edge);
    }

}
