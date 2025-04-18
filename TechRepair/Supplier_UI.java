package TechRepair;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Supplier_UI extends JFrame {

	private SupplierAction supplierAction;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField ID_Input;
	private JTextField Name_Input;
	private JTextField Contact_Input;
	private JTextField Parts_Input;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier_UI frame = new Supplier_UI();
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
	public Supplier_UI() {
		setTitle("Manage Supplier");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Supplier Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(307, 0, 389, 69);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage_Customer_UI customerFrame = new manage_Customer_UI();
				customerFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 64, 64));
		btnNewButton.setBounds(54, 30, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Inventory");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Inventory_UI InventryFrame = new Manage_Inventory_UI();
				InventryFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(64, 0, 128));
		btnNewButton_1.setBounds(791, 30, 143, 21);
		contentPane.add(btnNewButton_1);
		
		initializeTable();
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(37, 439, 418, 274);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("Supplier ID : ");
		lblNewLabel_1.setBounds(523, 455, 125, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Supplier Name : ");
		lblNewLabel_1_1.setBounds(523, 496, 125, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contact Details : ");
		lblNewLabel_1_2.setBounds(523, 540, 125, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Supplied Parts : ");
		lblNewLabel_1_3.setBounds(523, 582, 125, 21);
		contentPane.add(lblNewLabel_1_3);
		
		ID_Input = new JTextField();
		ID_Input.setBounds(626, 456, 189, 19);
		contentPane.add(ID_Input);
		ID_Input.setColumns(10);
		
		Name_Input = new JTextField();
		Name_Input.setColumns(10);
		Name_Input.setBounds(626, 497, 189, 19);
		contentPane.add(Name_Input);
		
		Contact_Input = new JTextField();
		Contact_Input.setColumns(10);
		Contact_Input.setBounds(626, 541, 189, 19);
		contentPane.add(Contact_Input);
		
		Parts_Input = new JTextField();
		Parts_Input.setColumns(10);
		Parts_Input.setBounds(626, 583, 189, 19);
		contentPane.add(Parts_Input);
		
		Panel panel = new Panel();
		panel.setBounds(478, 419, 10, 10);
		contentPane.add(panel);
		
		JButton EditBtn = new JButton("Edit");
		EditBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = ID_Input.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Supplier ID to edit.");
		            return;
		        }

		        try {
		            Supplier supplier = supplierAction.getSupplierByID(id);

		            if (supplier != null) {
		                ID_Input.setText(supplier.getSupplierID());
		                Name_Input.setText(supplier.getSupplierName());
		                Contact_Input.setText(supplier.getSupplierContactNumber());
		                Parts_Input.setText(supplier.getSupplierProvidedParts());
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Supplier with the given ID does not exist.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		EditBtn.setForeground(new Color(255, 255, 255));
		EditBtn.setBackground(new Color(0, 0, 255));
		EditBtn.setBounds(849, 455, 85, 21);
		contentPane.add(EditBtn);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputFields();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 128, 0));
		btnNewButton_2.setBounds(849, 582, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton SaveBtn = new JButton("Save Changes");
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String id = ID_Input.getText();
		            String name = Name_Input.getText();
		            String contact = Contact_Input.getText();
		            String parts = Parts_Input.getText();

		            if (id.isEmpty() || name.isEmpty() || contact.isEmpty() || parts.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

		            	Supplier supp = new Supplier(id, name, contact, parts);

			            boolean result = supplierAction.updateSupplier(supp);
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Updated Supplier Details in the database");
			                loadSuppliers();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Updating Supplier in database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }

			}
		});
		SaveBtn.setForeground(new Color(0, 0, 0));
		SaveBtn.setBackground(new Color(255, 128, 128));
		SaveBtn.setBounds(523, 651, 151, 21);
		contentPane.add(SaveBtn);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = ID_Input.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Supplier ID to Delete.");
		            return;
		        }
				try {
		            boolean result = supplierAction.deleteSupplier(id);
		                if (result) {
		                    JOptionPane.showMessageDialog(contentPane, "Deleted Supplier Details from database");
		                    clearInputFields();
		                } else {
		                    JOptionPane.showMessageDialog(contentPane, "Error Deleting Supplier from database");
		                }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setBounds(705, 651, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JButton addBtn = new JButton("Add Supplier");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String id = ID_Input.getText();
		            String name = Name_Input.getText();
		            String contact = Contact_Input.getText();
		            String parts = Parts_Input.getText();
		            
		            if (id.isEmpty() || name.isEmpty() || contact.isEmpty() || parts.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

			            Supplier supp = new Supplier(id, name, contact, parts);
	
			            boolean result = supplierAction.addSupplier(supp);
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Added New Supplier Details to the database");
			                loadSuppliers();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Adding Supplier to database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setBackground(new Color(0, 128, 0));
		addBtn.setBounds(820, 651, 114, 21);
		contentPane.add(addBtn);
		
		supplierAction = new SupplierAction();
		
		loadSuppliers();
	}
	
	private void initializeTable() {
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Supplier ID", "Supplier Name", "Contact Details", "Supplied Parts" });
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(37, 73, 919, 327);
        contentPane.add(scrollPane);
    }
	
	private void loadSuppliers() {
        tableModel.setRowCount(0); // Clear existing rows
        List<Supplier> suppliers = supplierAction.getAllSuppliers();
        for (Supplier supplier : suppliers) {
            addRowToTable(supplier);
        }
    }

    private void addRowToTable(Supplier supplier) {
        tableModel.addRow(new Object[]{
            supplier.getSupplierID(),
            supplier.getSupplierName(),
            supplier.getSupplierContactNumber(),
            supplier.getSupplierProvidedParts()
        });
    }

    private void clearInputFields() {
        ID_Input.setText("");
        Name_Input.setText("");
        Contact_Input.setText("");
        Parts_Input.setText("");
    }

    
}
