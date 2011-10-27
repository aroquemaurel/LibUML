package evenements.btn;

import evenements.EvenementCarre;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import org.jgraph.JGraph;

/**
 *
 * @author satenske
 */
public class EvenementBtnFleche extends EvenementBtn{
    private EvenementCarre m_listenerCarre;

    public EvenementBtnFleche(JGraph p_graph, JFrame p_fenetre, EvenementCarre p_listenerCarre) {
        super(p_graph, p_fenetre);
        m_listenerCarre = p_listenerCarre;
    }

	@Override
    public void mousePressed(MouseEvent event){
        super.getGraph().addMouseListener(m_listenerCarre);
    }
}
