package com.homeBanking.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homeBanking.entity.ContaInvestimento;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sobrenome;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Conta> contas;


    public static class Builder {
        public String nome;
        public String sobrenome;
        public String endereco;
        public String telefone;
        private List<Conta> contas;
        
        public Builder set(Consumer<Builder> builderConsumer) {
            builderConsumer.accept(this);
            return this;
        }
        //Conta nubank1 = new ContaCorrente().setLimiteDeCredito(1000.0).setBanco(nubank).setId(1L).setSaldo(10.0);
        //Conta abc1 = new ContaInvestimento().setTipoAplicacao("LCA").setBanco(nubank).setId(1L).setSaldo(100.0);
        public Builder adicionaContaCorrente(Banco banco,Double limiteCredito, Double saldo){
            getContas().add(new ContaCorrente()
                .setLimiteDeCredito(limiteCredito)
                .setBanco(banco)
                .setSaldo(saldo));
            return this;    
        }

        public Builder adicionaContaInvestimento(Banco banco,String tipoAplicacao, Double saldo){
            getContas().add(new ContaInvestimento()
                .setTipoAplicacao(tipoAplicacao)
                .setBanco(banco)
                .setSaldo(saldo));
            return this;    
        }

        public Cliente build() {
            Cliente cliente = new Cliente();
            cliente.nome = this.nome;
            cliente.sobrenome = this.sobrenome;
            cliente.endereco = this.endereco;
            cliente.telefone = this.telefone;
            this.getContas().stream().forEach(c->c.setCliente(cliente));
            cliente.contas = this.getContas();
            return cliente;
        }

        public List<Conta> getContas() {
            if (contas == null) {
                contas = new ArrayList<Conta>();
            }
            return contas;
        }

        
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Cliente setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Cliente setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public Cliente setContas(List<Conta> contas) {
        this.contas = contas;
        return this;
    }

    @JsonIgnore
    public Double getTotalAplicacoes(){
        return this.getContas().stream().collect(Collectors.summingDouble(Conta::getSaldo));
    }

	public Conta getConta(Banco banco, long id) {
		return this.getContas().stream().filter(c->c.getId()==id && c.getBanco().equals(banco)).collect(Collectors.toList()).get(0);
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}