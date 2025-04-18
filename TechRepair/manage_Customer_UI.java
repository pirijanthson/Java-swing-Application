package TechRepair;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class manage_Customer_UI extends JFrame {

	private CustomerAction customerAction;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField OID_Input;
	private JTextField CID_Input;
	private JTextField Name_Input;
	private JTextField Email_Input;
	private JTextField Status_Input;
	private JTextField Parts_Input;
	private JTextField Total_Input;
	private JTextField Type_Input;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manage_Customer_UI frame = new manage_Customer_UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public manage_Customer_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setTitle("Manage Customer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 802);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Customers Orders Details");
		lblNewLabel.setBounds(184, 19, 543, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		initializeTable();
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(41, 408, 429, 267);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Order ID : ");
		lblNewLabel_1.setBounds(518, 410, 133, 20);
		contentPane.add(lblNewLabel_1);
		
		OID_Input = new JTextField();
		OID_Input.setBounds(661, 411, 191, 19);
		contentPane.add(OID_Input);
		OID_Input.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer ID : ");
		lblNewLabel_1_1.setBounds(518, 444, 133, 20);
		contentPane.add(lblNewLabel_1_1);
		
		CID_Input = new JTextField();
		CID_Input.setBounds(661, 445, 191, 19);
		CID_Input.setColumns(10);
		contentPane.add(CID_Input);
		
		JLabel lblNewLabel_1_2 = new JLabel("Customer Name : ");
		lblNewLabel_1_2.setBounds(518, 478, 133, 20);
		contentPane.add(lblNewLabel_1_2);
		
		Name_Input = new JTextField();
		Name_Input.setBounds(661, 479, 191, 19);
		Name_Input.setColumns(10);
		contentPane.add(Name_Input);
		
		JLabel lblNewLabel_1_3 = new JLabel("Customer Email : ");
		lblNewLabel_1_3.setBounds(518, 513, 133, 20);
		contentPane.add(lblNewLabel_1_3);
		
		Email_Input = new JTextField();
		Email_Input.setBounds(661, 514, 191, 19);
		Email_Input.setColumns(10);
		contentPane.add(Email_Input);
		
		JLabel lblNewLabel_1_4 = new JLabel("Order Type : ");
		lblNewLabel_1_4.setBounds(518, 554, 133, 20);
		contentPane.add(lblNewLabel_1_4);

		Type_Input = new JTextField();
		Type_Input.setBounds(661, 555, 191, 19);
		contentPane.add(Type_Input);
		Type_Input.setColumns(10);
		
		JLabel lblNewLabel_1_5 = new JLabel("Order Status : ");
		lblNewLabel_1_5.setBounds(518, 593, 133, 20);
		contentPane.add(lblNewLabel_1_5);
		
		Status_Input = new JTextField();
		Status_Input.setBounds(661, 594, 191, 19);
		Status_Input.setColumns(10);
		contentPane.add(Status_Input);
		
		JLabel lblNewLabel_1_6 = new JLabel("Required Parts : ");
		lblNewLabel_1_6.setBounds(518, 632, 133, 20);
		contentPane.add(lblNewLabel_1_6);
		
		Parts_Input = new JTextField();
		Parts_Input.setBounds(661, 633, 191, 19);
		Parts_Input.setColumns(10);
		contentPane.add(Parts_Input);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Total Amount : ");
		lblNewLabel_1_6_1.setBounds(518, 667, 133, 20);
		contentPane.add(lblNewLabel_1_6_1);
		
		Total_Input = new JTextField();
		Total_Input.setColumns(10);
		Total_Input.setBounds(661, 668, 191, 19);
		contentPane.add(Total_Input);
		
		Panel panel = new Panel();
		panel.setBounds(469, 355, 10, 10);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_UI home = new Home_UI();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 64, 0));
		btnNewButton.setBounds(41, 37, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Supplier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier_UI supplierFrame = new Supplier_UI();
				supplierFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setBounds(803, 37, 133, 21);
		contentPane.add(btnNewButton_1);
		
		JButton SaveBtn = new JButton("Save Changes");
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String oid = OID_Input.getText();
					String cid = CID_Input.getText();
					String name = Name_Input.getText();
					String email = Email_Input.getText();
					String type = Type_Input.getText();
					String status = Status_Input.getText();
					String parts = Parts_Input.getText();
					String totalString = Total_Input.getText();

		            if (oid.isEmpty() || cid.isEmpty() || name.isEmpty() || email.isEmpty() || type.isEmpty() || status.isEmpty() || parts.isEmpty() || totalString.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

			            double total;
			            try {
			                total = Double.parseDouble(totalString);
			            } catch (NumberFormatException nfe) {
			                JOptionPane.showMessageDialog(contentPane, "Total cost must be a valid number.");
			                return;
			            }
					
						Customer cus = new Customer(oid, cid, name, email, type, status, parts, total);
						
						boolean result = customerAction.updateCustomer(cus);
						
						if (result) {
		                    JOptionPane.showMessageDialog(contentPane, "Update Order Details to the database");
		                    loadSuppliers();
		                    clearInputFields();
		                    textArea.setText(cus.printDetails());
		                } else {
		                    JOptionPane.showMessageDialog(contentPane, "Error Update Order to database");
		                }
					}
					
				} catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		SaveBtn.setForeground(new Color(255, 255, 255));
		SaveBtn.setBackground(new Color(64, 128, 128));
		SaveBtn.setBounds(492, 722, 133, 21);
		contentPane.add(SaveBtn);
		
		JButton DelBtn = new JButton("Delete");
		DelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String id = OID_Input.getText();
		            int row = table.getSelectedRow();
		            if (row >= 0) {
		                boolean result = customerAction.deleteCustomer(id);
		                if (result) {
		                    JOptionPane.showMessageDialog(contentPane, "Deleted Customer Details from database");
		                    loadSuppliers();
		                    clearInputFields();
		                } else {
		                    JOptionPane.showMessageDialog(contentPane, "Error Deleting Customer from database");
		                }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		DelBtn.setForeground(new Color(255, 255, 255));
		DelBtn.setBackground(new Color(255, 0, 0));
		DelBtn.setBounds(690, 722, 85, 21);
		contentPane.add(DelBtn);
		
		JButton AddBtn = new JButton("Add Order");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String oid = OID_Input.getText();
		            String cid = CID_Input.getText();
		            String name = Name_Input.getText();
		            String email = Email_Input.getText();
		            String type = Type_Input.getText();
		            String status = Status_Input.getText();
		            String parts = Parts_Input.getText();
		            String totalString = Total_Input.getText();

		            if (oid.isEmpty() || cid.isEmpty() || name.isEmpty() || email.isEmpty() || type.isEmpty() || status.isEmpty() || parts.isEmpty() || totalString.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

			            double total;
			            try {
			                total = Double.parseDouble(totalString);
			            } catch (NumberFormatException nfe) {
			                JOptionPane.showMessageDialog(contentPane, "Total cost must be a valid number.");
			                return;
			            }
	
			            Customer cus = new Customer(oid, cid, name, email, type, status, parts, total);
			            boolean result = customerAction.addCustomer(cus);
	
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Added New Order Details to the database");
			                loadSuppliers();
			                clearInputFields();
			                textArea.setText(cus.printDetails());
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Adding Order to database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
				
			}
		});
		AddBtn.setForeground(new Color(255, 255, 255));
		AddBtn.setBackground(new Color(255, 128, 0));
		AddBtn.setBounds(832, 722, 124, 21);
		contentPane.add(AddBtn);
		
		JButton EditBtn = new JButton("Edit");
		EditBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = OID_Input.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Order ID to edit.");
		            return;
		        }

		        try {
		        	Customer customer = customerAction.getCustomerByID(id);

		            if (customer != null) {
		                OID_Input.setText(customer.getOrderId());
						CID_Input.setText(customer.getCustomerId());
						Name_Input.setText(customer.getName());
						Email_Input.setText(customer.getEmail());
						Type_Input.setText(customer.getOrderType());
						Status_Input.setText(customer.getOrderStatus());
						Parts_Input.setText(customer.getRequiredParts());
						Total_Input.setText(String.valueOf(customer.getTotalCost()));
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Customer with the given ID does not exist.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		EditBtn.setForeground(new Color(255, 255, 255));
		EditBtn.setBackground(new Color(0, 0, 255));
		EditBtn.setBounds(877, 408, 59, 21);
		contentPane.add(EditBtn);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputFields();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 64, 128));
		btnNewButton_2.setBounds(873, 667, 83, 21);
		contentPane.add(btnNewButton_2);
		
		JButton infobtn = new JButton("i");
		infobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Order Types \n1. repairs \n2. maintenance \n3. spare parts");
			}
		});
		infobtn.setForeground(new Color(255, 255, 255));
		infobtn.setBackground(new Color(255, 0, 128));
		infobtn.setBounds(871, 554, 27, 21);
		contentPane.add(infobtn);
		
		JButton infobtn_1 = new JButton("i");
		infobtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Order Status \n1. Processing \n2.Shipping \n3.Ready");
			}
		});
		infobtn_1.setForeground(Color.WHITE);
		infobtn_1.setBackground(new Color(255, 0, 128));
		infobtn_1.setBounds(871, 593, 27, 21);
		contentPane.add(infobtn_1);
		
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage_Customer_UI customerFrame = new manage_Customer_UI();
				customerFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(0, 0, 64));
		btnNewButton_3.setBounds(136, 37, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Sent Email");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Email_UI email = new Email_UI();
				email.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(255, 128, 64));
		btnNewButton_4.setBounds(676, 37, 117, 21);
		contentPane.add(btnNewButton_4);
		
		customerAction = new CustomerAction();
		
		loadSuppliers();
	}
	
	private void initializeTable() {
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "OrderID", "Customer ID", "Name", "Email", "Order Type ", "Order Status", "Req.Parts", "Total Cost"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(37, 71, 919, 327);
        contentPane.add(scrollPane);
    }
	
	private void loadSuppliers() {
        tableModel.setRowCount(0); // Clear existing rows
        List<Customer> Customers = customerAction.getAllCustomers();
        for (Customer Customer : Customers) {
            addRowToTable(Customer);
        }
    }

    private void addRowToTable(Customer customer) {
        tableModel.addRow(new Object[]{
        		customer.getOrderId(),
                customer.getCustomerId(),
                customer.getName(), 
                customer.getEmail(), 
                customer.getOrderType(),
                customer.getOrderStatus(),
                customer.getRequiredParts(),
                customer.getTotalCost()
        });
    }
	
	private void clearInputFields() {
		OID_Input.setText("");
		CID_Input.setText("");
		Name_Input.setText("");
		Email_Input.setText("");
		Type_Input.setText("");
		Status_Input.setText("");
		Parts_Input.setText("");
		Total_Input.setText("");
    }
}
