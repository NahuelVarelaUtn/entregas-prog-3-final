package com.utn.jpql.model;

import jakarta.persistence.*;

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private String cuitCuil;
    @ManyToOne private CondicionIva condicionIva;

    protected Cliente() {}
    public Cliente(String denominacion, String cuitCuil, CondicionIva condicionIva) {
        this.denominacion = denominacion; this.cuitCuil = cuitCuil; this.condicionIva = condicionIva;
    }

    public Long getId() { return id; }
    public String getDenominacion() { return denominacion; }
    public String getCuitCuil() { return cuitCuil; }
    public CondicionIva getCondicionIva() { return condicionIva; }
    @Override public String toString() { return "Cliente{" + denominacion + ", " + cuitCuil + "}"; }
}
