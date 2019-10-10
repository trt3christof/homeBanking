package com.homeBanking.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Date data;
    private String descricao;
    private Double valor;

    @ManyToOne
    private Conta conta;

    public Date getData() {
        return data;
    }

    public Movimentacao setData(Date data) {
        this.data = data;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Movimentacao setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Movimentacao setValor(Double valor) {
        this.valor = valor;
        return this;
    }
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
        return String.format("%s-%s: %s", sdf.format(data), descricao, valor);
    }

    public Conta getConta() {
        return conta;
    }

    public Movimentacao setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}