package acteurs;

import java.util.ArrayList;

import forms.Stage;
import jdbc.JDBC_Entreprise;
import jdbc.JDBC_Stage;

public class Entreprise extends Utilisateur {

	/* ATTRIBUTS */
	private int attr_int_numSiret;
	private String attr_str_adresse;
	
	// Construct

	public Entreprise(String login, String mail, String prenom, String nom, int numSiret, String adresse) {
		super(login, mail, prenom, nom, TYPE_ENTREPRISE);
		setAttr_int_numSiret(numSiret);
		setAttr_str_adresse(adresse);
	}

	// Get & Set

	public int getAttr_int_numSiret() {
		return attr_int_numSiret;
	}

	public void setAttr_int_numSiret(int attr_int_numSiret) {
		this.attr_int_numSiret = attr_int_numSiret;
	}

	public String getAttr_str_adresse() {
		return attr_str_adresse;
	}

	public void setAttr_str_adresse(String attr_str_adresse) {
		this.attr_str_adresse = attr_str_adresse;
	}

	/* METHODES */

	public ArrayList<Stage> getStages() {
		return new JDBC_Stage().selectByIdEnt(getAttr_int_idUt());
	}
	
	// JDBC
	
	public void create() {
		setAttr_int_idUt(jdbc_entreprise);
	}
}
