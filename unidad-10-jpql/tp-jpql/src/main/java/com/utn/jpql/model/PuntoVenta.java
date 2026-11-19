package com.utn.jpql.model;

import jakarta.persistence.*;

@Entity
public class PuntoVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    private String descripcion;

    protected PuntoVenta() {}
    public PuntoVenta(Integer numero, String descripcion) { this.numero = numero; this.descripcion = descripcion; }

    public Long getId() { return id; }
    public Integer getNumero() { return numero; }
    public String getDescripcion() { return descripcion; }
    @Override public String toString() { return "PuntoVenta{" + numero + " - " + descripcion + "}"; }
}
