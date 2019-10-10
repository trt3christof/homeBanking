package com.homeBanking;

// import com.homeBanking.entity.Banco;
// import com.homeBanking.entity.Cliente;
// import com.homeBanking.entity.Conta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.homeBanking.entity"})
@ComponentScan
public class Main {
    public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}


// public static void main(String[] args) throws InterruptedException {

    
//     Banco nubank = new Banco().setId(1L).setNome("Nubank");
//     Banco abc = new Banco().setId(2L).setNome("ABC");

//     Cliente christofer = new Cliente.Builder()
//     .set((p)->{
//         p.nome="Christofer";
//         p.sobrenome="Roque";
//         p.endereco="BHTE";
//         p.telefone="31";
//     })
//     .adicionaContaCorrente(nubank, 1000.0, 10.0)
//     .adicionaContaInvestimento(abc, "LCA", 100.0)
//     .build();

//     System.out.println(christofer.getTotalAplicacoes());

//     Conta nubank1 = christofer.getConta(nubank,1L);
//     Conta abc1 = christofer.getConta(abc,1L);
//     transfere(nubank1, abc1, 10.0);

//     System.out.println(nubank1.getExtrato());
//     System.out.println(abc1.getExtrato());


//     Cliente fabio = new Cliente.Builder()
//     .set((p)->{
//         p.nome="Fabio";
//         p.sobrenome="Marinho";
//         p.endereco="BHTE";
//         p.telefone="31";
//     })
//     .adicionaContaCorrente(nubank, 100.0, 10.0)
//     .adicionaContaInvestimento(abc, "LCA", 50000.0)
//     .build();

//     Conta nubank2 = fabio.getConta(nubank,2L);
//     Conta abc2 = fabio.getConta(abc,2L);
    
//     transfere(abc2, abc1, 60000.0);



//     System.out.println(abc2.getExtrato());
//     System.out.println(abc1.getExtrato());


//     System.out.println(christofer.getTotalAplicacoes());
//     nubank.coletaTaxas();
//     abc.coletaTaxas();
//     System.out.println(christofer.getTotalAplicacoes());

//     Thread.sleep(100);

// }

// public static void transfere(Conta origem, Conta destino, Double valor){
//     TransferenciaStrategy transferencia = 
//         origem.getCliente().equals(destino.getCliente()) ? new TransferenciaMesmaTitularidade() : new TransferenciaOutraTitularidade();

//     transferencia.transfere(origem, destino, valor);
// }

}