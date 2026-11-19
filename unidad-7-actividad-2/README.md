# Trabajo Práctico: Lombok - DTO
**Asignatura:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación (UTN)

## Objetivo General
Comprender cómo Lombok ayuda en la creación de objetos complejos mediante anotaciones avanzadas (`@Builder`, `@Data`).

## Solución Incluida
- **`Usuario.java`**: Clase que representa un DTO de usuario aplicando las anotaciones `@Data` y `@Builder` de Lombok.
- Métodos de prueba en `main()` para verificar la creación e impresión de instancias.

## Conclusiones
1. **Patrón Builder:** Permite instanciar objetos complejos de forma clara, legible y flexible sin depender de múltiples constructores sobrecargados.
2. **Anotación @Data:** Genera automáticamente `getters`, `setters`, `equals()`, `hashCode()` y `toString()`, reduciendo significativamente el código repetitivo (boilerplate).
3. **Flexibilidad:** Simplifica la creación y mantenimiento de objetos DTO dentro del proyecto.
