import java.awt.*;
import java.applet.*;

public class Globo extends Rectangle {

	Image globo;
	int velY;
	
    public Globo(Image img) {
		super((int)(Math.random()*150)+900,(int)(Math.random()*700)+500,100,100);		    
    	globo = img;
    	velY = (int)(Math.random()*5)+3;
    
    } 
    
    public void dibujar (Graphics g, Applet a){
    	g.drawImage(globo,x,y,width,height,a);
    }
    
    public void move (){
		y-= velY;
		if(y<-100)
		y=1200;
    } 
    
}  