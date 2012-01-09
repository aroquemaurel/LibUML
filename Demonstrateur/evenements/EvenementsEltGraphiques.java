/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package evenements;

import com.mxgraph.model.mxCell;
import eltGraphique.ElementModelisation;
import eltGraphique.EltGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import ihm.PanneauGraph;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author satenske
 */
public class EvenementsEltGraphiques implements MouseListener {
    private PanneauGraph panneauGraph;
    private TypeLien typeDeLien;
    private int numClick;
    private mxCell sourceCelluleARelier;
    private mxCell destinationCelluleARelier;
    
    public EvenementsEltGraphiques(PanneauGraph p_panneauGraph, TypeLien p_typeDeLien){
        this.panneauGraph = p_panneauGraph;
        this.typeDeLien = p_typeDeLien;
        this.sourceCelluleARelier = null;
        this.destinationCelluleARelier = null;
        this.numClick = 0;
    }
    @Override
    public void mouseClicked(MouseEvent event) {
        ElementModelisation celluleActuelle;   
        EltGraphique el1 = null, el2 = null;
        celluleActuelle = (ElementModelisation) this.panneauGraph.getGraph().getSelectionCell();
        if(celluleActuelle != null){
            if(this.sourceCelluleARelier == null) {
                numClick++;
                sourceCelluleARelier = celluleActuelle;

                celluleActuelle = null;
            } else if(!celluleActuelle.equals(sourceCelluleARelier)){
                numClick++;
                this.destinationCelluleARelier = celluleActuelle;

            } 
            if(this.destinationCelluleARelier != null && sourceCelluleARelier != null){
                if(destinationCelluleARelier.getStyle().equals("CLASSE")){
                    //el1 = new Classe(this.panneauGraph.getGraph(), "test");
                    //el1.creer();
                    System.out.print("test1\n");
                }                         
                if(sourceCelluleARelier.getStyle().equals("CLASSE")){
                    //el2 = new Classe(this.panneauGraph.getGraph(), "test");
                   // el2.creer();
                    System.out.print("test2\n");
                }                
           //     Lien monLien = new Lien(el1, el2, this.panneauGraph.getGraph(), TypeLien.LIENCONTINU);
            //    monLien.creer();
            }
        }
        
        if(numClick >= 2){
            this.panneauGraph.getGraphControl().removeMouseListener(this);
        }
            
    }
    
    public int getNumeroClique(){
        return (this.numClick);
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
