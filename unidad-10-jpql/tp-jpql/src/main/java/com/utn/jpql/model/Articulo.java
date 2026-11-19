package com.utn.jpql.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Articulo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private BigDecimal precioVenta;
    @ManyToOne(optional = false) private Rubro rubro;
    @ManyToOne private Marca marca; // opcional (puede ser null)

    protected Articulo() {}
    public Articulo(String denominacion, BigDecimal precioVenta, Rubro rubro, Marca marca) {
        this.denominacion = denominacion; this.precioVenta = precioVenta; this.rubro = rubro; this.marca = marca;
    }

    public Long getId() { return id; }
    public String getDenominacion() { return denominacion; }
    public BigDecimal getPrecioVenta() { return precioVenta; }
    public Rubro getRubro() { return rubro; }
    public Marca getMarca() { return marca; }
    @Override public String toString() { return "Articulo{" + denominacion + "}"; }
}
