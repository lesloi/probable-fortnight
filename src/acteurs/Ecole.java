package acteurs;

public class Ecole {

	/* ATTRIBUTS */
	private int attr_int_idEc;
	private String attr_str_nom;
	private String attr_str_adresse;
	private String attr_str_mail;
	
	// JDBC
	

	/* METHODES */
	public Ecole(String name, String address, String mail) {
		this.setAttr_str_nom(name);
		this.setAttr_str_adresse(address);
		this.setAttr_str_mail(mail);
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
}
