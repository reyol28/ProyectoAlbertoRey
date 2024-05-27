# Juego de memoria de Alberto Rey

Este programa surge de la idea de hacer un juego que combine suerte y memoria. Para ello, he elegido el típico juego de memoria de levantar cartas y tratar de encontrar su pareja.

Para empezar, pensé en lo fundamental que tendría que tener el programa, que eran las reglas del juego bien definidas:
1. -El jugador elije la posición de la carta que desea levantar con el método seleccionarCarta() dos veces y se comprueba si ha encontrado una pareja. Esto se hace mediante un bucle. Todo esto va dentro de el método principal jugar().
2. -Se define cuando una partida ha terminado, que es cuando ya se hayan encontrado todas las posibles parejas. Una vez esto pase, se debe terminar el bucle y por tanto el juego. Lo he hecho con una variable que me dice cuantas parejas encontradas van (cada vez que se encuentra una se suma 1)y una constante que me dice cuantas parejas son las máximas posibles dentro de la partida.
3. Para hacer este juego necesitaria almacenar la información de las cartas en dos diferentes arrays. Uno que estuviera dado la vuelta (con la ms invertidas) que sirva para ocultar el array que contiene los números que se han de emparejar. Luego cuando se encontrase una pareja el tablero oculto pasa a ser igual que el tablero no oculto para que se vea que en esa posición 
4. Antes de nada lo primero que hay que hacer es el método mostrarTablero(), que nos permite ver como estan distribuidas las cartas. Para ello, hacemos como un array y metemos el valor del tableroOculto por cada posición y un if que indicará cuando ha llegado a la mitad de los números para que pase de línea y que quede mejor estructurado en vez de todo en una larga fila.
5. Luego hay que hacer el método de revelar carta, que es como  un mostrarTablero() pero que tiene un if más para que en la carta elegida revele la carta pero en las demás las deje ocultas. Si no existiera este método, ya no sería un juego de memoria, sino que sería un juego solamente de azar. 
6. Para acabar, hay que hacer un método que haga aleatorias las posiciones en las que salen los números para que no sean todas las partidas iguales. Con esto hacemos el método randomizarTablero(). Intente hacerlo de muchas formas, pero no me funcionaba así que tuve que buscar información sobre como hacerlo. Así, descrubrí la clase Random. Mediante el método Random.nextInt() logré hacer que funcionara.


Una vez hecho el juego,  se me ocurrió meter tres distintos niveles de dificultades, en ellos, lo único que cambiaría sería el número de parejas totales que habrían. Me decidí a poner 3 parejas en el fácil, 5 en el medio y 7 en el difícil. Para ello cree una interfaz que tuviera todos los métodos necesarios para el funcionamiento del juego, y tres clases que representen cada una un nivel de dificultad. Con esto, no solo ganaba que el juego fuera más complejo, sino que además ya podría hacer el diagrama de clases UML. Así también podría practicar la orientación a objetos.

Para finalizar, tenía que implementar las estadísticas, que lo hice con nuevos métodos como el de getDificultad() y getNumIntentos(), y luego con las clases File, Filewriter (esta tuve que buscar información) y LocalDateTime (también tuve que buscar información). Para evitar problemas, hice un try catch para que no hubieran problemas a la hora deescibir las estadísticas.

