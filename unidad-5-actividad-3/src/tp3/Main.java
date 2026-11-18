package tp3;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Principal (Main) para probar el Trabajo Práctico 3.
 */
public class Main {
    public static void main(String[] args) {
        // Crear lista de estudiantes para el curso 1
        List<Estudiante> alumnosCurso1 = new ArrayList<>();
        alumnosCurso1.add(new Estudiante("Juan", 20, "Ingeniería en Sistemas"));
        alumnosCurso1.add(new Estudiante("María", 22, "Diseño Gráfico"));

        // Crear lista de estudiantes para el curso 2
        List<Estudiante> alumnosCurso2 = new ArrayList<>();
        alumnosCurso2.add(new Estudiante("Pedro", 21, "Medicina"));
        alumnosCurso2.add(new Estudiante("Lucía", 19, "Arquitectura"));
        alumnosCurso2.add(new Estudiante("Carlos", 23, "Ingeniería en Sistemas"));

        // Instanciar cursos con composición
        Curso curso1 = new Curso("Estructuras de Datos", "Prof. Carlos Ruiz", alumnosCurso1);
        Curso curso2 = new Curso("Programación III", "Prof. Ana Gómez", alumnosCurso2);

        // Imprimir los cursos usando el toString() sobrescrito
        System.out.println("=== INFORMACIÓN DE CURSOS ===");
        System.out.println(curso1);
        System.out.println("-----------------------------------");
        System.out.println(curso2);
    }
}
