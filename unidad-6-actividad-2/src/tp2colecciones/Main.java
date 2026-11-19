package tp2colecciones;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Principal (Main) para el Trabajo Práctico de Colecciones (List / ArrayList).
 * Demuestra orden de inserción, admisión de duplicados, recorrido for-each y toString().
 */
public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();

        // Agregamos alumnos respetando el orden de inserción (incluyendo un duplicado)
        alumnos.add(new Alumno("Ana", 8.5));
        alumnos.add(new Alumno("Luis", 7.0));
        alumnos.add(new Alumno("Sofía", 9.25));
        alumnos.add(new Alumno("Ana", 8.5)); // ArrayList permite elementos duplicados

        System.out.println("=== LISTADO DE ALUMNOS (ARRAYLIST) ===");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}
