import java.io.*;
import java.util.*;
/**
 *DESCRIPCION: Clase mundo, representa el tablero de juego y las operaciones que se pueden hacer en el.
 */
public class Mundo{
    
    private char [][] tablero = new char [30][30];

    public Mundo (){
        for(int f=0; f<30; f++){
            for(int c=0; c<30; c++){
                tablero[f][c]='X';
            }
        }
    }

    public char getTablero(int f, int c){
        return tablero[f][c];
    }

  
//fin.
    public int numeroVivasTotal(){
        int contadorVivas=0;
        for(int f=0; f<30; f++){
            for(int c=0; c<30; c++){
                if(tablero[f][c]=='C' || tablero[f][c]=='N'){
                    contadorVivas++;
                }
            }
        }
        return contadorVivas;
    }

}
