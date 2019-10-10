package com.homeBanking;

import com.homeBanking.entity.Conta;

/**
 * TransferenciaMesmaTitularidade
 */
public class TransferenciaMesmaTitularidade implements TransferenciaStrategy {

    @Override
    public void transfere(Conta contaOrigem, Conta contaDestino, Double valor) {
        //Sem taxa
        //TRANSACTION*****

        contaOrigem.debitar("Debito em conta - transferencia",valor);
        contaDestino.creditar("Credito em conta - transferencia",valor);

        //TRANSACTION*****
    }

    
}