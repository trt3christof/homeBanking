package com.homeBanking;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpHelper {

    private static String base_url = "http://localhost:3000/posts";

    public static void post(String cliente, String banco, Long conta, Double valor) {

        try {
        // Criando o HttpClient
        HttpClient client = HttpClient.newHttpClient();
        // String no formato Json que irá conter o corpo da requisição PUT
        String body = String.format("{\"nome\": \"%s\", \"banco\": \"%s\", \"conta\": \"%s\", \"valor\": \"%s\"}", cliente, banco, conta, valor);
        //Criando um HttpRequest do tipo Put, especificando sua URI e atribuindo ao método Put o corpo da requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .uri(URI.create(base_url)).build();

        // Enviando a requisição e recebendo o Objeto de resposta da mesma.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        // Extraindo status de resposta da requisição Put
        int statusCode = response.statusCode();
        // Imprimindo resultado no console
        System.out.println(String.format("Status code: %s", statusCode));
        } catch (Exception e) {
            System.out.println("deu ruim");
        }
    }
}