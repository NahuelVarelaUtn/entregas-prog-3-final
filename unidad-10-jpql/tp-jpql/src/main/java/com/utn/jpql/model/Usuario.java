package com.utn.jpql.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;

    protected Usuario() {}
    public Usuario(String usuario) { this.usuario = usuario; }

    public Long getId() { return id; }
    public String getUsuario() { return usuario; }
    @Override public String toString() { return "Usuario{" + usuario + "}"; }
}
