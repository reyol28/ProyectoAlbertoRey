package Proyecto;

import java.util.Random;

public interface JuegoCartas {
    void jugar();
    void mostrarTablero();
    int seleccionarCarta();
    void revelarCarta(int carta);
    default void randomizarTablero(char[] tablero){
        Random random = new Random();//creo un objeto random para que me de un número aleatorio con el metodo random.nextInt

        for (int i = tablero.length - 1; i > 0; i--) {
            int posicionAleatoria = random.nextInt(i + 1);
            // intercambio el elemento en la posición i con el elemento en la posicionAleatoria
            char temp = tablero[posicionAleatoria];
            tablero[posicionAleatoria] = tablero[i];
            tablero[i] = temp;
        }
    }
    int getNumIntentos();
    String getDificultad();

}


