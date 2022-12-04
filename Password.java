import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Image;

public class Password {

	private JFrame frmRmTechnologies;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password window = new Password();
					window.frmRmTechnologies.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Password() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRmTechnologies = new JFrame();
		frmRmTechnologies.setBackground(new Color(64, 0, 64));
		frmRmTechnologies.setForeground(new Color(255, 255, 255));
		frmRmTechnologies.setTitle("RM Technologies");
		frmRmTechnologies.getContentPane().setBackground(new Color(255, 255, 128));
		frmRmTechnologies.setBounds(100, 100, 587, 391);
		frmRmTechnologies.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRmTechnologies.getContentPane().setLayout(null);
		
		JLabel label = new JLabel(); //JLabel Creation
        label.setIcon(new ImageIcon("sru.png"));
		Image img = new ImageIcon(this.getClass().getResource("/sru.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(141, 34, 300, 100);
		frmRmTechnologies.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("Enter the password to check its strength :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(118, 142, 336, 20);
		frmRmTechnologies.getContentPane().add(lblNewLabel);
		
		JLabel result = new JLabel("");
		result.setBounds(188, 278, 154, 14);
		frmRmTechnologies.getContentPane().add(result);
		
		JLabel suggestion = new JLabel("");
		suggestion.setBounds(198, 303, 144, 14);
		frmRmTechnologies.getContentPane().add(suggestion);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(253, 222, 89, 23);
		frmRmTechnologies.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String password = textField.getText();
				    if(password.matches("(\\s)*")){
				        result.setText("EMPTY SPACES");
				        result.setForeground(Color.red);
				        suggestion.setText("");
				    }
				    else if(password.matches("(.)*(\\s)+(.)*")){
				        result.setText("Whitespace not allowed");
				        result.setForeground(Color.red);
				        suggestion.setText("");
				    }
				    else if(password.length()<12){
				        result.setText("WEAK!");
				        result.setForeground(Color.red);
				        suggestion.setText("Add more characters");
				        suggestion.setForeground(Color.red);
				    }
				    else if(password.length()>30){
				        result.setText("Password too long");
				        result.setForeground(Color.red);
				        suggestion.setText("Reduce 12-30 characters");
				        suggestion.setForeground(Color.red);
				    }
				    else{
				        boolean hasNumber = password.matches("(.)*(\\d)(.)*");
				        if(!hasNumber){
				            result.setText("WEAK!");
				            result.setForeground(Color.red);
				            suggestion.setText("Add any digit");
				            suggestion.setForeground(Color.red);
				        }
				        else{
				            boolean hasSymbol = password.matches("(.)*[\\*\\!\\@\\#\\$\\%\\^\\&\\_\\-\\+\\=\\.\\'\\~\\,\\(\\)\\:\\;\\<\\>\\[\\]\\|\\}\\{]+(.)*");
				            if(hasSymbol){
				                result.setText("STRONG");
				                result.setForeground(Color.GREEN);
				                suggestion.setText("");
				            }
				            else{
				                result.setText("WEAK!");
				                suggestion.setText("Add any symbol");
				            }
				        }
				    }
								
			}
			
		});
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\Users\Dell\Downloads\OneDrive\Pictures\Saved Pictures\sr.jpg");
		
		
		textField = new JTextField();
		textField.setBounds(124, 187, 301, 20);
		frmRmTechnologies.getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}
}