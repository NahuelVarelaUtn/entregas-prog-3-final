package tp3;

import java.util.List;

/**
 * Clase Curso que contiene composición con estudiantes.
 */
public class Curso {
    private String nombreCurso;
    private String profesor;
    private List<Estudiante> listaDeEstudiantes;

    public Curso(String nombreCurso, String profesor, List<Estudiante> listaDeEstudiantes) {
        this.nombreCurso = nombreCurso;
        this.profesor = profesor;
        this.listaDeEstudiantes = listaDeEstudiantes;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getListaDeEstudiantes() {
        return listaDeEstudiantes;
    }

    public void setListaDeEstudiantes(List<Estudiante> listaDeEstudiantes) {
        this.listaDeEstudiantes = listaDeEstudiantes;
    }

    /**
     * Sobrescritura de toString() para mostrar la información formateada del curso,
     * el profesor, la cantidad de alumnos y la lista anidada de estudiantes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Curso: ").append(nombreCurso).append("\n");
        sb.append("Profesor: ").append(profesor).append("\n");
        sb.append("Cantidad de alumnos: ").append(listaDeEstudiantes.size()).append("\n");
        sb.append("Estudiantes:\n");
        for (Estudiante est : listaDeEstudiantes) {
            sb.append("  - ").append(est.toString()).append("\n");
        }
        return sb.toString();
    }
}
