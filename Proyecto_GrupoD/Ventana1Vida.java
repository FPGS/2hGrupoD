import java.io.*;
import java.util.*;

public class Vida {

    public static void main (String args[]) {
    	
    	 	if(n==1){
            VentanaGrid ventana = new VentanaGrid();
            tablero.tableroOpcion1();
            for(int f=0; f<30; f++){
                    for(int c=0;c<30;c++){
                        if(tablero.getTablero(f,c)=='C'){
                            ventana.iluminarCasillaColor1(f,c);
                        } else if (tablero.getTablero(f,c)=='N'){
                            ventana.iluminarCasillaColor2(f,c);
                        } else {
                            ventana.apagarCasilla(f,c);
                        }
                    }
            }
            ventana.esperar(2000);
            int generaciones=0;
            do{
                tablero.estadoPosicionSiguiente();
                for(int f=0; f<30; f++){
                    for(int c=0;c<30;c++){
                        if(tablero.getTablero(f,c)=='C'){
                            ventana.iluminarCasillaColor1(f,c);
                        } else if (tablero.getTablero(f,c)=='N'){
                            ventana.iluminarCasillaColor2(f,c);
                        } else {
                            ventana.apagarCasilla(f,c);
                        }
                    }
                }
                ventana.esperar(2000);
                generaciones++;
            }while(generaciones==1000||tablero.numeroVivasTotal()!=0);
            ventana.cerrarVentana();
    }
    } 
    
}