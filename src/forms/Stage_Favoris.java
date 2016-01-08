package forms;

import acteurs.Etudiant;
import jdbc.JDBC_Stage_Favoris;

public class Stage_Favoris {
	
	// Atributs
	private int attr_int_idEtu;
	private int attr_int_idSt;
	
	// JDBC
	static private JDBC_Stage_Favoris jdbc_stage_favoris = new JDBC_Stage_Favoris(); 

	// Construct
	
	public Stage_Favoris(int attr_int_idEtu, int attr_int_idSt) {
		setAttr_int_idEtu(attr_int_idEtu);
		setAttr_int_idSt(attr_int_idSt);
	}
	
	public static Stage_Favoris get(int idEtu, int idSt) {
		return jdbc_stage_favoris.select(idEtu, idSt);
	}

	// Get & Set

	public int getAttr_int_idEtu() {
		return attr_int_idEtu;
	}

	public void setAttr_int_idEtu(int attr_int_idEtu) {
		this.attr_int_idEtu = attr_int_idEtu;
	}

	public int getAttr_int_idSt() {
		return attr_int_idSt;
	}

	public void setAttr_int_idSt(int attr_int_idSt) {
		this.attr_int_idSt = attr_int_idSt;
	}
	
	// Méthodes
	
	public Etudiant getEtudiant() {
		return Etudiant.get(attr_int_idEtu);
	}

	public Stage getStage() {
		return Stage.get(attr_int_idSt);
	}
	
	// JDBC
	
	public void create() {
		jdbc_stage_favoris.insert(this);
	}
	
	public void remove() {
		jdbc_stage_favoris.delete(this);
	}
}
