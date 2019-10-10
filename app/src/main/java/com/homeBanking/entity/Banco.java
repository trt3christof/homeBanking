package com.homeBanking.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;

import com.homeBanking.ContaCorrenteVisitor;
import com.homeBanking.ContaInvestimentoVisitor;

@Entity
public class Banco {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;

    @OneToMany(mappedBy = "banco")
    private List<Conta> contas;

    public Long getId() {
        return id;
    }

    public Banco setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Banco setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public List<Conta> getContas() {
        if (this.contas==null) this.contas = new ArrayList<>();
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void coletaTaxas(){
        this.getContas().stream().forEach( c-> {c.accept(new ContaCorrenteVisitor()); c.accept(new ContaInvestimentoVisitor());});
    }

    
}