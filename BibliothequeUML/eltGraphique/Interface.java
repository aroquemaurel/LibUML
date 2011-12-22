package eltGraphique;

import com.mxgraph.view.mxGraph;
import java.util.ArrayList;
import eltGraphique.classe.Methode;
/**
 *
 * @author satenske
 */
public class Interface extends ElementModelisation {
    private ArrayList<Methode> listeDeMethodes;
    
    public Interface(String p_nom, mxGraph p_graph){
        super(p_nom, p_graph);
    }
    public ArrayList<Methode> getListeDeMethodes() {
        return (this.listeDeMethodes);
    }

    public void setListeDeMethodes(ArrayList<Methode> p_listeDeMethodes) {
        this.listeDeMethodes = p_listeDeMethodes;
    }

    @Override
    public void creer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
