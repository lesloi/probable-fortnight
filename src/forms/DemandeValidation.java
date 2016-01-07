package forms;

import acteurs.Etudiant;


public class DemandeValidation {

    private Stage obj_stage;
    private Etudiant obj_etudiant;
    
    
    public DemandeValidation() {}
    public DemandeValidation(Stage obj_stage, Etudiant obj_etudiant) {
        this.setObj_etudiant(obj_etudiant);
        this.setObj_stage(obj_stage);
    }
    
    
    /**
     * @return the obj_etudiant
     */
    public Etudiant getObj_etudiant() {
        return obj_etudiant;
    }
    /**
     * @param obj_etudiant the obj_etudiant to set
     */
    public void setObj_etudiant(Etudiant obj_etudiant) {
        this.obj_etudiant = obj_etudiant;
    }
    /**
     * @return the obj_stage
     */
    public Stage getObj_stage() {
        return obj_stage;
    }
    /**
     * @param obj_stage the obj_stage to set
     */
    public void setObj_stage(Stage obj_stage) {
        this.obj_stage = obj_stage;
    }
    
    
}
