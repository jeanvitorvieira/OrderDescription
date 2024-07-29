package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

// Classe principal que executará o programa
public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // Inicia um formato de data com padrão específico
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String name;
        Date birthDate = null;
        OrderStatus status = null;
        String n;
        double productPrice;
        String quantity;

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        // Algoritmo que evita a inserção da data no formato incorreto
        while (birthDate == null) {
            System.out.print("Birth date (DD/MM/YYYY): ");
            String birthDateStr = sc.nextLine();

            try {
                birthDate = sdf.parse(birthDateStr);
            } catch (ParseException e) {
                System.out.println("\nInvalid date format. Please enter in DD/MM/YYYY format.");
            }
        }

        // Inicialização do objeto client/cliente com os dados registrados
        Client client = new Client(name, email, birthDate);

        System.out.println("\nEnter order data:");

        // Algoritmo que impede a inserção de opções não registradas (obs: ele aceita letras minúsculas)
        while (status == null) {
            System.out.print("Status (PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED): ");
            String statusStr = sc.nextLine();
            try {
                status = OrderStatus.valueOf(statusStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("\nInvalid status.");
            }
        }

        // Inicialização do objeto order/pedido com os dados registrados
        Order order = new Order(new Date(), status, client);

        System.out.println();

        // Algoritmo que impede a inserção de caracteres que NÃO sejam números
        while (true) {
            System.out.print("How many items to this order? ");
            n = sc.nextLine();

            if (containsOnlyNumbers(n)) {
                break;
            } else {
                System.out.println("\nInvalid number.");
            }
        }

        // Repetição que registra os items do pedido
        for (int i = 1; i <= Integer.parseInt(n) ; i++) {
            System.out.println("\nEnter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();

            // Algoritmo que impede caracteres que não sejam números e pontos
            while (true) {
                System.out.print("Product price: ");
                String productPriceStr = sc.nextLine();

                if (containsOnlyNumbersAndDots(productPriceStr)) {
                    try {
                        productPrice = Double.parseDouble(productPriceStr);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("\nInvalid price.");
                    }
                } else {
                    System.out.println("\nInvalid price.");
                }
            }

            // Inicialização do objeto product/produto com os dados registrados
            Product product = new Product(productName, productPrice);

            // Algoritmo que impede a inserção de caracteres que NÃO sejam números
            while (true) {
                System.out.print("Quantity: ");
                quantity = sc.nextLine();

                if (containsOnlyNumbers(quantity)) {
                    break;
                } else {
                    System.out.println("\nInvalid number.");
                }
            }

            // Inicialização do objeto orderItem/itemDoPedido com os dados registrados
            OrderItem orderItem = new OrderItem(Integer.parseInt(quantity), productPrice, product);

            // Adição do orderItem/itemDoPedido ao order/pedido
            order.addItems(orderItem);
        }

        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }

    // Função que verifica se há apenas números
    public static boolean containsOnlyNumbers(String input) {
        return input.matches("\\d+");
    }

    // Função que verifica se há apenas números e pontos (utilizada para preços)
    public static boolean containsOnlyNumbersAndDots(String input) {
        return input.matches("\\d+(\\.\\d+)?");
    }
}