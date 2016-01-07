package acteurs;

import java.util.ArrayList;

import forms.Stage;

public class Entreprise extends Utilisateur {

	/* ATTRIBUTS */
	private String attr_str_addresse;

	public Entreprise(String login, String mail, String prenom, String nom) {
		super(login, mail, prenom, nom, TYPE_ENTREPRISE);
	}

	// Get & Set

	public String getAttr_str_addresse() {
		return attr_str_addresse;
	}

	public void setAttr_str_addresse(String attr_str_addresse) {
		this.attr_str_addresse = attr_str_addresse;
	}

	/* METHODES */
	
	public ArrayList<Stage> getAttr_list_catalogue() {
		// TODO Auto-generated method stub
		return null;
	}
}
