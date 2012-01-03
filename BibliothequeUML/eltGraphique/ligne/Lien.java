package eltGraphique.ligne;

import com.mxgraph.view.mxGraph;
import eltGraphique.ElementModelisation;
import eltGraphique.EltGraphique;

/**
 *
 * @author satenske
 */
abstract public class Lien extends EltGraphique {
	private ElementModelisation origine;
	private ElementModelisation extremite;
	private String texteOrigine;
	private String texteExtremite;
	private String typeFlecheExtremite;
	private String typeFlecheOrigine;
	private Cardinalite cardinaliteOrigine;
	private Cardinalite cardinaliteExtremite;

    public Lien(ElementModelisation p_origine, ElementModelisation p_extremite, mxGraph p_graph){
        super(p_graph);
        this.origine = p_origine;
        this.extremite = p_extremite;
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
    
    abstract public void creer(String p_style);
}
