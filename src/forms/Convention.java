package forms;

import acteurs.Etudiant;
import jdbc.JDBC_Convention;

public class Convention {

	/* ATTRIBUTS */
	private int attr_int_idConv;
	private int attr_int_idSt;
	private int attr_int_idEtu;
	private boolean attr_boolean_approbationDirecteur;
	private boolean attr_boolean_approbationEntreprise;
	private boolean attr_boolean_approbationEtudiant;

	// JDBC
	static private JDBC_Convention jdbc_convention = new JDBC_Convention();
	
	// Construct

	public Convention(int attr_int_idSt, int attr_int_idEtu,
			boolean attr_boolean_approbationDirecteur, boolean attr_boolean_approbationEntreprise,
			boolean attr_boolean_approbationEtudiant) {
		super();
		setAttr_int_idSt(attr_int_idSt);
		setAttr_int_idEtu(attr_int_idEtu);
		setAttr_boolean_approbationDirecteur(attr_boolean_approbationDirecteur);
		setAttr_boolean_approbationEntreprise(attr_boolean_approbationEntreprise);
		setAttr_boolean_approbationEtudiant(attr_boolean_approbationEtudiant);
	}
	
	public static Convention get(int idConv) {
		return jdbc_convention.select(idConv);
	}
	
	// Get & Set

	public int getAttr_int_idConv() {
		return attr_int_idConv;
	}

	public void setAttr_int_idConv(int attr_int_idConv) {
		this.attr_int_idConv = attr_int_idConv;
	}

	public int getAttr_int_idSt() {
		return attr_int_idSt;
	}

	public void setAttr_int_idSt(int attr_int_idSt) {
		this.attr_int_idSt = attr_int_idSt;
	}

	public int getAttr_int_idEtu() {
		return attr_int_idEtu;
	}

	public void setAttr_int_idEtu(int attr_int_idEtu) {
		this.attr_int_idEtu = attr_int_idEtu;
	}

	public boolean getAttr_boolean_approbationDirecteur() {
		return attr_boolean_approbationDirecteur;
	}

	public void setAttr_boolean_approbationDirecteur(boolean attr_boolean_approbationDirecteur) {
		this.attr_boolean_approbationDirecteur = attr_boolean_approbationDirecteur;
	}

	public boolean getAttr_boolean_approbationEntreprise() {
		return attr_boolean_approbationEntreprise;
	}

	public void setAttr_boolean_approbationEntreprise(boolean attr_boolean_approbationEntreprise) {
		this.attr_boolean_approbationEntreprise = attr_boolean_approbationEntreprise;
	}

	public boolean getAttr_boolean_approbationEtudiant() {
		return attr_boolean_approbationEtudiant;
	}

	public void setAttr_boolean_approbationEtudiant(boolean attr_boolean_approbationEtudiant) {
		this.attr_boolean_approbationEtudiant = attr_boolean_approbationEtudiant;
	}
	
	// Méthode
	
	public Stage getStage() {
		return Stage.get(attr_int_idSt);
	}
	
	public Etudiant getEtudiant() {
		return Etudiant.get(attr_int_idEtu);
	}
	
	// JDBC
	
	public void create() {
		setAttr_int_idConv(jdbc_convention.insert(this));
	}
	
	public void edit() {
		jdbc_convention.update(this);
	}
	
	public void remove() {
		jdbc_convention.delete(this);
	}
}
