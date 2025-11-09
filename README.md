-> Emparejador de Equipos Aleatorio (TAREA 3 POO)
Aplicación de escritorio desarrollada en Java con Swing que implementa un sistema de sorteo aleatorio para ligas profesionales de fútbol, 
cumpliendo con los requisitos de la programación orientada a objetos (POO) y el uso obligatorio de recursividad para la lógica de emparejamiento.

-> Tecnologías y Conceptos
Lenguaje: Java

Interfaz Gráfica (GUI): Swing (AWT)

Paradigma Principal: Programación Orientada a Objetos (POO)

Concepto Clave Implementado: Recursividad para la función de sorteo.

Manejo de Errores: Excepciones propias (InvalidTeamsException) para validación de datos.

-> Funcionalidades Clave
La aplicación está diseñada para gestionar las primeras etapas de un torneo eliminatorio, garantizando la aleatoriedad y la unicidad de los partidos en cada ronda.

Ingreso de Equipos: Permite agregar equipos manualmente a través de un campo de texto y un botón.

Validación por Etapa: El sistema valida la cantidad de equipos requerida antes de realizar el sorteo:

Octavos de Final: Requiere 16 equipos.

Cuartos de Final: Requiere 8 equipos.

Semifinales: Requiere 4 equipos.

Aleatoriedad y Recursividad: La lógica de emparejamiento está implementada en la clase Organizador utilizando un método recursivo que toma la lista de equipos, selecciona un par aleatorio, lo retira, y llama a la función con la lista restante (N-2), hasta que la lista esté vacía (Caso Base).

Persistencia de Resultados: Permite al usuario guardar los resultados del sorteo en un archivo .txt en una ubicación de su elección, mediante un cuadro de diálogo.

Reiniciar Aplicación: Después de cada sorteo, la tabla, el campo de ingreso y la lista interna de equipos del Organizador se limpian automáticamente para preparar la siguiente etapa o un nuevo torneo.

-> Instalacion y uso
Para utilizar esta app se puede descargar unicamente el archivo SORTEADOR DE PARTIDOS ALEATORIOS.jar (archivo ejecutable), o tambien puede clonar este repositorio para analizar más a profundidad
la funcionalidad de la aplicación.
