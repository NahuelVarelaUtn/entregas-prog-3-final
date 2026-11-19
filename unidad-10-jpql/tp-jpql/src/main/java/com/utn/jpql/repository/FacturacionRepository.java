package com.utn.jpql.repository;

import com.utn.jpql.model.*;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Consultas JPQL del TP grupal. Todas usan nombres de entidades/atributos Java
 * y parametros nombrados (:param) para evitar inyeccion SQL.
 */
public class FacturacionRepository {

    private final EntityManager em;

    public FacturacionRepository(EntityManager em) { this.em = em; }

    // ===================== NIVEL 1 =====================

    /** 1. Entidades completas. */
    public List<FacturaVenta> q01_todasLasFacturas() {
        return em.createQuery("SELECT f FROM FacturaVenta f", FacturaVenta.class).getResultList();
    }

    /** 2. Proyeccion: [numeroFactura, fechaEmision, importeTotal]. */
    public List<Object[]> q02_proyeccionFacturas() {
        return em.createQuery(
                "SELECT f.numeroFactura, f.fechaEmision, f.importeTotal FROM FacturaVenta f", Object[].class)
                .getResultList();
    }

    /** 3. Articulos de un rubro por denominacion. */
    public List<Articulo> q03_articulosPorRubro(String rubro) {
        return em.createQuery(
                "SELECT a FROM Articulo a WHERE a.rubro.denominacion = :rubro", Articulo.class)
                .setParameter("rubro", rubro)
                .getResultList();
    }

    /** 4. Facturas en un rango de fechas. */
    public List<FacturaVenta> q04_facturasEntreFechas(LocalDate desde, LocalDate hasta) {
        return em.createQuery(
                "SELECT f FROM FacturaVenta f WHERE f.fechaEmision BETWEEN :desde AND :hasta", FacturaVenta.class)
                .setParameter("desde", desde)
                .setParameter("hasta", hasta)
                .getResultList();
    }

    // ===================== NIVEL 2 =====================

    /** 5. EMITIDA, importe > minimo y sin fecha de anulacion. */
    public List<FacturaVenta> q05_facturasEmitidasNoAnuladas(String estado, BigDecimal minimo) {
        return em.createQuery(
                "SELECT f FROM FacturaVenta f " +
                "WHERE f.estado = :estado AND f.importeTotal > :minimo AND f.fechaAnulacion IS NULL",
                FacturaVenta.class)
                .setParameter("estado", estado)
                .setParameter("minimo", minimo)
                .getResultList();
    }

    /** 6. Clientes por texto parcial (case-insensitive) o CUIT/CUIL que comienza con "20-". */
    public List<Cliente> q06_clientesPorTextoOCuit(String texto) {
        return em.createQuery(
                "SELECT c FROM Cliente c " +
                "WHERE LOWER(c.denominacion) LIKE LOWER(CONCAT('%', :texto, '%')) " +
                "OR c.cuitCuil LIKE :prefijo", Cliente.class)
                .setParameter("texto", texto)
                .setParameter("prefijo", "20-%")
                .getResultList();
    }

    /** 7. Estados distintos ordenados ascendentemente. */
    public List<String> q07_estadosDistintos() {
        return em.createQuery(
                "SELECT DISTINCT f.estado FROM FacturaVenta f ORDER BY f.estado ASC", String.class)
                .getResultList();
    }

    /** 8. [COUNT, SUM, AVG] en una sola fila. */
    public Object[] q08_agregacionesSimples() {
        return em.createQuery(
                "SELECT COUNT(f), SUM(f.importeTotal), AVG(f.importeTotal) FROM FacturaVenta f", Object[].class)
                .getSingleResult();
    }

    /** 9. Puntos de venta cuyo numero esta en una lista. */
    public List<PuntoVenta> q09_puntosVentaPorNumeros(List<Integer> numeros) {
        return em.createQuery(
                "SELECT p FROM PuntoVenta p WHERE p.numero IN :numeros", PuntoVenta.class)
                .setParameter("numeros", numeros)
                .getResultList();
    }

    // ===================== NIVEL 3 =====================

    /** 10. Navegacion implicita: usuarioCarga.usuario. */
    public List<FacturaVenta> q10_facturasPorUsuario(String usuario) {
        return em.createQuery(
                "SELECT f FROM FacturaVenta f WHERE f.usuarioCarga.usuario = :usuario", FacturaVenta.class)
                .setParameter("usuario", usuario)
                .getResultList();
    }

    /** 11. INNER JOIN explicito: detalles de facturas de un punto de venta. */
    public List<FacturaVentaDetalle> q11_detallesPorPuntoVenta(Integer numeroPuntoVenta) {
        return em.createQuery(
                "SELECT d FROM FacturaVentaDetalle d " +
                "INNER JOIN d.facturaVenta f " +
                "INNER JOIN f.puntoVenta p " +
                "WHERE p.numero = :numero", FacturaVentaDetalle.class)
                .setParameter("numero", numeroPuntoVenta)
                .getResultList();
    }

