package com.tcs.mstipocambio.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.tcs.mstipocambio.model.api.TipoCambioRequest;
import com.tcs.mstipocambio.model.api.TipoCambioResponse;
import com.tcs.mstipocambio.model.entity.TipoCambio;
import com.tcs.mstipocambio.service.TipoCambioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tipoCambio")
public class TipoCambioRest {
    @Autowired
    private TipoCambioService tipoCambioService;

    @GetMapping("run")
    public String hello(){
        return "Service up and running!";
    }
    
    @PostMapping
    public ResponseEntity<TipoCambio> addTipoCambio(@RequestBody TipoCambio tipoCambio){
        TipoCambio temporal = tipoCambioService.addTipoCambio(tipoCambio);

        try{
            return ResponseEntity.created(new URI("/tipoCambio/"+ temporal.getId())).body(temporal);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoCambio>> getAllTipoCambio(){
        return ResponseEntity.ok(tipoCambioService.getAllTipoCambio());
    }

    @GetMapping (value = "{id}")
    public ResponseEntity<Optional<TipoCambio>> geTipoCambio(@PathVariable Integer id){
        return ResponseEntity.ok(tipoCambioService.getTipoCambioById(id));
    }

	@DeleteMapping
	private ResponseEntity<Void> deleteTipoCambio (@RequestBody TipoCambio tipoCambio){
		tipoCambioService.deleteTipoCambio(tipoCambio);;
		return ResponseEntity.ok().build();
	}

    @DeleteMapping (value = "{id}")
	private ResponseEntity<Void> deleteTipoCambioById(@PathVariable Integer id){
        Optional<TipoCambio> temporal = tipoCambioService.getTipoCambioById(id);
        
        if(temporal.isPresent()){
            tipoCambioService.deleteTipoCambioById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
	}

    @PutMapping
	private ResponseEntity<TipoCambio> updateIdentityDocType(@RequestBody TipoCambio tipoCambio){
        Optional<TipoCambio> temporal = tipoCambioService.getTipoCambioById(tipoCambio.getId());
        
        if(temporal.isPresent()){
            TipoCambio updateTipoCambio = temporal.get();
            updateTipoCambio.setMonedaOrigen(tipoCambio.getMonedaOrigen());
            updateTipoCambio.setMonedaDestino(tipoCambio.getMonedaDestino());
            updateTipoCambio.setTipoCambio(tipoCambio.getTipoCambio());
            tipoCambioService.addTipoCambio(updateTipoCambio);
            return ResponseEntity.ok(updateTipoCambio);
        }else{
            return ResponseEntity.notFound().build();
        }
	}

    @PostMapping("/applyTipoCambio")
    public ResponseEntity<TipoCambioResponse> applyTipoCambi(@RequestBody TipoCambioRequest tipoCambioRequest){
        Optional<TipoCambio> temporal = tipoCambioService.getTipoCambioByMoneda(tipoCambioRequest.getMonedaOrigen(), 
                                                                                tipoCambioRequest.getMonedaDestino());

        if(temporal.isPresent()){
            TipoCambio tipoCambio = temporal.get();
            TipoCambioResponse tipoCambioResponse = new TipoCambioResponse();
            tipoCambioResponse.setMonto(tipoCambioRequest.getMonto());
            if(tipoCambio.getOperador().equals("M")){
                double montotipoCambio = (double)Math.round(tipoCambioRequest.getMonto()*tipoCambio.getTipoCambio()*100)/100;
                tipoCambioResponse.setMontoTipoCambio(montotipoCambio);
            }else{
                double montotipoCambio = (double)Math.round(tipoCambioRequest.getMonto()/tipoCambio.getTipoCambio()*100)/100;
                tipoCambioResponse.setMontoTipoCambio(montotipoCambio);
            }
            tipoCambioResponse.setMonedaOrigen(tipoCambioRequest.getMonedaOrigen());
            tipoCambioResponse.setMonedaDestino(tipoCambioRequest.getMonedaDestino());
            tipoCambioResponse.setTipoCambio(tipoCambio.getTipoCambio());

            return ResponseEntity.ok(tipoCambioResponse);
        }else{
            return ResponseEntity.notFound().build();
        }
    }    
    
}