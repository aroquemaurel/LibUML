
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import org.jgraph.JGraph;

/**
 *
 * @author satenske
 */
public class EvenementBtnFleche extends EvenementBtn{
    private EvenementCarre listenerCarre;
    public EvenementBtnFleche(JGraph p_graph, JFrame p_fenetre, EvenementCarre p_listenerCarre) {
        super(p_graph, p_fenetre);
        this.listenerCarre = p_listenerCarre;
    }

    public void mousePressed(MouseEvent event){
        super.getGraph().addMouseListener(this.listenerCarre);
    }
}
