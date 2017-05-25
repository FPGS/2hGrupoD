import java.io.*;
import java.util.*;


public class Mundo {

    public Mundo {
    }
	 
	public void tableroOpcion1(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Introduzca las posiciones con celulas vivas. El formato sera: (fila,columna, valor). El valor sera C para cian o N para naranja. Ejemplo:(2,7,C). La secuencia termina con un 0.");
        String datos=scan.next();
        while(datos.equals("0")==false){
            int y;
            char color;
            int x=datos.charAt(1)-48;
            if(datos.charAt(2)==','){
                y=datos.charAt(3)-48;
                if(datos.charAt(4)==','){
                    color=datos.charAt(5);
                }else{
                    y=(y*10)+(datos.charAt(4)-48);
                    color=datos.charAt(6);
                }
            }else{
                x=(x*10)+(datos.charAt(2)-48);
                y=datos.charAt(4)-48;
                if(datos.charAt(5)==','){
                    color=datos.charAt(6);
                }else{
                    y=(y*10)+(datos.charAt(5)-48);
                    color=datos.charAt(7);
                }
            }
            tablero[x][y]=color;
            datos=scan.next();
        }
    }
    
}