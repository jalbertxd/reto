package com.tcs.mstipocambio.model.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioResponse {
    private double monto;
    private double montoTipoCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
}