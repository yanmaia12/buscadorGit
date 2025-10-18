# Buscador de Usuários do GitHub em Java

Um simples cliente de console em Java que utiliza a API REST do GitHub para buscar e exibir informações públicas de perfis de usuário.

Este projeto foi desenvolvido como um exercício prático para aprender a consumir APIs externas de forma segura e estruturada em Java.

## Funcionalidades

* Busca de dados de um usuário pelo seu `username`.
* Exibe informações como nome, login, localização. email (se for público), seguidores e quem está seguindo.
* Autenticação segura via API Token para garantir um limite maior de requisições.
* Tratamento de erros customizado para casos em que o usuário não é encontrado (HTTP 404).
* Uso de Variáveis de Ambiente para proteger a chave da API, seguindo as melhores práticas de segurança.

## Tecnologias Utilizadas

* **Java 17+:** Utilizando recursos modernos como `Records` e o `HttpClient` nativo.
* **Google Gson:** Biblioteca para "parsear" (converter) a resposta da API de JSON para objetos Java de forma simples e eficiente.
* **Java HttpClient:** Para realizar as requisições HTTP para a API do GitHub.

## Como Executar o Projeto

Para executar este projeto na sua máquina, siga os passos abaixo.

### Pré-requisitos

* **Java JDK 17** ou superior instalado e configurado no seu sistema.
* **Git** para clonar o repositório.

### 1. Clone o Repositório

```bash
git clone https://github.com/yanmaia12/buscadorGit.git
cd nome-do-seu-projeto