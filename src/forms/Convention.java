package forms;

import acteurs.Etudiant;

public class Convention {

	/* ATTRIBUTS */
	private int attr_int_idConv;

	private Stage obj_stage;
	private Etudiant obj_etudiant;

	private String attr_signatureDirecteur;
	private String attr_signatureEntreprise;
	private String attr_signatureEtudiant;

	private boolean atttr_boolean_approbationDirecteur;
	private boolean atttr_boolean_approbationEntreprise;
	private boolean atttr_boolean_approbationEtudiant;

	/* METHODES */
	public Convention() {
	}

	public Convention(int id, Stage stage, Etudiant eleve) {
		this.setAttr_int_idConv(id);
		this.setObj_stage(stage);
		this.setObj_etudiant(eleve);
		this.setAttr_signatureDirecteur(null);
		this.setAttr_signatureEntreprise(null);
		this.setAttr_signatureEtudiant(null);
		this.setAtttr_boolean_approbationDirecteur(false);
		this.setAtttr_boolean_approbationEntreprise(false);
		this.setAtttr_boolean_approbationEtudiant(false);
	}

	/**
	 * @return the attr_int_idConv
	 */
	public int getAttr_int_idConv() {
		return attr_int_idConv;
	}

	/**
	 * @param attr_int_idConv
	 *            the attr_int_idConv to set
	 */
	public void setAttr_int_idConv(int attr_int_idConv) {
		this.attr_int_idConv = attr_int_idConv;
	}

	/**
	 * @return the obj_stage
	 */
	public Stage getObj_stage() {
		return obj_stage;
	}

	/**
	 * @param obj_stage
	 *            the obj_stage to set
	 */
	public void setObj_stage(Stage obj_stage) {
		this.obj_stage = obj_stage;
	}

	/**
	 * @return the obj_etudiant
	 */
	public Etudiant getObj_etudiant() {
		return obj_etudiant;
	}

	/**
	 * @param obj_etudiant
	 *            the obj_etudiant to set
	 */
	public void setObj_etudiant(Etudiant obj_etudiant) {
		this.obj_etudiant = obj_etudiant;
	}

	/**
	 * @return the attr_signatureDirecteur
	 */
	public String getAttr_signatureDirecteur() {
		return attr_signatureDirecteur;
	}

	/**
	 * @param attr_signatureDirecteur
	 *            the attr_signatureDirecteur to set
	 */
	public void setAttr_signatureDirecteur(String attr_signatureDirecteur) {
		this.attr_signatureDirecteur = attr_signatureDirecteur;
	}

	/**
	 * @return the attr_signatureEntreprise
	 */
	public String getAttr_signatureEntreprise() {
		return attr_signatureEntreprise;
	}

	/**
	 * @param attr_signatureEntreprise
	 *            the attr_signatureEntreprise to set
	 */
	public void setAttr_signatureEntreprise(String attr_signatureEntreprise) {
		this.attr_signatureEntreprise = attr_signatureEntreprise;
	}

	/**
	 * @return the attr_signatureEtudiant
	 */
	public String getAttr_signatureEtudiant() {
		return attr_signatureEtudiant;
	}

	/**
	 * @param attr_signatureEtudiant
	 *            the attr_signatureEtudiant to set
	 */
	public void setAttr_signatureEtudiant(String attr_signatureEtudiant) {
		this.attr_signatureEtudiant = attr_signatureEtudiant;
	}

	/**
	 * @return the atttr_boolean_approbationDirecteur
	 */
	public boolean isAtttr_boolean_approbationDirecteur() {
		return atttr_boolean_approbationDirecteur;
	}

	/**
	 * @param atttr_boolean_approbationDirecteur
	 *            the atttr_boolean_approbationDirecteur to set
	 */
	public void setAtttr_boolean_approbationDirecteur(boolean atttr_boolean_approbationDirecteur) {
		this.atttr_boolean_approbationDirecteur = atttr_boolean_approbationDirecteur;
	}

	/**
	 * @return the atttr_boolean_approbationEntreprise
	 */
	public boolean isAtttr_boolean_approbationEntreprise() {
		return atttr_boolean_approbationEntreprise;
	}

	/**
	 * @param atttr_boolean_approbationEntreprise
	 *            the atttr_boolean_approbationEntreprise to set
	 */
	public void setAtttr_boolean_approbationEntreprise(boolean atttr_boolean_approbationEntreprise) {
		this.atttr_boolean_approbationEntreprise = atttr_boolean_approbationEntreprise;
	}

	/**
	 * @return the atttr_boolean_approbationEtudiant
	 */
	public boolean isAtttr_boolean_approbationEtudiant() {
		return atttr_boolean_approbationEtudiant;
	}

	/**
	 * @param atttr_boolean_approbationEtudiant
	 *            the atttr_boolean_approbationEtudiant to set
	 */
	public void setAtttr_boolean_approbationEtudiant(boolean atttr_boolean_approbationEtudiant) {
		this.atttr_boolean_approbationEtudiant = atttr_boolean_approbationEtudiant;
	}
}
