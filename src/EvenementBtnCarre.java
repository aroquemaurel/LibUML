
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jgraph.JGraph;

/**
 *
 * 
 * @author satenske
 */
class EvenementBtnCarre extends JButton implements MouseListener{
    private JGraph graph;
    private Point positionSouris;
    private JFrame fenetre;
    
    public EvenementBtnCarre(JGraph p_graph, JFrame p_fenetre){
        this.graph = p_graph;
        this.fenetre = p_fenetre;
        this.addMouseListener(this);
    }

    public void mouseExited(MouseEvent event){}
    public void mouseClicked(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}

    public void mousePressed(MouseEvent event){
        this.fenetre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void mouseReleased(MouseEvent event) {
        calculerPositionSouris();
       Carre carre = new Carre(this.positionSouris, 90, 100, this.graph);
        carre.afficher();
    }

    private void calculerPositionSouris(){
        PointerInfo pointer = MouseInfo.getPointerInfo();
        this.positionSouris = pointer.getLocation();

        this.positionSouris.setLocation(
                    this.positionSouris.getX() - this.fenetre.getX() - 90,
                    this.positionSouris.getY() - this.fenetre.getY() - 100
                );
         this.fenetre.setCursor(Cursor.getDefaultCursor());
    }
}

