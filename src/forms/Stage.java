package forms;

import java.util.Date;

import acteurs.Entreprise;
import jdbc.JDBC_Entreprise;
import jdbc.JDBC_Stage;

public class Stage {

	/* ATTRIBUTS */
	private int attr_int_idSt;
	private String attr_str_intitule;
	private String attr_str_description;

	private int attr_int_idEnt;

	// JDBC
	private JDBC_Stage jdbc_stage = new JDBC_Stage();

	// Construct

	public Stage(String attr_str_intitule, String attr_str_description, int attr_int_idEnt) {
		super();
		setAttr_str_intitule(attr_str_intitule);
		setAttr_str_description(attr_str_description);
		setAttr_int_idEnt(attr_int_idEnt);
	}

	// Get & Set

	public int getAttr_int_idSt() {
		return attr_int_idSt;
	}

	public void setAttr_int_idSt(int attr_int_idSt) {
		this.attr_int_idSt = attr_int_idSt;
	}

	public String getAttr_str_intitule() {
		return attr_str_intitule;
	}

	public void setAttr_str_intitule(String attr_str_intitule) {
		this.attr_str_intitule = attr_str_intitule;
	}

	public String getAttr_str_description() {
		return attr_str_description;
	}

	public void setAttr_str_description(String attr_str_description) {
		this.attr_str_description = attr_str_description;
	}

	public int getAttr_int_idEnt() {
		return attr_int_idEnt;
	}

	public void setAttr_int_idEnt(int attr_int_idEnt) {
		this.attr_int_idEnt = attr_int_idEnt;
	}

	// Méthodes

	public Entreprise getEntreprise() {
		return new JDBC_Entreprise().select(attr_int_idEnt);
	}
	
	// JDBC
	
	public void create() {
		setAttr_int_idSt(jdbc_stage.insert(this));
	}
	
	public void edit() {
		jdbc_stage.update(this);
	}
	
	public void remove() {
		jdbc_stage.delete(this);
	}
}
