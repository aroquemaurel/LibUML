package ihm.menu;

import eltGraphique.eltModelisation.Classe;
import ihm.FenetreDemo;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
* Menu contenant le tableau avec les données
*/
public class PanneauDroite extends Menu {   
    /**
     * Le tableau contenant les attributs
     */
    private JTable tableauAttributs;
    
    /**
     * Le label affichant le type de diagramme
     */
    private JLabel typeDiagrammeLabel;
    
    /** 
     * Le tableau contenant les méthodes
     */
    private JTable tableauMethodes;

    /**
     * Construit le panneau de droite 
     * @param p_dimension La dimension du panneau
     * @param p_fenetre La fenetre dans laquelle apparait le panneau
     */
    public PanneauDroite (Dimension p_dimension, FenetreDemo p_fenetre){
        super(p_dimension, p_fenetre);
    }

    /**
     * Ajoute le nom du diagramme dans le panneau
     */
    public void ajouterLabelDiagramme() {
        this.typeDiagrammeLabel = new JLabel(super.getFenetre().getPanneauGraph().getDiagramme().toString());
        super.add(this.typeDiagrammeLabel);
        super.updateUI();
    }

    /**
     * Affiche le table de la classe donnée avec les attributs et les méthodes
     * @param classe La classe pour laquelle il faut afficher les données
     */
    public void afficherTableauClasse(Classe classe){
          
        /* Si un tableau est déjà affiché, on le supprime pour en mettre un neuf */
        if(this.tableauAttributs != null){ 
            super.removeAll();
            this.ajouterLabelDiagramme();
        }

        /* On remplit le taleau des attributs ! */
        Object[][] donneesAttributs = new Object[classe.getAttributs().size()][5];
        for(int i = 0 ; i < classe.getAttributs().size() ; i++){
            donneesAttributs[i][0] = classe.getAttributs().get(i).getVisibilite();
            donneesAttributs[i][1] = classe.getAttributs().get(i).getType();
            donneesAttributs[i][2] = classe.getAttributs().get(i).getNom();
            donneesAttributs[i][3] = classe.getAttributs().get(i).estDeClasse();
            donneesAttributs[i][4] = classe.getAttributs().get(i).estConstante();
        }

        Object[][] donneesMethodes = new Object[classe.getMethodes().size()][4];
        for(int i = 0 ; i < classe.getMethodes().size() ; i++){
            donneesMethodes[i][0] = classe.getMethodes().get(i).getVisibilite();
            donneesMethodes[i][1] = classe.getMethodes().get(i).getTypeRetour();
            donneesMethodes[i][2] = classe.getMethodes().get(i).getNom();
            donneesMethodes[i][3] = classe.getMethodes().get(i).estDeClasse();
        }
        
        //Les titres des colonnes
        String  titreAttributs[] = {"Visibilité", "Type de retour", "Nom", "Static", "Constant"};
        String  titreMethodes[] = {"Visibilité", "Type de retour", "Nom", "Static"};

        this.tableauAttributs = new JTable(donneesAttributs, titreAttributs);
        this.tableauMethodes = new JTable(donneesMethodes, titreMethodes);
        this.tableauAttributs.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.tableauMethodes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        
        super.add(new JScrollPane(tableauAttributs));
        super.add(new JScrollPane(tableauMethodes));
        super.updateUI(); // On met à jour le panneau
    }

    @Override
    public void ajouterObjetsGraphiques() {
    }
}

