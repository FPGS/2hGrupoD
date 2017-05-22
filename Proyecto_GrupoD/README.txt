Queremos desarrollar una variante del juego de la vida con las siguientes reglas:.
� El tablero de juego tendr� unas dimensiones fijas de 30x30.
� Habr� 2 tipos de c�lulas (cian y naranja).
� Cuando cambiamos de turno, hay que recalcular las c�lulas vivas y las que mueren (y por tanto desaparecen del tablero) sabiendo lo siguiente:
o Una c�lula viva con 2 � 3 c�lulas vecinas vivas (de cualquier tipo) sigue viva en el siguiente turno.
o En una casilla vac�a con exactamente 3 c�lulas vecinas vivas (de cualquier tipo), nacer� una nueva c�lula en el siguiente turno.
? El tipo de la c�lula que nazca depender� de sus vecinas justo antes de nacer.
? Si tiene 2 � 3 vecinas cian la nueva c�lula ser� cian, en otro caso ser� naranja.
o En cualquier otro caso la c�lula muere y desaparece en el siguiente turno (por "soledad", si tiene 0-1 vecinos, o por "superpoblaci�n", si tiene 4-8 vecinos).
� Mientras haya alguna c�lula viva, el juego tendr� que mostrar un nuevo turno por pantalla cada segundo. Si no quedan c�lulas vivas en el tablero o han pasado 1000 turnos, el juego terminar�.
Como puede observarse, la evoluci�n de este juego est� determinada por el estado inicial y no necesita ninguna entrada de datos posterior.
� La configuraci�n inicial se podr� proporcionar de tres formas, que se detallan a continuaci�n. Para determinar de qu� forma se proporcionar�, el programa debe mostrar al usuario un men� con las tres opciones, y el usuario elegir la opci�n preferida introduci�ndola por teclado. Las tres formas son:
o Pidi�ndole al usuario que introduzca a trav�s del teclado las posiciones que contienen c�lulas cian y naranja.
Por ejemplo:
�Introduzca las posiciones con c�lulas vivas. El formato ser�: (fila, columna, valor). Valor ser� C para cian o N para naranja. Ejemplo: (2,7,C). La secuencia termina con un 0.�
o A trav�s de un fichero de texto con extensi�n .mat que contendr� el valor de cada posici�n del tablero por filas. Se usar� �C� para cian, �N� para naranja y �X� para una posici�n vac�a. En
Pr�cticas de Inform�tica. Grado en Ingenier�a El�ctrica
Departamento de Inform�tica e Ingenier�a de Sistemas 2
este caso el programa pedir� al usuario el nombre del fichero con extensi�n .mat donde se encuentra la configuraci�n deseada.
Por ejemplo:
XXXCCCNNXXXXXCCCNNXXXXXCCCNNXX
XXXXCXXXXXXXXXCXXXXXXXXXCXXXXX
XXCXXXXXXXXXXXCXXXXXXXXXCXXXXX
etc.
o A trav�s de un fichero de texto con extensi�n .lst que contendr� las posiciones que tienen c�lulas cian y naranja (por ejemplo: 2 7 C , quiere decir que en la fila 2 columna 7 hay una c�lula cian). Habr� una posici�n por fila. En este caso el programa pedir� al usuario el nombre del fichero con extensi�n .lst donde se encuentra la configuraci�n deseada.
Por ejemplo:
7 3 C
9 6 C
1 1 N
Un ejemplo de configuraci�n inicial que pod�is usar es el siguiente: todas las c�lulas muertas excepto las del siguiente patr�n (la c�lula naranja de la segunda fila en la componente 14,14):