package acteurs;


public class Professeur extends Utilisateur {

	// Attributs
	private String attr_str_matiere;
	private int attr_int_idEc;
	private int attr_int_isCom;

	// Construct
	public Professeur(Utilisateur ut, String matiere, int idEc, int isCom) {
		super(ut);
		setAttr_str_matiere(matiere);
		setAttr_int_idEc(idEc);
		setAttr_int_isCom(isCom);
	}
	
	public static Professeur get(int idProf) {
		return jdbc_professeur.select(idProf);
	}
	
	// Get & Set
	public String getAttr_str_matiere() {
		return attr_str_matiere;
	}

	public void setAttr_str_matiere(String attr_str_matiere) {
		this.attr_str_matiere = attr_str_matiere;
	}

	public int getAttr_int_idEc() {
		return attr_int_idEc;
	}

	public void setAttr_int_idEc(int attr_int_idEc) {
		this.attr_int_idEc = attr_int_idEc;
	}

	public int getAttr_int_isCom() {
		return attr_int_isCom;
	}

	public void setAttr_int_isCom(int attr_int_isCom) {
		this.attr_int_isCom = attr_int_isCom;
	}
	
	// Méthodes

	public Ecole getEcole() {
		return jdbc_ecole.select(attr_int_idEc);
	}

	// JDBC
	public void create() {
		super.create();
		jdbc_professeur.insert(this);
	}

	public void edit() {
		super.edit();
		jdbc_professeur.update(this);
	}

	public void remove() {
		super.remove();
		jdbc_professeur.delete(this);
	}
}
