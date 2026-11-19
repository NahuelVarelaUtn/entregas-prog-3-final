# Trabajo Práctico: DTO Clásico (POJO)
**Asignatura:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación (UTN)

## Objetivo General
Aprender qué es un DTO clásico en Java (POJO) y cómo implementarlo de forma manual.

## Clases Incluidas
- **`Producto.java`**: Clase con atributos `codigo`, `nombre`, `precio` y `autor`, constructores, *getters/setters* y `toString()`.
- **`ProductoDTO.java`**: DTO clásico con atributos `codigo`, `nombre` y `precio`, implementado manualmente sin librerías externas.
- **`Main.java`**: Instancia objetos `Producto` y `ProductoDTO`, carga los DTOs mediante *getters/setters*, los almacena en una `List<ProductoDTO>` y los muestra por consola.

## Conclusiones
1. **DTOs clásicos (POJOs):** Permiten estructurar datos simples con constructores y métodos de acceso explícitos sin depender de frameworks o anotaciones.
2. **Transporte de datos entre capas:** Ayudan a exponer únicamente los campos necesarios (omitiendo datos como `autor` en `ProductoDTO`) al comunicar distintas capas de una aplicación.
