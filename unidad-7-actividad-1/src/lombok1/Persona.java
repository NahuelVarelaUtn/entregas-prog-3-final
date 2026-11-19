package lombok1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Persona utilizando anotaciones de Project Lombok para reducir código repetitivo.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private String nombre;
    private int edad;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre=\"" + nombre + "\"" +
                ", edad=" + edad +
                '}';
    }
}
