package TechRepair;

import java.util.*;

public class Report {
    private String ReportID;
    private Date ReportDate;
    private String OrderID;
    private String OrderStatus;
    private String CustomerID;
    private String EmployeeID;
    private String RepairID;
    private String SupplierID;
    private List<String> OrderParts;

    Report(String Rid, Date Rdate, String Oid, String Ostatus, String Cid, String Eid, String Reid, String Sid, List<String> Oparts){
        ReportID = Rid;
        ReportDate = Rdate;
        OrderID = Oid;
        OrderStatus = Ostatus;
        CustomerID = Cid;
        EmployeeID = Eid;
        RepairID = Reid;
        SupplierID = Sid;
        OrderParts = Oparts;
    }

    public String PrintReport(){
        return "Report ID : "+ReportID+"\nReport Date : "+ReportDate+"\nOrder ID : "+OrderID+"\nCustomer ID : "+CustomerID+"\nEmployee ID : "+EmployeeID+"\nRepair Job ID : "+RepairID+"\nSupplier ID : "+SupplierID+"\nOrder Parts : "+OrderParts;
    }

    public String getReportID(){
        return ReportID;
    }

    public Date getReportDate(){
        return ReportDate;
    }

    public String getOrderID(){
        return OrderID;
    }

    public String getOrderStatus(){
        return OrderStatus;
    }

    public String getCustomerID(){
        return CustomerID;
    }
    
    public String getEmployeeID(){ 
        return EmployeeID;
    }

    public String getRepairID(){
        return RepairID;
    }

    public String getSupplierID(){
        return SupplierID;
    }

    public List<String> getOrderParts(){
        return OrderParts;
    }
}