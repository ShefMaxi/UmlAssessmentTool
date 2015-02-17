package FileHandler;

public class ActorsXmi {
    private String id;
    private String name;
    private String type;
  //  private int age;
   // private String role;
     // new change
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String typ) {
        this.type = typ;
    }
   
     
    @Override
    public String toString() {
        return "Usecase:: ID="+this.id+" Name=" + this.name  + " Type=" + this.type  ;
    }

}

