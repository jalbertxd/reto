package com.tcs.mstipocambio.service;

import java.util.List;
import java.util.Optional;

import com.tcs.mstipocambio.model.entity.TipoCambio;
import com.tcs.mstipocambio.repository.TipoCambioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCambioService {
    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    public TipoCambio addTipoCambio(TipoCambio tipoCambio){
        return tipoCambioRepository.save(tipoCambio);
    }
    public List<TipoCambio> getAllTipoCambio(){
        return tipoCambioRepository.findAll();
    }
    public void deleteTipoCambio(TipoCambio tipoCambio){
        tipoCambioRepository.delete(tipoCambio);
    }
    public void deleteTipoCambioById(Integer id){
        tipoCambioRepository.deleteById(id);
    }
    public Optional<TipoCambio> getTipoCambioById(Integer id){
        return tipoCambioRepository.findById(id);
    }   
    public Optional<TipoCambio> getTipoCambioByMoneda(String monedaOrigen, String monedaDestino){
        return tipoCambioRepository.findTipoCambioByMoneda(monedaOrigen, monedaDestino);
    }
}