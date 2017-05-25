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

    public void tableroOpcion3(){
        try{
            Scanner scan=new Scanner(System.in);
            System.out.println("Introduzca el nombre del fichero .lst");
            String nombre=scan.next();
            String fichero = "C:/Users/Lydia/Documents/" + nombre + ".lst";
            FileInputStream in = new FileInputStream(fichero);
            Scanner scann = new Scanner (in);
            String datos = scann.next();
            while(scann.hasNextLine() == true){
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
                datos=scann.nextLine();
                datos=scann.next();
            }
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("No existe el fichero");
        }catch (IOException e){
            System.out.println("Error E/S");
        }
    }


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
