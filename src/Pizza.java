package src;

import java.util.Arrays;

/**
 * Clase que representa el modelo de datos de una Pizza.
 * Se mueve a lo largo del sistema de pilas.
 */
public class Pizza {
    private String nombre;
    private String[] ingredientes;

    /**
     * Constructor para inicializar la pizza.
     * Es obligatorio el uso de un arreglo de tamaño fijo (3) para los ingredientes.
     * 
     * @param nombre Nombre de la pizza
     * @param ingredientes Arreglo de exactamente 3 ingredientes
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        if (ingredientes == null || ingredientes.length != 3) {
            throw new IllegalArgumentException("La pizza debe tener exactamente 3 ingredientes.");
        }
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Pizza: " + nombre + " | Ingredientes: " + Arrays.toString(ingredientes);
    }
}
