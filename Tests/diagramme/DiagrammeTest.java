package diagramme;

import com.mxgraph.view.mxGraph;
import eltGraphique.ElementGraphique;
import eltGraphique.ligne.Lien;
import eltGraphique.ligne.TypeLien;
import eltModelisation.*;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import util.Liste;

/**
 * Classe de test unitaires de la classe <b>Diagramme</b>.
 * @author Marie-Ly
 * @author Geoffroy
 */
public class DiagrammeTest {
    
    private Diagramme monDiagramme;
    private mxGraph monGraph;
    private String maString;
    private ActeurActif monActeurActif;
    private CasUtilisation monCasUtilisation;
    private ActeurPassif monActeurPassif;
    private Traitement monTraitement;
    private Classe maClasse;
    private Interface monInterface;
    private Lien monLien;
    
    @Before
    public void setUp() {
        this.monDiagramme = new Diagramme();
        this.monGraph = new mxGraph();
        this.maString = "un test";
        
        this.monActeurActif = new ActeurActif(monGraph, monDiagramme, maString);
        this.monActeurPassif = new ActeurPassif(monGraph, monDiagramme, maString);
        this.monCasUtilisation = new CasUtilisation(monGraph, monDiagramme, maString);
        this.monTraitement = new Traitement(monGraph, monDiagramme, maString, null, false);
        this.maClasse = new Classe(monGraph, monDiagramme, maString);
        this.monInterface = new Interface (monGraph, maString, monDiagramme);
        this.monLien = new Lien (this.monActeurActif, this.monCasUtilisation, monGraph, monDiagramme, TypeLien.ASSOCIATION);
    }
    
    @After
    public void tearDown() {
        this.monDiagramme = null;
    }
    
    @Test
    public void testConstructeurDiagramme(){
        assertTrue(this.monDiagramme.getElementsGraphiques() instanceof List);
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif, 
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseAssociationCasUtilisationActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseAssociationActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.ASSOCIATION));
    }

    @Test
    public void testLienAutoriseAssociationActeurPassifActeurPassif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurPassif, 
                this.monActeurPassif,
                TypeLien.ASSOCIATION));
    }
    @Test
    public void testLienAutoriseGeneralisationCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.GENERALISATION));
    }
    
    @Test
    public void testLienAutoriseGeneralisationActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.GENERALISATION));
    }

    @Test
    public void testLienAutoriseDependanceCasUtilisationCasUtilisation () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monCasUtilisation,
                this.monCasUtilisation,
                TypeLien.DEPENDANCE));
    }
    
     @Test
    public void testLienAutoriseDepencanceActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }  
     
    @Test
    public void testLienAutoriseCompositionClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseCompositionLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.COMPOSITION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    @Test
    public void testLienAutoriseAssociationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.ASSOCIATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    @Test
    public void testLienAutoriseGeneralisationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.maClasse,
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseGeneralisationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien,
                this.monLien,
                TypeLien.GENERALISATION));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseDependanceLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.DEPENDANCE));    
    }
    
    @Test
    public void testLienAutoriseDependanceLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.DEPENDANCE));    
    }
    @Test
    public void testLienAutoriseAgregationClasseClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationClasseLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.maClasse, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienClasse () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.maClasse,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAgregationLienLien () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monLien, 
                this.monLien,
                TypeLien.AGREGATION));    
    }
    
    @Test
    public void testLienAutoriseAssociationTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.ASSOCIATION));
    }
    
    
    @Test
    public void testLienAutoriseDependanceTraitementTraitement () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monTraitement,
                this.monTraitement,
                TypeLien.DEPENDANCE));
    }
    
    @Test
    public void testLienAutoriseDependanceActeurActifActeurActif () {
        assertTrue(this.monDiagramme.lienAutorise(
                this.monActeurActif,
                this.monActeurActif,
                TypeLien.DEPENDANCE));
    }
     
    
    @Test
    public void testLienAutoriseClasseAssociation () {
        assertTrue(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.CLASSE_ASSOCIATION));
    }
    
    @Test
    public void testLienAutoriseFleche () {
        assertTrue(this.monDiagramme.lienAutorise(
                null,
                null,
                TypeLien.FLECHE));
    }
    
    @Test
    public void testEltAutoriseTraitement () {
        assertTrue(this.monDiagramme.eltAutorise(this.monTraitement));
    }
    
    @Test
    public void testEltAutoriseClasse () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.maClasse));    
    }
    
    @Test
    public void testEltAutoriseLien () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monLien));
    }

    @Test
    public void testEltAutoriseActeurActif () {
        assertTrue(this.monDiagramme.eltAutorise(
                this.monActeurActif));
    }
    
    @Test
    public void testEltAutoriseActeurPassif () {
        assertTrue(this.monDiagramme.eltAutorise(this.monActeurPassif));
    }
    
    @Test
    public void testEltAutoriseInterface () {
        assertTrue(this.monDiagramme.eltAutorise(this.monInterface));
    } 
    
    @Test
    public void testEltAutoriseCasUtilisation () {
        assertTrue(this.monDiagramme.eltAutorise( this.monCasUtilisation));
    }    

    @Test
    public void testGetElementsGraphiques(){
        assertEquals(this.monDiagramme.getElementsGraphiques(),new Liste<ElementGraphique>());
    } 
    
    @Test
    public void getElementGraphiqueViaCelluleTraitement(){
        ElementGraphique ElemTeste = this.monTraitement;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleClasse(){
        ElementGraphique ElemTeste = this.maClasse;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleLien(){
        ElementGraphique ElemTeste = this.monLien;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleActeurActif(){
        ElementGraphique ElemTeste = this.monActeurActif;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleActeurPassif(){
        ElementGraphique ElemTeste = this.monActeurPassif;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleInterface(){
        ElementGraphique ElemTeste = this.monInterface;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
    
    @Test
    public void getElementGraphiqueViaCelluleCasUtilisation(){
        ElementGraphique ElemTeste = this.monCasUtilisation;
        ElemTeste.creer();
        assertTrue(this.monDiagramme.getElementGraphiqueViaCellule(ElemTeste.getCellule()) == ElemTeste);
    }
}
