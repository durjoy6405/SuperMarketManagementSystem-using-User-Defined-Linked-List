/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part2;

import javax.swing.JOptionPane;

/**
 *
 * @author Durjoy
 */
public class Functionality {
    private static LinkedList<Product> products = new LinkedList<>();
    private static int lastProductId = 0; // Track the last used product ID
    //private static int lastActivityId = 0; // Track the last used Activity ID

    public static void addProduct(String productName, String category, int quantity) {
        int productId = ++lastProductId; // Increment and use the new product ID
        Product product = new Product(productId, productName, category, quantity);
        products.append(product);
        Activity activity = new Activity( 1, "NewProductAdded", quantity);
        product.addActivity(activity);
        System.out.println(product.getProductId() + product.getProductName() + product.getCategory() + product.getQuantity() + product.getDate());
    }

    public static void deleteProduct(int productId) {
        Node<Product> productNode = findProductNodeById(productId);
        if(productNode != null){
            Product product = productNode.data;
            products.remove(product);
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid ID. "
                    + "This product is not available in the system", 
                    "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static LinkedList<Product> getProductsByCategory(String category) {
        LinkedList<Product> productsByCategory = new LinkedList<>();
        Node<Product> current = products.head;
        while (current != null) {
            Product product = current.data;
            if (product.getCategory().equalsIgnoreCase(category)) {
                productsByCategory.append(product);
            }
            current = current.next;
        }
        return productsByCategory;
    }

    public static LinkedList<Product> getAllProducts() {
        LinkedList<Product> allProducts = new LinkedList<>();
        Node<Product> current = products.head;
        while (current != null) {
            allProducts.append(current.data);
            current = current.next;
        }
        return allProducts;
    }

    public static Product findProductById(int productId) {
        Node<Product> productNode = findProductNodeById(productId);
        return (productNode != null) ? productNode.data : null;
    }

    private static Node<Product> findProductNodeById(int productId) {
        Node<Product> current = products.head;
        while (current != null) {
            if (current.data.getProductId() == productId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void addStock(int productId, int quantity) {
        Node<Product> productNode = findProductNodeById(productId);
        if (productNode != null) {
            Product product = productNode.data;
            product.setQuantity(product.getQuantity() + quantity);
            LinkedList<Activity> activitiesList = product.getActivities();
            Node<Activity> tailNode = activitiesList.getTail();
            Activity lastActivity = tailNode.data;
            Activity activity = new Activity(lastActivity.getActivityId() + 1, "AddToStock", quantity);
            product.addActivity(activity);
            JOptionPane.showMessageDialog(null, "The new stock is updated successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Product not found."
                    + " Kindly add as a brand new product",
                        "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void sellProduct(int productId, int quantity) {
        Node<Product> productNode = findProductNodeById(productId);
        if (productNode != null) {
            Product product = productNode.data;
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                product.setQuantity(currentQuantity - quantity);
                LinkedList<Activity> activitiesList = product.getActivities();
                Node<Activity> tailNode = activitiesList.getTail();
                Activity lastActivity = tailNode.data;
                Activity activity = new Activity(lastActivity.getActivityId() + 1, "RemoveFromStock", quantity);
                product.addActivity(activity);
                JOptionPane.showMessageDialog(null, "Product is sold");
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient stock for sale.",
                        "Alert", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product not found.",
                        "Alert", JOptionPane.WARNING_MESSAGE);
        }
    }
}

