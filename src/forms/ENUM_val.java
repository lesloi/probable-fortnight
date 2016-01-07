package forms;

public enum ENUM_val {

  //Objets directement construits
    Validation("Valisation"),
    Refus("Refus"),
    Processing("Processing");
     
    private String name = "";
     
    //Constructeur
    ENUM_val(String name){
      this.name = name;
    }
     
    public String toString(){
      return name;
    }
    
}
