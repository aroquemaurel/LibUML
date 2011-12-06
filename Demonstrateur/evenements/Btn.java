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
    }

    public void mouseClicked(MouseEvent event) {
        JOptionPane.showMessageDialog(null,"Cette fonctionnalité n'est pas implémentée");
    }

    public void mouseEntered(MouseEvent event) { }    

    public void mouseExited(MouseEvent event) { }

    public void mousePressed(MouseEvent event) {

    }

    public void mouseReleased(MouseEvent event) {
    }
    
  
}
