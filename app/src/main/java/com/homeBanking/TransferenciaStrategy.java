package com.homeBanking;

import com.homeBanking.entity.Conta;

/**
 * Transferencia
 */
public interface TransferenciaStrategy {
    public void transfere(Conta contaOrigem,Conta contaDestino,Double valor);
}