package TechRepair;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SupplierAction {
    private DatabaseConnection con;

    public SupplierAction() {
        con = DatabaseConnection.getSingleConnection();
    }

    public boolean addSupplier(Supplier supplier) {
        try {
            String query = "INSERT INTO supplier (supplierId, supplierName, contactDetails, partsSupplied) VALUES ('" 
                            + supplier.getSupplierID() + "', '" 
                            + supplier.getSupplierName() + "', '" 
                            + supplier.getSupplierContactNumber() + "', '" 
                            + supplier.getSupplierProvidedParts() + "')";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean updateSupplier(Supplier supplier) {
        try {
            String query = "UPDATE supplier SET supplierName = '" 
                            + supplier.getSupplierName() + "', contactDetails = '" 
                            + supplier.getSupplierContactNumber() + "', partsSupplied = '" 
                            + supplier.getSupplierProvidedParts() + "' WHERE supplierId = '" 
                            + supplier.getSupplierID() + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteSupplier(String id) {
        try {
            String query = "DELETE FROM supplier WHERE supplierId = '" 
                            + id + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();
        try {
            String query = "SELECT * FROM supplier";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("supplierId");
                String name = rs.getString("supplierName");
                String contact = rs.getString("contactDetails");
                String parts = rs.getString("partsSupplied");
                suppliers.add(new Supplier(id, name, contact, parts));
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return suppliers;
    }
    
    public Supplier getSupplierByID(String id) {
        Supplier supplier = null;
        try {
            String query = "SELECT * FROM supplier WHERE supplierId = ?";
            
            ResultSet rs = con.executeQuery(query, id); 

            if (rs.next()) {
                String name = rs.getString("supplierName");
                String contact = rs.getString("contactDetails");
                String parts = rs.getString("partsSupplied");
                supplier = new Supplier(id, name, contact, parts);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return supplier;
    }

}
