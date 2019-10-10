package com.homeBanking;

import com.homeBanking.entity.ContaCorrente;
import com.homeBanking.entity.ContaInvestimento;

/**
 * ContaVisitor
 */

public interface ContaVisitor {

    public void visitaContaCorrente(ContaCorrente conta);
    public void visitaContaInvestimento(ContaInvestimento conta);

}