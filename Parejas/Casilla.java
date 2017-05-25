import java.awt.*;
import java.applet.*;

public class Casilla extends Rectangle{
	public static final int DIM = 100;
	private Image imagen;
	Image reverso;
	private boolean descubierta;
    public Casilla(int posx, int posy, Image img, Image rev) {
		super(posx, posy, DIM, DIM);
    	imagen = img;
    	reverso = rev;
    	descubierta = false;
    }

	public Image getImagen(){
		return imagen;
	}
	
	public void setImagen(Image nueva){
		imagen = nueva;
	}
	
	public boolean getDescubierta(){
		return descubierta;
	}

	public void setDescubierta(boolean d){
		descubierta = d;
	}

    public void dibujar(Graphics g, Applet a){
		if(descubierta)
			g.drawImage(imagen, x, y, width, height, a);
		else
			g.drawImage(reverso, x, y, width, height, a);
    }
    
}