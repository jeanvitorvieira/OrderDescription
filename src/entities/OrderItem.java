package entities;

// Classe utilizada para registrar e gerenciar tudo acerca do item do pedido (quantidade, preço e produto)
public class OrderItem {

    private  Integer quantity;
    private  Double price;

    private Product product;

    // Construtor vazio (inicia o objeto sem nada)
    public OrderItem() {

    }

    // Construtor cheio (inicia o objeto com os atributos necessários)
    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    // Getters e Setters de cada atributo para facilitar a manutenção dos mesmos
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Função que retorna o sub total de cada item
    public  Double subTotal() {
        return quantity * price;
    }

    // Função toString que retorna os detalhes do pedido de acordo com o solicitado
    @Override
    public String toString() {
        return product.getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity +
                ", Subtotal: $"
                + String.format("%.2f", subTotal());
    }
}
