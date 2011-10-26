package evenements;

import figures.Carre;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import org.jgraph.JGraph;

/**
 *
 * 
 * @author satenske
 */
public class EvenementBtnCarre extends EvenementBtn{
    private Point positionSouris;
    
    public EvenementBtnCarre(JGraph p_graph, JFrame p_fenetre){
        super(p_graph, p_fenetre);
        this.addMouseListener(this);
    }

    public void mousePressed(MouseEvent event){
        super.getFenetre().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void mouseReleased(MouseEvent event) {
        calculerPositionSouris();
		Carre carre = new Carre(this.positionSouris, 90, 100, super.getGraph());
        carre.afficher();
    }

    private void calculerPositionSouris(){
        PointerInfo pointer = MouseInfo.getPointerInfo();
        this.positionSouris = pointer.getLocation();

        this.positionSouris.setLocation(
                    this.positionSouris.getX() - super.getFenetre().getX() - 90,
                    this.positionSouris.getY() - super.getFenetre().getY() - 100
                );
        super.getFenetre().setCursor(Cursor.getDefaultCursor());
    }
}

