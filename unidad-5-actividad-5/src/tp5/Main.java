package tp5;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase Principal (Main) para probar el uso de HashSet y la consistencia entre equals() y hashCode().
 */
public class Main {
    public static void main(String[] args) {
        // Creamos un HashSet de productos
        Set<Producto> productosSet = new HashSet<>();

        // Instanciamos productos
        Producto p1 = new Producto("P001", "Notebook", 1200.50);
        Producto p2 = new Producto("P002", "Mouse Óptico", 25.00);
        Producto p3 = new Producto("P003", "Teclado Mecánico", 75.50);
        
        // Producto con el mismo código que p1 pero diferente nombre y precio (Duplicado lógico)
        Producto p1Duplicado = new Producto("P001", "Notebook Gamer Actualizada", 1400.00);

        // Agregamos los productos al HashSet
        productosSet.add(p1);
        productosSet.add(p2);
        productosSet.add(p3);
        
        // Intentamos agregar el producto duplicado
        boolean agregado = productosSet.add(p1Duplicado);
        
        System.out.println("¿Se pudo agregar el producto duplicado (P001)?: " + agregado);

        // Mostramos el contenido final del HashSet
        System.out.println("\n=== CONTENIDO DEL HASHSET (SIN DUPLICADOS) ===");
        for (Producto p : productosSet) {
            System.out.println(p);
        }
    }
}
