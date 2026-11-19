# Trabajo Práctico: Java Record como DTO
**Asignatura:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación (UTN)

## Objetivo General
Aprender a crear DTOs modernos e inmutables utilizando la característica `record` de Java.

## Archivos Incluidos
- **`Producto.java`**: Clase con atributos `codigo`, `nombre`, `proveedor` y `precio`, constructores, *getters/setters* y `toString()`.
- **`ProductoRecord.java`**: `record` inmutable con componentes `codigo`, `nombre` y `precio`.
- **`Main.java`**: Instancia objetos `Producto` y `ProductoRecord` (directamente y a partir de `Producto`), los guarda en una lista y los muestra por consola.

## Conclusiones
1. **Utilidad de los records:** Reducen drásticamente el código repetitivo para estructuras de datos inmutables, generando automáticamente constructor canónico, métodos de acceso (`codigo()`, `nombre()`, `precio()`), `equals()`, `hashCode()` y `toString()`.
2. **Records vs. POJOs clásicos:** Mientras un POJO clásico suele requerir escritura manual (o anotaciones) de *getters/setters* mutables y `toString()`, un `record` expresa de forma directa y concisa un portador de datos inmutable.
3. **Inmutabilidad en el modelado:** Evita modificaciones accidentales de los datos una vez creados, aportando seguridad y previsibilidad al transportar información entre capas.
