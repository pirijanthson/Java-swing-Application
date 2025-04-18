package TechRepair;

public class Order {
	private String ID; 
	private String CustomerID;
	private String EmployeeID;
	private String OrderType;
	private String Status;
	private String requiredParts;
	
	Order(String id, String Custid, String empid, String ordertype, String status, String parts){
		ID = id;
		CustomerID = Custid;
		EmployeeID = empid;
		OrderType = ordertype;
		Status = status;
		requiredParts = parts;
	}
	
	public String printOrderDetails() {
		return "Order id : "+ID+"\nCustomer id : "+CustomerID+"\nOrder Type : "+OrderType+"\nOrder Status : "+Status+"\nOrder required parts : "+requiredParts;
	}
	
	public String getID(){
		return EmployeeID;
	}
	
	public String getCustomerID(){
		return CustomerID;
	}

	public String getOrderType(){
		return OrderType;
	}

	public String getStatus(){
		return Status;
	}

	public String getRequiredParts(){
		return requiredParts;
	}
	
}
