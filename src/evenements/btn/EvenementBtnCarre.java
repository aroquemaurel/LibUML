package evenements.btn;

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
    private Point m_positionSouris;

    public EvenementBtnCarre(JGraph p_graph, JFrame p_fenetre){
        super(p_graph, p_fenetre);
        this.addMouseListener(this);
    }

	@Override
    public void mousePressed(MouseEvent event){
        super.getFenetre().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

	@Override
    public void mouseReleased(MouseEvent event) {
        calculerPositionSouris();
       Carre carre = new Carre(m_positionSouris, 90, 100, super.getGraph());
        carre.afficher();
    }
	private double positionRelativeALaFenetre(int p_tailleElement, boolean abscisse){
		if(abscisse)
			return (m_positionSouris.x - super.getFenetre().getX() - p_tailleElement);
		else
			return (m_positionSouris.y - super.getFenetre().getY() - p_tailleElement);

	}
    private void calculerPositionSouris(){
        PointerInfo pointer = MouseInfo.getPointerInfo();
        m_positionSouris = pointer.getLocation();

		if (positionRelativeALaFenetre(90, true) < 0 || positionRelativeALaFenetre(100, false) < 0){
			m_positionSouris.setLocation(100, 100);
		}
		else{
			m_positionSouris.setLocation(positionRelativeALaFenetre(90, true), positionRelativeALaFenetre(100, false));
		}
        super.getFenetre().setCursor(Cursor.getDefaultCursor());
    }
}

