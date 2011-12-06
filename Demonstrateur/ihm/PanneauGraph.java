package ihm;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;

/**
 *
 * @author satenske
 */
public class PanneauGraph extends mxGraphComponent {  
    private int largeurPanneau;
    private int longueurPanneau;
    
    public PanneauGraph(int p_largeurPanneau, int p_longueurPanneau){
        super(new mxGraph());        
        
        this.largeurPanneau = p_largeurPanneau;
        this.longueurPanneau = p_longueurPanneau;
        
        this.parametrerPanneau();
    }
    
    private void parametrerPanneau(){
        this.setGridVisible(true);
        this.setInvokesStopCellEditing(true);
        this.setPreferredSize(new Dimension(this.largeurPanneau, this.longueurPanneau));    
    }
}
