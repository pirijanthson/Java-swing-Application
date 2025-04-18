package TechRepair;


public class Supplier {
    private String ID;
    private String Name;
    private String ContactNumber;
    private String PartsProvided;

    Supplier(String id2, String name, String phone, String parts){
        ID = id2;
        Name = name;
        ContactNumber = phone;
        PartsProvided = parts;
    }

    public String printSupplierDetails(){
        return "Supplier ID : "+ID+"\nSupplier Name : "+Name+"\nSupplier Contact Number : "+ContactNumber+"\nSupplier Provided Parts : "+PartsProvided;
    }

    public String getSupplierID(){
        return ID;
    }

    public String getSupplierName(){
        return Name;
    }

    public String getSupplierContactNumber(){
        return ContactNumber;
    }

    public String getSupplierProvidedParts(){
        return PartsProvided;
    }
    // Setters (optional, if you plan to update supplier info)
    public void setSupplierID(String ID) {
        this.ID = ID;
    }

    public void setSupplierName(String Name) {
        this.Name = Name;
    }

    public void setSupplierContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public void setSupplierProvidedParts(String PartsProvided) {
        this.PartsProvided = PartsProvided;
    }
}