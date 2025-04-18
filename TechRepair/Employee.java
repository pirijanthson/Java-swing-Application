package TechRepair;

public class Employee {
    private String ID;
    private String Name;
    private String Role;
    private String Email;
    private String Phone;
    private String Address;
    private String Status;
    private String WorkLocation;
    private String Schedule;

    Employee(String id, String name, String role, String email, String phone, String address, String status, String work, String schedule){
        ID = id;
        Name = name;
        Role = role;
        Email = email;
        Phone = phone;
        Address = address;
        Status = status;
        WorkLocation = work;
        Schedule = schedule;
    }

    public String printEmp(){
        return "Employee ID: " + ID + "\nEmployee Name: " + Name + "\nEmployee Role"+Role+"\nEmployee Email : "+Email+"\nEmployee Phone Number : "+Phone+"\nEmployee Address : "+Address+"\nEmployee Availability : "+Status+"\nEmployee Work Type : "+WorkLocation+"\nEmployee Work Schedule : "+Schedule;
    }

    public String getEmpID(){
        return ID;
    }

    public String getEmpName(){
        return Name;
    }

    public String getEmpRole(){
        return Role;
    }

    public String getEmpEmail(){
        return Email;
    }
    
    public String getEmpPhone() {
    	return Phone;
    }

    public String getEmpAddress(){
        return Address;
    }

    public String getEmpStatus(){
        return Status;
    }
    
    public String getEmpWorklocation(){
        return WorkLocation;
    }

    public String getEmpSchedule(){
        return Schedule;
    }
}
