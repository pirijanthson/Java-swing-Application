package TechRepair;

import java.util.*;

public class Repairjob {
    private String JobID;
    private String OrderID;
    private String EmployeeID;
    private Date scheduledTime;

    Repairjob(String Jid, String Oid, String Eid, Date Stime){
        JobID = Jid;
        OrderID = Oid;
        EmployeeID = Eid;
        scheduledTime = Stime;
    }

    public String printRepairJob(){
        return "Job ID : "+JobID+"\nOrder ID : "+OrderID+"\nEmployee ID : "+EmployeeID+"\nJob Scduled Date : "+scheduledTime;
    }

    public String getJobID(){
        return JobID;
    }

    public String getJobOrderID(){
        return OrderID;
    }

    public String getJobEmpID(){
        return EmployeeID;
    }

    public Date getJobSchDate(){
        return scheduledTime;
    }

}