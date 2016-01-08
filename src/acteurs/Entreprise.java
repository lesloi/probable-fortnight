package acteurs;

import java.util.ArrayList;

import forms.Convention;
import forms.Stage;
import jdbc.JDBC_Stage;

public class Entreprise extends Utilisateur {

	/* ATTRIBUTS */
	private int attr_int_numSiret;
	private String attr_str_adresse;

	// Construct

	public Entreprise(Utilisateur ut, int numSiret, String adresse) {
		super(ut);
		setAttr_int_numSiret(numSiret);
		setAttr_str_adresse(adresse);
	}

	public static Entreprise get(int idEnt) {
		return jdbc_entreprise.select(idEnt);
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
	   // System.out.println(getAttr_int_idUt());
		return new JDBC_Stage().selectByIdEnt(getAttr_int_idUt());
	}

	public ArrayList<Convention> getConventions() {
		ArrayList<Convention> arrayList = new ArrayList<Convention>();

		ArrayList<Stage> stages = getStages();

		for (int i = 0, length = stages.size(); i < length; i++) {
			arrayList.addAll(stages.get(i).getConventions());
		}

		return arrayList;
	}

	// JDBC

	public void create() {
		super.create();
		jdbc_entreprise.insert(this);
	}

	public void edit() {
		super.edit();
		jdbc_entreprise.update(this);
	}

	public void remove() {
		super.remove();
		jdbc_entreprise.delete(this);
	}
}
