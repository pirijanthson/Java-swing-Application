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
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Manage_Employee_UI extends JFrame {

	private EmployeeAction employeeAction;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField id_input;
	private JTextField name_input;
	private JTextField role_input;
	private JTextField email_input;
	private JTextField phone_input;
	private JLabel address_tag;
	private JTextField address_input;
	private JLabel status_tag;
	private JTextField status_input;
	private JButton save_btn;
	private JButton add_btn;
	private JButton delete_btn;
	private JTextField work_input;
	private JTextField time_input;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manage_Employee_UI frame = new Manage_Employee_UI();
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
	public Manage_Employee_UI() {
		setTitle("Manage Employee");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 795);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Employee Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(277, 1, 393, 55);
		contentPane.add(lblNewLabel);
		
		initializeTable();
		
		JLabel id_tag = new JLabel("Employee ID : ");
		id_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		id_tag.setToolTipText("Em00");
		id_tag.setBounds(421, 368, 200, 19);
		contentPane.add(id_tag);
		
		id_input = new JTextField();
		id_input.setBounds(596, 368, 223, 19);
		contentPane.add(id_input);
		id_input.setColumns(10);
		
		JLabel name_tag = new JLabel("Employee name : ");
		name_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		name_tag.setBounds(421, 401, 200, 19);
		contentPane.add(name_tag);
		
		name_input = new JTextField();
		name_input.setBounds(596, 401, 223, 19);
		contentPane.add(name_input);
		name_input.setColumns(10);
		
		JLabel role_tag = new JLabel("Employee role : ");
		role_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		role_tag.setBounds(421, 435, 200, 19);
		contentPane.add(role_tag);
		
		role_input = new JTextField();
		role_input.setBounds(596, 435, 223, 19);
		contentPane.add(role_input);
		role_input.setColumns(10);
		
		JLabel email_tag = new JLabel("Employee Email : ");
		email_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email_tag.setBounds(421, 468, 200, 19);
		contentPane.add(email_tag);
		
		email_input = new JTextField();
		email_input.setBounds(596, 468, 223, 19);
		contentPane.add(email_input);
		email_input.setColumns(10);
		
		JLabel phone_tag = new JLabel("Employee Phone : ");
		phone_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phone_tag.setBounds(421, 497, 200, 19);
		contentPane.add(phone_tag);
		
		phone_input = new JTextField();
		phone_input.setBounds(596, 497, 223, 19);
		contentPane.add(phone_input);
		phone_input.setColumns(10);
		
		address_tag = new JLabel("Employee Address : ");
		address_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		address_tag.setBounds(421, 526, 200, 19);
		contentPane.add(address_tag);
		
		address_input = new JTextField();
		address_input.setBounds(596, 526, 223, 19);
		contentPane.add(address_input);
		address_input.setColumns(10);
		
		status_tag = new JLabel("Employee Status : ");
		status_tag.setFont(new Font("Tahoma", Font.PLAIN, 12));
		status_tag.setBounds(421, 555, 200, 19);
		contentPane.add(status_tag);
		
		status_input = new JTextField();
		status_input.setBounds(596, 555, 223, 19);
		contentPane.add(status_input);
		status_input.setColumns(10);

		JLabel address_tag_1 = new JLabel("Employee Work Location : ");
		address_tag_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		address_tag_1.setBounds(421, 584, 200, 19);
		contentPane.add(address_tag_1);
		
		work_input = new JTextField();
		work_input.setColumns(10);
		work_input.setBounds(596, 584, 223, 19);
		contentPane.add(work_input);
		
		JLabel status_tag_1 = new JLabel("Employee Work schedule : ");
		status_tag_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		status_tag_1.setBounds(421, 613, 200, 19);
		contentPane.add(status_tag_1);
		
		time_input = new JTextField();
		time_input.setColumns(10);
		time_input.setBounds(596, 613, 223, 19);
		contentPane.add(time_input);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(26, 340, 348, 265);
		contentPane.add(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(448, 307, 10, 10);
		contentPane.add(panel);
		
		save_btn = new JButton("Save changes");
		save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = id_input.getText();
					String name = name_input.getText();
					String role = role_input.getText();
					String email = email_input.getText();
					String phone = phone_input.getText();
					String address = address_input.getText();
					String status = status_input.getText();
					String work = work_input.getText();
					String time = time_input.getText();

		            if (id.isEmpty() || name.isEmpty() || role.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || status.isEmpty() || work.isEmpty() || time.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

		            	Employee empl = new Employee(id, name, role, email, phone, address, status, work, time);

			            boolean result = employeeAction.updateEmployee(empl);
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Updated Employee Details in the database");
			                textArea.setText(empl.printEmp());
			                loadEmployees();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Updating Employee in database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
				
				
			}
		});
		save_btn.setForeground(new Color(255, 255, 255));
		save_btn.setBackground(new Color(0, 0, 160));
		save_btn.setBounds(435, 695, 150, 21);
		contentPane.add(save_btn);
		
		add_btn = new JButton("Add Employee");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = id_input.getText();
					String name = name_input.getText();
					String role = role_input.getText();
					String email = email_input.getText();
					String phone = phone_input.getText();
					String address = address_input.getText();
					String status = status_input.getText();
					String work = work_input.getText();
					String time = time_input.getText();

		            if (id.isEmpty() || name.isEmpty() || role.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || status.isEmpty() || work.isEmpty() || time.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

		            	Employee empl = new Employee(id, name, role, email, phone, address, status, work, time);

			            boolean result = employeeAction.addEmployee(empl);
			            if (result) {
			            	JOptionPane.showMessageDialog(panel, "Added New Employee Details to the database");
							loadEmployees();
			                clearInputFields();
			                textArea.setText(empl.printEmp());
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Adding Employee to database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }

				
				
			}
		});
		add_btn.setForeground(new Color(255, 255, 255));
		add_btn.setBackground(new Color(128, 0, 128));
		add_btn.setBounds(698, 695, 121, 21);
		contentPane.add(add_btn);
		
		delete_btn = new JButton("Delete");
		delete_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = id_input.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Employee ID to Delete.");
		            return;
		        }
				try {
		            boolean result = employeeAction.deleteEmployee(id);
		            if (result) {
		                JOptionPane.showMessageDialog(contentPane, "Deleted Employee Details from database");
		                clearInputFields();
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Error Deleting Employee from database");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		delete_btn.setForeground(new Color(255, 255, 255));
		delete_btn.setBackground(new Color(255, 0, 0));
		delete_btn.setBounds(603, 695, 85, 21);
		contentPane.add(delete_btn);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_UI home = new Home_UI();
				home.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(64, 0, 128));
		btnNewButton.setBounds(26, 24, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sent Email");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Email_UI email = new Email_UI();
				email.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 0, 64));
		btnNewButton_1.setBounds(753, 24, 141, 21);
		contentPane.add(btnNewButton_1);
		
		
		JButton statusbtn = new JButton("i");
		statusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Employee Status \n1. Active \n2. On Leave \n3. Part-Time \n4. Full-Time \n5. Retired \n6. Terminated \n7. Probationary");
			}
		});
		statusbtn.setForeground(new Color(255, 255, 255));
		statusbtn.setBackground(new Color(255, 0, 128));
		statusbtn.setBounds(829, 554, 26, 21);
		contentPane.add(statusbtn);
		
		JButton rolebtn = new JButton("i");
		rolebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Employee Role \nOffice Roles \n1. Customer Service Representative \n2. Administrative Assistant \n3. Office Manager \n4. Parts Specialist"
						+ "\n\nField Roles \n1. Field Technician \n2. Repair Technician \n3. Maintenance Specialist \n4. Delivery Coordinator");
			}
		});
		rolebtn.setForeground(Color.WHITE);
		rolebtn.setBackground(new Color(255, 0, 128));
		rolebtn.setBounds(829, 434, 26, 21);
		contentPane.add(rolebtn);
		
		JButton workbtn = new JButton("i");
		workbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Employee Work Location \n1. Office \n2. Field \n3. Hybrid");
			}
		});
		workbtn.setForeground(Color.WHITE);
		workbtn.setBackground(new Color(255, 0, 128));
		workbtn.setBounds(829, 584, 26, 21);
		contentPane.add(workbtn);
		
		JButton timebtn = new JButton("i");
		timebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Employee Time Schedule \n1. 9 AM - 5 PM \n2. 8 AM - 4 PM  \n3. Shift A (8 AM - 4 PM) \n4. Shift B (4 PM - 12 AM) \n5. Flexible");
			}
		});
		timebtn.setForeground(Color.WHITE);
		timebtn.setBackground(new Color(255, 0, 128));
		timebtn.setBounds(829, 612, 26, 21);
		contentPane.add(timebtn);
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id =id_input.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Employee ID to edit.");
		            return;
		        }

		        try {
		            Employee employee = employeeAction.getEmployeeByID(id);

		            if (employee != null) {
		            	id_input.setText(employee.getEmpID());
						name_input.setText(employee.getEmpName());
						role_input.setText(employee.getEmpRole());
						email_input.setText(employee.getEmpEmail());
						phone_input.setText(employee.getEmpPhone());
						address_input.setText(employee.getEmpAddress());
						status_input.setText(employee.getEmpStatus());
						work_input.setText(employee.getEmpWorklocation());
						time_input.setText(employee.getEmpSchedule());
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Employee with the given ID does not exist.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 255));
		btnNewButton_2.setBounds(828, 367, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputFields();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(64, 128, 128));
		btnNewButton_3.setBounds(734, 649, 85, 21);
		contentPane.add(btnNewButton_3);
		
		employeeAction = new EmployeeAction();
		
		loadEmployees();
	}
	
	private void initializeTable() {
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "ID", "Name", "Role", "Email", "Phone", "Address", "Status", "Work Location", "Schedule"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(26, 51, 857, 279);
        contentPane.add(scrollPane);
    }
	
	private void loadEmployees() {
        tableModel.setRowCount(0);
        List<Employee> employees = employeeAction.getAllEmployees();
        for (Employee employee : employees) {
            addRowToTable(employee);
        }
    }

    private void addRowToTable(Employee employee) {
        tableModel.addRow(new Object[]{
        		employee.getEmpID(), 
                employee.getEmpName(),
                employee.getEmpRole(),
                employee.getEmpEmail(), 
                employee.getEmpPhone() ,
                employee.getEmpAddress(), 
                employee.getEmpStatus(),
                employee.getEmpWorklocation(), 
                employee.getEmpSchedule()
        });
    }

    private void clearInputFields() {
    	id_input.setText("");
		name_input.setText("");
		role_input.setText("");
		email_input.setText("");
		phone_input.setText("");
		address_input.setText("");
		status_input.setText("");
		work_input.setText("");
		time_input.setText("");
    }
}
