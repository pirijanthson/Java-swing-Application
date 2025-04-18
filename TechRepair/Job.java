package TechRepair;

public class Job {
	private String JobID;
	private String OrderID;
	private String EmpID;
	
	Job(String jid, String oid, String eid){
		JobID = jid;
		OrderID = oid;
		EmpID = eid;
	}
	
	public String printInventory(){
        return "Job ID : " + JobID + "\nOrder ID : " + OrderID + "\nEmployee ID : " + EmpID;
    }

    public String getJobID(){
        return JobID;
    }

    public String getOrderID(){
        return OrderID;
    }

    public String getEmployeeID(){
        return EmpID;
    }
}
