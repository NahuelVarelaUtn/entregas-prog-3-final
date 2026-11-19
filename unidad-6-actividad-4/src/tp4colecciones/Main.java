package tp4colecciones;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase Principal (Main) para el Trabajo Práctico de Colecciones (Map / HashMap).
 * Demuestra el uso de HashMap<String, Curso>, recuperación por clave y recorrido con entrySet().
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Curso> cursosMap = new HashMap<>();

        // 1. Agregar varios cursos con su código como clave
        cursosMap.put("PRG3", new Curso("Programación III", "Prof. Ana Gómez"));
        cursosMap.put("EDD1", new Curso("Estructuras de Datos", "Prof. Carlos Ruiz"));
        cursosMap.put("BD02", new Curso("Bases de Datos II", "Prof. Laura Martínez"));

        // 2. Recuperar un curso por su clave
        String claveBuscada = "PRG3";
        Curso cursoRecuperado = cursosMap.get(claveBuscada);
        System.out.println("=== RECUPERACIÓN POR CLAVE (" + claveBuscada + ") ===");
        if (cursoRecuperado != null) {
            System.out.println(cursoRecuperado);
        } else {
            System.out.println("No se encontró un curso con la clave " + claveBuscada);
        }

        // 3. Recorrer el Map con entrySet() e imprimir todas las entradas
        System.out.println("\n=== TODAS LAS ENTRADAS DEL HASHMAP (entrySet) ===");
        for (Map.Entry<String, Curso> entrada : cursosMap.entrySet()) {
            System.out.println("Clave: " + entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
