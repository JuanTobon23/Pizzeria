package src;

/**
 * Clase de control que coordina las dos pilas manuales para el sistema Undo/Redo.
 */
public class GestionPedidos {
    // Pila Principal (Undo): Donde se apilan los pedidos conforme se registran.
    private PilaManual pilaPrincipal;
    
    // Pila Secundaria (Redo): Donde se mueven los pedidos "deshechos" para su recuperación.
    private PilaManual pilaSecundaria;

    public GestionPedidos() {
        this.pilaPrincipal = new PilaManual();
        this.pilaSecundaria = new PilaManual();
    }

    /**
     * Registra un nuevo pedido en la pila principal.
     * Cada vez que se registra un nuevo pedido, la pila de redo se limpia,
     * ya que la línea de tiempo de acciones ha divergido.
     * @param pizza Objeto pizza a registrar.
     */
    public void registrarPedido(Pizza pizza) {
        pilaPrincipal.push(pizza);
        System.out.println("\n[EXITO] Pedido registrado: " + pizza.toString());
        
        // Limpiar la pila secundaria (Redo) porque se introdujo una nueva acción
        // Esto previene que se rehagan acciones de un estado diferente.
        pilaSecundaria = new PilaManual();
    }

    /**
     * Acción Deshacer (Undo).
     * Retira el último pedido de la pila principal y lo envía a la secundaria.
     */
    public void deshacer() {
        if (pilaPrincipal.isEmpty()) {
            System.out.println("\n[ERROR] No hay pedidos para deshacer en la Pila Principal.");
            return;
        }
        
        // pop() de la pila principal
        Pizza pizzaDeshecha = pilaPrincipal.pop();
        
        // push() a la secundaria
        pilaSecundaria.push(pizzaDeshecha);
        
        System.out.println("\n[UNDO] Se ha deshecho el pedido de: " + pizzaDeshecha.getNombre());
    }

    /**
     * Acción Rehacer (Redo).
     * Retira el último pedido deshecho de la pila secundaria y lo devuelve a la principal.
     */
    public void rehacer() {
        if (pilaSecundaria.isEmpty()) {
            System.out.println("\n[ERROR] No hay pedidos para rehacer en la Pila Secundaria.");
            return;
        }
        
        // pop() de la pila secundaria
        Pizza pizzaRehecha = pilaSecundaria.pop();
        
        // push() a la principal
        pilaPrincipal.push(pizzaRehecha);
        
        System.out.println("\n[REDO] Se ha rehecho el pedido de: " + pizzaRehecha.getNombre());
    }

    /**
     * Muestra la pizza actual (la última registrada y activa) en el tope de la pila.
     */
    public void mostrarPedidoActual() {
        Pizza actual = pilaPrincipal.peek();
        if (actual == null) {
            System.out.println("\n[INFO] Actualmente no hay pedidos activos en producción.");
        } else {
            System.out.println("\n[ACTUAL] Pedido en producción: " + actual.toString());
        }
    }
}
