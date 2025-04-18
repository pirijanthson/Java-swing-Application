package TechRepair;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerAction {
	private DatabaseConnection con;

    public CustomerAction() {
        con = DatabaseConnection.getSingleConnection();
    }

    public boolean addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO customer (oid, cid, name, email, type, status, parts, total) VALUES ('" 
                            + customer.getOrderId() + "', '" 
                            + customer.getCustomerId() + "', '" 
                            + customer.getName() + "', '" 
                            + customer.getEmail() + "', '" 
                            + customer.getOrderType() + "', '" 
                            + customer.getOrderStatus() + "', '" 
                            + customer.getRequiredParts() + "', '"
                            + customer.getTotalCost() + "')";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public boolean updateCustomer(Customer customer) {
        try {
            String query = "UPDATE customer SET cid = '" 
                            + customer.getCustomerId() + "', name = '" 
                            + customer.getName() + "', email = '" 
                            + customer.getEmail() + "', type = '" 
                            + customer.getOrderType() + "', status = '" 
                            + customer.getOrderStatus() + "', parts = '"
                            + customer.getRequiredParts() + "', total = '" 
                            + customer.getTotalCost() + "' WHERE oid = '" 
                            + customer.getOrderId() + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteCustomer(String id) {
        try {
            String query = "DELETE FROM customer WHERE oid = '" 
                            + id + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public List<Customer> getAllCustomers() {
        List<Customer> Customers = new ArrayList<>();
        try {
            String query = "SELECT * FROM customer";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                String oid = rs.getString("oid");
                String cid = rs.getString("cid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String type = rs.getString("type");
                String status = rs.getString("status");
                String parts = rs.getString("parts");
                double total = rs.getDouble("total");
                Customers.add(new Customer(oid, cid, name, email, type, status, parts, total));
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return Customers;
    }
    
    public Customer getCustomerByID(String id) {
    	Customer customer = null;
        try {
            String query = "SELECT * FROM customer WHERE oid = ?";
            
            ResultSet rs = con.executeQuery(query, id); 

            if (rs.next()) {
            	String oid = rs.getString("oid");
                String cid = rs.getString("cid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String type = rs.getString("type");
                String status = rs.getString("status");
                String parts = rs.getString("parts");
                double total = rs.getDouble("total");
                customer = new Customer(oid, cid, name, email, type, status, parts, total);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return customer;
    }
}
