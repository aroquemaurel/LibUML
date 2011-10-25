package evenements;


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
    private JGraph graph;
    private JFrame fenetre;

    public EvenementBtn(JGraph p_graph, JFrame p_fenetre) {
        this.graph = p_graph;
        this.fenetre = p_fenetre;
    }

    public JFrame getFenetre() {
        return this.fenetre;
    }

    public JGraph getGraph() {
        return this.graph;
    }

    public void mouseExited(MouseEvent event){}

    public void mouseClicked(MouseEvent event){}

    public void mouseEntered(MouseEvent event){}

    public void mousePressed(MouseEvent event){}

    public void mouseReleased(MouseEvent event){}
}
