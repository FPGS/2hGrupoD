import java.awt.*;
import java.applet.*;
import java.net.*;

public class Parejas extends Applet implements Runnable{
	Casilla casillas[][];
	Image imagenes[];
	Image reverso;
	Casilla cUno, cDos;
	Thread animacion;
	int temporal = 0, cuentaSegundos = 0;
    public void init() {
    	imagenes = new Image[8];
    	for(int i=0; i<8; i++)
    		imagenes[i] = getImage(getCodeBase(), "imagenes/" + (i+1) + ".png");
    	reverso = getImage(getCodeBase(), "imagenes/reverso.png");
		casillas = new Casilla[4][4];
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				casillas[i][j] = new Casilla(98 + (j*Casilla.DIM), 98 + (i*Casilla.DIM), imagenes[((i*4)+j) % 8], reverso);
		desordenar();
    }
    
    public void start(){
    	animacion = new Thread(this);
    	animacion.start(); //llama al método run
    }
    
    public void run(){
    	while(true){
				cuentaSegundos++;
				if((cuentaSegundos - temporal) == 3){
					cUno.setDescubierta(false);
					cDos.setDescubierta(false);
					cUno = cDos = null;	
					repaint();
				}
    		try{
    			Thread.sleep(1000);
    		}catch(InterruptedException e){};
    	}
    }
    
    public void paint(Graphics g){
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				casillas[i][j].dibujar(g, this);
    }

	public void desordenar(){
		Image auxiliar;
		for(int i=0; i<25; i++){
			int alea1 = (int)(Math.random()*16);
			int alea2 = (int)(Math.random()*16);
			auxiliar = casillas[(int)(alea1/4)][alea1%4].getImagen();
			casillas[(int)(alea1/4)][alea1%4].setImagen(casillas[(int)(alea2/4)][alea2%4].getImagen());
			casillas[(int)(alea2/4)][alea2%4].setImagen(auxiliar);
		}
	}
	
	public int cuantos(){
		int num = 0;
		if(cUno != null) num++;
		if(cDos != null) num++;
		return num;
	}
	
	public boolean mouseDown(Event ev, int x, int y){
		for(int i=0; i<4; i++)
			for(int j=0; j<4; j++)
				if(casillas[i][j].contains(x, y)){
					if(!casillas[i][j].getDescubierta()){
						casillas[i][j].setDescubierta(true);
						switch(cuantos()){
							case 0: 
								cUno = casillas[i][j];
								break;
							case 1:
								cDos = casillas[i][j];
								if(cUno.getImagen() == cDos.getImagen()){
									cUno = cDos = null;
								}else{
									temporal = cuentaSegundos;
								}
						}
						repaint();
					}
					break;
				}
		return true;
	}
	
}