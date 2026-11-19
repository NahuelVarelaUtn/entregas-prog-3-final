package tp3colecciones;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase Principal (Main) para el Trabajo Práctico de Colecciones (Set / HashSet).
 * Demuestra cómo un HashSet previene duplicados usando equals() y hashCode().
 */
public class Main {
    public static void main(String[] args) {
        Set<Producto> productos = new HashSet<>();

        // Insertamos productos
        Producto p1 = new Producto("P001", "Teclado Mecánico");
        Producto p2 = new Producto("P002", "Mouse Inalámbrico");
        Producto p3 = new Producto("P003", "Monitor 24 pulgadas");
        
        // Producto con el mismo código que p1 (duplicado por código)
        Producto p1Duplicado = new Producto("P001", "Teclado RGB Edición Especial");

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);

        // Intentamos agregar el duplicado
        boolean agregado = productos.add(p1Duplicado);

        System.out.println("=== PRUEBA DE UNICIDAD EN HASHSET ===");
        System.out.println("¿Se agregó el producto duplicado con código P001?: " + agregado);

        System.out.println("\n=== LISTADO DE PRODUCTOS EN EL HASHSET ===");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
