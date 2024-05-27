package Proyecto;

import java.util.Scanner;

public class JuegoDificil implements JuegoCartas{
    private char[] tablero;
    private char[] tableroOculto;
    private int paresEncontrados;
    private int numIntentos;
    private int maxParesEncontrados;
    private String dificultad="DIFÍCIL";

    public JuegoDificil()
    {
        this.tablero = new char[]{'1', '1', '2', '2', '3', '3','4','4','5','5','6','6','7','7'};//los números representan las cartas
        this.tableroOculto = new char[]{'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ', 'ɯ'};//las Ms invertidas representan las cartas volteadas que aún no han sido emparejadas.
        this.paresEncontrados = 0;
        this.numIntentos=0;
        this.maxParesEncontrados=7;
    }
    @Override
    public int getNumIntentos()
    {
        return numIntentos;
    }

    public String getDificultad() {return dificultad; }
    @Override
    public void jugar()
    {
        randomizarTablero(tablero);
        while (paresEncontrados < maxParesEncontrados)
        {
            mostrarTablero();
            int primeraCarta = seleccionarCarta();
            revelarCarta(primeraCarta);
            int segundaCarta = seleccionarCarta();
            revelarCarta(segundaCarta);
            if (tablero[primeraCarta] == tablero[segundaCarta]) {
                System.out.println("¡Encontraste una pareja!");
                tableroOculto[primeraCarta] = tablero[primeraCarta];
                tableroOculto[segundaCarta] = tablero[segundaCarta];
                paresEncontrados++;
            } else {
                System.out.println("No es una pareja. Intenta de nuevo.");
            }
            numIntentos++;
        }
        System.out.println("¡Felicidades, has ganado con un total de " + numIntentos + " intentos!");
    }
    @Override
    public void mostrarTablero()
    {
        System.out.println("----------------------------");
        for (int i = 0; i < tableroOculto.length; i++) {
            System.out.print("| " + tableroOculto[i] + " ");
            if ((i + 1) % 7 == 0) {
                System.out.println("|");
                System.out.println("----------------------------");
            }
        }
    }
    @Override
    public int seleccionarCarta() {
        int carta;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.print("Ingresa el número de carta (1-14): ");
            carta = sc.nextInt()-1;
        } while (carta < 0 || carta > 13 || tableroOculto[carta] != 'ɯ');
        return carta;
    }
    @Override
    public void revelarCarta(int carta)
    {
        System.out.println("----------------------------");
        for (int i = 0; i < tableroOculto.length; i++) {
            if(i==carta) {
                System.out.print("| " + tablero[i] + " ");
            }
            else{
                System.out.print("| " + tableroOculto[i] + " ");
            }
            if ((i + 1) % 7 == 0) {
                System.out.println("|");
                System.out.println("----------------------------");
            }
        }
    }

    @Override
    public void randomizarTablero(char[] tablero) {
        JuegoCartas.super.randomizarTablero(tablero);
    }
}
