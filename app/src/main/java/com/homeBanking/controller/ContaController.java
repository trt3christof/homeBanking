package com.homeBanking.controller;

import com.homeBanking.entity.Conta;
import com.homeBanking.repository.ContaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    //@RequestMapping("/creditar")
    // TODO: Escolher:
    // /conta/id/creditar
    // /creditarConta
    // TODO: usar @RequestBody para Post!

    @RequestMapping(value ="/creditar", method = RequestMethod.POST,consumes = "application/json")
    //@PostMapping(path = "/creditar", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    public String creditar(@RequestParam("idConta") Long idConta,
                            @RequestParam("motivoCredito") String motivoCredito,
                            @RequestParam("valor") Double valor) {
        
        Conta conta = buscarConta(idConta);
        conta.creditar(motivoCredito, valor);

        return "";
    }

    private Conta buscarConta(Long idConta) {
        return contaRepository.findById(idConta).get() ;
    }
}