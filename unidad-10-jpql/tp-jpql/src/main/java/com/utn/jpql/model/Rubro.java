package com.utn.jpql.model;

import jakarta.persistence.*;

@Entity
public class Rubro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    protected Rubro() {}
    public Rubro(String denominacion) { this.denominacion = denominacion; }

    public Long getId() { return id; }
    public String getDenominacion() { return denominacion; }
    @Override public String toString() { return "Rubro{" + denominacion + "}"; }
}
