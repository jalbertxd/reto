package com.tcs.mstipocambio.repository;

import java.util.Optional;

import com.tcs.mstipocambio.model.entity.TipoCambio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer>{
    //Obtener tipo de cambio por moneda origen y destino
    @Query("SELECT t FROM TipoCambio t WHERE t.monedaOrigen = :monedaOrigen AND t.monedaDestino = :monedaDestino")
    Optional<TipoCambio> findTipoCambioByMoneda(@Param("monedaOrigen") String monedaOrigen, 
                                                @Param("monedaDestino") String monedaDestino);
}