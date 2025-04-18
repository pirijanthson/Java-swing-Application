package TechRepair;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InventoryAction {
	private DatabaseConnection con;

    public InventoryAction() {
        con = DatabaseConnection.getSingleConnection();
    }

    public boolean addInventory(Inventory inventory) {
        try {
            String query = "INSERT INTO inventory (id, name, quantity, sid) VALUES ('" 
                            + inventory.getInventoryID() + "', '" 
                            + inventory.getPartName() + "', '" 
                            + inventory.getQuantity() + "', '" 
                            + inventory.getSupplierID() + "')";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean updateInventory(Inventory inventory) {
        try {
            String query = "UPDATE inventory SET name = '" 
                            + inventory.getPartName() + "', quantity = '" 
                            + inventory.getQuantity() + "', sid = '" 
                            + inventory.getSupplierID() + "' WHERE id = '" 
                            + inventory.getInventoryID() + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteInventory(String id) {
        try {
            String query = "DELETE FROM inventory WHERE id = '" 
                            + id + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public List<Inventory> getAllInventory() {
        List<Inventory> inventorys = new ArrayList<>();
        try {
            String query = "SELECT * FROM inventory";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String quantity = rs.getString("quantity");
                String sid = rs.getString("sid");
                inventorys.add(new Inventory(id, name, quantity, sid));
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return inventorys;
    }
    
    public Inventory getInventoryByID(String id) {
    	Inventory inventory = null;
        try {
            String query = "SELECT * FROM inventory WHERE id = ?";
            
            ResultSet rs = con.executeQuery(query, id); 

            if (rs.next()) {
            	String name = rs.getString("name");
                String quantity = rs.getString("quantity");
                String sid = rs.getString("sid");
                inventory = new Inventory(id, name, quantity, sid);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return inventory;
    }

}
