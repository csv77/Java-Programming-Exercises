package testclasses;

public class Staff extends Employee {
    private String title;
    
    public Staff(){
    }
    
    public Staff(String name, String address, String phone, String email,
                 int office, double salary, String title){
        super(name, address, phone, email, office, salary);
        this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String toString(){
        return super.toString() + "\ntitle: " + getTitle();
    }
    
}
