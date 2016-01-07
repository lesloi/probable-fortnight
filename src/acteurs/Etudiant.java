
package acteurs;

import jdbc.JDBC_Etudiant;

public class Etudiant extends Utilisateur {

	/* ATTRIBUTS */
	private int attr_int_numEtudiant;
	private String attr_str_formation;
	private int attr_int_idEc;

	// JDBC
	static private JDBC_Etudiant jdbc_etudiant = new JDBC_Etudiant();

	public Etudiant(String login, String mail, String prenom, String nom) {
		super(login, mail, prenom, nom, TYPE_ETUDIANT);
	}

	public int getAttr_int_numEtudiant() {
		return attr_int_numEtudiant;
	}

	public void setAttr_int_numEtudiant(int attr_int_numEtudiant) {
		this.attr_int_numEtudiant = attr_int_numEtudiant;
	}

	public String getAttr_str_formation() {
		return attr_str_formation;
	}

	public void setAttr_str_formation(String attr_str_formation) {
		this.attr_str_formation = attr_str_formation;
	}

	public int getAttr_int_idEc() {
		return attr_int_idEc;
	}

	public void setAttr_int_idEc(int attr_int_idEc) {
		this.attr_int_idEc = attr_int_idEc;
	}

	// JDBC
	public void create() {
		super.create();
		jdbc_etudiant.insert(this);
	}
	
	public void edit() {
		super.edit();
		jdbc_etudiant.update(this);
	}
	
	public void remove() {
		super.remove();
		jdbc_etudiant.delete(this);
	}
}
