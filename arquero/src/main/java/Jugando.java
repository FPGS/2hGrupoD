import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class Jugando extends Applet implements Runnable{
	public static final int GLOB = 20;
	Image buffer,arqueroImage,fl,gl,fon;
	Graphics graphics;
	List <Flecha> flechas;
	List <Globo> globos;
	Thread animacionThread;

	Arquero arquero;
    public void init(){
    
	fon = getImage(getDocumentBase(),"imagenes/fondo.jpg");
    
    arqueroImage = getImage(getDocumentBase(),"imagenes/arquero.gif");
    arquero = new Arquero(arqueroImage,20,20,120,100);
	
	fl = getImage(getDocumentBase(),"imagenes/flecha.gif");
	flechas = new ArrayList<Flecha>();
	
	gl = getImage(getDocumentBase(),"imagenes/globo.gif");
	globos = new ArrayList<Globo>();
	for(int i = 0; i<GLOB; i++)
		globos.add(new Globo(gl));
		
	buffer = this.createImage(1300,700);
	graphics = buffer.getGraphics();
		
	}
	

	public void paint(Graphics g){
		graphics.setColor(Color.black);
		graphics.fillRect(0,0,1300,700);
		graphics.drawImage(fon,0,0,this);
		arquero.dibujar(graphics,this);
		for (Flecha flecha : flechas) {
			flecha.dibujar(graphics, this);
		}
		for	(int i =0; i<globos.size(); i++)
			globos.get(i).dibujar(graphics,this);
		
		
		g.drawImage(buffer,0,0,this);
   	}
   	
   	public void update (Graphics g){
   		paint(g);
   	}
  	
 	public void run(){
    	while(true){
			for (int i = 0; i<flechas.size(); i++){
				flechas.get(i).move();
				if (flechas.get(i).x > 1500)
					flechas.remove(i);
			}
			for (int i = 0; i<globos.size(); i++)
				globos.get(i).move();	
					
			for (int i = 0; i<flechas.size(); i++)		
					for (int j = 0; j<globos.size(); j++)
						if (globos.get(j).contains(flechas.get(i).posiciones())){
							globos.remove(j);
							flechas.remove(i);
							break;
						}
			repaint();	
			
    	
		}
    }
      	
	public boolean mouseMove (Event ev, int x, int y){
		arquero.setY(y);
		repaint();
		return true;
	}
    
    public boolean mouseDown (Event ev,int x , int y){
    	flechas.add(new Flecha(fl,y+15));
    	//sizef++;
    	repaint();
    	return true;
    }  
}
