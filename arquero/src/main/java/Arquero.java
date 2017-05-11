import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Arquero {

	private Image imagen;
	private int x, y, anchura, altura;
	private int aspectRatio;

    public Arquero(Image imgs,int posx, int posy ,int anchura ,int altura) {
   		imagen = imgs;
   		x=posx;
   		y=posy;
   		this.anchura=anchura;
   		this.altura=altura;
		aspectRatio = altura / anchura;
		imgs.getScaledInstance(anchura, altura, 0);
    }
    

    public void dibujar(Graphics g, Applet a){
    	g.drawImage(imagen,x,y,anchura,altura,a);
    }

  	public void setY (int py){
		y = py;

	}

	public int getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(int aspectRatio) {
		this.aspectRatio = aspectRatio;
	}
  
}