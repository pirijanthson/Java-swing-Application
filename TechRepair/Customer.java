package TechRepair;

public class Customer {
	private String orderId;
    private String customerId;
    private String Name;
    private String Email;
    private String orderType;
    private String orderStatus;
    private String requiredParts;
    private double totalCost;
	
	Customer(String oid, String cid, String name, String email, String type, String status,  String parts, double total){
		orderId = oid;
		customerId = cid;
	    Name = name;
	    Email = email;
	    orderType = type;
	    orderStatus = status;
	    requiredParts = parts;
	    totalCost = total;
	}
	
	public String printDetails() {
		return "Order ID : "+orderId+"\nCustomer ID : "+customerId+"\nCustomer Name : "+Name+"\nCustomer email : "+Email+"\nOrder Type : "+orderType+"\nCustomer Order Status : "+orderStatus+"\nRequired Parts : "+requiredParts+ "\nTotal cost : "+totalCost;
	}
	
	public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

	public String getName() {
		return Name;
	}
	
	public String getEmail() {
		return Email;
	}
	
    public String getOrderType() {
        return orderType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getRequiredParts() {
        return requiredParts;
    }

    public double getTotalCost() {
        return totalCost;
    }

}