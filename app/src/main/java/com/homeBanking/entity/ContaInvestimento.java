package com.homeBanking.entity;

import com.homeBanking.ContaVisitor;
import com.homeBanking.entity.Conta;
import javax.persistence.Entity;

@Entity
public class ContaInvestimento extends Conta {
    private String tipoAplicacao;

    public String getTipoAplicacao() {
        return tipoAplicacao;
    }

    public ContaInvestimento setTipoAplicacao(String tipoAplicacao) {
        this.tipoAplicacao = tipoAplicacao;
        return this;
    }

    @Override
    public void accept(ContaVisitor contaVisitor) {
        contaVisitor.visitaContaInvestimento(this);
    }

}