import java.util.ArrayList;
import java.util.List;



//{ https://www.perplexity.ai/search/597a197a-63be-4049-8a62-2f9d7f029119

enum OrderStatus {
    PLACED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED
}

class User {
    private String name;
    private String phone;
    private String address;

    public User(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

class MenuItem {
    private int itemId;
    private String name;
    private double price;

    public MenuItem(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Restaurant {
    private int id;
    private String name;
    private List<MenuItem> menu;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void showMenu() {
        System.out.println("Menu of " + name + ":");
        for (MenuItem item : menu) {
            System.out.println(item.getItemId() + " - " + item.getName() + " - Rs." + item.getPrice());
        }
    }

    public String getName() {
        return name;
    }
}

class CartItem {
    private MenuItem item;
    private int quantity;

    public CartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return item.getPrice() * quantity;
    }

    public void showCartItem() {
        System.out.println(item.getName() + " x " + quantity + " = Rs." + getTotalPrice());
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(new CartItem(item, quantity));
    }

    public double getTotalAmount() {
        double total = 0;
        for (CartItem cartItem : items) {
            total += cartItem.getTotalPrice();
        }
        return total;
    }

    public void showCart() {
        System.out.println("Cart Items:");
        for (CartItem cartItem : items) {
            cartItem.showCartItem();
        }
        System.out.println("Total Amount = Rs." + getTotalAmount());
    }

    public List<CartItem> getItems() {
        return items;
    }
}

class Order {
    private int orderId;
    private User user;
    private List<CartItem> items;
    private OrderStatus status;

    public Order(int orderId, User user, List<CartItem> items) {
        this.orderId = orderId;
        this.user = user;
        this.items = items;
        this.status = OrderStatus.PLACED;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public void showOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Customer: " + user.getName());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Order Items:");
        double total = 0;
        for (CartItem item : items) {
            item.showCartItem();
            total += item.getTotalPrice();
        }
        System.out.println("Order Total = Rs." + total);
        System.out.println("Order Status = " + status);
    }
}

class DeliveryPerson {
    private String name;
    private String phone;

    public DeliveryPerson(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void deliverOrder(Order order) {
        System.out.println("\nDelivery Person " + name + " is assigned to this order.");
        order.updateStatus(OrderStatus.OUT_FOR_DELIVERY);
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        User user = new User("Aman", "9876543210", "Delhi");

        Restaurant restaurant = new Restaurant(1, "Tasty Bites");
        MenuItem item1 = new MenuItem(101, "Burger", 120);
        MenuItem item2 = new MenuItem(102, "Pizza", 250);
        MenuItem item3 = new MenuItem(103, "Cold Drink", 60);

        restaurant.addMenuItem(item1);
        restaurant.addMenuItem(item2);
        restaurant.addMenuItem(item3);

        restaurant.showMenu();

        Cart cart = new Cart();
        cart.addItem(item1, 2);
        cart.addItem(item3, 1);

        System.out.println();
        cart.showCart();

        Order order = new Order(5001, user, cart.getItems());
        order.showOrderDetails();

        order.updateStatus(OrderStatus.PREPARING);
        System.out.println("\nOrder status updated to PREPARING.");
        order.showOrderDetails();

        DeliveryPerson deliveryPerson = new DeliveryPerson("Ravi", "9999999999");
        deliveryPerson.deliverOrder(order);
        order.showOrderDetails();

        order.updateStatus(OrderStatus.DELIVERED);
        System.out.println("\nOrder delivered successfully.");
        order.showOrderDetails();
    }
}