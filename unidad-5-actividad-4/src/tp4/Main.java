package tp4;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Principal (Main) para probar el Trabajo Práctico 4 de Programación III.
 * Demuestra el uso de equals() y cómo evitar duplicados en una lista usando contains().
 */
public class Main {
    public static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();

        // Creamos productos iniciales
        Producto p1 = new Producto("P001", "Notebook", 1200.50);
        Producto p2 = new Producto("P002", "Mouse Óptico", 25.00);
        Producto p3 = new Producto("P003", "Teclado Mecánico", 75.50);

        // Intentamos agregar productos a la lista evitando duplicados con contains()
        agregarProductoUnico(listaProductos, p1);
        agregarProductoUnico(listaProductos, p2);
        agregarProductoUnico(listaProductos, p3);

        // Intentamos agregar un producto duplicado (mismo código "P001", aunque distinto nombre/precio)
        Producto pDuplicado = new Producto("P001", "Notebook Gamer Modificada", 1500.00);
        agregarProductoUnico(listaProductos, pDuplicado);

        // Mostramos el resultado final
        System.out.println("\n=== LISTA FINAL DE PRODUCTOS (SIN DUPLICADOS) ===");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
    }

    /**
     * Método auxiliar para agregar un producto a la lista solo si no existe previamente
     * (evaluado mediante equals basado en el código).
     */
    public static void agregarProductoUnico(List<Producto> lista, Producto nuevoProducto) {
        if (!lista.contains(nuevoProducto)) {
            lista.add(nuevoProducto);
            System.out.println("Producto agregado con éxito: " + nuevoProducto.getNombre());
        } else {
            System.out.println("-> ¡Aviso! El producto con código [" + nuevoProducto.getCodigo() + "] ya existe en la lista. No se duplicó.");
        }
    }
}
