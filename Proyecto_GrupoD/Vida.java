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

      //fin ventanas 
        } else {
            System.out.println("3.El numero que ha introducido no es valido.");
        }
    }
}
