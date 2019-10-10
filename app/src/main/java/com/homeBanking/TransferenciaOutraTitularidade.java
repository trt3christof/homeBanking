package com.homeBanking;

import com.homeBanking.entity.Conta;

/**
 * TransferenciaOutraTitularidade
 */
public class TransferenciaOutraTitularidade implements TransferenciaStrategy {

    @Override
    public void transfere(Conta contaOrigem, Conta contaDestino, Double valor) {
        //Com taxa
        contaOrigem.debitar("Debito em conta - transferencia",valor);
        contaDestino.creditar("Credito em conta - transferencia",valor);

        //Débito da taxa
        contaOrigem.debitar("Debito em conta - taxa transferencia",contaOrigem.getTaxaTransferencia(valor));
    }

    
}