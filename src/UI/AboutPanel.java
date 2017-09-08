package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AboutPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public AboutPanel() {
		initialize();
	}
	
	private void initialize() {
		// TODO Auto-generated method stub
		JPanel abPanel = new JPanel(new FlowLayout()); 
		abPanel.setBackground(Color.white);		
		abPanel.setBorder(BorderFactory.createLineBorder(new Color(37, 174, 96)));
		
		JLabel abLabel = new JLabel("New label");
		abLabel.setText("<html><title/><body>RTC Export/Import Tool<br/><br/>Version:1.00.00</body></html>");
		abLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		abLabel.setBounds(200, 20, 300, 100);
		
		MyCanvas mc=new MyCanvas();
        try{
            File file=new File("icon/RTCSync.png");
            BufferedImage bi=ImageIO.read(file);
            mc.setImage(bi);
        }catch(Exception e){
            e.printStackTrace();
        }
        mc.repaint();
        mc.setBounds(50, 30, 100, 100);
			
		abPanel.setLayout(null);
		abPanel.add(abLabel);
		abPanel.add(mc);
		abPanel.setBounds(120, 80, 600, 300);
		
		
		JLabel titleLabel=new JLabel("About");
		titleLabel.setForeground(new Color(37, 174, 96));
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		titleLabel.setBounds(15, 0, 250, 50);
		
		this.setLayout(null);
		this.add(titleLabel);		
		this.add(abPanel);
		this.setBackground(Color.white);
	}	
}
