package com.utn.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String email;

    public static void main(String[] args) {
        // 1. Crear instancias de Usuario utilizando el patrón Builder
        Usuario usuario1 = Usuario.builder()
                .id(1L)
                .nombre("Juan Pérez")
                .email("juan.perez@example.com")
                .build();

        Usuario usuario2 = Usuario.builder()
                .id(2L)
                .nombre("María Gómez")
                .email("maria.gomez@example.com")
                .build();

        // 2. Imprimir los datos por consola (aprovechando el toString() generado por @Data)
        System.out.println("=== Instancias de Usuario Creadas con @Builder ===");
        System.out.println(usuario1);
        System.out.println(usuario2);
    }
}
