package ihm;

import com.mxgraph.model.mxGraphModel;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author satenske
 */
public class PanneauGraph extends JPanel {
	private mxGraphModel model = new mxGraphModel();
	private mxGraph graph = new mxGraph(this.model);
	private JScrollPane panneauGraph = new JScrollPane();

	private void parametrerGraph() {
	}

	public PanneauGraph() {
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
