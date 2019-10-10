package com.homeBanking;

import com.homeBanking.entity.ContaCorrente;
import com.homeBanking.entity.ContaInvestimento;

/**
 * ContaCorrenteVisitor
 */
public class ContaCorrenteVisitor implements ContaVisitor{

    @Override
    public void visitaContaCorrente(ContaCorrente conta) {
        conta.debitar("Taxa Mensal de Servicos", 1.0);
    }

    @Override
    public void visitaContaInvestimento(ContaInvestimento conta) {}

    
}