import java.applet.Applet;
import java.awt.*;
/**
 * 
 */
public class Pieza extends Rectangle{
    private static final int DIMENSION=60;
    private Image pieza;
    private int numeroElemento;
    private boolean mover;
    
    public Pieza(Image pieza, int ne){
        super(((int)(Math.random() * 240))+400,((int)(Math.random() * 240)),DIMENSION,DIMENSION);
        this.pieza=pieza;
        numeroElemento=ne;
        mover=true;
    }
    
    public void dibujar(Graphics g, Applet applet){
        g.drawImage(pieza,x,y,width,height,applet);
    }
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public int getNumElem(){
        return numeroElemento;
    }
    
    public void setMover(boolean mov){
        mover=mov;
    }
    
    public boolean getMover(){
        return mover;
    }
    
}
