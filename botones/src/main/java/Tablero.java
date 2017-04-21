import java.awt.*;
import java.applet.*;
import java.net.*;

public class Tablero extends Applet{
	public static final int TAM = 5; 
	Image imagenes[][];
	Lugar lugares[][];
	AudioClip error, acierto, exito;
	Point blanco;
	Button boton;
    public void init() {
    	try{
    		error = getAudioClip(new URL(getDocumentBase(), "sonidos/error.wav"));
    		acierto = getAudioClip(new URL(getDocumentBase(), "sonidos/correct.wav"));
    		exito = getAudioClip(new URL(getDocumentBase(), "sonidos/exito.wav"));
    	}catch(MalformedURLException e){}    	
    	imagenes = new Image[TAM][TAM];
    	for(int i=0; i<TAM; i++)
    		for(int j=0; j<TAM; j++)
    			if(!((i==TAM-1) && (j==TAM-1)))
    				imagenes[i][j] = getImage(getCodeBase(), "botones/" + ((i*TAM)+j+1) + ".gif");
    	lugares = new Lugar[TAM][TAM];
    	for(int i=0; i<TAM; i++)
    		for(int j=0; j<TAM; j++)
    			lugares[i][j] = new Lugar(imagenes[i][j], (i*TAM)+j);
    	blanco = new Point(TAM-1, TAM-1);
    	Panel panel = new Panel();
    	boton = new Button("Empezar");
    	panel.add(boton);
    	this.setLayout(new BorderLayout());
    	this.add("South",panel);
    }
    
    public void paint(Graphics g){
    	for(int i=0; i<TAM; i++)
    		for(int j=0; j<TAM; j++)
				lugares[i][j].dibujar(g, this, j, i);
    }

	public boolean mover(Point click){
		Point desplazamiento, hasta; 
		desplazamiento = new Point(delta(click.x, blanco.x), delta(click.y, blanco.y));
		if ((desplazamiento.x == 0) && (desplazamiento.y == 0))
			return false;
		if ((desplazamiento.x != 0) && (desplazamiento.y != 0))
			return false;
		hasta = new Point(click.x + desplazamiento.x, click.y + desplazamiento.y);
		if(!((blanco.x == hasta.x) && (blanco.y == hasta.y)))
			mover(hasta);
		lugares[blanco.x][blanco.y].setImagen(lugares[click.x][click.y].getImagen());
		lugares[blanco.x][blanco.y].valor = lugares[click.x][click.y].valor;
		lugares[click.x][click.y].setImagen(null);
		lugares[click.x][click.y].valor = 24;
		blanco = click;
		return true;
	}

	public int delta(int a, int b){
		if(a==b) return 0;
		else return ((b-a)/Math.abs(b-a));
	}

    public boolean mouseDown(Event ev, int x, int y){
    	Point click;
    	click = new Point(y/Lugar.DIM, x/Lugar.DIM);
    	if(mover(click)){
    		acierto.play();
    		comprobar();
			repaint();
    	}else
			error.play();
    	return true;
    }

	public void comprobar(){
		boolean correcto = true;
		for(int i=0; i<TAM; i++)
			for(int j=0; j<TAM; j++)
				if(lugares[i][j].valor != ((i*TAM+j)))
					correcto = false;
		if(correcto = true)
			exito.play();
	}

	public boolean action(Event ev, Object obj){
		if(ev.target instanceof Button){
			for(int i=0;i<1000;i++)
			mover(new Point((int)(Math.random()*5),(int)(Math.random()*5)));
			repaint();
			return true;
		}
		return false;
	}

}