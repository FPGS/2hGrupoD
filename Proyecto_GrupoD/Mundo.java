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

    public void estadoPosicionSiguiente(){
        for(int x=0; x<30; x++){
            for(int y=0; y<30; y++){
                if(x==0&&y==0){
                    if(tablero[0][0]=='C' || tablero[0][0]=='N'){
                        if(numeroVivasAlrededor(0,0)<=1){
                            tablero[x][y]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(0,0)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[1][1]=='C'){
                                cian++;
                            }
                            if(tablero[1][0]=='C'){
                                cian++;
                            }
                            if(tablero[0][1]=='C'){
                                cian++;
                            }

                            if(tablero[1][1]=='N'){
                                naranja++;
                            }
                            if(tablero[0][1]=='N'){
                                naranja++;
                            }
                            if(tablero[1][0]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[0][0]='N';
                            } else {
                                tablero[0][0]='C';
                            }

                        }
                    }
                } else if(x==0&&y==29){
                    if(tablero[0][29]=='C' || tablero[0][29]=='N'){
                        if(numeroVivasAlrededor(0,29)<=1){
                            tablero[y][x]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(29,0)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[0][28]=='C'){
                                cian++;
                            }
                            if(tablero[1][29]=='C'){
                                cian++;
                            }
                            if(tablero[1][28]=='C'){
                                cian++;
                            }

                            if(tablero[0][28]=='N'){
                                naranja++;
                            }
                            if(tablero[1][29]=='N'){
                                naranja++;
                            }
                            if(tablero[1][28]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[0][29]='N';
                            } else {
                                tablero[0][29]='C';
                            }

                        }
                    }
                }else if(y==29&&x==29){
                    if(tablero[29][29]=='C' || tablero[29][29]=='N'){
                        if(numeroVivasAlrededor(29,29)<=1){
                            tablero[29][29]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(29,29)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[28][28]=='C'){
                                cian++;
                            }
                            if(tablero[28][29]=='C'){
                                cian++;
                            }
                            if(tablero[29][28]=='C'){
                                cian++;
                            }

                            if(tablero[28][28]=='N'){
                                naranja++;
                            }
                            if(tablero[28][29]=='N'){
                                naranja++;
                            }
                            if(tablero[29][28]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[29][29]='N';
                            } else {
                                tablero[29][29]='C';
                            }

                        }
                    }
                }else if(x==29&&y==0){
                    if(tablero[29][0]=='C' || tablero[29][0]=='N'){
                        if(numeroVivasAlrededor(29,0)<=1){
                            tablero[29][0]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(29,0)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[28][0]=='C'){
                                cian++;
                            }
                            if(tablero[28][1]=='C'){
                                cian++;
                            }
                            if(tablero[29][1]=='C'){
                                cian++;
                            }

                            if(tablero[28][0]=='N'){
                                naranja++;
                            }
                            if(tablero[28][1]=='N'){
                                naranja++;
                            }
                            if(tablero[29][1]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[29][0]='N';
                            } else {
                                tablero[29][0]='C';
                            }

                        }
                    }
                }else if(y==0){
                    if(tablero[x][0]=='C' || tablero[x][0]=='N'){
                        if(numeroVivasAlrededor(x,0)<=1 || numeroVivasAlrededor(x,0)>=4){
                            tablero[x][0]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(x,0)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[x-1][0]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][0]=='C'){
                                cian++;
                            }
                            if(tablero[x][1]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][1]=='C'){
                                cian++;
                            }
                            if(tablero[x-1][1]=='C'){
                                cian++;
                            }

                            if(tablero[x-1][0]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][0]=='N'){
                                naranja++;
                            }
                            if(tablero[x-1][1]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][1]=='N'){
                                naranja++;
                            }
                            if(tablero[x][1]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[x][0]='N';
                            } else {
                                tablero[x][0]='C';
                            }
                        }
                    }
                }else if(y==29){
                    if(tablero[x][29]=='C' || tablero[x][29]=='N'){
                        if(numeroVivasAlrededor(x,29)<=1 || numeroVivasAlrededor(x,29)>=4){
                            tablero[x][29]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(x,29)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[x-1][29]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][29]=='C'){
                                cian++;
                            }
                            if(tablero[x][28]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][28]=='C'){
                                cian++;
                            }
                            if(tablero[x-1][28]=='C'){
                                cian++;
                            }

                            if(tablero[x-1][29]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][29]=='N'){
                                naranja++;
                            }
                            if(tablero[x-1][28]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][28]=='N'){
                                naranja++;
                            }
                            if(tablero[x][28]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[x][29]='N';
                            } else {
                                tablero[x][29]='C';
                            }
                        }
                    }
                }else if(x==0){
                    if(tablero[0][y]=='C' || tablero[0][y]=='N'){
                        if(numeroVivasAlrededor(0,y)<=1 || numeroVivasAlrededor(0,y)>=4){
                            tablero[0][y]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(0,y)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[0][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[0][y+1]=='C'){
                                cian++;
                            }
                            if(tablero[1][y+1]=='C'){
                                cian++;
                            }
                            if(tablero[1][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[1][y]=='C'){
                                cian++;
                            }

                            if(tablero[0][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[0][y+1]=='N'){
                                naranja++;
                            }
                            if(tablero[1][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[1][y]=='N'){
                                naranja++;
                            }
                            if(tablero[1][y+1]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[0][y]='N';
                            } else {
                                tablero[0][y]='C';
                            }
                        }
                    }
                }else if(x==29){
                    if(tablero[29][y]=='C' || tablero[29][y]=='N'){
                        if(numeroVivasAlrededor(29,y)<=1 || numeroVivasAlrededor(29,y)>=4){
                            tablero[29][y]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(29,y)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[29][y+1]=='C'){
                                cian++;
                            }
                            if(tablero[29][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[28][y+1]=='C'){
                                cian++;
                            }
                            if(tablero[28][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[28][y]=='C'){
                                cian++;
                            }

                            if(tablero[29][y+1]=='N'){
                                naranja++;
                            }
                            if(tablero[29][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[28][y+1]=='N'){
                                naranja++;
                            }
                            if(tablero[28][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[28][y]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[29][y]='N';
                            } else {
                                tablero[29][y]='C';
                            }
                        }
                    }
                }else{
                    if(tablero[x][y]=='C' || tablero[x][y]=='N'){
                        if(numeroVivasAlrededor(x,y)<=1 || numeroVivasAlrededor(x,y)>=4){
                            tablero[x][y]='X';                  
                        }  
                    }else {
                        if(numeroVivasAlrededor(x,y)==3){
                            int naranja=0;
                            int cian=0;
                            if(tablero[x-1][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[x][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][y-1]=='C'){
                                cian++;
                            }
                            if(tablero[x-1][y]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][y]=='C'){
                                cian++;
                            }
                            if(tablero[x-1][y+1]=='C'){
                                cian++;
                            }
                            if(tablero[x][y+1]=='C'){
                                cian++;
                            }
                            if(tablero[x+1][y+1]=='C'){
                                cian++;
                            }

                            if(tablero[x-1][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[x][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][y-1]=='N'){
                                naranja++;
                            }
                            if(tablero[x-1][y]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][y]=='N'){
                                naranja++;
                            }
                            if(tablero[x-1][y+1]=='N'){
                                naranja++;
                            }
                            if(tablero[x][y+1]=='N'){
                                naranja++;
                            }
                            if(tablero[x+1][y+1]=='N'){
                                naranja++;
                            }

                            if(cian<naranja){
                                tablero[x][y]='N';
                            } else {
                                tablero[x][y]='C';
                            }
                        }
                    }
                }
            }
        }
    }

}
