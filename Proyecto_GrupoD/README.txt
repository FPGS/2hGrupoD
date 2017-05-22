Queremos desarrollar una variante del juego de la vida con las siguientes reglas:.
• El tablero de juego tendrá unas dimensiones fijas de 30x30.
• Habrá 2 tipos de células (cian y naranja).
• Cuando cambiamos de turno, hay que recalcular las células vivas y las que mueren (y por tanto desaparecen del tablero) sabiendo lo siguiente:
o Una célula viva con 2 ó 3 células vecinas vivas (de cualquier tipo) sigue viva en el siguiente turno.
o En una casilla vacía con exactamente 3 células vecinas vivas (de cualquier tipo), nacerá una nueva célula en el siguiente turno.
? El tipo de la célula que nazca dependerá de sus vecinas justo antes de nacer.
? Si tiene 2 ó 3 vecinas cian la nueva célula será cian, en otro caso será naranja.
o En cualquier otro caso la célula muere y desaparece en el siguiente turno (por "soledad", si tiene 0-1 vecinos, o por "superpoblación", si tiene 4-8 vecinos).
• Mientras haya alguna célula viva, el juego tendrá que mostrar un nuevo turno por pantalla cada segundo. Si no quedan células vivas en el tablero o han pasado 1000 turnos, el juego terminará.
Como puede observarse, la evolución de este juego está determinada por el estado inicial y no necesita ninguna entrada de datos posterior.
• La configuración inicial se podrá proporcionar de tres formas, que se detallan a continuación. Para determinar de qué forma se proporcionará, el programa debe mostrar al usuario un menú con las tres opciones, y el usuario elegir la opción preferida introduciéndola por teclado. Las tres formas son:
o Pidiéndole al usuario que introduzca a través del teclado las posiciones que contienen células cian y naranja.
Por ejemplo:
“Introduzca las posiciones con células vivas. El formato será: (fila, columna, valor). Valor será C para cian o N para naranja. Ejemplo: (2,7,C). La secuencia termina con un 0.”
o A través de un fichero de texto con extensión .mat que contendrá el valor de cada posición del tablero por filas. Se usará ‘C’ para cian, ‘N’ para naranja y ‘X’ para una posición vacía. En
Prácticas de Informática. Grado en Ingeniería Eléctrica
Departamento de Informática e Ingeniería de Sistemas 2
este caso el programa pedirá al usuario el nombre del fichero con extensión .mat donde se encuentra la configuración deseada.
Por ejemplo:
XXXCCCNNXXXXXCCCNNXXXXXCCCNNXX
XXXXCXXXXXXXXXCXXXXXXXXXCXXXXX
XXCXXXXXXXXXXXCXXXXXXXXXCXXXXX
etc.
o A través de un fichero de texto con extensión .lst que contendrá las posiciones que tienen células cian y naranja (por ejemplo: 2 7 C , quiere decir que en la fila 2 columna 7 hay una célula cian). Habrá una posición por fila. En este caso el programa pedirá al usuario el nombre del fichero con extensión .lst donde se encuentra la configuración deseada.
Por ejemplo:
7 3 C
9 6 C
1 1 N
Un ejemplo de configuración inicial que podéis usar es el siguiente: todas las células muertas excepto las del siguiente patrón (la célula naranja de la segunda fila en la componente 14,14):