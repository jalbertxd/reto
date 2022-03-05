package com.tcs.mstipocambio.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_cambio")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "moneda_origen", nullable = false)
    private String monedaOrigen;
    @Column(name = "moneda_destino", nullable = false)
    private String monedaDestino; 
    @Column(name = "tipo_cambio", nullable = false)
    private double tipoCambio; 
    @Column(name = "operador", nullable = false)
    private String operador;
}