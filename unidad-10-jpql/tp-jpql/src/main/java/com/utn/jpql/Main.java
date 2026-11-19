package com.utn.jpql;

import com.utn.jpql.model.*;
import com.utn.jpql.repository.FacturacionRepository;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("facturacionPU");
        EntityManager em = emf.createEntityManager();
        cargarDatos(em);

        FacturacionRepository r = new FacturacionRepository(em);

        titulo("NIVEL 1");
        titulo("1. Todas las facturas");                       imprimir(r.q01_todasLasFacturas());
        titulo("2. Proyeccion (nro, fecha, importe)");         imprimirFilas(r.q02_proyeccionFacturas());
        titulo("3. Articulos del rubro 'Electronica'");        imprimir(r.q03_articulosPorRubro("Electronica"));
        titulo("4. Facturas entre 2026-01-01 y 2026-06-30");
        imprimir(r.q04_facturasEntreFechas(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 6, 30)));

        titulo("NIVEL 2");
        titulo("5. EMITIDA, > 10000, no anuladas");
        imprimir(r.q05_facturasEmitidasNoAnuladas("EMITIDA", new BigDecimal("10000")));
        titulo("6. Clientes con 'perez' o CUIT 20-*");         imprimir(r.q06_clientesPorTextoOCuit("perez"));
        titulo("7. Estados distintos");                        imprimir(r.q07_estadosDistintos());
        titulo("8. COUNT / SUM / AVG");
        System.out.println(Arrays.toString(r.q08_agregacionesSimples()));
        titulo("9. Puntos de venta 1, 2, 5");                  imprimir(r.q09_puntosVentaPorNumeros(List.of(1, 2, 5)));

        titulo("NIVEL 3");
        titulo("10. Facturas del usuario 'jgomez'");           imprimir(r.q10_facturasPorUsuario("jgomez"));
        titulo("11. Detalles del punto de venta 1");           imprimir(r.q11_detallesPorPuntoVenta(1));
        titulo("12. Articulos con marca (LEFT JOIN)");         imprimirFilas(r.q12_articulosConMarca());
        titulo("13. Facturas con articulos de marca 'Samsung'"); imprimir(r.q13_facturasPorMarca("Samsung"));
        titulo("14. Facturas sobre el promedio");              imprimir(r.q14_facturasSobrePromedio());
        titulo("15. Facturas del CUIT 20-11111111-1");         imprimir(r.q15_facturasPorCuit("20-11111111-1"));

        titulo("NIVEL 4");
        titulo("16. Resumen por punto de venta");              imprimirFilas(r.q16_resumenPorPuntoVenta());
        titulo("17. Usuarios con mas de 2 facturas");          imprimir(r.q17_usuariosConMasDeNFacturas(2));
        titulo("18. Ventas por marca");                        imprimirFilas(r.q18_ventasPorMarca());
        titulo("19. Total por condicion de IVA");              imprimirFilas(r.q19_totalPorCondicionIva());

        titulo("NIVEL 5");
        titulo("20. Marcas con articulos facturados");         imprimir(r.q20_marcasConArticulosFacturados());
        titulo("21. Articulos nunca facturados");              imprimir(r.q21_articulosNuncaFacturados());
        titulo("22. Categoria por importe");
        imprimirFilas(r.q22_categoriaPorImporte(new BigDecimal("50000"), new BigDecimal("10000")));

        em.close();
        emf.close();
    }

    private static void cargarDatos(EntityManager em) {
        em.getTransaction().begin();

        Rubro electro = new Rubro("Electronica"), hogar = new Rubro("Hogar");
        Marca samsung = new Marca("Samsung"), lg = new Marca("LG"), philips = new Marca("Philips");
        Usuario jgomez = new Usuario("jgomez"), mlopez = new Usuario("mlopez");
        PuntoVenta pv1 = new PuntoVenta(1, "Casa Central"), pv2 = new PuntoVenta(2, "Sucursal Mendoza"),
                   pv3 = new PuntoVenta(3, "Sucursal Cordoba");
        CondicionIva ri = new CondicionIva("Responsable Inscripto"), cf = new CondicionIva("Consumidor Final");
        Cliente c1 = new Cliente("Juan Perez", "20-11111111-1", cf);
        Cliente c2 = new Cliente("Maria Rodriguez", "27-22222222-3", cf);
        Cliente c3 = new Cliente("Distribuidora PEREZ SA", "30-33333333-4", ri);
        for (Object o : new Object[]{electro, hogar, samsung, lg, philips, jgomez, mlopez, pv1, pv2, pv3, ri, cf, c1, c2, c3})
            em.persist(o);

        Articulo tv = new Articulo("Smart TV 50", new BigDecimal("45000"), electro, samsung);
        Articulo cel = new Articulo("Celular A54", new BigDecimal("30000"), electro, samsung);
        Articulo heladera = new Articulo("Heladera 300L", new BigDecimal("80000"), hogar, lg);
        Articulo licuadora = new Articulo("Licuadora", new BigDecimal("8000"), hogar, null);   // sin marca
        Articulo plancha = new Articulo("Plancha", new BigDecimal("5000"), hogar, philips);     // nunca facturada
        for (Articulo a : new Articulo[]{tv, cel, heladera, licuadora, plancha}) em.persist(a);

        factura(em, 1, "2026-02-10", "EMITIDA", "45000", null, jgomez, pv1, c1, new Object[][]{{tv, 1, "45000"}});
        factura(em, 2, "2026-03-15", "EMITIDA", "9000", null, jgomez, pv1, c2, new Object[][]{{licuadora, 1, "8000"}});
        factura(em, 3, "2026-05-20", "ANULADA", "80000", "2026-05-21", mlopez, pv2, c3, new Object[][]{{heladera, 1, "80000"}});
        factura(em, 4, "2026-08-01", "EMITIDA", "75000", null, jgomez, pv2, c1, new Object[][]{{tv, 1, "45000"}, {cel, 1, "30000"}});
        factura(em, 5, "2026-09-12", "PAGADA", "12000", null, mlopez, pv1, c3, new Object[][]{{licuadora, 1, "8000"}, {licuadora, 1, "4000"}});
        factura(em, 6, "2026-10-05", "EMITIDA", "30000", null, jgomez, pv3, c2, new Object[][]{{cel, 1, "30000"}});

        em.getTransaction().commit();
        em.clear();
    }

    private static void factura(EntityManager em, int nro, String fecha, String estado, String total, String anul,
                                Usuario u, PuntoVenta pv, Cliente c, Object[][] detalles) {
        FacturaVenta f = new FacturaVenta(nro, LocalDate.parse(fecha), estado, new BigDecimal(total),
                anul == null ? null : LocalDate.parse(anul), u, pv, c);
        for (Object[] d : detalles)
            f.agregarDetalle(new FacturaVentaDetalle((Articulo) d[0], (Integer) d[1], new BigDecimal((String) d[2])));
        em.persist(f);
    }

    private static void titulo(String t) { System.out.println("\n=== " + t + " ==="); }
    private static void imprimir(List<?> l) { l.forEach(x -> System.out.println("  " + x)); }
    private static void imprimirFilas(List<Object[]> l) { l.forEach(x -> System.out.println("  " + Arrays.toString(x))); }
}
