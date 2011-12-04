package ihm;

import com.mxgraph.model.mxGraphModel;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author satenske
 */
public class PanneauGraph extends JPanel {
	private mxGraphModel model;
	private mxGraph graph;
	private JScrollPane panneauGraph;

	private void parametrerGraph() {
	}

	public PanneauGraph() {
		this.panneauGraph = new JScrollPane();
		this.model = new mxGraphModel();
		this.graph = new mxGraph(this.model);
		parametrerGraph();
		this.panneauGraph.setPreferredSize(new Dimension(500, 500));
	}

	public JScrollPane getPanneauGraph() {
		return this.panneauGraph;
	}

	public mxGraph getGraph() {
		return this.graph;
	}

/*	public DefaultGraphCell celluleSurvolee(MouseEvent event){
		DefaultGraphCell celluleActuelle;
		Point position = event.getPoint();

      celluleActuelle = (DefaultGraphCell)this.graph.getFirstCellForLocation(position.x, position.y);

	  return celluleActuelle;

	}*/
}
