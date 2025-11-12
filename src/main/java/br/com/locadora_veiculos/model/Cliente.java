package br.com.locadora_veiculos.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private String endereco;

    public Cliente(String nome, String sobrenome, String rg, String cpf, String endereco) {}

    public Cliente(Long id, String nome, String sobrenome, String rg, String cpf, String endereco) {
        this.id = id;
        this.nome =  nome;
        this.sobrenome =  sobrenome;
        this.rg =  rg;
        this.cpf =  cpf;
        this.endereco =  endereco;
    }



    public Long getId() {return this.id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return this.rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return this.cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public static Cliente convertFromDao(ResultSet result) throws SQLException {
        Long id = result.getLong("id_cliente");
        String nome = result.getString("nome");
        String sobrenome = result.getString("sobrenome");
        String rg = result.getString("rg");
        String cpf = result.getString("cpf");
        String endereco = result.getString("endereco");

        return new Cliente(id, nome, sobrenome, rg, cpf, endereco);
    }

    //TODO: list.stream().map(Classe::metodoConvert).toList()

    public static List<Cliente> converListFromDao(ResultSet result) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();

        while (result.next()) {
            clientes.add(Cliente.convertFromDao(result));
        }

        return clientes;
    }

}
