package TechRepair;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JobAction {
	private DatabaseConnection con;

    public JobAction() {
        con = DatabaseConnection.getSingleConnection();
    }

    public boolean addJob(Job job) {
        try {
            String query = "INSERT INTO job (jid, oid, eid) VALUES ('" 
                            + job.getJobID() + "', '" 
                            + job.getOrderID() + "', '" 
                            + job.getEmployeeID() + "')";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean updateJob(Job job) {
        try {
            String query = "UPDATE job SET oid = '" 
                            + job.getOrderID() + "', eid = '" 
                            + job.getEmployeeID() + "' WHERE jid = '" 
                            + job.getJobID() + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }

    public boolean deleteJob(String id) {
        try {
            String query = "DELETE FROM job WHERE jid = '" 
                            + id + "'";
            return con.execute(query);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            return false;
        }
    }
    
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        try {
            String query = "SELECT * FROM job";
            ResultSet rs = con.executeQuery(query);
            while (rs.next()) {
                String jid = rs.getString("jid");
                String oid = rs.getString("oid");
                String eid = rs.getString("eid");
                jobs.add(new Job(jid,oid,eid));
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return jobs;
    }
    
    public Job getJobByID(String id) {
        Job job = null;
        try {
            String query = "SELECT * FROM job WHERE jid = ?";
            
            ResultSet rs = con.executeQuery(query, id); 

            if (rs.next()) {
                String oid = rs.getString("oid");
                String eid = rs.getString("eid");
                job = new Job(id, oid, eid);
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return job;
    }
}