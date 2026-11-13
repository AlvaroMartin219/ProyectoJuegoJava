## Penalty Football

Bienvenido al Proyecto de mi juego Penalty Football. Es un juego por consola, tú eliges dónde tirar y el portero se lanza
a una posición aleatoria.

Autor: AMLosa

Fecha: 15/10/2026

## Instrucciones de Compilación y Ejecución

Para poder evaluar el juego, sigue estos pasos desde la terminal ubicándote en la raíz del proyecto:

1. **Crear el directorio para los binarios (si no existe):**
mkdir bin

javac -d bin src/JuegoFutbol.java

java -cp bin JuegoFutbol

## Cómo se juega

    1. Empieza el juego con un menú en el que debes elegir una de las cinco opciones.
        1. Iniciar Juego
        2. Descansar
        3. Ver Estadísticas
        4. Entrar Tienda
        5. Salir

    2. Una vez que eliges una opción, si has elegido la opción de iniciar juego este empieza.

        2.1 Te pregunta dónde quieres tirar, tienes 3 posiciones:
            - izquierda
            - centro
            - derecha
            (No importan las mayúsculas ni los espacios sobrantes. Si escribes una posición
            incorrecta, se te vuelve a preguntar sin gastar el tiro.)

        2.2 El portero elige una posición aleatoria donde se va a intentar parar el penalti.
            - Si coincide con tu posición, para el penalti (33% de probabilidad).
            - Si no coincide, metes gol (66% de probabilidad).

        2.3 Al terminar los 5 tiros, se te muestran las estadísticas de la partida.

    3. Si has decidido entrar a descansar, te regenera 10 puntos de energía, hasta un máximo de 100.
       Empiezas el juego con 100 puntos y cada partida te quita 10 puntos de energía. Si tienes menos de 10 puntos de energía no puedes
       jugar y debes descansar. Si ya tienes la energía al máximo, el juego te avisa de que no necesitas descansar.

    4. Si has decidido entrar a ver las estadísticas, te enseña las estadísticas que se acumulan, es decir, el dinero
       ganado en la anterior ronda, el dinero total, la energía que te queda, las pociones compradas, los tiros
       realizados, los goles, las paradas y los tiros por cada lado.

    5. Si decides entrar a la tienda te da dos opciones de compra, pociones de tiro y pociones de energía.
       Cada poción cuesta 100 € y, tras cada compra, se te pregunta si quieres seguir comprando (s/n).
       Si no tienes dinero suficiente, no se realiza la compra.
       (Las pociones todavía no tienen efecto en el juego, se implementarán en la segunda evaluación.)

    6. A las opciones 2, 3 y 4 del menú solamente puedes entrar al haber jugado una ronda.
       

    7. Si eliges la opción 5, el juego termina y se muestra el dinero total acumulado durante la sesión.

## Economía del juego
    - Cada gol anotado otorga 100 €.
    - Si metes los 5 goles de la tanda (partido perfecto), recibes un bonus de 500 € adicionales.
    - Cada tiro parado por el portero te quita 50 € (nunca te quedas con dinero negativo, el mínimo es 0 €).
    - Cada poción (tiro o energía) cuesta 100 €.

## Estadísticas
    - Total tiros realizados
    - Total goles metidos
    - Total paradas del portero
    - Tiros por la izquierda, centro y derecha
    - Dinero ganado en la ronda
    - Dinero acumulado
    - Energía
    - Total pociones tiro y energía

## Estructura del Proyecto

El proyecto contiene dos carpetas, bin y src.:

├── src/    → Código fuente (JuegoFutbol.java)

├── bin/    → Archivos compilados (se generan automáticamente)

└── README.md

### ¡Gracias por probar mi juego! Cualquier sugerencia es bienvenida.
