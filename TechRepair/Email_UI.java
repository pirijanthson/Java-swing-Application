package TechRepair;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Email_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EmailInput;
	private JTextField NameInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email_UI frame = new Email_UI();
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
	public Email_UI() {
		setTitle("Sent Notification ");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 812);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sent Notifications ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(243, 26, 432, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(62, 108, 159, 23);
		contentPane.add(lblNewLabel_1);
		
		EmailInput = new JTextField();
		EmailInput.setBounds(60, 132, 374, 29);
		contentPane.add(EmailInput);
		EmailInput.setColumns(10);

		NameInput = new JTextField();
		NameInput.setColumns(10);
		NameInput.setBounds(60, 207, 374, 29);
		contentPane.add(NameInput);
		

		JTextArea Message = new JTextArea();
		Message.setBounds(62, 377, 372, 388);
		contentPane.add(Message);

		Panel panel = new Panel();
		panel.setBounds(443, 308, 10, 10);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1_3 = new JLabel("Name");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(62, 183, 159, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Type");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(62, 262, 159, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JButton CustomerBtn = new JButton("Message for Customer");
		CustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = NameInput.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Please fill the Name field.");
                    return;
                }
                Message.setText(String.format(
                    "Subject: Update on Your Recent TechRepair Order\n"
                    + "Hi %s,\n\n"
                    + "I hope this message finds you well.\n\n"
                    + "We wanted to inform you that we have received your recent order with TechRepair and are in the process of handling it. Here’s a brief update on your order:\n\n"
                    + "Order Details:\n"
                    + "Service Requested: Spare Parts\n"
                    + "Estimated Completion Date: 20/09/2024\n"
                    + "Our team is currently reviewing the specifics of your request, and if any additional parts need to be sourced or if there are any updates to the timeline, we will let you know promptly.\n\n"
                    + "If you have any questions or require further assistance, please do not hesitate to reach out to us at Sajeepan634@gmail.com\n\n"
                    + "Thank you for choosing TechRepair. We look forward to providing you with the best service possible.\n\n"
                    + "Best regards,\n"
                    + "TechRepair\n",
                    name
                ));
			}
		});
		CustomerBtn.setForeground(new Color(255, 255, 255));
		CustomerBtn.setBackground(new Color(0, 0, 160));
		CustomerBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		CustomerBtn.setBounds(62, 295, 181, 23);
		contentPane.add(CustomerBtn);
		
		JButton EmployeeBtn = new JButton("Message for Employee");
		EmployeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = NameInput.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Please fill the Name field.");
                    return;
                }
                Message.setText(String.format(
                    "Subject: New Task Assignment and Schedule Update\n"
                    + "Hi %s,\n\n"
                    + "I hope you’re doing well.\n\n"
                    + "We have a new task assignment for you as part of our ongoing efforts to streamline our operations at TechRepair. Here are the details:\n\n"
                    + "Task: Repair System\n"
                    + "Due Date: 12/09/2024\n"
                    + "Details: Change RAM, Processor\n"
                    + "Schedule Update: Please review your schedule for the upcoming week. We have made some adjustments to accommodate this new task. You can view your updated schedule in our system or reach out to the HR team if you need any clarifications.\n\n"
                    + "If you have any questions or if there are any conflicts with your current assignments, please let us know as soon as possible. Your timely feedback and cooperation are crucial for ensuring that our projects are completed efficiently.\n\n"
                    + "Thank you for your continued hard work and dedication.\n\n"
                    + "Best regards,\n"
                    + "TechRepair\n",
                    name
                ));
			}
		});
		EmployeeBtn.setForeground(Color.WHITE);
		EmployeeBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		EmployeeBtn.setBackground(new Color(255, 0, 128));
		EmployeeBtn.setBounds(253, 295, 181, 23);
		contentPane.add(EmployeeBtn);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Message");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(62, 344, 159, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		
		JButton btnNewButton = new JButton("Sent");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = EmailInput.getText();
		        String message = Message.getText();
		        if (email.isEmpty() || message.isEmpty()) {
		            JOptionPane.showMessageDialog(contentPane, "Please fill all the fields.");
		            return;
		        }
		        try {
		            String subject = URLEncoder.encode("Update+on+Your+Recent+TechRepair+Order", StandardCharsets.UTF_8.toString());
		            String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());

		            encodedMessage = encodedMessage.replace("+", "%20");

		            URI mailto = new URI(String.format(
		                "mailto:%s?subject=%s&body=%s",
		                email,
		                subject,
		                encodedMessage
		            ));

		            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
		                Desktop.getDesktop().mail(mailto);
		            } else {
		                System.out.println("Mail client is not supported.");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(745, 581, 111, 29);
		contentPane.add(btnNewButton);
		
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailInput.setText("");
				NameInput.setText("");
				Message.setText("");
			}
		});
		clearbtn.setForeground(new Color(255, 255, 255));
		clearbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearbtn.setBackground(new Color(0, 0, 160));
		clearbtn.setBounds(491, 581, 129, 29);
		contentPane.add(clearbtn);
		
		JButton BackCusbtn = new JButton("Back to Customer");
		BackCusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage_Customer_UI cusfr = new manage_Customer_UI();
				cusfr.setVisible(true);
				dispose();
			}
		});
		BackCusbtn.setForeground(new Color(255, 255, 255));
		BackCusbtn.setBackground(new Color(128, 0, 64));
		BackCusbtn.setBounds(48, 51, 185, 29);
		contentPane.add(BackCusbtn);
		
		JButton BackEmpbtn = new JButton("Back to Employee");
		BackEmpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Employee_UI empfr = new Manage_Employee_UI();
				empfr.setVisible(true);
				dispose();
			}
		});
		BackEmpbtn.setForeground(Color.WHITE);
		BackEmpbtn.setBackground(new Color(128, 0, 64));
		BackEmpbtn.setBounds(655, 51, 185, 29);
		contentPane.add(BackEmpbtn);
		
	}
}
