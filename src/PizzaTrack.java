package src;

import java.util.Scanner;

/**
 * Clase principal que contiene el menú interactivo en consola.
 */
public class PizzaTrack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionPedidos gestionPedidos = new GestionPedidos();
        int opcion = -1;

        System.out.println("============================================");
        System.out.println("   Bienvenido a Pizza-Track (Undo/Redo)");
        System.out.println("============================================");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                String input = scanner.nextLine();
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre de la pizza: ");
                        String nombre = scanner.nextLine();
                        
                        String[] ingredientes = new String[3];
                        System.out.println("Ingrese los 3 ingredientes (obligatorio):");
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Ingrediente " + (i + 1) + ": ");
                            ingredientes[i] = scanner.nextLine();
                        }
                        
                        Pizza nuevaPizza = new Pizza(nombre, ingredientes);
                        gestionPedidos.registrarPedido(nuevaPizza);
                        break;
                    case 2:
                        gestionPedidos.deshacer();
                        break;
                    case 3:
                        gestionPedidos.rehacer();
                        break;
                    case 4:
                        gestionPedidos.mostrarPedidoActual();
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema Pizza-Track. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("[ERROR] Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Por favor ingrese un número válido.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }

        } while (opcion != 0);

        scanner.close();
    }
}
