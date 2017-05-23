import java.io.*;
import java.util.*;
/**
 *DESCRIPCION: Clase Vida que contiene el metodo main que realiza la logica de los turnos.
 *Segun que opcion se elija se introducen los datos de manera distinta...
 */
public class Vida{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("MENU");
        System.out.println("1.Introducir por teclado las posiciones de las celulas.");
        System.out.println("2.Introducir por un fichero de texto con extension .mat las posiciones de las celulas.");
        System.out.println("3.Introducir por un fichero de texto con extensión .lst las posiciones de las celulas.");
        int n = scan.nextInt();

        Mundo tablero = new Mundo();

       public int numeroVivasAlrededor(int x, int y){
        int contadorVivas = 0;
        if(x==0&&y==0){
            if(tablero[1][0]=='C' || tablero[1][0]=='N'){
                contadorVivas++;
            }
            if(tablero[1][1]=='C' || tablero[1][1]=='N'){
                contadorVivas++;
            }
            if(tablero[0][1]=='C' || tablero[0][1]=='N'){
                contadorVivas++;
            }
        } else if(x==29&&y==29){
            if(tablero[28][28]=='C' || tablero[28][28]=='N'){
                contadorVivas++;
            }
            if(tablero[28][29]=='C' || tablero[28][29]=='N'){
                contadorVivas++;
            }
            if(tablero[29][28]=='C' || tablero[29][28]=='N'){
                contadorVivas++;
            }
        }else if(x==0&&y==29){
            if(tablero[0][28]=='C' || tablero[0][28]=='N'){
                contadorVivas++;
            }
            if(tablero[1][29]=='C' || tablero[1][29]=='N'){
                contadorVivas++;
            }
            if(tablero[1][28]=='C' || tablero[1][28]=='N'){
                contadorVivas++;
            }
        }else if(x==29&&y==0){
            if(tablero[28][0]=='C' || tablero[28][0]=='N'){
                contadorVivas++;
            }
            if(tablero[28][1]=='C' || tablero[28][1]=='N'){
                contadorVivas++;
            }
            if(tablero[29][1]=='C' || tablero[29][1]=='N'){
                contadorVivas++;
            }
        }else if(x==0){
            if(tablero[0][y-1]=='C' || tablero[0][y-1]=='N'){
                contadorVivas++;
            }
            if(tablero[0][y+1]=='C' || tablero[0][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[1][y]=='C' || tablero[1][y]=='N'){
                contadorVivas++;
            }
            if(tablero[1][y+1]=='C' || tablero[1][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[1][y-1]=='C' || tablero[1][y-1]=='N'){
                contadorVivas++;
            }
        }else if(x==29){
            if(tablero[29][y-1]=='C' || tablero[29][y-1]=='N'){
                contadorVivas++;
            }
            if(tablero[29][y+1]=='C' || tablero[29][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[28][y]=='C' || tablero[28][y]=='N'){
                contadorVivas++;
            }
            if(tablero[28][y+1]=='C' || tablero[28][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[28][y-1]=='C' || tablero[28][y-1]=='N'){
                contadorVivas++;
            }
        }else if(y==0){
            if(tablero[x-1][0]=='C' || tablero[x-1][0]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][0]=='C' || tablero[x+1][0]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][1]=='C' || tablero[x+1][1]=='N'){
                contadorVivas++;
            }
            if(tablero[x-1][1]=='C' || tablero[x-1][1]=='N'){
                contadorVivas++;
            }
            if(tablero[x][1]=='C' || tablero[x][1]=='N'){
                contadorVivas++;
            }
        }else if(y==29){
            if(tablero[x-1][29]=='C' || tablero[x-1][29]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][29]=='C' || tablero[x+1][29]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][28]=='C' || tablero[x+1][28]=='N'){
                contadorVivas++;
            }
            if(tablero[x-1][28]=='C' || tablero[x-1][28]=='N'){
                contadorVivas++;
            }
            if(tablero[x][28]=='C' || tablero[x][28]=='N'){
                contadorVivas++;
            }
        }else{
            if(tablero[x-1][y]=='C' || tablero[x-1][y]=='N'){
                contadorVivas++;
            }
            if(tablero[x-1][y+1]=='C' || tablero[x-1][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[x-1][y-1]=='C' || tablero[x-1][y-1]=='N'){
                contadorVivas++;
            }
            if(tablero[x][y+1]=='C' || tablero[x][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[x][y-1]=='C' || tablero[x][y-1]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][y+1]=='C' || tablero[x+1][y+1]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][y]=='C' || tablero[x+1][y]=='N'){
                contadorVivas++;
            }
            if(tablero[x+1][y-1]=='C' || tablero[x+1][y-1]=='N'){
                contadorVivas++;
            }
        }
        return contadorVivas;
    }
      //fin ventanas 
        } else {
            System.out.println("3.El numero que ha introducido no es valido.");
        }
    }
}
