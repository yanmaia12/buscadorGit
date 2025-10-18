package com.yanmaia12.buscadorgit.main;

import com.yanmaia12.buscadorgit.exception.ErroConsultaException;
import com.yanmaia12.buscadorgit.service.ApiGit;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApiGit api = new ApiGit();

        System.out.print("Digite o nome do usuário que deseja buscar: ");
        String username = sc.nextLine();

        try {
            String responseBody = api.useApi(username);
            System.out.println(responseBody);
        }catch (ErroConsultaException e){
            System.out.println("Erro: " + e.getMessage());
        }catch (IOException | InterruptedException e){
            System.out.println("Erro de conexão ou na consulta da API: " + e.getMessage());
        }finally {
            sc.close();
        }

    }
}
