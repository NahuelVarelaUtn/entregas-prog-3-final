package com.utn.jpql.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FacturaVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroFactura;
    private LocalDate fechaEmision;
    private String estado;              // EMITIDA, ANULADA, PAGADA...
    private BigDecimal importeTotal;
    private LocalDate fechaAnulacion;   // null si no fue anulada

    @ManyToOne(optional = false) private Usuario usuarioCarga;
    @ManyToOne(optional = false) private PuntoVenta puntoVenta;
    @ManyToOne(optional = false) private Cliente cliente;

    @OneToMany(mappedBy = "facturaVenta", cascade = CascadeType.ALL)
    private List<FacturaVentaDetalle> detalles = new ArrayList<>();

    protected FacturaVenta() {}
    public FacturaVenta(Integer numeroFactura, LocalDate fechaEmision, String estado, BigDecimal importeTotal,
                        LocalDate fechaAnulacion, Usuario usuarioCarga, PuntoVenta puntoVenta, Cliente cliente) {
        this.numeroFactura = numeroFactura; this.fechaEmision = fechaEmision; this.estado = estado;
        this.importeTotal = importeTotal; this.fechaAnulacion = fechaAnulacion;
        this.usuarioCarga = usuarioCarga; this.puntoVenta = puntoVenta; this.cliente = cliente;
    }

    public void agregarDetalle(FacturaVentaDetalle d) { d.setFacturaVenta(this); detalles.add(d); }

    public Long getId() { return id; }
    public Integer getNumeroFactura() { return numeroFactura; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public String getEstado() { return estado; }
    public BigDecimal getImporteTotal() { return importeTotal; }
    public List<FacturaVentaDetalle> getDetalles() { return detalles; }
    @Override public String toString() {
        return "FacturaVenta{nro=" + numeroFactura + ", fecha=" + fechaEmision + ", estado=" + estado + ", total=" + importeTotal + "}";
    }
}
