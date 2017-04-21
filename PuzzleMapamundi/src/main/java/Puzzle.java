import java.awt.*;
import java.applet.*;
/**
 *
 */
public class Puzzle extends Applet{
    private Pieza piezas[];
    private int posPiezaMovimiento;
    private boolean activa=false;
    private Rectangle cuadricula[][] = new Rectangle[5][5];
    private Image fondo;
    
    private Image imagen;//
    private Graphics noseve;//

    public void init(){
        piezas = new Pieza[25];
        for(int i=0;i<piezas.length;i++){
            Image piezaProvisional = getImage(getCodeBase(), "imagenes/"+(i+1)+".png");
            piezas[i]=new Pieza(piezaProvisional,(i+1));
        }
        
        fondo = getImage(getCodeBase(), "imagenes/mapamundi3.png");
        
        int posY=0;
        for(int i=0;i<cuadricula.length;i++){
            int posX=0;
            for(int j=0;j<cuadricula[0].length;j++){
                cuadricula[i][j]=new Rectangle(posX,posY,60,60);
                posX+=60;
            }
            posY+=60;
        }
        
        imagen = createImage(800,800);//
        noseve = imagen.getGraphics();//
    }

    public void paint(Graphics g){
        noseve.setColor(Color.black);//
        noseve.fillRect(0, 0, 800, 600);//
        
        noseve.drawImage(fondo,0,0,this);
        
        for(int i=0;i<piezas.length;i++){
            piezas[i].dibujar(noseve, this);
        }

        /*noseve.setColor(Color.yellow);
        for(int i=0;i<cuadricula.length;i++){
            for(int j=0;j<cuadricula[0].length;j++){
                noseve.drawRect((int)cuadricula[i][j].getX(),(int)cuadricula[i][j].getY(),(int)cuadricula[i][j].getWidth(),(int)cuadricula[i][j].getHeight());
            }
        }
        */
       
       int contador=0;
       for(int i=0;i<piezas.length;i++){
           if(!piezas[i].getMover()){
               contador++;
           }
       }
       
       if(contador>=piezas.length){
           noseve.setColor(Color.yellow);
           noseve.drawString("HAS GANADO!!!",100,350);
       }
       
        g.drawImage(imagen, 0, 0, this);//
    }

    public void update(Graphics g){////
        paint(g);
    }

    public boolean mouseDown(Event e, int x, int y){
        for(int i=0;i<piezas.length;i++){
            if(piezas[i].contains(x,y)){
                posPiezaMovimiento=i;
                if(piezas[i].getMover()){
                    activa=true;
                }
            }
        }
        return true;
    }

    public boolean mouseDrag(Event e, int x, int y){
        if(activa){
            piezas[posPiezaMovimiento].setX(x);
            piezas[posPiezaMovimiento].setY(y);
            repaint();
        }
        return true;
    }

    public boolean mouseUp(Event e, int x, int y){
        //OJO, este evento es cuando el ratón esta levantado, pero no requiere
        //que se haya clickado antes para funcionar de manera que por eso necesitamos
        //activa
        if(activa){
            for(int i=0;i<cuadricula.length;i++){
                for(int j=0;j<cuadricula[0].length;j++){
                    for(int k=0;k<piezas.length;k++){
                        
                        if(cuadricula[i][j].intersects(piezas[k]) && piezas[k].getNumElem()==((i*5)+j+1)){
                            piezas[k].setX((int)cuadricula[i][j].getX());
                            piezas[k].setY((int)cuadricula[i][j].getY());
                            piezas[k].setMover(false);
                            repaint();
                        } else if(cuadricula[i][j].intersects(piezas[k]) && piezas[k].getNumElem()!=((i*5)+j+1)){
                            piezas[k].setX((int)(Math.random() * 240)+400);
                            piezas[k].setY((int)(Math.random() * 240));
                        }
                        
                    }

                }
            }
        }
        activa=false;
        return true;
    }

}
