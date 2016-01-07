package forms;

public class Notification {

    private int attr_int_idNotif;
    private String attr_str_message;
    
    public Notification() {}
    public Notification(int id, String txt) {
        
        this.setattr_int_idNotif(id);
        this.setattr_str_message(txt);
        
    }
    /**
     * @return the attr_int_idNotif
     */
    public int getattr_int_idNotif() {
        return attr_int_idNotif;
    }
    /**
     * @param attr_int_idNotif the attr_int_idNotif to set
     */
    public void setattr_int_idNotif(int attr_int_idNotif) {
        this.attr_int_idNotif = attr_int_idNotif;
    }
    /**
     * @return the attr_str_message
     */
    public String getattr_str_message() {
        return attr_str_message;
    }
    /**
     * @param attr_str_message the attr_str_message to set
     */
    public void setattr_str_message(String attr_str_message) {
        this.attr_str_message = attr_str_message;
    }
    
    
}
