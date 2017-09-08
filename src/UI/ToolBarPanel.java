package UI;

import UI.AppMainWindow;
import UI.ConstantsUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToolBarPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static MyIconButton buttonExport;
	public static MyIconButton buttonImport;
	public static MyIconButton buttonAbout;
	
	public final static ImageIcon ICON_EXPORT_DISABLE = new ImageIcon("icon/ExportDisable.png");
	public final static ImageIcon ICON_EXPORT_ENABLE = new ImageIcon("icon/ExportEnable.png");
	public final static ImageIcon ICON_IMPORT_DISABLE = new ImageIcon("icon/ImportDisable.png");
	public final static ImageIcon ICON_IMPORT_ENABLE = new ImageIcon("icon/ImportEnable.png");
	public final static ImageIcon ICON_ABOUT_DISABLE = new ImageIcon("icon/AboutDisable.png");
	public final static ImageIcon ICON_ABOUT_ENABLE = new ImageIcon("icon/AboutEnable.png");


	public ToolBarPanel() {
		initialize();
		addButtion();
		addListener();
	}


	private void initialize() {
		Dimension preferredSize = new Dimension(48, ConstantsUI.MAIN_WINDOW_HEIGHT);
		this.setPreferredSize(preferredSize);
		this.setMaximumSize(preferredSize);
		this.setMinimumSize(preferredSize);
		this.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		this.setLayout(new GridLayout(2, 1));
	}


	private void addButtion() {

		JPanel panelUp = new JPanel();
		panelUp.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		panelUp.setLayout(new FlowLayout(-2, -2, -4));
		JPanel panelDown = new JPanel();
		panelDown.setBackground(ConstantsUI.TOOL_BAR_BACK_COLOR);
		panelDown.setLayout(new BorderLayout(0, 0));
		
		buttonExport = new MyIconButton(ICON_EXPORT_DISABLE,
										ICON_EXPORT_ENABLE,
										ICON_EXPORT_DISABLE,
										"Export data from RTC.");
		buttonImport = new MyIconButton(ICON_IMPORT_DISABLE,
										ICON_IMPORT_ENABLE,
										ICON_IMPORT_DISABLE,
										"Import data to RTC.");
		buttonAbout = new MyIconButton(ICON_ABOUT_DISABLE,
										ICON_ABOUT_ENABLE,
										ICON_ABOUT_DISABLE,
										"About me.");

		panelUp.add(buttonExport);
		panelUp.add(buttonImport);

		panelDown.add(buttonAbout, BorderLayout.SOUTH);
		this.add(panelUp);
		this.add(panelDown);

	}


	private void addListener() {

		buttonExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonExport.setIcon(ICON_EXPORT_ENABLE);
				buttonImport.setIcon(ICON_IMPORT_DISABLE);
				buttonAbout.setIcon(ICON_ABOUT_DISABLE);

				AppMainWindow.centerPanel.removeAll();				
				AppMainWindow.centerPanel.add(AppMainWindow.exportPanel, BorderLayout.CENTER);
				AppMainWindow.centerPanel.updateUI();

			}
		});

		buttonImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonExport.setIcon(ICON_EXPORT_DISABLE);
				buttonImport.setIcon(ICON_IMPORT_ENABLE);
				buttonAbout.setIcon(ICON_ABOUT_DISABLE);

				AppMainWindow.centerPanel.removeAll();
				AppMainWindow.centerPanel.add(AppMainWindow.importPanel, BorderLayout.CENTER);
				AppMainWindow.centerPanel.updateUI();

			}
		});

		buttonAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonExport.setIcon(ICON_EXPORT_DISABLE);
				buttonImport.setIcon(ICON_IMPORT_DISABLE);
				buttonAbout.setIcon(ICON_ABOUT_ENABLE);

				AppMainWindow.centerPanel.removeAll();	
				AppMainWindow.centerPanel.add(AppMainWindow.aboutPanel, BorderLayout.CENTER);
				AppMainWindow.centerPanel.updateUI();

			}
		});
	}
}
