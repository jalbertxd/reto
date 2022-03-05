package com.tcs.mstipocambio.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioRequest {

	private double monto;
	private String monedaOrigen;
    private String monedaDestino;
}