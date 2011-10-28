
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
	private GraphModel m_model = new DefaultGraphModel();
	private JGraph m_graph = new JGraph(m_model);
	private JScrollPane m_panneauGraph = new JScrollPane(m_graph);

	private void parametrerGraph() {
		m_graph.setGridVisible(true);
		m_graph.setGridSize(10);
		m_graph.setCloneable(true);
		m_graph.setInvokesStopCellEditing(true);
		m_graph.setJumpToDefaultPort(true);
	}

	public Panneau() {
		parametrerGraph();
		m_panneauGraph.setPreferredSize(new Dimension(500, 500));
	}

	public JScrollPane getPanneauGraph() {
		return m_panneauGraph;
	}

	public JGraph getGraph() {
		return m_graph;
	}
}
