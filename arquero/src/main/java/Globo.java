import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Globo extends Rectangle {

	private Image globo;
	int velY;
	
    public Globo(Image img) {
		super((int)(Math.random()*150)+900,(int)(Math.random()*700)+500,100,100);		    
		setGlobo(img);
    	velY = (int)(Math.random()*5)+3;
    
    } 
    
    public void dibujar (Graphics g, Applet a){
		g.drawImage(getGlobo(), x, y, width, height, a);
    }
    
    public void move (){
		y-= velY;
		if(y<-100)
		y=1200;
	}

	public Image getGlobo() {
		return globo;
	}

	public void setGlobo(Image globo) {
		this.globo = globo;
	}
    
}  