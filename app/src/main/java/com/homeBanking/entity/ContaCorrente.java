package com.homeBanking.entity;

import com.homeBanking.ContaVisitor;
import javax.persistence.Entity;

@Entity
public class ContaCorrente extends Conta {
    private Double limiteDeCredito;

    public Double getLimiteDeCredito() {
        return limiteDeCredito;
    }

    public ContaCorrente setLimiteDeCredito(Double limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
        return this;
    }

    @Override
    public void accept(ContaVisitor contaVisitor) {
        contaVisitor.visitaContaCorrente(this);
    }
}