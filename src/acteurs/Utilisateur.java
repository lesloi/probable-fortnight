
package acteurs;

import jdbc.*;

public class Utilisateur {
	static final int TYPE_ETUDIANT = 1;
	static final int TYPE_PROFESSEUR = 2;
	static final int TYPE_ENTREPRISE = 3;

	/* ATTRIBUTS */
	private int attr_int_idUt;
	private String attr_str_login;
	private String attr_str_mail;
	private String attr_str_prenom;
	private String attr_str_nom;
	private int attr_int_type;

	// jdbc_utilisateur
	static protected JDBC_Ecole jdbc_ecole= new JDBC_Ecole();
	static protected JDBC_Entreprise jdbc_entreprise = new JDBC_Entreprise();
	static protected JDBC_Etudiant jdbc_etudiant = new JDBC_Etudiant();
	static protected JDBC_Professeur jdbc_professeur = new JDBC_Professeur();
	static protected JDBC_Utilisateur jdbc_utilisateur = new JDBC_Utilisateur();
	static protected JDBC_Stage jdbc_stage = new JDBC_Stage();

	// Construct
	public Utilisateur(String login, String mail, String prenom, String nom, int type) {
		setAttr_str_login(login);
		setAttr_str_mail(mail);
		setAttr_str_prenom(prenom);
		setAttr_str_nom(nom);
		setAttr_int_type(type);
	}

	// Get & Set
	public int getAttr_int_idUt() {
		return attr_int_idUt;
	}

	public void setAttr_int_idUt(int attr_int_idUt) {
		this.attr_int_idUt = attr_int_idUt;
	}

	public String getAttr_str_login() {
		return attr_str_login;
	}

	public void setAttr_str_login(String attr_str_login) {
		this.attr_str_login = attr_str_login;
	}

	public String getAttr_str_mail() {
		return attr_str_mail;
	}

	public void setAttr_str_mail(String attr_str_mail) {
		this.attr_str_mail = attr_str_mail;
	}

	public int getAttr_int_type() {
		return attr_int_type;
	}

	public void setAttr_int_type(int attr_int_type) {
		this.attr_int_type = attr_int_type;
	}

	public String getAttr_str_prenom() {
		return attr_str_prenom;
	}

	public void setAttr_str_prenom(String attr_str_prenom) {
		this.attr_str_prenom = attr_str_prenom;
	}

	public String getAttr_str_nom() {
		return attr_str_nom;
	}

	public void setAttr_str_nom(String attr_str_nom) {
		this.attr_str_nom = attr_str_nom;
	}

	// JDBC
	protected void create() {
		setAttr_int_idUt(jdbc_utilisateur.insert(this));
	}

	protected void edit() {
		jdbc_utilisateur.update(this);
	}

	protected void remove() {
		jdbc_utilisateur.delete(this);
	}
}
