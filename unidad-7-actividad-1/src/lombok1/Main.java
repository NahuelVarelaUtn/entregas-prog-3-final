package lombok1;

/**
 * Clase Principal (Main) para probar la clase Persona con anotaciones de Lombok.
 * Demuestra el uso del constructor vacío (@NoArgsConstructor), constructor lleno (@AllArgsConstructor),
 * getters y setters (@Getter, @Setter).
 */
public class Main {
    public static void main(String[] args) {
        // 1. Instanciar utilizando constructor vacío (@NoArgsConstructor) y asignar valores con setters
        Persona personaVacia = new Persona();
        personaVacia.setNombre("Nahuel");
        personaVacia.setEdad(23);

        // 2. Instanciar utilizando constructor lleno (@AllArgsConstructor)
        Persona personaCompleta = new Persona("Lucía", 21);

        // 3. Mostrar atributos en consola usando getters y toString()
        System.out.println("=== PERSONA CREADA CON CONSTRUCTOR VACÍO + SETTERS ===");
        System.out.println(personaVacia);
        System.out.println("Nombre vía getter: " + personaVacia.getNombre() + " | Edad vía getter: " + personaVacia.getEdad());

        System.out.println("\n=== PERSONA CREADA CON CONSTRUCTOR LLENO ===");
        System.out.println(personaCompleta);
        System.out.println("Nombre vía getter: " + personaCompleta.getNombre() + " | Edad vía getter: " + personaCompleta.getEdad());
    }
}
