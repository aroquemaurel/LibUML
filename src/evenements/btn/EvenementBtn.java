package evenements.btn;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jgraph.JGraph;

/**
 *
 * @author satenske
 */
public class EvenementBtn extends JButton implements MouseListener {
    private JGraph m_graph;
    private JFrame m_fenetre;

    public EvenementBtn(JGraph p_graph, JFrame p_fenetre) {
        m_graph = p_graph;
        m_fenetre = p_fenetre;
    }

    public JFrame getFenetre() {
        return m_fenetre;
    }

    public JGraph getGraph() {
        return m_graph;
    }

    public void mouseExited(MouseEvent event) {}

    public void mouseClicked(MouseEvent event) {}

    public void mouseEntered(MouseEvent event) {}

    public void mousePressed(MouseEvent event) {}

    public void mouseReleased(MouseEvent event) {}
}
