
echo curl -i -X POST -H "Content-Type:application/json" -d '{"nome": "NuBank"}' http://localhost:5555/bancoes
curl -i -X POST -H "Content-Type:application/json" -d '{"nome": "NuBank"}' http://localhost:5555/bancoes

echo curl -i -X POST -H "Content-Type:application/json" -d '{"nome": "Flavio","sobrenome": "Bolsonaro","endereco": "Asa Norte 666","telefone": "61-66666666"}' http://localhost:5555/clientes
curl -i -X POST -H "Content-Type:application/json" -d '{"nome": "Flavio","sobrenome": "Bolsonaro","endereco": "Asa Norte 666","telefone": "61-66666666"}' http://localhost:5555/clientes

#echo curl -i -X POST -H "Content-Type:application/json" -d '{"cliente": 2, "banco": 1, "saldo": 0,"limiteDeCredito": 1000000}' http://localhost:5555/contaCorrentes
curl -i -X POST -H "Content-Type:application/json" -d '{"cliente.id": 2, "banco.id": 1, "saldo": 0,"limiteDeCredito": 1000000}' http://localhost:5555/contaCorrentes

curl -i -X POST -H "Content-Type:application/json; charset=utf-8" -d '{"idConta": 1,"motivoCredito": "Queiroz","valor": 2000}' http://localhost:5555/creditar
