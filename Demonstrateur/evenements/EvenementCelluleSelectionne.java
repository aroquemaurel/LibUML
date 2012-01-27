package evenements;

import com.mxgraph.model.mxCell;
import eltGraphique.ElementGraphique;
import eltGraphique.eltModelisation.Acteur;
import eltGraphique.eltModelisation.Classe;
import eltGraphique.eltModelisation.Traitement;
import evenements.menu.contextuel.*;
import ihm.FenetreDemo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Cette classe permet de gérer les actions produites lors de la selection d'une cellule
 */
public class EvenementCelluleSelectionne implements MouseListener {
    private final FenetreDemo fenetre; // la fenêtre dans lequel les cellules apparraissent
    
    /*
     * Méthode permettant d'afficher le menu contextuel au clic sur un Acteur
     */
    private JPopupMenu construireMenuContextuel(Acteur element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        
        JMenuItem itemLigneDeVie;
        String texteItemLigneDeVie;
        EvenementLigneDeVie evenementAfficherLigneDeVie = new EvenementLigneDeVie(element);

        texteItemLigneDeVie = 
            (element.getVisibiliteLigneDeVie()) ? "Ne pas afficher ligne de vie" : "Afficher ligne de vie";
        itemLigneDeVie = new JMenuItem(texteItemLigneDeVie);
        
        menuContextuel.add(itemSupprimer);
        menuContextuel.add(itemLigneDeVie);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);
        itemLigneDeVie.addActionListener(evenementAfficherLigneDeVie);
        
        return menuContextuel;
    }
    
    /*
     * Méthode permettant d'afficher le menu contextuel au clic sur un Traitement
     */
    private JPopupMenu construireMenuContextuel(Traitement element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        
        JMenuItem itemLigneDeVie;
        String texteItemLigneDeVie;
        EvenementDebutSequence evenementDebutSequence = new EvenementDebutSequence(element);

        texteItemLigneDeVie = 
            (element.estDebutSequence()) ? "Ne pas afficher la flèche de début de séquence" : 
                "Afficher la flèche de début de séquence";
        itemLigneDeVie = new JMenuItem(texteItemLigneDeVie);
        
        menuContextuel.add(itemSupprimer);
        menuContextuel.add(itemLigneDeVie);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);
        itemLigneDeVie.addActionListener(evenementDebutSequence);
        
        return menuContextuel;
    }   
    
    /*
     * Méthode permettant d'afficher le menu contextuel au clic sur un Traitement
     */
    private JPopupMenu construireMenuContextuel(Classe element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);
        
        JMenuItem itemAjouterMethode = new JMenuItem("Ajouter une méthode");
        EvenementAjouterMethode evenementAjouterMethode = new EvenementAjouterMethode(this.fenetre, element);

        JMenuItem itemAjouterAttribut = new JMenuItem("Ajouter un attribut");
        EvenementAjouterAttribut evenementAjouterAttribut = new EvenementAjouterAttribut(this.fenetre, element);
		
        JMenuItem itemGenererInterface = new JMenuItem("Générer une interface");
        EvenementGenererInterface evenementGenererInterface = new EvenementGenererInterface(element);
              
        menuContextuel.add(itemSupprimer);
        menuContextuel.add(itemAjouterAttribut);
        menuContextuel.add(itemAjouterMethode);
        menuContextuel.add(itemGenererInterface);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);
        itemAjouterAttribut.addActionListener(evenementAjouterAttribut);
        itemAjouterMethode.addActionListener(evenementAjouterMethode);
        itemGenererInterface.addActionListener(evenementGenererInterface);
        
        return menuContextuel;
    }       
    
    
    /*
     * Méthode permettant d'afficher le menu contextuel au clic sur un ElementGrahique autre que Traitement et Acteur
     */
    private JPopupMenu construireMenuContextuel(ElementGraphique element){
	JPopupMenu menuContextuel = new JPopupMenu();
	
        JMenuItem itemSupprimer = new JMenuItem("Supprimer");
        EvenementSupprimer evenementSupprimer = new EvenementSupprimer(element);

        menuContextuel.add(itemSupprimer);
        this.fenetre.getPanneauPrincipal().add(menuContextuel);
        
        itemSupprimer.addActionListener(evenementSupprimer);

        return menuContextuel;
    }    

    /*
     * Construit l'objet à l'aide de la fenetre dans laquelle apparaissent les éléments graphique
     */
    public EvenementCelluleSelectionne(FenetreDemo p_fenetre){
        this.fenetre = p_fenetre;
        
        /* Ajout un listener sur le graph*/
        this.fenetre.getPanneauGraph().getGraphControl().addMouseListener(this); 
    }
    
    @Override
    public void mouseClicked(MouseEvent event) { }   

    @Override
    public void mousePressed(MouseEvent arg0) { 
        ElementGraphique element = this.fenetre.getPanneauGraph().getDiagramme().getElementGraphiqueViaCellule(
                            (mxCell) this.fenetre.getPanneauGraph().getGraph().getSelectionCell());
        
        if(element != null) {
            if(element instanceof Classe) {
                this.fenetre.getPanneauDroite().afficherTableauClasse((Classe) element);
            }        
        }
    }
	/*
	 * Méthode s'executant à la selection d'un élément graphique 
	 */
    @Override
    public void mouseReleased(MouseEvent event) {
        ElementGraphique element = this.fenetre.getPanneauGraph().getDiagramme().getElementGraphiqueViaCellule(
                            (mxCell) this.fenetre.getPanneauGraph().getGraph().getSelectionCell());
        JPopupMenu menuContextuel;

		if(element != null){ /* Si on un a séléctionné un élément graphique */
            if(event.getButton() == MouseEvent.BUTTON3){
                /* Au clique droit on construit le menu contextuel, qui est différent en fonction de l'élément graphique*/
                if(element instanceof Acteur){
                    menuContextuel = construireMenuContextuel((Acteur) element);
                } else if (element instanceof Traitement){
                    menuContextuel = construireMenuContextuel((Traitement) element);                               
                } else if (element instanceof Classe) {
                    menuContextuel = construireMenuContextuel((Classe) element);                               
                } else {
                    menuContextuel = construireMenuContextuel((ElementGraphique) element);                                
                }

                /* On affiche le menu contextuel construit précédemment */
                menuContextuel.show(this.fenetre.getPanneauPrincipal(), event.getX(),event.getY());
                menuContextuel.show(this.fenetre.getPanneauGraph(), event.getX(), event.getY());
            }
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent arg0) {}
    
    @Override
    public void mouseExited(MouseEvent arg0) {}
}
