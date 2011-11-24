/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ElementModelisation.DiagrammeClasse;

import java.util.ArrayList;

/**
 *
 * @author spongebob
 */
class Methode {
    private String typeRetour;
    private Visibilite visibilite;
    private ArrayList<Variable> parametres;
    private boolean constant;
    private boolean deClasse;

    public ArrayList<Variable> getParametres() {
        return this.parametres;
    }

    public void setParametres(ArrayList<Variable> parametres) {
        this.parametres = parametres;
    }

    public String getTypeRetour() {
        return this.typeRetour;
    }

    public void setTypeRetour(String typeRetour) {
        this.typeRetour = typeRetour;
    }

    public boolean isConstant() {
        return constant;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    public boolean isDeClasse() {
        return deClasse;
    }

    public void setDeClasse(boolean deClasse) {
        this.deClasse = deClasse;
    }

    public Visibilite getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(Visibilite visibilite) {
        this.visibilite = visibilite;
    }
    
    public void ajouterParametre(String nom, String type, boolean constant) {
        
    }
}
