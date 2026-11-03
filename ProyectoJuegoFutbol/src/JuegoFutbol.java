/*
 Fecha: 15/10/2026
 Autor: AMLosa
 Descripción: Readme.md
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class JuegoFutbol {
    public static void main(String[] args) throws IOException {
        //Declaramos las constantes para poder ponerle colores.
        final String RESTABLECER = "\u001B[0m";
        final String CIAN = "\u001B[36m";
        final String VERDE = "\u001B[32m";
        final String AMARILLO = "\u001B[33m";
        final String ROJO = "\u001B[31m";
        
        //Declaramos las variables para recoger los datos del usuario.
        String preguntaTirar;
        String posicionTiro;
        boolean posicionValida;
        String [] posiciones = {"izquierda", "derecha", "centro"};
        int opcionMenu;
        int partidasJugadas;
        String compraTienda;

        // Declaramos las variables para que siempre la respuesta del usuario sean minusculas y no haya problemas

        String preguntaTirarMinus;

        // Declaramos las variables para el dinero recaudado 

        final int PREMIO_GOL = 100;
        final int BONUS_PERFECTO = 500;
        int dineroTotal;
        int dineroRonda;

        // Declaramos las variables de la tienda

        int pocionTiro;
        int pocionEnergia;
        String opcionTienda;
        boolean compraValida;
        
        //Declaramos las variables para las estadisticas.
        int goles;
        int paradas;
        int tiroIzquierda;                     
        int tiroDerecha;
        int tiroCentro;
        int totalTiros;
        int energia;
        energia = 100;
        pocionEnergia = 0;
        pocionTiro = 0;

        final int TIROS = 5;

        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

        // Empieza el juego y muestra un menu.

        System.out.println(CIAN + "-------------------------------------");
        System.out.println("|           PENALTY FOOTBALL        |");
        System.out.println("-------------------------------------"+ RESTABLECER);

        partidasJugadas = 0; // Inicializamos la variable para que nos de un mensaje de despedida u otro
        dineroTotal = 0;
        dineroRonda = 0;

        do {
            System.out.println(CIAN + "------------------------------------------------");
            System.out.println("|               1. INICIAR JUEGO               |");
            System.out.println("|                 2. DESCANSAR                 |");
            System.out.println("|               3. VER ESTADISTICAS            |");
            System.out.println("|               4. ENTRAR TIENDA               |");
            System.out.println("|                   5. SALIR                   |");
            System.out.println("------------------------------------------------" + RESTABLECER);
            System.out.print("Introduce una opcion del menu (1-5): ");
            opcionMenu = Integer.parseInt(lector.readLine());

            // Validamos las opciones del menú
            switch (opcionMenu) {
                case 1:
                    if (energia <= 10) {
                        System.out.println("Has querido entrar a jugar pero tu jugador tiene menos de 10 de energía. \nPuedes ponerte a descansar desde el menú.");
                    } else {
                        partidasJugadas++;
                        System.out.println(VERDE + "Has empezado a jugar, tienes 5 tiros, puedes elegir entre tirar a la izquierda, centro o derecha."+ RESTABLECER);

                        //Variable para que el portero pueda elegir una opcion automaticamente.

                        Random aleatorio = new Random();

                        //Inicializamos todas las variables de estadisticas.

                        goles = 0;
                        paradas = 0;
                        tiroIzquierda = 0;
                        tiroDerecha = 0;
                        tiroCentro = 0;
                        totalTiros = 0;
                        
                    

                        energia = energia - 10;
                        for (int contador = 0; contador < TIROS; contador++){
                        do {
                            System.out.print("Elige la posicion donde quieres tirar el penalti: ");
                            preguntaTirar = lector.readLine();
                            preguntaTirarMinus = preguntaTirar.toLowerCase().trim();

                            posicionValida = preguntaTirarMinus.equals("izquierda") || preguntaTirarMinus.equals("centro") || preguntaTirarMinus.equals("derecha");

                            if (!posicionValida){
                                System.out.println(ROJO + "\nPosicion incorrecta, vuelve a intentarlo\n" + RESTABLECER);
                            }
                            
                        } while (!posicionValida);

                            if ("izquierda".equals(preguntaTirarMinus)) {
                                tiroIzquierda++;

                            } else if ("derecha".equals(preguntaTirarMinus)) {
                                tiroDerecha++;

                            } else {
                                tiroCentro++;
                            }

                            posicionTiro = posiciones[aleatorio.nextInt(posiciones.length)];
                            System.out.println("El portero se tira a " + posicionTiro);
                            totalTiros++;


                            if (preguntaTirarMinus.equals(posicionTiro)){
                                System.out.println(ROJO + "FALLOO ¡El portero ha conseguido parar el penalti!" + RESTABLECER);
                                paradas++;
                            
                            } else {
                                System.out.println(VERDE + "¡GOOOOOOOOL!" + RESTABLECER);
                                goles++;
                            }

                        }

                        dineroRonda = goles * PREMIO_GOL;

                        if (goles == TIROS) {
                            dineroRonda += BONUS_PERFECTO;
                            System.out.println(AMARILLO + "¡¡PARTIDO PERFECTO!! Has metido los " + TIROS + " penaltis, bonus de " + BONUS_PERFECTO + " euros " + RESTABLECER);
                        }

                        dineroTotal += dineroRonda;

                        System.out.println(CIAN + "---------------------------------------------");
                        System.out.println("|               ESTADÍSTICAS                |");
                        System.out.println("---------------------------------------------" + RESTABLECER);
                        System.out.println(AMARILLO +"| Has realizado un total de  " + totalTiros + " tiros        |");
                        System.out.printf(AMARILLO + "| Has conseguido meter %d goles.             |%n| El portero te ha conseguido parar %d tiros |%n", goles, paradas);
                        System.out.println("| Dinero ganado en esta ronda: " + dineroRonda + "€         |");
                        System.out.println("| Dinero total acumulado: " + dineroTotal + "€              |");
                        System.out.println("| Total energía " + energia + "                          |");
                        System.out.println("| Total pociones tiro " + pocionTiro + "                     |");
                        System.out.println("| Total pociones energía " + pocionEnergia + "                  |");
                        System.out.println("| Tiros por el lado izquierdo: " + tiroIzquierda + "            |");
                        System.out.println("| Tiros por el lado derecho: " + tiroDerecha + "              |");
                        System.out.println("| Tiros por el centro: " + tiroCentro + "                    |" + RESTABLECER);

                    }
                    break;
            
                case 2:
                    if (energia >= 100){
                        System.out.println(ROJO + "Tienes el maximo de energía. No necesitas descansar más.\n" + RESTABLECER);
                    } else {
                        energia = energia + 10;
                        System.out.println(VERDE + "Has decidido descansar esta ronda para ganar energía. Has conseguido 10 puntos más de energía. Ahora tienes: " + energia + RESTABLECER);
                    }
                    break;

                case 3:
                    if (partidasJugadas > 0){
                        System.out.println("Has decidido ver las estadisticas de la partida.");
                        System.out.println(AMARILLO + "| Dinero ganado en esta ronda: " + dineroRonda + "€         |");
                        System.out.println("| Dinero total acumulado: " + dineroTotal + "€              |");
                        System.out.println("| Total energía " + energia + "                          |");
                        System.out.println("| Total pociones tiro " + pocionTiro + "                    |");
                        System.out.println("| Total pociones energía " + pocionEnergia + "                 |" + RESTABLECER);
                    } else {
                        System.out.println("Todavia no has realizado ninguna tanda de penaltis. No tienes estadísticas que mostrar.\n");
                    }
                    break;
                
                case 4:
                    if (partidasJugadas > 0){
                        System.out.println("Has entrado a la tienda, puedes comprar (Poción Tiro, Poción Energía).");
                        do {
                            compraValida = false;
                            do {
                                System.out.print("Elige el producto que quieres comprar (tiro, energía): ");
                                compraTienda = lector.readLine().trim().toLowerCase();
                                if ("tiro".equals(compraTienda)){
                                    pocionTiro++;
                                    compraValida = true;
                                    System.out.println("Has comprado una poción de tiro.");

                                } else if ("energia".equals(compraTienda)){
                                    pocionEnergia++;
                                    compraValida = true;
                                    System.out.println("Has comprado una poción de energía.");

                                } else {
                                    System.out.println(ROJO + "No has elegido una opcion valida, intentalo de nuevo. (tiro, energia)" + RESTABLECER);
                                }
                                
                            } while (!compraValida);
                            
                            do {
                                System.out.print("¿Quiéres seguir comprando en la tienda? (s, n) ");
                                opcionTienda = lector.readLine().trim().toLowerCase();

                                if (!"s".equals(opcionTienda) && !"n".equals(opcionTienda)){
                                    System.out.println(ROJO + "Opcion no válida, responde s o n" + RESTABLECER);
                                }

                            } while (!"s".equals(opcionTienda) && !"n".equals(opcionTienda));
                        } while ("s".equals(opcionTienda));

                        System.out.println("Has salido de la tienda. ¡Hasta pronto!");
                    } else {
                        System.out.println(ROJO + "Todavia no has jugado ninguna vez, para entrar a la tienda tienes que jugar al menos 1 vez." + RESTABLECER);
                    }
                    break;

                case 5:
                    if (partidasJugadas > 0){
                        System.out.println(ROJO + "Has decidido dejar de jugar, gracias por jugar. Te llevas " + dineroTotal + " euros. ¡Hasta pronto!" + RESTABLECER);

                    } else {  
                        System.out.println(ROJO + "Has decidido salir del juego, hasta pronto" + RESTABLECER);

                    }
                    break;

                default:
                    System.out.println(ROJO + "Has introducido una opción no válida, elige una opcion entre 1-5." + RESTABLECER);
                    break;
                }
        
        } while (opcionMenu!=5);

    }

}