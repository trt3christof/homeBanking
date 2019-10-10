package com.homeBanking;

import com.homeBanking.entity.ContaCorrente;
import com.homeBanking.entity.ContaInvestimento;

/**
 * ContaInvestimentoVisitor
 */
public class ContaInvestimentoVisitor implements ContaVisitor {

    @Override
    public void visitaContaCorrente(ContaCorrente conta) {}

    @Override
    public void visitaContaInvestimento(ContaInvestimento conta) {
        conta.debitar("Taxa Mensal de Servicos", conta.getSaldo()*0.0001);
    }

    
    
}