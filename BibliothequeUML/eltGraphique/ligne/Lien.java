package eltGraphique.ligne;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;
import eltGraphique.EltGraphique;

/**
 *
 */
public class Lien extends EltGraphique {
	private ElementModelisation origine;
	private ElementModelisation extremite;
	private String texteOrigine;
	private String texteExtremite;
	private String typeFlecheExtremite;
	private String typeFlecheOrigine;
	private Cardinalite cardinaliteOrigine;
	private Cardinalite cardinaliteExtremite;
    private mxCell lien;   
    private String typeFleche;
    
    public Lien(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph,
        String p_typeFleche){
        super(p_graph);
        this.origine = p_origine;
        this.extremite = p_extremite;
        this.typeFleche = p_typeFleche;
    }
	/*
	 * Getters
	 */
	public ElementModelisation getExtremite() {
		return (this.extremite);
	}

	public ElementModelisation getOrigine() {
		return (this.origine);
	}

	public String getTexteOrigine() {
		return (this.texteOrigine);
	}

	public String getTypeFlecheExtremite() {
		return (this.typeFlecheExtremite);
	}

	public String getTypeFlecheOrigine() {
		return (this.typeFlecheOrigine);
	}

	/*
	 * Setters
	 */
	public void setExtremite(ElementModelisation p_extremite) {
		this.extremite = p_extremite;
	}

	public void setOrigine(ElementModelisation p_origine) {
		this.origine = p_origine;
	}

	public void setTexteExtremite(String p_texteExtremite) {
		this.texteExtremite = p_texteExtremite;
	}

	public void setTexteOrigine(String p_texteOrigine) {
		this.texteOrigine = p_texteOrigine;
	}

	public void setTypeFlecheExtremite(String p_typeFlecheExtremite) {
		this.typeFlecheExtremite = p_typeFlecheExtremite;
	}

	public void setTypeFlecheOrigine(String p_typeFlecheOrigine) {
		this.typeFlecheOrigine = p_typeFlecheOrigine;
	}
    
    public void creer(){
     super.setCellule((mxCell) super.getGraph().insertEdge(
            super.getGraph().getDefaultParent(), null, null,
            this.getOrigine().getCellule(), this.getExtremite().getCellule(), 
            this.typeFleche));
        super.setConnectable(false);        
    }

}
