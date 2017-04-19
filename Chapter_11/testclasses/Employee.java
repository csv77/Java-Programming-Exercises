package testclasses;

import testmydate.MyDate;

public class Employee extends Person {
    private int office;
    private double salary;
    private MyDate dateHired;
    
    public Employee(){
    }
    
    public Employee(String name, String address, String phone, String email,
                    int office, double salary){
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = new MyDate();
    }
    
    public int getOffice(){
        return office;
    }
    
    public String getSalary(){
        return String.format("%.2f", salary);
    }
    
    public String getDateHired(){
        return dateHired.getMonth() + "/" + dateHired.getDay() + "/" + dateHired.getYear();
    }
    
    public void setOffice(int office){
        this.office = office;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    public void setDateHired(){
        this.dateHired = new MyDate();
    }
    
    @Override
    public String toString(){
        return super.toString() + "\noffice: " + getOffice() + "\nsalary: $" + getSalary() + 
                "\ndate hired: " + getDateHired();
    }
    
}
