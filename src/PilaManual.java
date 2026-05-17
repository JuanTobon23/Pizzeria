package src;

/**
 * Implementación de una estructura de datos tipo Pila (Stack) desde cero.
 * Utiliza Listas Ligadas (Nodos) en lugar de arreglos o java.util.Stack.
 */
public class PilaManual {
    // Puntero al elemento en la cima de la pila
    private Nodo tope;

    public PilaManual() {
        this.tope = null;
    }

    /**
     * Valida si la pila de pedidos se encuentra vacía.
     * @return true si la pila no tiene elementos, false de lo contrario.
     */
    public boolean isEmpty() {
        // La pila está vacía si el puntero 'tope' no apunta a ningún nodo.
        return tope == null;
    }

    /**
     * Inserta un objeto Pizza en el tope de la pila.
     * @param pizza Objeto a insertar.
     */
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza);
        
        // LÓGICA DE PUNTEROS:
        // 1. El 'siguiente' del nuevo nodo apunta al nodo que actualmente es el 'tope'.
        //    Si la pila estaba vacía, 'tope' es null, por lo que 'siguiente' será null.
        nuevoNodo.setSiguiente(tope);
        
        // 2. Ahora, el 'tope' de la pila se actualiza para ser este nuevo nodo,
        //    convirtiéndolo en el último elemento insertado (LIFO).
        tope = nuevoNodo;
    }

    /**
     * Retira el objeto del tope y devuelve su contenido.
     * @return El objeto Pizza que estaba en el tope, o null si la pila está vacía.
     */
    public Pizza pop() {
        if (isEmpty()) {
            return null;
        }
        
        // Se guarda la referencia de la pizza del tope actual para devolverla.
        Pizza pizzaRemovida = tope.getPizza();
        
        // LÓGICA DE PUNTEROS:
        // El 'tope' de la pila se actualiza al nodo 'siguiente' del tope actual.
        // El nodo que estaba en el tope original queda sin referencias y será recolectado
        // por el Garbage Collector (GC), eliminándolo efectivamente de la pila.
        tope = tope.getSiguiente();
        
        return pizzaRemovida;
    }

    /**
     * Visualiza la pizza en el tope sin retirarla de la lista.
     * @return El objeto Pizza en el tope, o null si está vacía.
     */
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        // Retorna la información sin alterar la estructura o punteros de la pila.
        return tope.getPizza();
    }
}
