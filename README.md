# Mutantes-UTN-Prog3
# Mutant Detector

Este proyecto es una aplicación de Spring Boot que detecta si una secuencia de ADN pertenece a un mutante. La lógica de detección se basa en la búsqueda de secuencias repetitivas de bases nitrogenadas (A, T, C, G) en las filas, columnas y diagonales de una matriz NxN.  

## Estructura del Proyecto

- src/main/java/com/parcial_prog3/mutant/MutantApplication.java: Clase principal que inicia la aplicación Spring Boot.
- src/main/java/com/parcial_prog3/mutant/services/MutantDetector.java: Clase que contiene la lógica para detectar si una secuencia de ADN es mutante.
- src/test/java/com/parcial_prog3/mutant/MutantApplicationTests.java: Clase que contiene los tests unitarios para validar la funcionalidad del detector de mutantes.

## Lógica de Detección

La clase MutantDetector verifica si una secuencia de ADN es mutante buscando secuencias de 4 bases nitrogenadas iguales en las filas, columnas y diagonales de la matriz de ADN. Si se encuentran más de una de estas secuencias, se considera que el ADN es mutante.  

### Validaciones

Antes de realizar la detección, se realizan varias validaciones en la entrada:  

- El array de ADN no puede ser null.
- El array de ADN no puede estar vacío.
- Cada fila del array de ADN no puede ser null.
- El array de ADN debe ser NxN.
- Cada fila del array de ADN solo puede contener los caracteres 'A', 'T', 'C', 'G'.

## Tests Unitarios

Los tests unitarios se encuentran en la clase MutantApplicationTests y cubren los siguientes casos:  

### Manejo de Errores

- Array vacío: Verifica que se lance una excepción cuando el array de ADN está vacío.
- Array NxM: Verifica que se lance una excepción cuando el array de ADN no es NxN.
- Array con números como strings: Verifica que se lance una excepción cuando el array de ADN contiene caracteres inválidos.
- Array nulo: Verifica que se lance una excepción cuando el array de ADN es null.
- Array de NxN con nulls: Verifica que se lance una excepción cuando alguna fila del array de ADN es null.
- Array con letras distintas a las propuestas: Verifica que se lance una excepción cuando el array de ADN contiene caracteres distintos a 'A', 'T', 'C', 'G'.

### Casos de Prueba

- Mutante 1: Verifica que una secuencia de ADN con múltiples secuencias repetitivas sea detectada como mutante.
- Mutante 2: Verifica otro caso de secuencia de ADN mutante.
- Mutante 3: Verifica un caso extremo donde todas las filas contienen la misma base nitrogenada.
- No Mutante 1: Verifica que una secuencia de ADN sin suficientes secuencias repetitivas no sea detectada como mutante.
- No Mutante 2: Verifica otro caso de secuencia de ADN no mutante.
- Mutante 4: Verifica un caso más complejo de secuencia de ADN mutante.
- Mutante 5: Verifica un caso adicional de secuencia de ADN mutante.

## Ejecución de Tests

Para ejecutar los tests unitarios, puedes usar el siguiente comando de Gradle: 

```bash
./gradlew test
```

