package TechRepair;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAction {
	private DatabaseConnection con;

    public EmployeeAction() {
        con = DatabaseConnection.getSingleConnection();
    }

    public boolean addEmployee(Employee employee) {
        try {
            String query = "INSERT INTO employee (id, name,role,email,phone,address,status,workLocation,schedule) VALUES ('" 
                            + employee.getEmpID() + "', '" 
                            + employee.getEmpName() + "', '" 
                            + employee.getEmpRole() + "', '" 
                            + employee.getEmpEmail() + "', '" 
                            + employee.getEmpPhone() + "', '" 
                            + employee.getEmpAddress() + "', '" 
                            + employee.getEmpStatus() + "', '" 
                            + employee.getEmpWorklocation() + "', '" 
                            + employee.getEmpSchedule() + "')";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public boolean updateEmployee(Employee employee) {
        try {
            String query = "UPDATE employee SET name = '" 
                            + employee.getEmpName() + "', role = '" 
                            + employee.getEmpRole() + "', email = '" 
                            + employee.getEmpEmail() + "', phone = '" 
                            + employee.getEmpPhone() + "', address = '" 
                            + employee.getEmpAddress() + "', status = '" 
                            + employee.getEmpStatus() + "', workLocation = '" 
                            + employee.getEmpWorklocation() + "', schedule = '" 
                            + employee.getEmpSchedule() + "' WHERE supplierId = '" 
                            + employee.getEmpID() + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteEmployee(String id) {
        try {
            String query = "DELETE FROM employee WHERE Eid = '" + id + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            String query = "SELECT * FROM employee";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String role = rs.getString("role");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String status = rs.getString("status");
                String work = rs.getString("workLocation");
                String schedule = rs.getString("schedule");
                employees.add(new Employee(id, name, role, email, phone, address, status, work, schedule));
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return employees;
    }
    
    public Employee getEmployeeByID(String id) {
    	Employee employee = null;
        try {
            String query = "SELECT * FROM employee WHERE id = ?";
            
            ResultSet rs = con.executeQuery(query, id); 

            if (rs.next()) {
            	String name = rs.getString("name");
                String role = rs.getString("role");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String status = rs.getString("status");
                String work = rs.getString("workLocation");
                String schedule = rs.getString("schedule");
                employee = new Employee(id, name, role, email, phone, address, status, work, schedule);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return employee;
    }
}
