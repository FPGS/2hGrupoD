import java.awt.*;
import java.applet.*;

public class Flecha extends Point {
	public static final int FLX = 55;
	public static final int ANCHURA = 100;
	public static final int ALTURA = 50;	
	Image flecha;
	int velX,velY;
	
    public Flecha(Image img, int py) {
    	super(0,py);
    	flecha = img;
    	velX = 10;
    
    }
    
    public void dibujar (Graphics g, Applet a){
    	g.drawImage(flecha,x+FLX,y,ANCHURA,ALTURA,a);
    }
    
    public void move (){
		x+= velX;
	
    } 
 	
 	public Point posiciones (){
 		return new Point(x+ANCHURA, y + (ALTURA/2));
 	}
}  