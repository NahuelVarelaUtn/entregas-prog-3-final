package com.utn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Persona.class;

            // 1. Obtener e imprimir sus constructores
            System.out.println("=== Constructores de Persona ===");
            Constructor<?>[] constructores = clazz.getDeclaredConstructors();
            for (Constructor<?> ctor : constructores) {
                System.out.println(ctor);
            }

            // 2. Instanciar un objeto utilizando Reflection
            System.out.println("\n=== Instanciacion con Reflection ===");
            Constructor<?> ctorConParametros = clazz.getDeclaredConstructor(String.class, int.class);
            Object instancia = ctorConParametros.newInstance("Nahuel", 22);
            Persona persona = (Persona) instancia;
            persona.mostrarInformacion();

            // 3. Modificar el valor de nombre en tiempo de ejecucion
            System.out.println("\n=== Modificacion de atributo privado 'nombre' ===");
            Field campoNombre = clazz.getDeclaredField("nombre");
            campoNombre.setAccessible(true);
            campoNombre.set(persona, "Nahuel Actualizado");

            // 4. Invocar un metodo que muestre la informacion de la persona
            System.out.println("\n=== Invocacion de metodo mostrarInformacion ===");
            Method metodoInfo = clazz.getDeclaredMethod("mostrarInformacion");
            metodoInfo.invoke(persona);

            // 5. Verificar / inspeccionar Saludar() y su encapsulamiento
            System.out.println("\n=== Metodo Saludar() y modificadores ===");
            Method metodoSaludar = clazz.getDeclaredMethod("Saludar");
            String saludo = (String) metodoSaludar.invoke(persona);
            System.out.println("Resultado de Saludar(): " + saludo);
            System.out.println("Modificadores actuales de Saludar(): " + Modifier.toString(metodoSaludar.getModifiers()));

            metodoSaludar.setAccessible(false);
            System.out.println("Acceso reflexivo restringido con setAccessible(false).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
