package TechRepair;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Allocate_Job_UI extends JFrame {

	private JobAction jobAction;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField JobInput;
	private JTextField OrderInput;
	private JTextField EmpInput;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allocate_Job_UI frame = new Allocate_Job_UI();
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
	public Allocate_Job_UI() {
		setTitle("Allocate Job");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Allocate Employees to Customer Order Jobs");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 15, 598, 50);
		contentPane.add(lblNewLabel);
		
		JButton BackBtn = new JButton("Back");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_UI home = new Home_UI();
				home.setVisible(true);
				dispose();
			}
		});
		BackBtn.setForeground(new Color(255, 255, 255));
		BackBtn.setBackground(new Color(255, 128, 0));
		BackBtn.setBounds(40, 36, 85, 21);
		contentPane.add(BackBtn);
		
		JButton empbtn = new JButton("View Employee");
		empbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Employee_UI emp = new Manage_Employee_UI();
				emp.setVisible(true);
				dispose();
			}
		});
		empbtn.setForeground(new Color(255, 255, 255));
		empbtn.setBackground(new Color(0, 64, 128));
		empbtn.setBounds(779, 36, 120, 21);
		contentPane.add(empbtn);
		
		initializeTable();
		
		JLabel lblNewLabel_1 = new JLabel("Job ID : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(531, 360, 110, 21);
		contentPane.add(lblNewLabel_1);
		
		JobInput = new JTextField();
		JobInput.setBounds(625, 362, 144, 19);
		contentPane.add(JobInput);
		JobInput.setColumns(10);
		
		OrderInput = new JTextField();
		OrderInput.setColumns(10);
		OrderInput.setBounds(625, 405, 144, 19);
		contentPane.add(OrderInput);
		
		JLabel lblNewLabel_1_1 = new JLabel("Order ID : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(531, 403, 110, 21);
		contentPane.add(lblNewLabel_1_1);
		
		EmpInput = new JTextField();
		EmpInput.setColumns(10);
		EmpInput.setBounds(625, 447, 144, 19);
		contentPane.add(EmpInput);
		
		JLabel lblNewLabel_1_2 = new JLabel("Employee ID : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(531, 445, 110, 21);
		contentPane.add(lblNewLabel_1_2);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(35, 359, 434, 227);
		contentPane.add(textArea);
		
		Panel panel = new Panel();
		panel.setBounds(472, 302, 10, 10);
		contentPane.add(panel);
		
		JButton Editbtn = new JButton("Edit");
		Editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JobInput.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Job ID to edit.");
		            return;
		        }

		        try {
		            Job job = jobAction.getJobByID(id);

		            if (job != null) {
		                JobInput.setText(job.getJobID());
		                OrderInput.setText(job.getOrderID());
		                EmpInput.setText(job.getEmployeeID());
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Job with the given ID does not exist.");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		Editbtn.setForeground(new Color(255, 255, 255));
		Editbtn.setBackground(new Color(0, 0, 255));
		Editbtn.setBounds(779, 361, 59, 21);
		contentPane.add(Editbtn);
		
		JButton savebtn = new JButton("Save Changes ");
		savebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String jid = JobInput.getText();
		            String oid = OrderInput.getText();
		            String eid = EmpInput.getText();

		            if (jid.isEmpty() || oid.isEmpty() || eid.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

		            	Job job1 = new Job(jid, oid,eid);

			            boolean result = jobAction.updateJob(job1);
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Updated Job Details in the database");
			                loadJobs();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Updating Job in database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		savebtn.setForeground(new Color(255, 255, 255));
		savebtn.setBackground(new Color(128, 0, 128));
		savebtn.setBounds(531, 532, 128, 21);
		contentPane.add(savebtn);
		
		JButton deletebtn = new JButton("Delete");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JobInput.getText();
				
				if (id.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please enter a Job ID to Delete.");
		            return;
		        }
				try {
		            boolean result = jobAction.deleteJob(id);
		            if (result) {
		                JOptionPane.showMessageDialog(contentPane, "Deleted Job Details from database");
		                clearInputFields();
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Error Deleting Job from database");
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		deletebtn.setForeground(new Color(255, 255, 255));
		deletebtn.setBackground(new Color(255, 0, 0));
		deletebtn.setBounds(669, 532, 85, 21);
		contentPane.add(deletebtn);
		
		JButton addbtn = new JButton("Add Job");
		addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String jid = JobInput.getText();
		            String oid = OrderInput.getText();
		            String eid = EmpInput.getText();

		            if (jid.isEmpty() || oid.isEmpty() || eid.isEmpty()) {
		                JOptionPane.showMessageDialog(contentPane, "Please fill in all the fields.");
		                return;
		            } else {

		            	Job job1 = new Job(jid, oid,eid);
	
			            boolean result = jobAction.addJob(job1);
			            if (result) {
			                JOptionPane.showMessageDialog(contentPane, "Added New Job Details to the database");
			                loadJobs();
			                clearInputFields();
			            } else {
			                JOptionPane.showMessageDialog(contentPane, "Error Adding Job to database");
			            }
		            }
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(contentPane, "An error occurred: " + ex.getMessage());
		        }
			}
		});
		addbtn.setForeground(new Color(255, 255, 255));
		addbtn.setBackground(new Color(0, 128, 255));
		addbtn.setBounds(764, 532, 85, 21);
		contentPane.add(addbtn);
		
		JButton clearbtn = new JButton("Reset");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearInputFields();
			}
		});
		clearbtn.setForeground(new Color(255, 255, 255));
		clearbtn.setBackground(new Color(128, 0, 0));
		clearbtn.setBounds(764, 482, 85, 21);
		contentPane.add(clearbtn);
		
		jobAction = new JobAction();
		
		loadJobs();
	}
	
	private void initializeTable() {
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Job ID", "Order ID", "Supplier UI"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(37, 73, 869, 256);
        contentPane.add(scrollPane);
    }
	
	private void loadJobs() {
        tableModel.setRowCount(0); // Clear existing rows
        List<Job> jobs = jobAction.getAllJobs();
        for (Job job : jobs) {
            addRowToTable(job);
        }
    }

    private void addRowToTable(Job job) {
        tableModel.addRow(new Object[]{
        		job.getJobID(), 
                job.getOrderID(),
                job.getEmployeeID()
        });
    }

    private void clearInputFields() {
        JobInput.setText("");
        OrderInput.setText("");
        EmpInput.setText("");
    }

}
