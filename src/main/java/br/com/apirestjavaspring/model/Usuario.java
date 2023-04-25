package br.com.apirestjavaspring.model;

import jakarta.persistence.*;

// Criar Entidade Usuario

@Entity // Annotation que persiste a Entidade ao Banco de dados [Cria a tabela usuario]
@Table(name = "usuarios") // Annotation que define um nome para a tabela [Caso não defina, o nome será o
                          // mesmo da classe]
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Character sexo;
    private String login;
    private String senha;

    // Getters and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
