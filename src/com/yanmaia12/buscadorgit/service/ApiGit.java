package com.yanmaia12.buscadorgit.service;

import com.google.gson.Gson;
import com.yanmaia12.buscadorgit.exception.ErroConsultaException;
import com.yanmaia12.buscadorgit.model.GitUser;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiGit {

    public String useApi(String username) throws IOException, InterruptedException {
        //Se não tiver uma env só substituir por:
        //String apiKey = "SUA_API_KEY_AQUI";
        String apiKey = System.getenv("GITHUB_API_KEY");

        if (apiKey == null || apiKey.isEmpty()){
            throw new IllegalStateException("A chave não foi encontrada");
        }

        String userEncoded = URLEncoder.encode(username, StandardCharsets.UTF_8);
        String url = "https://api.github.com/users/" + userEncoded;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization","Bearer " + apiKey)
                .GET()
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404){
            throw new ErroConsultaException("Usuário não encontrado!");
        }

        Gson gson = new Gson();
        GitUser gitUser = gson.fromJson(response.body(), GitUser.class);
        return "Username: %s,\nNome: %s,\nRepositórios postados: %d\nLocalização: %s\nEmail: %s\nFollowers: %d\nFollowing: %d".formatted(gitUser.login(), gitUser.name(), gitUser.public_repos(), gitUser.location(), gitUser.email(), gitUser.followers(), gitUser.following());
    }

}
