package tp3colecciones;

import java.util.Objects;

/**
 * Clase Producto con atributos codigo y descripcion.
 * Sobrescribe equals() y hashCode() basándose exclusivamente en 'codigo'
 * para asegurar la unicidad en colecciones Set (HashSet).
 */
public class Producto {
    private String codigo;
    private String descripcion;

    public Producto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=\"" + codigo + "\"" +
                ", descripcion=\"" + descripcion + "\"" +
                '}';
    }
}
