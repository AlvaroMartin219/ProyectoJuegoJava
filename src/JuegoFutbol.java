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
        String direccionJugador;
        String direccionPortero;
        boolean posicionValida;
        String [] posiciones = {"izquierda", "derecha", "centro"};
        int opcionMenu;
        int partidasJugadas;
        String compraTienda;

        // Declaramos las variables para que siempre la respuesta del usuario sean minusculas y no haya problemas

        String direccionNormalizada;

        // Declaramos las variables para el dinero recaudado 

        final int PREMIO_GOL = 100;
        final int BONUS_PERFECTO = 500;
        final int PENALIZACION_FALLO = 50;
        int ganancias;
        int perdidas;
        int dineroTotal;
        int dineroRonda;

        // Declaramos las variables de la tienda

        int pocionTiro;
        int pocionEnergia;
        String opcionTienda;
        boolean compraValida;
        final int COSTE_POCION_ENERGIA = 100;
        final int COSTE_POCION_TIRO = 100;
        
        //Declaramos las variables para las estadisticas.
        int goles;
        int paradas;
        int tiroIzquierda;                     
        int tiroDerecha;
        int tiroCentro;
        int totalTirosRonda;
        int totalTirosGlobal;
        int totalGolesGlobal;
        int totalTirosIzquierda;
        int totalTirosCentro;
        int totalTirosDerecha;
        int totalParadas;
        

        // Inicializamos las variables para dar las estadisticas de todas las partidas
        totalTirosGlobal = 0;
        totalParadas = 0;
        totalGolesGlobal = 0;
        totalTirosIzquierda = 0;
        totalTirosCentro = 0;
        totalTirosDerecha = 0;
        
        int energia;
        final int ENERGIA_MAX = 100;
        final int COSTE_ENERGIA = 10;
        final int RECUPERACION_DESCANSO = 10;
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
        ganancias = 0;
        perdidas = 0;

        // MENU PRINCIPAL
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
                    // INICIAMOS JUEGO
                    if (energia < 10) {
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
                        totalTirosRonda = 0;
                                               
                    
                        // QUITAMOS EL COSTE DE ENERGIA PARA QUE VAYA CANSANDOSE EL JUGADOR
                        energia-=COSTE_ENERGIA;

                        // EJECUCION DE LA TANDA
                        for (int contador = 0; contador < TIROS; contador++){
                        do {
                            System.out.print("Elige la posicion donde quieres tirar el penalti: ");
                            direccionJugador = lector.readLine();
                            direccionNormalizada = direccionJugador.toLowerCase().trim();

                            posicionValida = false;
                            int i = 0;
                            while (i < posiciones.length && !posicionValida) {
                                if (direccionNormalizada.equals(posiciones[i])){
                                    posicionValida = true;
                                }
                                i++;
                            }
                            

                            if (!posicionValida){
                                System.out.println(ROJO + "\nPosicion incorrecta, vuelve a intentarlo\n" + RESTABLECER);
                            }
                            
                        } while (!posicionValida);

                            if ("izquierda".equals(direccionNormalizada)) {
                                tiroIzquierda++;
                                totalTirosIzquierda++;


                            } else if ("derecha".equals(direccionNormalizada)) {
                                tiroDerecha++;
                                totalTirosDerecha++;

                            } else {
                                tiroCentro++;
                                totalTirosCentro++;
                            }

                            direccionPortero = posiciones[aleatorio.nextInt(posiciones.length)];
                            System.out.println("El portero se tira a " + direccionPortero);
                            totalTirosRonda++;
                            totalTirosGlobal++;


                            if (direccionNormalizada.equals(direccionPortero)){
                                System.out.println(ROJO + "FALLOO ¡El portero ha conseguido parar el penalti!" + RESTABLECER);
                                paradas++;
                                totalParadas++;

                                
                            
                            } else {
                                System.out.println(VERDE + "¡GOOOOOOOOL!" + RESTABLECER);
                                goles++;
                                totalGolesGlobal++;
                                
                                
                            }

                        }

                        ganancias = goles * PREMIO_GOL;
                        perdidas = paradas * PENALIZACION_FALLO;
                        dineroRonda = ganancias - perdidas;


                        if (goles == TIROS) {
                            dineroRonda += BONUS_PERFECTO;
                            System.out.println(AMARILLO + "¡¡PARTIDO PERFECTO!! Has metido los " + TIROS + " penaltis, bonus de " + BONUS_PERFECTO + " euros " + RESTABLECER);
                        }

                        dineroTotal += dineroRonda;
                        if (dineroTotal < 0){
                            dineroTotal = 0;
                        }

                        // ESTADÍSTICAS DE LA RONDA
                        System.out.println(CIAN + "---------------------------------------------");
                        System.out.println("|               ESTADÍSTICAS                |");
                        System.out.println("---------------------------------------------" + RESTABLECER);
                        
                        // Activamos el color amarillo para todo el bloque de datos
                        System.out.print(AMARILLO);
                        
                        // %-30s alinea el texto a la izquierda reservando 30 caracteres
                        // %10d o %9d alinea el número a la derecha reservando 10 o 9 caracteres
                        System.out.printf("| %-30s %10d |%n", "Tiros realizados:", totalTirosRonda);
                        System.out.printf("| %-30s %10d |%n", "Goles marcados:", goles);
                        System.out.printf("| %-30s %10d |%n", "Paradas del portero:", paradas);
                        System.out.printf("| %-28s %9dEUR |%n", "Dinero ganado en esta ronda:", dineroRonda);
                        System.out.printf("| %-28s %9dEUR |%n", "Dinero total acumulado:", dineroTotal);
                        System.out.printf("| %-30s %10d |%n", "Total energía:", energia);
                        System.out.printf("| %-30s %10d |%n", "Total pociones tiro:", pocionTiro);
                        System.out.printf("| %-30s %10d |%n", "Total pociones energía:", pocionEnergia);
                        System.out.printf("| %-30s %10d |%n", "Tiros por el lado izquierdo:", tiroIzquierda);
                        System.out.printf("| %-30s %10d |%n", "Tiros por el lado derecho:", tiroDerecha);
                        System.out.printf("| %-30s %10d |%n", "Tiros por el centro:", tiroCentro);
                        
                        // Restablecemos el color al final de los datos
                        System.out.print(RESTABLECER);
                
                    }
                    break;
            
                case 2:
                    // DESCANSAMOS
                    if (partidasJugadas > 0){
                        if (energia >= ENERGIA_MAX){
                            System.out.println(ROJO + "Tienes el maximo de energía. No necesitas descansar más.\n" + RESTABLECER);
                        } else {
                            energia = energia + RECUPERACION_DESCANSO;
                            System.out.println(VERDE + "Has decidido descansar esta ronda para ganar energía. Has conseguido 10 puntos más de energía. Ahora tienes: " + energia + RESTABLECER);
                        }
                    } else {
                        System.out.println(ROJO + "Todavía no has jugado ninguna vez, para descansar tienes que jugar al menos 1 vez" + RESTABLECER);
                    }
                    break;

                case 3:
                    // ESTADISTICAS GLOBALES 
                        if (partidasJugadas > 0){
                            System.out.println("Has decidido ver las estadisticas de la partida.");
                        
                            System.out.println(CIAN + "-------------------------------------------------");
                            System.out.println("|             ESTADÍSTICAS GLOBALES             |");
                            System.out.println("-------------------------------------------------" + RESTABLECER);
                        
                            // Activamos el color amarillo para todo el bloque de datos
                            System.out.print(AMARILLO); 
                        
                            // %-35s alinea el texto a la izquierda reservando 35 caracteres
                            // %8d o %9d alinea el número a la derecha reservando 8 o 9 caracteres
                            System.out.printf("| %-33s %8dEUR |%n", "Dinero ganado en la ultima ronda:", dineroRonda);
                            System.out.printf("| %-33s %8dEUR |%n", "Dinero total acumulado:", dineroTotal);
                            System.out.printf("| %-35s %9d |%n", "Total energía:", energia);
                            System.out.printf("| %-35s %9d |%n", "Total pociones de tiro:", pocionTiro);
                            System.out.printf("| %-35s %9d |%n", "Total pociones de energía:", pocionEnergia);
                            System.out.printf("| %-35s %9d |%n", "Tiros totales realizados:", totalTirosGlobal);
                            System.out.printf("| %-35s %9d |%n", "Goles totales marcados:", totalGolesGlobal);
                            System.out.printf("| %-35s %9d |%n", "Paradas totales del portero:", totalParadas);
                            System.out.printf("| %-35s %9d |%n", "Tiros por el lado izquierdo:", totalTirosIzquierda);
                            System.out.printf("| %-35s %9d |%n", "Tiros por el lado derecho:", totalTirosDerecha);
                            System.out.printf("| %-35s %9d |%n", "Tiros por el centro:", totalTirosCentro);
                        
                            // Restablecemos el color al final de los datos
                            System.out.print(RESTABLECER); 
                    

                    } else {
                        System.out.println("Todavia no has realizado ninguna tanda de penaltis. No tienes estadísticas que mostrar.\n");
                    }
                    break;
                
                case 4:
                    // TIENDA 
                    if (partidasJugadas > 0){
                        System.out.println(CIAN + "Has entrado a la tienda, puedes comprar (Poción Tiro, Poción Energia)." + RESTABLECER);
                        do {
                            compraValida = false;
                            do {
                                System.out.print("Elige el producto que quieres comprar (tiro, energia(sin tilde)): ");
                                compraTienda = lector.readLine().trim().toLowerCase();
                                if ("tiro".equals(compraTienda)){
                                    if (dineroTotal >= COSTE_POCION_TIRO){
                                        pocionTiro++;
                                        dineroTotal-=COSTE_POCION_TIRO;
                                        System.out.println(VERDE + "Has comprado una poción de tiro." + RESTABLECER);
                                        compraValida = true;
                                    } else {
                                        System.out.println(ROJO + "No tienes suficiente dinero para comprar esta poción" + RESTABLECER);
                                        compraValida = true;
                                    }
                                    

                                } else if ("energia".equals(compraTienda)){
                                    if (dineroTotal >= COSTE_POCION_ENERGIA){
                                        dineroTotal-=COSTE_POCION_ENERGIA;
                                        pocionEnergia++;
                                        System.out.println(VERDE + "Has comprado una poción de energía." + RESTABLECER);
                                        compraValida = true;
                                    } else {
                                        System.out.println(ROJO + "No tienes suficiente dinero para comprar esta poción" + RESTABLECER);
                                        compraValida = true;
                                    }

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
                    // FIN DEL JUEGO
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