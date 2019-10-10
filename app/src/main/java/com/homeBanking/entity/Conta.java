package com.homeBanking.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homeBanking.COAF;
import com.homeBanking.ContaVisitor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Conta{
    @Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Double saldo;

    @ManyToOne
    private Banco banco;
    
    @ManyToOne
    private Cliente cliente;
    
    //protected List<ContaObserver> observers;

    @Transient
    @JsonIgnore
    private SubmissionPublisher<Movimentacao> publisher = new SubmissionPublisher<>();

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    private static Double TAXA_TRANSFERENCIA = 0.01;

    public abstract void accept(ContaVisitor contaVisitor);

    public Conta() {
        this.movimentacoes = new ArrayList<>();
        getPublisher().subscribe(COAF.getInstanciaCOAF());
        //this.observers = new ArrayList<>();
        //this.observers.add(COAF.getInstanciaCOAF());
    }

    public Long getId() {
        return id;
    }

    public Conta setId(Long id) {
        this.id = id;
        return this;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Conta setSaldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Banco getBanco() {
        return banco;
    }

    public Conta setBanco(Banco banco) {
        this.banco = banco;
        banco.getContas().add(this);
        return this;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public String getExtrato(){
        StringBuffer sb = new StringBuffer();
        this.getMovimentacoes().stream()
            .sorted((m1,m2)->m1.getData().compareTo(m2.getData()))
            .map(Movimentacao::toString)
            .forEach(s -> {
                    sb.append(s);
                    sb.append("\n");
                });
        
        sb.append(String.format("\nSALDO: %.2f", saldo));
        return sb.toString();     
    }

	public void debitar(String descricao, Double valor) {
        saldo -= valor;
        movimentacoes.add(getNovaMovimentacao(descricao).setValor(-valor));
	}

    public void creditar(String descricao, Double valor) {
        saldo += valor;
        Movimentacao m = getNovaMovimentacao(descricao).setValor(valor);
        movimentacoes.add(m);
        if (valor>COAF.LIMITE_PARA_NOTIFICACAO){
            getPublisher().submit(m);
            //this.observers.stream().forEach(o->o.update(this, m));
        }
    }
    
    private Movimentacao getNovaMovimentacao(String descricao) {
        return new Movimentacao().setData(new Date())
                        .setConta(this)
                        .setDescricao(descricao);
    }

	public Double getTaxaTransferencia(Double valor) {
		return TAXA_TRANSFERENCIA * valor;
	}

    public Cliente getCliente() {
        return cliente;
    }

    public Conta setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public SubmissionPublisher<Movimentacao> getPublisher() {
        return publisher;
    }

}