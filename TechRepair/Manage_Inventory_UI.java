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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Manage_Inventory_UI extends JFrame {

	private InventoryAction inventoryAction;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField Name_Input;
	private JTextField Quantity_Input;
	private JTextField SID_Input;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Inventory_UI frame = new Manage_Inventory_UI();
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
	public Manage_Inventory_UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setTitle("Manage Inventory ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initializeTable();
		
		JLabel lblNewLabel = new JLabel("Manage Inventory details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(234, 10, 409, 48);
		contentPane.add(lblNewLabel);
		
		JLabel Part_ID = new JLabel("Part ID : ");
		Part_ID.setBounds(411, 350, 112, 21);
		contentPane.add(Part_ID);
		
		textField = new JTextField();
		textField.setBounds(512, 352, 199, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel Part_Name = new JLabel("Part Name : ");
		Part_Name.setBounds(411, 395, 112, 21);
		contentPane.add(Part_Name);
		
		Name_Input = new JTextField();
		Name_Input.setBounds(512, 397, 199, 19);
		contentPane.add(Name_Input);
		Name_Input.setColumns(10);
		
		JLabel Quantity = new JLabel("Stock Quantity : ");
		Quantity.setBounds(412, 441, 111, 21);
		contentPane.add(Quantity);
		
		Quantity_Input = new JTextField();
		Quantity_Input.setBounds(512, 443, 199, 19);
		contentPane.add(Quantity_Input);
		Quantity_Input.setColumns(10);
		
		JLabel Suppllier_ID = new JLabel("Supplier ID : ");
		Suppllier_ID.setBounds(411, 485, 112, 21);
		contentPane.add(Suppllier_ID);
		
		SID_Input = new JTextField();
		SID_Input.setBounds(512, 487, 199, 19);
		contentPane.add(SID_Input);
		SID_Input.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 330, 303, 240);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(426, 299, 10, 10);
		contentPane.add(panel);
		
		JButton Savebtn = new JButton("Save Changes ");
		Savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pid = textField.getText();
					String name = Name_Input.getText();
					String quantity = Quantity_Input.getText();
					String sid = SID_Input.getText();

		            if (pid.isEmpty() || name.isEmpty() || quantity.isEmpty() || sid.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
					} else {

		            	Inventory invent = new Inventory (pid, name, quantity, sid);

			            boolean result = inventoryAction.updateInventory(invent);
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Updated Inventory Details in the database");
			                textArea.setText(invent.printInventory());
			                loadInventorys();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Updating Inventory in database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
				
			}
		});
		Savebtn.setForeground(new Color(255, 255, 255));
		Savebtn.setBackground(new Color(0, 0, 128));
		Savebtn.setBounds(400, 549, 139, 21);
		contentPane.add(Savebtn);
		
		JButton Addbtn = new JButton("Add Inventory");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                	String pid = textField.getText();
    				String name = Name_Input.getText();
    				String quantity = Quantity_Input.getText();
    				String sid = SID_Input.getText();
		            
		            if (pid.isEmpty() || name.isEmpty() || quantity.isEmpty() || sid.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

		            	Inventory inven = new Inventory (pid, name, quantity, sid);
	
			            boolean result = inventoryAction.addInventory(inven);
			            if (result) {
			            	JOptionPane.showMessageDialog(panel, "Added New Inventory Details to the database");
							
							textArea.setText(inven.printInventory());
							loadInventorys();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Adding Inventory to database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		Addbtn.setForeground(new Color(255, 255, 255));
		Addbtn.setBackground(new Color(128, 0, 0));
		Addbtn.setBounds(679, 549, 139, 21);
		contentPane.add(Addbtn);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
	            
	            if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Inventory ID to delete.");
		            return;
		        }
	            
				try {
		            int row = table.getSelectedRow();
		            if (row >= 0) {
		                boolean result = inventoryAction.deleteInventory(id);
		                if (result) {
		                    JOptionPane.showMessageDialog(contentPane, "Deleted Inventory Details from database");
		                    loadInventorys();
		                    clearInputFields();
		                } else {
		                    JOptionPane.showMessageDialog(contentPane, "Error Deleting Inventory from database");
		                }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(567, 549, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputFields();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 64, 128));
		btnNewButton_1.setBounds(727, 485, 71, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Inventory ID to edit.");
		            return;
		        }

		        try {
		        	Inventory inventory = inventoryAction.getInventoryByID(id);

		            if (inventory != null) {
		                textField.setText(inventory.getInventoryID());
		                Name_Input.setText(inventory.getPartName());
		                Quantity_Input.setText(inventory.getQuantity());
		                SID_Input.setText(inventory.getSupplierID());
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Inventory with the given ID does not exist.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 128, 0));
		btnNewButton_2.setBounds(727, 350, 71, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Supplier_UI supplierframe = new Supplier_UI();
				supplierframe.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(128, 0, 64));
		btnNewButton_3.setBounds(38, 30, 85, 21);
		contentPane.add(btnNewButton_3);
		
		inventoryAction = new InventoryAction();
		
		loadInventorys();
	}
	
	private void initializeTable() {
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Part ID", "Part Name", "Quantity", "Supplier ID" });
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(37, 73, 777, 236);
        contentPane.add(scrollPane);
    }
	
	private void loadInventorys() {
        tableModel.setRowCount(0);
        List<Inventory> inventorys = inventoryAction.getAllInventory();
        for (Inventory inventory : inventorys) {
            addRowToTable(inventory);
        }
    }

    private void addRowToTable(Inventory inventory ) {
        tableModel.addRow(new Object[]{
        	inventory.getInventoryID(),
        	inventory.getPartName(),
        	inventory.getQuantity(),
        	inventory.getSupplierID()
        });
    }

    private void clearInputFields() {
    	textField.setText("");
		Name_Input.setText("");
		Quantity_Input.setText("");
		SID_Input.setText("");
    }
}