    /** 12. LEFT JOIN: [articulo, marca (puede ser null)]. */
    public List<Object[]> q12_articulosConMarca() {
        return em.createQuery(
                "SELECT a.denominacion, m.denominacion FROM Articulo a LEFT JOIN a.marca m", Object[].class)
                .getResultList();
    }

    /** 13. Multinivel: facturas con al menos un detalle de una marca. */
    public List<FacturaVenta> q13_facturasPorMarca(String marca) {
        return em.createQuery(
                "SELECT DISTINCT f FROM FacturaVenta f " +
                "JOIN f.detalles d " +
                "JOIN d.articulo a " +
                "JOIN a.marca m " +
                "WHERE m.denominacion = :marca", FacturaVenta.class)
                .setParameter("marca", marca)
                .getResultList();
    }

    /** 14. Subconsulta en WHERE: importe > promedio general. */
    public List<FacturaVenta> q14_facturasSobrePromedio() {
        return em.createQuery(
                "SELECT f FROM FacturaVenta f " +
                "WHERE f.importeTotal > (SELECT AVG(f2.importeTotal) FROM FacturaVenta f2)", FacturaVenta.class)
                .getResultList();
    }

    /** 15. Facturas de un cliente por CUIT/CUIL. */
    public List<FacturaVenta> q15_facturasPorCuit(String cuitCuil) {
        return em.createQuery(
                "SELECT f FROM FacturaVenta f WHERE f.cliente.cuitCuil = :cuit", FacturaVenta.class)
                .setParameter("cuit", cuitCuil)
                .getResultList();
    }

    // ===================== NIVEL 4 =====================

    /** 16. [descripcion PV, cantidad de facturas, suma facturada]. */
    public List<Object[]> q16_resumenPorPuntoVenta() {
        return em.createQuery(
                "SELECT p.descripcion, COUNT(f), SUM(f.importeTotal) " +
                "FROM FacturaVenta f JOIN f.puntoVenta p " +
                "GROUP BY p.descripcion", Object[].class)
                .getResultList();
    }

    /** 17. Usuarios con mas de N facturas (HAVING). */
    public List<String> q17_usuariosConMasDeNFacturas(long minimo) {
        return em.createQuery(
                "SELECT u.usuario FROM FacturaVenta f JOIN f.usuarioCarga u " +
                "GROUP BY u.usuario HAVING COUNT(f) > :minimo", String.class)
                .setParameter("minimo", minimo)
                .getResultList();
    }

    /** 18. [marca, SUM(cantidad), SUM(subtotal)] agrupado por marca. */
    public List<Object[]> q18_ventasPorMarca() {
        return em.createQuery(
                "SELECT m.denominacion, SUM(d.cantidad), SUM(d.subtotal) " +
                "FROM FacturaVentaDetalle d JOIN d.articulo a JOIN a.marca m " +
                "GROUP BY m.denominacion", Object[].class)
                .getResultList();
    }

    /** 19. [condicion de IVA, suma facturada] (via cliente.condicionIva). */
    public List<Object[]> q19_totalPorCondicionIva() {
        return em.createQuery(
                "SELECT ci.denominacion, SUM(f.importeTotal) " +
                "FROM FacturaVenta f JOIN f.cliente c JOIN c.condicionIva ci " +
                "GROUP BY ci.denominacion", Object[].class)
                .getResultList();
    }

    // ===================== NIVEL 5 =====================

    /** 20. EXISTS: marcas con al menos un articulo facturado. */
    public List<Marca> q20_marcasConArticulosFacturados() {
        return em.createQuery(
                "SELECT m FROM Marca m WHERE EXISTS (" +
                "  SELECT 1 FROM FacturaVentaDetalle d WHERE d.articulo.marca = m)", Marca.class)
                .getResultList();
    }

    /** 21. NOT EXISTS: articulos nunca facturados. */
    public List<Articulo> q21_articulosNuncaFacturados() {
        return em.createQuery(
                "SELECT a FROM Articulo a WHERE NOT EXISTS (" +
                "  SELECT 1 FROM FacturaVentaDetalle d WHERE d.articulo = a)", Articulo.class)
                .getResultList();
    }

    /** 22. CASE WHEN: [numeroFactura, importeTotal, categoria] ordenado por importe desc. */
    public List<Object[]> q22_categoriaPorImporte(BigDecimal alto, BigDecimal bajo) {
        return em.createQuery(
                "SELECT f.numeroFactura, f.importeTotal, " +
                "  CASE WHEN f.importeTotal > :alto THEN 'ALTO VALOR' " +
                "       WHEN f.importeTotal >= :bajo THEN 'MEDIO VALOR' " +
                "       ELSE 'BAJO VALOR' END AS categoria " +
                "FROM FacturaVenta f ORDER BY f.importeTotal DESC", Object[].class)
                .setParameter("alto", alto)
                .setParameter("bajo", bajo)
                .getResultList();
    }
}
