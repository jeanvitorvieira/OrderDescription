package entities;

// Classe utilizada para registrar e gerenciar tudo acerca do produto (nome e preço)
public class Product {

    private String name;
    private Double price;

    // Construtor vazio (inicia o objeto sem nada)
    public Product() {

    }

    // Construtor cheio (inicia o objeto com os atributos necessários)
    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // Getters e Setters de cada atributo para facilitar a manutenção dos mesmos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
