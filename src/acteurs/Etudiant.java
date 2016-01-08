package acteurs;

import java.util.ArrayList;

import forms.Convention;
import forms.Stage;
import forms.Stage_Favoris;
import jdbc.JDBC_Convention;
import jdbc.JDBC_Stage_Favoris;

public class Etudiant extends Utilisateur {

	/* ATTRIBUTS */
	private int attr_int_numEtudiant;
	private String attr_str_formation;
	private int attr_int_idEc;

	// Construct

	public Etudiant(Utilisateur ut, int numEtudiant, String formation, int idEc) {
		super(ut);
		setAttr_int_numEtudiant(numEtudiant);
		setAttr_str_formation(formation);
		setAttr_int_idEc(idEc);
	}

	public static Etudiant get(int idEtu) {
		return jdbc_etudiant.select(idEtu);
	}

	// Get & Set

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

	// Méthodes

	public Ecole getEcole() {
		return jdbc_ecole.select(attr_int_idEc);
	}

	public ArrayList<Stage> getStage_Favoris() {
		ArrayList<Stage> arrayList = new ArrayList<Stage>();

		ArrayList<Stage_Favoris> stages_favoris = new JDBC_Stage_Favoris().selectByIdEtu(getAttr_int_idUt());
		for (int i = 0, length = stages_favoris.size(); i < length; i++) {
			arrayList.add(stages_favoris.get(i).getStage());
		}

		return arrayList;
	}

	public ArrayList<Convention> getConventions() {
		return new JDBC_Convention().selectByIdEtu(getAttr_int_idUt());
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
