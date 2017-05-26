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
    } else if (n==2){           
            VentanaGrid ventana = new VentanaGrid();
            tablero.tableroOpcion2();
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

      //fin ventanas 
	if (n==3){
            VentanaGrid ventana = new VentanaGrid();
            tablero.tableroOpcion3();
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

        } else {
            System.out.println("3.El numero que ha introducido no es valido.");
        }
    }
}
