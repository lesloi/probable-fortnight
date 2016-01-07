package acteurs;

import jdbc.JDBC_Ecole;
import jdbc.JDBC_Professeur;

public class Ecole {

	/* ATTRIBUTS */
	private int attr_int_idEc;
	private String attr_str_nom;
	private String attr_str_adresse;
	private String attr_str_mail;
	
	private int attr_int_idDir;
	
	// JDBC
	private static JDBC_Ecole jdbc_ecole = new JDBC_Ecole();

	/* METHODES */
	public Ecole(String name, String address, String mail, int idDir) {
		this.setAttr_str_nom(name);
		this.setAttr_str_adresse(address);
		this.setAttr_str_mail(mail);
		this.setAttr_int_idDir(idDir);
	}

	/**
	 * @return the attr_int_idEc
	 */
	public int getAttr_int_idEc() {
		return attr_int_idEc;
	}

	/**
	 * @param attr_int_idEc
	 *            the attr_int_idEc to set
	 */
	public void setAttr_int_idEc(int attr_int_idEc) {
		this.attr_int_idEc = attr_int_idEc;
	}

	/**
	 * @return the attr_str_nom
	 */
	public String getAttr_str_nom() {
		return attr_str_nom;
	}

	/**
	 * @param attr_str_nom
	 *            the attr_str_nom to set
	 */
	public void setAttr_str_nom(String attr_str_nom) {
		this.attr_str_nom = attr_str_nom;
	}

	/**
	 * @return the attr_str_adresse
	 */
	public String getAttr_str_adresse() {
		return attr_str_adresse;
	}

	/**
	 * @param attr_str_adresse
	 *            the attr_str_adresse to set
	 */
	public void setAttr_str_adresse(String attr_str_adresse) {
		this.attr_str_adresse = attr_str_adresse;
	}

	/**
	 * @return the attr_str_mail
	 */
	public String getAttr_str_mail() {
		return attr_str_mail;
	}

	/**
	 * @param attr_str_mail
	 *            the attr_str_mail to set
	 */
	public void setAttr_str_mail(String attr_str_mail) {
		this.attr_str_mail = attr_str_mail;
	}

	public int getAttr_int_idDir() {
		return attr_int_idDir;
	}

	public void setAttr_int_idDir(int attr_int_idDir) {
		this.attr_int_idDir = attr_int_idDir;
	}
	
	// Méthodes
	
	public Professeur getDirecteur() {
		return new JDBC_Professeur().select(attr_int_idDir);
	}
	
	public void setDirecteur(Professeur prof) {
		setAttr_int_idDir(prof.getAttr_int_idUt());
		edit();
	}

	// JDBC
	
	public void create() {
		setAttr_int_idEc(jdbc_ecole.insert(this));
	}
	
	public void edit() {
		jdbc_ecole.update(this);
	}
	
	public void remove() {
		jdbc_ecole.delete(this);
	}
}
