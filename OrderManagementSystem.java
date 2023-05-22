import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManagementSystem {
    private Map<String, List<Product>> orders;

    public OrderManagementSystem() {
        orders = new HashMap<>();
    }

    public void addProductToOrder(String orderId, Product product) {
        List<Product> productList = orders.getOrDefault(orderId, new ArrayList<>());
        productList.add(product);
        orders.put(orderId, productList);
    }

    public List<Product> getOrderProducts(String orderId) {
        return orders.getOrDefault(orderId, new ArrayList<>());
    }

    public double calculateOrderTotal(String orderId) {
        List<Product> productList = orders.get(orderId);
        double total = 0.0;
        if (productList != null) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public int getOrdersCount() {
        return orders.size();
    }
}



