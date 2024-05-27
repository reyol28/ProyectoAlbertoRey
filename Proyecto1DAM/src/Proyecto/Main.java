package Proyecto;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce tu nick (nickname):");
        String nick=sc.next();
        int numIntentos=0;
        String dificultad="";
        System.out.println("Introduce ahora el número de dificultad que quieres jugar.\n1-Fácil.\n2-Medio.\n3-Difícil");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                JuegoFacil juegoFacil=new JuegoFacil();
                juegoFacil.jugar();
                numIntentos= juegoFacil.getNumIntentos();
                dificultad= juegoFacil.getDificultad();
                break;
            case 2:
                JuegoMedio juegoMedio=new JuegoMedio();
                juegoMedio.jugar();
                numIntentos= juegoMedio.getNumIntentos();
                dificultad= juegoMedio.getDificultad();
                break;
            case 3:
                JuegoDificil juegoDificil=new JuegoDificil();
                juegoDificil.jugar();
                numIntentos= juegoDificil.getNumIntentos();
                dificultad= juegoDificil.getDificultad();
                break;
            default:
                System.out.println("No has introducido un número de dificultad válido.");
                break;
        }


        LocalDateTime fecha= LocalDateTime.now();

        try
        {
            File archivo=new File("Estadisticas.txt");
            //FileWriter nos ayuda a escribir dentro de un archivo.
            FileWriter escribir=new FileWriter(archivo,true);
            escribir.write("Partida. \n-Nickname: "+nick+"\n-Dificultad: "+dificultad+"\n-Fecha: "+fecha+"\n-Número de intentos: "+numIntentos+"\n");// el último \n se pone para quue la próxima vez que se escriba se haga en una nueva línea.
            escribir.close();
        }
        catch(Exception e)
        {
            System.out.println("Error al escribir");
        }

    }
}


