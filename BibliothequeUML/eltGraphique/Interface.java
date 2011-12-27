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
    
    public Interface(mxGraph p_graph, String p_texte){
        super(p_graph, p_texte);
		this.creer();
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
