package com.utn.reflection;

public class Persona {
    private String nombre;
    private int edad;

    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String Saludar() {
        return "Hola";
    }

    public void mostrarInformacion() {
        System.out.println("Persona -> nombre: " + nombre + ", edad: " + edad);
    }
}
