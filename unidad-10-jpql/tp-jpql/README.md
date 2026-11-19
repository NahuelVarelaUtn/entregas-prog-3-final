# TP Grupal - Consultas Avanzadas con JPQL

Proyecto Maven (Java 17, JPA 3 / Hibernate 6, H2 en memoria) con las 22 consultas del TP.

## Estructura
- `model/` entidades: FacturaVenta, FacturaVentaDetalle, Articulo, Rubro, Marca, Cliente, CondicionIva, PuntoVenta, Usuario
- `repository/FacturacionRepository.java` un metodo por consigna (`q01` ... `q22`)
- `Main.java` carga datos de prueba y ejecuta todas las consultas

## Ejecutar
    mvn compile exec:java

## Supuestos del modelo
- La condicion de IVA de la factura se obtiene via `factura.cliente.condicionIva` (consigna 19).
- `Articulo.marca` es opcional (para el LEFT JOIN de la consigna 12).
- Si tu modelo real tiene otros nombres de atributos, ajusta solo los strings JPQL del repositorio.

## Criterios cumplidos
- `em.createQuery(jpql, Clase.class)` en todas las consultas.
- Parametros nombrados (`:param`), sin concatenar valores.
- JPQL sobre nombres de entidades y atributos Java, nunca de tablas.
