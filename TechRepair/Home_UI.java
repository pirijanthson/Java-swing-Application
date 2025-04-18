package TechRepair;

import java.awt.EventQueue;

import java.awt.Desktop;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_UI frame = new Home_UI();
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
	public Home_UI() {
		setTitle("TechRepair");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 676);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sajee\\Downloads\\OOP Project\\maintenance_564898.png"));
		lblNewLabel.setBounds(389, 34, 160, 180);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tech Repair");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(287, 184, 372, 74);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manage_Customer_UI customerFrame = new manage_Customer_UI();
				customerFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\sajee\\Downloads\\OOP Project\\user.png"));
		btnNewButton.setBounds(118, 296, 160, 164);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Manage Customer");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(92, 459, 220, 33);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage_Employee_UI employeeFrame = new Manage_Employee_UI();
				employeeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setSelectedIcon(null);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\sajee\\Downloads\\check (2).png"));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setBounds(399, 296, 160, 164);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Manage Employee");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(373, 459, 220, 33);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Allocate_Job_UI job = new Allocate_Job_UI();
				job.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\sajee\\Downloads\\shopping 128.png"));
		btnNewButton_2.setBackground(new Color(64, 128, 128));
		btnNewButton_2.setBounds(663, 296, 160, 164);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Manage Jobs");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(637, 459, 220, 33);
		contentPane.add(lblNewLabel_2_2);
		
		JButton btnNewButton_3 = new JButton("About US");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            URI uri = new URI("file:///C:/Users/sajee/Downloads/Web/aboutUS.html#team");
		            
		            if (Desktop.isDesktopSupported()) {
		                Desktop desktop = Desktop.getDesktop();
		                
		                if (desktop.isSupported(Desktop.Action.BROWSE)) {
		                    desktop.browse(uri);
		                }
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(255, 128, 0));
		btnNewButton_3.setBounds(373, 590, 139, 21);
		contentPane.add(btnNewButton_3);
	}
}
