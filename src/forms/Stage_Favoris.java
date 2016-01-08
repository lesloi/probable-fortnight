package forms;

import acteurs.Etudiant;
import jdbc.JDBC_Stage_Favoris;

public class Stage_Favoris {
	
	// Atributs
	private int attr_idEtu;
	private int attr_idSt;
	
	// JDBC
	static private JDBC_Stage_Favoris jdbc_stage_favoris = new JDBC_Stage_Favoris(); 

	// Construct
	
	public Stage_Favoris(int attr_idEtu, int attr_idSt) {
		setAttr_idEtu(attr_idEtu);
		setAttr_idSt(attr_idSt);
	}
	
	public static Stage_Favoris get(int idEtu, int idSt) {
		return jdbc_stage_favoris.select(idEtu, idSt);
	}

	// Get & Set

	public int getAttr_idEtu() {
		return attr_idEtu;
	}

	public void setAttr_idEtu(int attr_idEtu) {
		this.attr_idEtu = attr_idEtu;
	}

	public int getAttr_idSt() {
		return attr_idSt;
	}

	public void setAttr_idSt(int attr_idSt) {
		this.attr_idSt = attr_idSt;
	}
	
	// Méthodes
	
	public Etudiant getEtudiant() {
		return Etudiant.get(attr_idEtu);
	}
	
	public Stage getStage() {
		return Stage.get(attr_idSt);
	}
	
	// JDBC
	
	public void create() {
		jdbc_stage_favoris.insert(this);
	}
	
	public void remove() {
		jdbc_stage_favoris.delete(this);
	}
}
