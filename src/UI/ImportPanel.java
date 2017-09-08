package UI;

import javax.swing.*;
import java.awt.*;

public class ImportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public ImportPanel() {
		initialize();
	}
	private void initialize() {

		JLabel titleLabel=new JLabel("RTC Import");
		titleLabel.setForeground(new Color(37, 174, 96));
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		titleLabel.setBounds(15, 0, 250, 50);
		
		JLabel productLabel=new JLabel("Product:");
		productLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		productLabel.setBounds(160, 150, 250, 25);
		
		String products[]={"Studio 5000 Architect(S5KA)","CCW"};
		JComboBox<String> productComboBox = new JComboBox<String>(products);
		productComboBox.setBounds(260, 150, 250, 25);
		

		JLabel fileLabel=new JLabel("File:");
		fileLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		fileLabel.setBounds(160, 220, 50, 25);
		
		JTextField filename=new JTextField(20);
		filename.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		filename.setBounds(260, 220, 250, 25);
		
		JButton browerButton=new JButton("Browse...");
		browerButton.setBounds(510, 220, 100, 25);
		
		JButton importButton=new JButton("Import Data");
		importButton.setBounds(510, 300, 100, 25);
		
		this.setLayout(null);
		this.add(titleLabel);
		this.add(productLabel);
		this.add(productComboBox);
		this.add(fileLabel);
		this.add(filename);
		this.add(browerButton);
		this.add(importButton);
		this.setBackground(Color.WHITE);
	}

}
