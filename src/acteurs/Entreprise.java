package acteurs;

import java.util.ArrayList;

import forms.Stage;

public class Entreprise {

	/* ATTRIBUTS */
	private int attr_int_idEntr;
	private String attr_str_login;
	private String attr_str_nom;

	private String attr_str_mail;
	private String attr_str_addresse;

	private String att_str_signature;

	/* METHODES */
	public Entreprise() {
		super();
	}

	public Entreprise(int id, String name, String mail, String address, String sign) {
		super();
		this.setAttr_int_idEntr(id);
		this.setAttr_str_login(null);
		this.setAttr_str_nom(name);
		this.setAttr_str_mail(mail);
		this.setAttr_str_addresse(address);
		this.setAtt_str_signature(sign);
	}

	/**
	 * @return the attr_int_idEntr
	 */
	public int getAttr_int_idEntr() {
		return attr_int_idEntr;
	}

	/**
	 * @param attr_int_idEntr
	 *            the attr_int_idEntr to set
	 */
	public void setAttr_int_idEntr(int attr_int_idEntr) {
		this.attr_int_idEntr = attr_int_idEntr;
	}

	/**
	 * @return the attr_str_login
	 */
	public String getAttr_str_login() {
		return attr_str_login;
	}

	/**
	 * @param attr_str_login
	 *            the attr_str_login to set
	 */
	public void setAttr_str_login(String attr_str_login) {
		this.attr_str_login = attr_str_login;
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

	/**
	 * @return the attr_str_addresse
	 */
	public String getAttr_str_addresse() {
		return attr_str_addresse;
	}

	/**
	 * @param attr_str_addresse
	 *            the attr_str_addresse to set
	 */
	public void setAttr_str_addresse(String attr_str_addresse) {
		this.attr_str_addresse = attr_str_addresse;
	}

	/**
	 * @return the signature
	 */
	public String getAtt_str_signature() {
		return att_str_signature;
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	public void setAtt_str_signature(String signature) {
		this.att_str_signature = signature;
	}

	public ArrayList<Stage> getAttr_list_catalogue() {
		// TODO Auto-generated method stub
		return null;
	}
}
