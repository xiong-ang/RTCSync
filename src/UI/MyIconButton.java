package UI;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * �Զ��尴ť�֧࣬���Զ���Ĭ��ͼ�ꡢ����ͼ�ꡢʧЧͼ���tip��ʾ
 * 
 * @author Bob
 *
 */
public class MyIconButton extends JButton {

	private static final long serialVersionUID = 1L;
	private ImageIcon iconEnable, iconDisable;

	/**
	 * ����
	 * 
	 * @param iconNormal
	 *            Ĭ��ͼ��
	 * @param iconEnable
	 *            ����ͼ��
	 * @param iconDisable
	 *            ʧЧͼ��
	 * @param tip
	 *            ��ʾ
	 */
	public MyIconButton(ImageIcon iconNormal, ImageIcon iconEnable, ImageIcon iconDisable, String tip) {
		super(iconNormal);

		this.iconEnable = iconEnable;
		this.iconDisable = iconDisable;

		initialize();
		setUp();
	}

	/**
	 * ��ʼ�������ð�ť���ԣ��ޱߣ��޽�����Ⱦ���������������߾�0
	 */
	private void initialize() {
		this.setBorderPainted(false);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusable(true);
		this.setMargin(new Insets(0, 0, 0, 0));
	}

	/**
	 * ���ð�ťͼ�꣺����ƹ�����ѹ��ʧЧ��ͼ�� �����ð�ť��ʾ
	 */
	private void setUp() {
		this.setRolloverIcon(iconEnable);
		// this.setSelectedIcon(iconEnable);
		this.setPressedIcon(iconEnable);
		this.setDisabledIcon(iconDisable);
/*
		if (!tip.equals("")) {
			this.setToolTipText(tip);
		}*/

	}
}
