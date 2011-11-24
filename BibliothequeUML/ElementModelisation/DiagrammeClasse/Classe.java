/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementModelisation.DiagrammeClasse;

import java.util.ArrayList;

/**
 *
 * @author satenske
 */
public class Classe extends ElementModelisation.ElementModelisation {
    private String typeDeRetour;
    private boolean abstraite;
    private Visibilite visibilite;
    private ArrayList<Methode> methoides;
    private ArrayList<Attribut> attributs;
    private boolean constante;

    /* 
     * Guetteurs/Setteurs
     */
    public boolean isConstante() {
        return constante;
    }

    public void setConstante(boolean constante) {
        this.constante = constante;
    }

    public boolean siAbstraite() {
        return abstraite;
    }

    public void setAbstraite(boolean abstraite) {
        this.abstraite = abstraite;
    }

    public ArrayList<Attribut> getAttributs() {
        return attributs;
    }

    public void setAttributs(ArrayList<Attribut> attributs) {
        this.attributs = attributs;
    }

    public ArrayList<Methode> getMethoides() {
        return methoides;
    }
    
    public void setMethoides(ArrayList<Methode> methoides) {
        this.methoides = methoides;
    }

    public String getTypeDeRetour() {
        return typeDeRetour;
    }

    public void setTypeDeRetour(String typeDeRetour) {
        this.typeDeRetour = typeDeRetour;
    }

    public Visibilite getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(Visibilite visibilite) {
        this.visibilite = visibilite;
    }
    
    public void ajouterMethode(String p_nomMethode, String p_typeDeRetour,
                               Visibilite p_visibilite, boolean p_deClasse,
                               boolean constante) {
        
    }
    
    public void ajouterAttributs(String p_type, String nom,
                                 Visibilite visibilite, boolean constante,
                                 boolean deClasse) {
        
    }
}
