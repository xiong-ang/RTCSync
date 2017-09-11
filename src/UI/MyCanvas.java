package UI;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

class MyCanvas extends Canvas{
	private static final long serialVersionUID = 1L;
	
    private BufferedImage bi;
    private Image im;
    private int image_width;
    private int image_height;
    
    public void setImage(BufferedImage bi){
        this.bi=bi;
        this.zoom();
    }
    
    public void paint(Graphics g){
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);
    }
    
    public void zoom(){
        image_width=bi.getWidth();
        image_height=bi.getHeight();
        im=bi.getScaledInstance(image_width,image_height,Image.SCALE_SMOOTH);
    }
}
