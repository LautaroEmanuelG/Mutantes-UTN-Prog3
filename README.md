# 🧬 Mutantes-UTN-Prog3

Este proyecto es una aplicación de Spring Boot diseñada para detectar si una secuencia de ADN pertenece a un mutante, basada en la búsqueda de secuencias repetitivas de bases nitrogenadas (A, T, C, G) en una matriz NxN.

## 📂 Estructura del Proyecto

- 📄 **MutantApplication.java**: Clase principal que inicia la aplicación.
- 🧬 **MutantDetector.java**: Lógica para detectar ADN mutante.
- ✅ **MutantApplicationTests.java**: Tests unitarios que validan la funcionalidad del detector.

## 🧠 Lógica de Detección

El detector busca secuencias de 4 bases nitrogenadas iguales en filas, columnas y diagonales de una matriz de ADN. Si se encuentran dos o más de estas secuencias, se considera que el ADN es mutante.

### ⚠️ Validaciones Previas

Se realizan las siguientes validaciones antes de procesar la secuencia:

- El array de ADN no puede ser `null`, vacío o de tamaño incorrecto (debe ser NxN).
- Cada fila del array solo puede contener los caracteres 'A', 'T', 'C', 'G'.

## 📜 API y Documentación

La API expone dos endpoints principales y está documentada con Swagger.

### Endpoints Principales

#### Obtener estadísticas de ADN:

```http
GET /stats/
```

Respuesta exitosa:

```json
{
    "count_human_dna": 0,
    "count_mutant_dna": 1,
    "ratio": 0.0
}
```

Verificar si una secuencia es mutante:

```http
POST /mutant/
```

Cuerpo de la solicitud:

```json
{
    "dna": [
        "ACCTAA", 
        "CCGTGC", 
        "TTATTT", 
        "AGAAGG", 
        "CCCCTA", 
        "TCACTG"
    ]
}
```

Respuesta para ADN no mutante:

```json
{
    "message": "Not a mutant",
    "mutant": false
}
```

- Swagger UI: Swagger UI - Mutantes
- URL de la API: API Mutantes

### 💾 Persistencia de Datos

El proyecto utiliza una base de datos H2 en modo local para almacenar secuencias de ADN. La base de datos se encuentra en la siguiente ruta:

- Ruta de la base de datos: mutant/data/mutants_db.mv.db

### 🧪 Pruebas Unitarias

La clase MutantApplicationTests cubre los siguientes casos:

### 🚨 Casos de Manejo de Errores:

- Secuencia de ADN vacía o nula.
- Tamaño de matriz no NxN.
- Caracteres no válidos en la secuencia de ADN.

### ✅ Casos de Prueba para ADN Mutante y No Mutante:

- 🧬 Mutante 1: Detecta una secuencia con múltiples repeticiones.
- 🔬 Mutante 2: Otro caso de ADN mutante.
- 🧫 Mutante 3: Caso extremo con todas las bases idénticas en una fila.
- 🧑‍🔬 No Mutante 1: Secuencia sin suficientes repeticiones.
- 👨‍🔬 No Mutante 2: Otro ejemplo de ADN no mutante.
- 🧑‍🚀 Mutante 4: Caso más complejo de mutante.
- 👩‍🚀 Mutante 5: Caso adicional de ADN mutante.

### 🏃‍♂️ Ejecución de Tests

Para ejecutar los tests unitarios, utiliza el siguiente comando:

```bash
./gradlew test
```
