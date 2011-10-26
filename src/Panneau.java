
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphModel;
import org.jgraph.graph.GraphModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author satenske
 */
public class Panneau extends JPanel {
	private GraphModel model = new DefaultGraphModel();
	private JGraph graph = new JGraph(model);
	private JScrollPane panneauGraph = new JScrollPane(graph);

	private void parametrerGraph() {
		graph.setGridVisible(true);
		graph.setGridSize(10);
		graph.setCloneable(true);
		graph.setInvokesStopCellEditing(true);
		graph.setJumpToDefaultPort(true);
	}

	public Panneau() {
		parametrerGraph();
		this.panneauGraph.setPreferredSize(new Dimension(500, 500));
	}

	public JScrollPane getPanneauGraph() {
		return this.panneauGraph;
	}

	public JGraph getGraph() {
		return this.graph;
	}
}
