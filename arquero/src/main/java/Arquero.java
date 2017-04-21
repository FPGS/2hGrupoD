import java.awt.*;
import java.applet.*;
import java.awt.Image;

public class Arquero {

	Image imagen;
	int x,y,anchura,altura;
		
    public Arquero(Image imgs,int posx, int posy ,int anchura ,int altura) {
   		imagen = imgs;
   		x=posx;
   		y=posy;
   		this.anchura=anchura;
   		this.altura=altura;
   		
    }
    
    public void dibujar(Graphics g, Applet a){
    	g.drawImage(imagen,x,y,anchura,altura,a);
    }

  	public void setY (int py){
		y = py;

	}
  
}