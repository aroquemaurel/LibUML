package ihm;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import java.awt.Dimension;

/**
 *
 * @author satenske
 */
public class PanneauGraph extends mxGraphComponent {  
    public PanneauGraph(mxGraph p_graph){
        super(p_graph);
        this.parametrerPanneau();
    }
    
    private void parametrerPanneau(){
        this.setGridVisible(true);
        this.setInvokesStopCellEditing(true);
        this.setPreferredSize(new Dimension(500,620));    
        this.setPreferredSize(new Dimension(500,620));        
    }
}
