package com.utn.dto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 2. Crear varios objetos Producto y ProductoDTO
        Producto producto1 = new Producto("P-001", "Clean Code", 45000.0, "Robert C. Martin");
        Producto producto2 = new Producto("P-002", "Effective Java", 52000.0, "Joshua Bloch");

        ProductoDTO dto1 = new ProductoDTO();
        ProductoDTO dto2 = new ProductoDTO();
        ProductoDTO dto3 = new ProductoDTO("P-003", "Design Patterns", 48500.0);

        // 3. Cargar los objetos ProductoDTO usando getters y setters y guardarlos en una lista
        dto1.setCodigo(producto1.getCodigo());
        dto1.setNombre(producto1.getNombre());
        dto1.setPrecio(producto1.getPrecio());

        dto2.setCodigo(producto2.getCodigo());
        dto2.setNombre(producto2.getNombre());
        dto2.setPrecio(producto2.getPrecio());

        List<ProductoDTO> listaProductosDTO = new ArrayList<>();
        listaProductosDTO.add(dto1);
        listaProductosDTO.add(dto2);
        listaProductosDTO.add(dto3);

        // 4. Mostrar la lista en consola
        System.out.println("=== Lista de ProductoDTO ===");
        for (ProductoDTO dto : listaProductosDTO) {
            System.out.println(dto);
        }
    }
}
