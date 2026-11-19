package com.utn.recorddto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar varios Producto y ProductoRecord
        Producto producto1 = new Producto("COD-001", "Teclado Mecánico", "TechSupply", 65000.0);
        Producto producto2 = new Producto("COD-002", "Mouse Inalámbrico", "PeriféricosSur", 28500.0);
        Producto producto3 = new Producto("COD-003", "Monitor 24\"", "VisualTech", 210000.0);

        ProductoRecord recordDirecto1 = new ProductoRecord("COD-101", "Webcam HD", 34000.0);
        ProductoRecord recordDirecto2 = new ProductoRecord("COD-102", "Auriculares USB", 42000.0);

        // 2. Instanciar los ProductoRecord con los objetos Producto
        ProductoRecord recordDesdeProd1 = new ProductoRecord(
                producto1.getCodigo(),
                producto1.getNombre(),
                producto1.getPrecio()
        );
        ProductoRecord recordDesdeProd2 = new ProductoRecord(
                producto2.getCodigo(),
                producto2.getNombre(),
                producto2.getPrecio()
        );
        ProductoRecord recordDesdeProd3 = new ProductoRecord(
                producto3.getCodigo(),
                producto3.getNombre(),
                producto3.getPrecio()
        );

        // 3. Guardarlos en una lista
        List<ProductoRecord> listaRecords = new ArrayList<>();
        listaRecords.add(recordDesdeProd1);
        listaRecords.add(recordDesdeProd2);
        listaRecords.add(recordDesdeProd3);
        listaRecords.add(recordDirecto1);
        listaRecords.add(recordDirecto2);

        // 4. Mostrar los productos en consola
        System.out.println("=== Lista de ProductoRecord ===");
        for (ProductoRecord item : listaRecords) {
            System.out.println(item);
        }
    }
}