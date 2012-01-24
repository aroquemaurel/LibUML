package evenements;

import com.mxgraph.model.mxCell;
import diagramme.Diagramme;
import eltGraphique.eltModelisation.ElementModelisation;
import eltGraphique.eltModelisation.Traitement;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import ihm.FenetreDemo;
import ihm.fenetreInterdiction.FenetreInterdictionLiaisonElement;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Cette classe prmet de gérér le lien entre deux éléments graphiques.
 * @author satenske
 */
public class EvenementsLienElementGraphique implements MouseListener {
    private final FenetreDemo fenetre;
    private final Diagramme diagramme;
    private final TypeLien typeDeLien;
    private int numeroClique;
    private mxCell sourceCelluleARelier;
    private mxCell destinationCelluleARelier;

    /**
    * Constructeur d'un évènement de lien entre deux éléments graphiques.
    * @param p_panneauGraph panneau graphique dans lequel le lien est fait
    * @param  p_diagramme diagramme dans lequel le lien est fait
    * @param p_typeDeLien type du lien créé
    */
    public EvenementsLienElementGraphique(FenetreDemo p_fenetre, Diagramme p_diagramme,
                                    TypeLien p_typeDeLien) {
        this.fenetre = p_fenetre;
        this.diagramme = p_diagramme;
        this.typeDeLien = p_typeDeLien;
        this.sourceCelluleARelier = null;
        this.destinationCelluleARelier = null;
        this.numeroClique = 0;
    }

    /**
    * Cette méthode permet de gérer les actions produites lors d'un clic avec la souris.
    */
    @Override
    public void mouseClicked(MouseEvent event) {
        mxCell celluleActuelle = (mxCell) this.fenetre.getPanneauGraph().getGraph().getSelectionCell();

		
        if(celluleActuelle != null){ // si on a selectioné une cellule
            // si on a pas déjà trouvé la source, on l'affecte, on incrémente le nombre de clic
            if(this.sourceCelluleARelier == null) { 
                this.numeroClique++;
                this.sourceCelluleARelier = celluleActuelle;
            } // sinon, si la cellule ne correspond pas déjà à la source, on affecte la destination
            else if(!celluleActuelle.equals(sourceCelluleARelier)){ 
                this.numeroClique++;
                this.destinationCelluleARelier = celluleActuelle;

            }
             //on a trouvé la source et la destination, on peut les relier
            if(this.destinationCelluleARelier != null && sourceCelluleARelier != null){
                ElementModelisation sourceElementModelisation = (ElementModelisation) 
                        this.diagramme.getElementGraphiqueViaCellule(this.sourceCelluleARelier);
                ElementModelisation destinationElementModelisation = (ElementModelisation) 
                        this.diagramme.getElementGraphiqueViaCellule(this.destinationCelluleARelier);
                
                if(destinationElementModelisation instanceof Traitement && 
                        sourceElementModelisation instanceof Traitement){
                    Traitement traitementSource = (Traitement) sourceElementModelisation;
                    traitementSource.ajouterMessage((Traitement) destinationElementModelisation, "Message", 
                            this.typeDeLien);
                } else {
                    Lien monLien = new Lien(sourceElementModelisation, destinationElementModelisation, 
                            this.fenetre.getPanneauGraph().getGraph(), this.fenetre.getPanneauGraph().getDiagramme(), this.typeDeLien);
                    
                    if(this.fenetre.getPanneauGraph().getDiagramme().lienAutorise(sourceElementModelisation, 
                                                                    destinationElementModelisation, this.typeDeLien)){
                        monLien.creer();
                    } else {
                        FenetreInterdictionLiaisonElement fenetreInterdiction = 
                                new FenetreInterdictionLiaisonElement(this.fenetre);
                        fenetreInterdiction.afficherInterdiction();
                    }  
                }
            }
        }

        if(numeroClique >= 2){ //Deux clic, c'est bon, on supprime le listener
            this.fenetre.getPanneauGraph().getGraphControl().removeMouseListener(this);
        }

    }
    
    /**
    * Retourne le numéro du clique.
    * @return Le numéro du clique
    */
    public int getNumeroClique(){
        return (this.numeroClique);
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
