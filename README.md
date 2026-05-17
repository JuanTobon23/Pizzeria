# Pizza-Track

Pizza-Track es un sistema interactivo por consola que simula la gestión de pedidos de una pizzería utilizando **Pilas Manuales** basadas en **Listas Ligadas**. El proyecto incluye la funcionalidad de "Deshacer" (Undo) y "Rehacer" (Redo).

## Objetivo del Proyecto
El proyecto implementa la estructura de datos Pila (Stack) desde cero mediante Nodos interconectados (Listas Ligadas), restringiendo estrictamente el uso de la librería de Java `java.util.Stack`. El propósito es demostrar el entendimiento de punteros en memoria y la lógica detrás del apilamiento LIFO (Last-In, First-Out).

## Requisitos Previos
- **Java Development Kit (JDK)**: El proyecto debe ejecutarse usando el JDK de **Eclipse Temurin**.
- Terminal o Consola del sistema.

## Instrucciones de Compilación y Ejecución

1. Abre tu terminal y navega al directorio raíz del proyecto (`Pizzeria`).
2. Compila el código fuente usando el compilador de Java (`javac`):

```bash
javac -d bin src/*.java
```

3. Ejecuta la clase principal (`PizzaTrack`) que contiene el menú de consola:

```bash
java -cp bin src.PizzaTrack
```

## Pruebas de Consola (Capturas de Pantalla)

*(Usuario: Aquí puedes pegar las capturas de pantalla de tus pruebas)*

### 1. Registrar una Pizza
![alt text](Registrar_pizza.png)

### 2. Mostrar Pedido Actual
![alt text](Mostrar_pedido_actual.png)

### 3. Deshacer (Undo)
![alt text](Undo.png)

### 4. Rehacer (Redo)
![alt text](Redo.png)
