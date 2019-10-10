package com.homeBanking;

import com.homeBanking.entity.Conta;
import com.homeBanking.entity.Movimentacao;

/**
 * ContaObserver
 */
public interface ContaObserver {
    public void update(Conta conta, Movimentacao movimentacao);
}