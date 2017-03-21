import java.awt.Graphics;
import java.awt.Event;
import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import java.applet.*;
import java.util.List;
import java.util.ArrayList;


public class Jugando extends Applet implements Runnable{
	public static final int GLOB = 20;
	Image imagen,ar,fl,gl,fon;
	Graphics noseve;
	List <Flecha> flechas;
	List <Globo> globos;
	Thread animacion;

	Arquero arquero;
    public void init(){
    
	fon = getImage(getDocumentBase(),"imagenes/fondo.jpg");
    
    ar = getImage(getDocumentBase(),"imagenes/arquero.gif");
    arquero = new Arquero(ar,20,20,120,100);
	
	fl = getImage(getDocumentBase(),"imagenes/flecha.gif");
	flechas = new ArrayList<Flecha>();
	
	gl = getImage(getDocumentBase(),"imagenes/globo.gif");
	globos = new ArrayList<Globo>();
	for(int i = 0; i<GLOB; i++)
		globos.add(new Globo(gl));
		
	imagen = this.createImage(1300,700);
	noseve = imagen.getGraphics();
		
	}
	
	public void start(){
		animacion = new Thread(this);
		animacion.start();//Llama metodo run
	}
	
	public void paint(Graphics g){
		noseve.setColor(Color.black);
		noseve.fillRect(0,0,1300,700);
		noseve.drawImage(fon,0,0,this);
		arquero.dibujar(noseve,this);
		for (int i =0; i<flechas.size(); i++)
			flechas.get(i).dibujar(noseve,this);
		for	(int i =0; i<globos.size(); i++)
			globos.get(i).dibujar(noseve,this);
		
		
	g.drawImage(imagen,0,0,this);
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
			
    	try{
    		Thread.sleep(10);
    	}catch(InterruptedException e){};
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
