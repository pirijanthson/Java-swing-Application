package TechRepair;

public class Inventory {
    private String ID;
    private String partName;
    private String Quantity;
    private String SupplierID;

    Inventory (String id, String partname, String quantity, String Sup_id){
        ID = id;
        partName = partname;
        Quantity = quantity;
        SupplierID = Sup_id;
    }

    public String printInventory(){
        return "Part Name: " + partName + "\nID: " + ID + "\nQuantity: " + Quantity + "\nSupplier ID: " + SupplierID ;
    }

    public String getPartName(){
        return partName;
    }

    public String getInventoryID(){
        return ID;
    }

    public String getQuantity(){
        return Quantity;
    }

    public String getSupplierID(){
        return SupplierID;
    }
    
}
