package forms;

import java.util.Date;

import acteurs.Entreprise;

public class Stage {

    /* ATTRIBUTS */
    private int attr_int_idSt;
    private String attr_str_intitule;
    private String attr_str_descOS;
    private String attr_str_nomEntreprise;
    
    private Date attr_date_start_stage;
    private Date attr_date_end_stage;
    
    
    /* METHODES */
    public Stage(){}
    public Stage(int id, String name, String description, Entreprise company/*, Date start, Date end*/){
        this.setAttr_int_idSt(id);
        this.setAttr_str_intitule(name);
        this.setAttr_str_descOS(description);
        this.setAttr_str_nomEntreprise(company.getAttr_str_nom());
        /*this.setAttr_date_start_stage(start);
        this.setAttr_date_end_stage(end);*/
    }
    /**
     * @return the attr_int_idSt
     */
    public int getAttr_int_idSt() {
        return attr_int_idSt;
    }
    /**
     * @param attr_int_idSt the attr_int_idSt to set
     */
    public void setAttr_int_idSt(int attr_int_idSt) {
        this.attr_int_idSt = attr_int_idSt;
    }
    /**
     * @return the attr_str_intitule
     */
    public String getAttr_str_intitule() {
        return attr_str_intitule;
    }
    /**
     * @param attr_str_intitule the attr_str_intitule to set
     */
    public void setAttr_str_intitule(String attr_str_intitule) {
        this.attr_str_intitule = attr_str_intitule;
    }
    /**
     * @return the attr_str_descOS
     */
    public String getAttr_str_descOS() {
        return attr_str_descOS;
    }
    /**
     * @param attr_str_descOS the attr_str_descOS to set
     */
    public void setAttr_str_descOS(String attr_str_descOS) {
        this.attr_str_descOS = attr_str_descOS;
    }
    /**
     * @return the attr_str_nomEntreprise
     */
    public String getAttr_str_nomEntreprise() {
        return attr_str_nomEntreprise;
    }
    /**
     * @param attr_str_nomEntreprise the attr_str_nomEntreprise to set
     */
    public void setAttr_str_nomEntreprise(String attr_str_nomEntreprise) {
        this.attr_str_nomEntreprise = attr_str_nomEntreprise;
    }
    /**
     * @return the attr_date_start_stage
     */
    public Date getAttr_date_start_stage() {
        return attr_date_start_stage;
    }
    /**
     * @param attr_date_start_stage the attr_date_start_stage to set
     */
    public void setAttr_date_start_stage(Date attr_date_start_stage) {
        this.attr_date_start_stage = attr_date_start_stage;
    }
    /**
     * @return the attr_date_end_stage
     */
    public Date getAttr_date_end_stage() {
        return attr_date_end_stage;
    }
    /**
     * @param attr_date_end_stage the attr_date_end_stage to set
     */
    public void setAttr_date_end_stage(Date attr_date_end_stage) {
        this.attr_date_end_stage = attr_date_end_stage;
    }
    
}
