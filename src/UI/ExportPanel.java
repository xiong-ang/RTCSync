package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ExportPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public ExportPanel() {
		initialize();
	}
	private void initialize() {
		/*
		JPanel abPanel = new JPanel(new FlowLayout()); 
		abPanel.setBackground(Color.white);
		abPanel.setBounds(100, 100, 264, 230);
		abPanel.setBorder(BorderFactory.createTitledBorder( "About "));				
		JLabel abLabel = new JLabel("New label");
		abPanel.add(abLabel);
		*/
		JLabel titleLabel=new JLabel("RTC Export");
		titleLabel.setForeground(new Color(37, 174, 96));
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		titleLabel.setBounds(15, 0, 250, 50);
		
		JLabel productLabel=new JLabel("Product:");
		productLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		productLabel.setBounds(80, 80, 80, 25);
		
		String products[]={"Studio 5000 Architect(S5KA)","Factory Talk View(FTView)","CCW"};
		JComboBox<String> productComboBox = new JComboBox<String>(products);
		productComboBox.setBounds(180, 80, 250, 25);

		JLabel attriLabel=new JLabel("Attribute:");
		attriLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		attriLabel.setBounds(80, 120, 250, 50);
		
		CheckBoxList attriList=new CheckBoxList();        
        attriList.setBorder(BorderFactory.createLineBorder(new Color(37, 174, 96)));
        JCheckBox check1 = new JCheckBox("one");
        check1.setSelected(true);
        JCheckBox check2 = new JCheckBox("two");
        check2.setSelected(true);
        JCheckBox check3 = new JCheckBox("three");
        JCheckBox check4 = new JCheckBox("four");
        JCheckBox check5 = new JCheckBox("five");
        JCheckBox check6 = new JCheckBox("six");
        JCheckBox check7 = new JCheckBox("seven");
        JCheckBox[] myList = { check1, check2,check3, check4,check5, check6,check7};
        attriList.setListData(myList);
        attriList.setBounds(180, 120, 250, 200);
        
        JLabel fiterLabel=new JLabel("Fliter:");
        fiterLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fiterLabel.setBounds(480, 80, 250, 25);
        
        JPanel fiterPanel = new JPanel(new FlowLayout()); 
        fiterPanel.setBackground(Color.white);		
        fiterPanel.setBorder(BorderFactory.createLineBorder(new Color(37, 174, 96)));
		
		JLabel abLabel = new JLabel();
		abLabel.setText("<html><title/><body>RTC Export/Import Tool<br/><br/>Version:1.00.00</body></html>");
		abLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		abLabel.setBounds(20, 20, 200, 200);
		
			
		fiterPanel.setLayout(null);
		fiterPanel.add(abLabel);
		fiterPanel.setBounds(550, 80, 250, 240);
		
		JButton exportButton=new JButton("Export Data");
		exportButton.setBounds(280, 400, 150, 30);
		
		JButton reportButton=new JButton("Generate Reports");
		reportButton.setBounds(550, 400, 150, 30);
		
		this.setLayout(null);
		this.add(titleLabel);		
		this.add(productLabel);
		this.add(productComboBox);
		this.add(attriLabel);
		this.add(attriList);
		this.add(fiterLabel);
		this.add(fiterPanel);
		this.add(exportButton);
		this.add(reportButton);
		this.setBackground(Color.white);
	}

}
