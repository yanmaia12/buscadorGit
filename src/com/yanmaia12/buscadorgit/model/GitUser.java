package com.yanmaia12.buscadorgit.model;

public record GitUser(String login, String name, String location, String email, int followers, int following, int public_repos) {
}
