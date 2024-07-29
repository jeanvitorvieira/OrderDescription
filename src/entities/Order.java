package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe utilizada para registrar e gerenciar tudo acerca do pedido (momento do pedido, status, cliente e items)
public class Order {

    // Inicia um formato de data com padrão específico
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    // Construtor vazio (inicia o objeto sem nada)
    public Order() {

    }

    // Construtor cheio (inicia o objeto com os atributos necessários)
    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    // Getters e Setters de cada atributo (tirando lista) para facilitar a manutenção dos mesmos
    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // Função que adiciona items ao pedido
    public void addItems(OrderItem item) {
        items.add(item);
    }

    // Função que remove items do pedido (não implementada)
    public void removeItems(OrderItem item) {
        items.remove(item);
    }

    // Função que retorna o total dos valores entre os items do pedido
    public Double total() {
        double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    // Função toString que retorna os detalhes do pedido de acordo com o solicitado
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder utilizado para facilitar a adição de texto/objetos ao retorno
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
