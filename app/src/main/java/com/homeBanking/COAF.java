package com.homeBanking;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

import com.homeBanking.entity.Movimentacao;

/**
 * COAF
 */
public class COAF implements Subscriber<Movimentacao> {

    public static final Double LIMITE_PARA_NOTIFICACAO = 50000.0;
    private static COAF coaf = null;
    private Subscription subscription;

    private void update(Movimentacao movimentacao) {
        // System.out.println(String.format("Treta: %s recebeu
        // %s",conta.getCliente().getNome(),movimentacao.getValor()));
        HttpHelper.post(movimentacao.getConta().getCliente().getNome(), 
            movimentacao.getConta().getBanco().getNome(), 
            movimentacao.getConta().getId(),
            movimentacao.getValor());
    }

    public static COAF getInstanciaCOAF() {
        if (coaf == null)
            coaf = new COAF();
        return coaf;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        // TODO Auto-generated method stub
        this.subscription = subscription;
        this.subscription.request(1);

    }

    @Override
    public void onNext(Movimentacao item) {
        // TODO Auto-generated method stub
        this.update(item);
        this.subscription.request(1);

    }

    @Override
    public void onError(Throwable throwable) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onComplete() {
        // TODO Auto-generated method stub

    }
    
}