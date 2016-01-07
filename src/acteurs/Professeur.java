package acteurs;


import jdbc.JDBC_Professeur;

public class Professeur extends Utilisateur {

	// Attributs
	private String attr_str_matiere;
	private int attr_int_idEc;
	private int attr_int_isDir;
	private int attr_int_isCom;

	// JDBC
	private JDBC_Professeur jdbc_professeur = new JDBC_Professeur();

	// Construct
	public Professeur(String login, String mail, String prenom, String nom) {
		super(login, mail, prenom, nom, TYPE_PROFESSEUR);
	}

	// Get & Set
	public String getAttr_str_matiere() {
		return attr_str_matiere;
	}

	public void setAttr_str_matiere(String attr_str_matiere) {
		this.attr_str_matiere = attr_str_matiere;
	}

	public int getAttr_int_idEc() {
		return attr_int_idEc;
	}

	public void setAttr_int_idEc(int attr_int_idEc) {
		this.attr_int_idEc = attr_int_idEc;
	}

	public int getAttr_int_isDir() {
		return attr_int_isDir;
	}

	public void setAttr_int_isDir(int attr_int_isDir) {
		this.attr_int_isDir = attr_int_isDir;
	}

	public int getAttr_int_isCom() {
		return attr_int_isCom;
	}

	public void setAttr_int_isCom(int attr_int_isCom) {
		this.attr_int_isCom = attr_int_isCom;
	}
}
