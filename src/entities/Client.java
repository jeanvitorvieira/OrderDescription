package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

// Classe utilizada para registrar e gerenciar tudo acerca do cliente (nome, email e data de nascimento)
public class Client {

    // Inicia um formato de data com padrão específico
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private String name;
    private  String email;
    private  Date birthDate;

    // Construtor vazio (inicia o objeto sem nada)
    public Client() {

    }

    // Construtor cheio (inicia o objeto com os atributos necessários)
    public Client(String name, String email, Date birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    // Getters e Setters de cada atributo para facilitar a manutenção dos mesmos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    // Função toString que retorna os detalhes do pedido de acordo com o solicitado
    @Override
    public String toString() {
        return name + " (" + sdf.format(birthDate) + ") - " + email;
    }
}
