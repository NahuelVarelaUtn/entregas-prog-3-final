# Trabajo Práctico: Reflection en Java
**Asignatura:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación (UTN)

## Objetivo General
Comprender cómo funciona el mecanismo de Reflection en Java para inspeccionar y manipular clases, constructores, atributos y métodos en tiempo de ejecución, evaluando tanto su potencia como sus riesgos.

## Archivos Incluidos
- **`Persona.java`**: Clase con atributos privados `nombre` y `edad`, constructores, *getters/setters*, método `Saludar()` que retorna `"Hola"` y `mostrarInformacion()`.
- **`Main.java`**: Demuestra inspección de constructores, instanciación dinámica, modificación de campo privado en tiempo de ejecución, invocación reflexiva de métodos y control de acceso con `Reflection`.

## Conclusiones
1. **Inspección y manipulación dinámica:** Reflection permite descubrir constructores, campos y métodos en tiempo de ejecución, así como modificar atributos privados y ejecutar métodos dinámicamente.
2. **Riesgos y buenas prácticas:** Aunque resulta clave en frameworks y herramientas genéricas, abusar de Reflection puede reducir la seguridad de tipos, impactar el rendimiento y romper el encapsulamiento si no se usa con criterio.
