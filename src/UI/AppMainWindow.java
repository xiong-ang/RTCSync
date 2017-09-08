package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AppMainWindow {

    private JFrame frame;

    //
    private static JPanel mainPanel;
    
    private static ToolBarPanel leftToolBox;
    public static JPanel centerPanel;
    
    //Login
    private static JLabel usernameLabel,passwordLabel;
    private static JTextField usernameText;
    private static JPasswordField passwordText;
    private static JLabel tipLabel;
    private static JButton loginButton;
    private static JPanel jp1,jp2;
    private static JPanel loginPanel;
    
    //
    public static JPanel exportPanel;
    public static JPanel importPanel;
    public static JPanel aboutPanel;        
    
    private static Boolean isLogined;
    public static String username;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMainWindow window = new AppMainWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AppMainWindow() {
        initialize();
    }

    private void initialize() {
    	
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        frame = new JFrame();     
        frame.setSize(900,500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("RTC Sync");
        frame.setResizable(false);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/RTCSync.png"));
        frame.setBackground(Color.WHITE);
        
        loginPanel=new JPanel();
        initializeLoginPanel();
        
        mainPanel = new JPanel(true);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.add(loginPanel, BorderLayout.CENTER);
                 
        addListener();
        
        frame.add(mainPanel);
        
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //frame.setUndecorated(true);
        //frame.setVisible(true);
        
        isLogined=false;
        username=null;
    } 
    
    private void initializeLoginPanel()
    {
    	jp1=new JPanel();
		jp2=new JPanel();
		jp1.setBackground(Color.white);
		jp2.setBackground(Color.white);
		
		usernameLabel=new JLabel("User name:  ");
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		passwordLabel=new JLabel("Password:    ");
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		usernameText=new JTextField(20);
		usernameText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordText=new JPasswordField(20);
		passwordText.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		jp1.add(usernameLabel);
		jp1.add(usernameText);		
		jp2.add(passwordLabel);
		jp2.add(passwordText);
		
		tipLabel=new JLabel("* Please input username and password");
		tipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tipLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tipLabel.setForeground(new Color(37, 174, 96));
		
		JPanel groupPanel = new JPanel(new GridLayout(3,1));
		groupPanel.setBackground(Color.white);				
		groupPanel.add(jp1);
		groupPanel.add(jp2);
		groupPanel.add(tipLabel);
		groupPanel.setBounds(150, 140, 600, 150);
		
		
		JLabel titleLabel=new JLabel("Welcome");
		titleLabel.setForeground(new Color(37, 174, 96));
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		titleLabel.setBounds(330, 40, 250, 50);
		
		loginButton=new JButton("Sign in");
		loginButton.setBounds(550, 300, 100, 30);
		
		loginPanel.setLayout(null);
		loginPanel.setBackground(Color.white);
		loginPanel.add(groupPanel);
		loginPanel.add(titleLabel);
		loginPanel.add(loginButton);
    }
    
    private void addListener()
    {
    	frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent e) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }
        });
    	
    	loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isLogined=loginRTC();
                if(isLogined)
                {
                	username=usernameText.getText();
                	frame.setTitle(frame.getTitle()+" [ User name: "+username+" ]");
                	initializeLoginedPanel();
                }
                else
                	clearUI();
            }
        });  
    	
    }
    
    private Boolean loginRTC()
    {
    	return true;
    }
    
    private void initializeLoginedPanel()
    {   
    	/*
    	MyCanvas userIcon=new MyCanvas();
        try{
            File file=new File("icon/DataSync.png");
            BufferedImage bi=ImageIO.read(file);
            userIcon.setImage(bi);
        }catch(Exception e){
            e.printStackTrace();
        }
        userIcon.repaint();
        userIcon.setBounds(780, 10, 50, 50);
        */
    	
    	exportPanel= new ExportPanel();
    	//exportPanel.add(userIcon);
        importPanel=new ImportPanel();
        //importPanel.add(userIcon);
        aboutPanel=new AboutPanel(); 
        //aboutPanel.add(userIcon);
        
        centerPanel = new JPanel(true);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.removeAll();				
		centerPanel.add(AppMainWindow.exportPanel, BorderLayout.CENTER);
		centerPanel.updateUI();
        
        

        leftToolBox = new ToolBarPanel();
        ToolBarPanel.buttonExport.setIcon(ToolBarPanel.ICON_EXPORT_ENABLE);
		ToolBarPanel.buttonImport.setIcon(ToolBarPanel.ICON_IMPORT_DISABLE);
		ToolBarPanel.buttonAbout.setIcon(ToolBarPanel.ICON_ABOUT_DISABLE);
		
		mainPanel.removeAll();			
    	mainPanel.add(leftToolBox, BorderLayout.WEST);
    	mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.updateUI();
    	
    }
    
    private	void clearUI()
	{
		tipLabel.setText("*Invalid login information. Please try again.");
    	tipLabel.setForeground(Color.RED);
    	passwordText.setText("");
    	passwordText.requestFocus();
	}
}
