package tp4colecciones;

/**
 * Clase Curso con atributos nombre y docente.
 * Sobrescribe toString() usando comillas dobles escapadas para evitar errores de sintaxis.
 */
public class Curso {
    private String nombre;
    private String docente;

    public Curso(String nombre, String docente) {
        this.nombre = nombre;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre=\"" + nombre + "\"" +
                ", docente=\"" + docente + "\"" +
                '}';
    }
}
