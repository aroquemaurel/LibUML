/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.util.Hashtable;
import javax.swing.JOptionPane;

/**
 *
 * @author satenske
 */
public class Btn extends JButton implements MouseListener {  
    protected FenetreDemo fenetre;
    
    public Btn(String p_string, FenetreDemo p_fenetre){
        super(p_string);
        this.fenetre = p_fenetre;
        this.addMouseListener(this);
        this.creerLesStyle();
    }
    /**
     * Méthode appelée lors du clic de souris
     */
    public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
    }

    /**
     * Méthode appelée lors du survol de la souris
     */
    public void mouseEntered(MouseEvent event) {

    }

    /**
     * Méthode appelée lorsque la souris sort de la zone du bouton
     */
    public void mouseExited(MouseEvent event) {

    }

    /**
     * Méthode appelée lorsque l'on presse le clic gauche de la souris
     */
    public void mousePressed(MouseEvent event) {

    }

    /**
     * Méthode appelée lorsque l'on relâche le clic de souris
     */
    public void mouseReleased(MouseEvent event) {
    }
    
    protected void creerLesStyle() {
		mxStylesheet stylesheet =
		    this.fenetre.getPanneauGraph().getGraph().getStylesheet();
		Hashtable<String, Object> style =
		    new Hashtable<String, Object>();
		
        /* Ateur */
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ACTOR);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("ACTEUR", style);
        
		/* UseCase */
		style = null;
		style = new Hashtable<String, Object>();
		style.put(mxConstants.STYLE_SHAPE,
			  mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_OPACITY, 50);
		style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
		stylesheet.putCellStyle("USECASE", style);
	}
}
