# Trabajo Práctico - Lombok - DTO (Parte 1)
**Materia:** Programación III  
**Carrera:** Tecnicatura Universitaria en Programación a Distancia (UTN)

## Descripción
Se implementa la clase `Persona` con los atributos `nombre` y `edad` utilizando las anotaciones `@Getter`, `@Setter`, `@NoArgsConstructor` y `@AllArgsConstructor` de Project Lombok. En `Main` se instancian objetos mediante ambos constructores y se muestran sus valores por consola.

## Compilación y ejecución
- **Con Maven:**
  ```bash
  mvn compile exec:java -Dexec.mainClass="lombok1.Main"
  ```
- **Con `javac` (teniendo `lombok.jar` en el classpath):**
  ```bash
  javac -cp path/to/lombok.jar -d bin src/lombok1/Persona.java src/lombok1/Main.java
  java -cp bin;path/to/lombok.jar lombok1.Main
  ```
