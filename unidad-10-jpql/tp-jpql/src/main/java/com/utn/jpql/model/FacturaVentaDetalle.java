package com.utn.jpql.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class FacturaVentaDetalle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private BigDecimal subtotal;
    @ManyToOne(optional = false) private Articulo articulo;
    @ManyToOne(optional = false) private FacturaVenta facturaVenta;

    protected FacturaVentaDetalle() {}
    public FacturaVentaDetalle(Articulo articulo, Integer cantidad, BigDecimal subtotal) {
        this.articulo = articulo; this.cantidad = cantidad; this.subtotal = subtotal;
    }

    void setFacturaVenta(FacturaVenta f) { this.facturaVenta = f; }
    public Long getId() { return id; }
    public Integer getCantidad() { return cantidad; }
    public BigDecimal getSubtotal() { return subtotal; }
    public Articulo getArticulo() { return articulo; }
    @Override public String toString() { return "Detalle{" + articulo + " x" + cantidad + " = " + subtotal + "}"; }
}
