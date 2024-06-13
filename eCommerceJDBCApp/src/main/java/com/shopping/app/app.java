package com.shopping.app;

import java.util.Scanner;
import java.util.List;

import com.shopping.daoImpl.UserDAOImpl;
import com.shopping.daoImpl.ProductDAOImpl;
import com.shopping.daoImpl.OrderDAOImpl;
import com.shopping.daoImpl.OrderItemDAOImpl;
import com.shopping.model.User;
import com.shopping.model.Product;
import com.shopping.model.Order;
import com.shopping.model.OrderItem;

public class app {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        ProductDAOImpl productDAO = new ProductDAOImpl();
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

        boolean exit = false;

        do {
        	System.out.println("Enter 'C' if you are a Customer");
    		System.out.println("Enter 'A' if you are a Admin");
    		System.out.println("Enter 'Exit' to exit");
            String userType = scanner.nextLine();

            if (userType.equalsIgnoreCase("C")) {
                handleCustomerActions(productDAO);
            } else if (userType.equalsIgnoreCase("A")) {
                handleAdminActions(userDAO, productDAO, orderDAO, orderItemDAO);
            } else if (userType.equalsIgnoreCase("Exit")) {
                exit = true;
            } else {
                System.out.println("Invalid choice, please try again.\n");
            }
        } while (!exit);

        scanner.close();
    }

    private static void handleCustomerActions(ProductDAOImpl productDAO) {
        boolean back = false;
        do {
            System.out.println("Customer Options:");
            System.out.println("1. Search Product by Name");
            System.out.println("2. Show All Products");
            System.out.println("3. Back");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter product name:");
                String name = scanner.nextLine();
                Product product = productDAO.getProductByName(name);
                if (product != null) {
                    System.out.println(product);
                } else {
                    System.out.println("Product not found.");
                }
            } else if (choice.equals("2")) {
                List<Product> products = productDAO.getAllProducts();
                for (Product product : products) {
                    System.out.println(product);
                }
            } else if (choice.equals("3")) {
                back = true;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (!back);
    }

    private static void handleAdminActions(UserDAOImpl userDAO, ProductDAOImpl productDAO, OrderDAOImpl orderDAO, OrderItemDAOImpl orderItemDAO) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (username.equals("Akshay") && password.equals("123@123")) {
            boolean back = false;
            do {
                System.out.println("Admin Options:");
                System.out.println("1. User Section");
                System.out.println("2. Product Section");
                System.out.println("3. Order Section");
                System.out.println("4. OrderItem Section");
                System.out.println("5. Back");
                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    handleUserSection(userDAO);
                } else if (choice.equals("2")) {
                    handleProductSection(productDAO);
                } else if (choice.equals("3")) {
                    handleOrderSection(orderDAO);
                } else if (choice.equals("4")) {
                    handleOrderItemSection(orderItemDAO);
                } else if (choice.equals("5")) {
                    back = true;
                } else {
                    System.out.println("Invalid choice, please try again.");
                }
            } while (!back);
        } else {
            System.out.println("Invalid credentials, access denied.");
        }
    }

    
    private static void handleUserSection(UserDAOImpl userDAO) {
        boolean back = false;
        do {
            System.out.println("User Section:");
            System.out.println("1. Add User");
            System.out.println("2. Update User Data");
            System.out.println("3. Delete User");
            System.out.println("4. Show All Users");
            System.out.println("5. Back");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter user details (name, username, password, email, phone):");
                User user = new User(0, scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), null);
                userDAO.addUser(user);
            } else if (choice.equals("2")) {
                System.out.println("Enter userId to update:");
                int userId = Integer.parseInt(scanner.nextLine());
                User user = userDAO.getUser(userId);
                if (user != null) {
                    System.out.println("Enter new details (name, username, password, email, phone):");
                    user.setName(scanner.nextLine());
                    user.setUsername(scanner.nextLine());
                    user.setPassword(scanner.nextLine());
                    user.setEmail(scanner.nextLine());
                    user.setPhone(scanner.nextLine());
                    userDAO.updateUser(user);
                } else {
                    System.out.println("User not found.");
                }
            } else if (choice.equals("3")) {
                System.out.println("Enter userId to delete:");
                int userId = Integer.parseInt(scanner.nextLine());
                userDAO.deleteUser(userId);
            } else if (choice.equals("4")) {
                List<User> users = userDAO.getAllUsers();
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                System.out.println(User.getTableHeader());
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                for (User user : users) {
                    System.out.println(user);
                }
                System.out.println("----------------------------------------------------------------------------------------------------------------------");
            } else if (choice.equals("5")) {
                back = true;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (!back);
    }

    private static void handleProductSection(ProductDAOImpl productDAO) {
        boolean back = false;
        do {
            System.out.println("Product Section:");
            System.out.println("1. Insert Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show All Products");
            System.out.println("5. Back");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter product details (name, description, rating, price, category):");
                Product product = new Product(0, scanner.nextLine(), scanner.nextLine(), Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()), scanner.nextLine());
                productDAO.addProduct(product);
            } else if (choice.equals("2")) {
                System.out.println("Enter productId to update:");
                int productId = scanner.nextInt();
                Product product = productDAO.getProductByProductId(productId);
                if (product != null) {
                    System.out.println("Enter new details (name, description, rating, price, category):");
                    product.setName(scanner.nextLine());
                    product.setDescription(scanner.nextLine());
                    product.setRating(Double.parseDouble(scanner.nextLine()));
                    product.setPrice(Double.parseDouble(scanner.nextLine()));
                    product.setCategory(scanner.nextLine());
                    productDAO.updateProduct(product);
                } else {
                    System.out.println("Product not found.");
                }
            } else if (choice.equals("3")) {
                System.out.println("Enter productId to delete:");
                int productId = Integer.parseInt(scanner.nextLine());
                productDAO.deleteProduct(productId);
            } else if (choice.equals("4")) {
                List<Product> products = productDAO.getAllProducts();
                for (Product product : products) {
                    System.out.println(product);
                }
            } else if (choice.equals("5")) {
                back = true;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (!back);
    }

    private static void handleOrderSection(OrderDAOImpl orderDAO) {
        boolean back = false;
        do {
            System.out.println("Order Section:");
            System.out.println("1. Insert Order Data");
            System.out.println("2. Update Order Data");
            System.out.println("3. Delete Order Data");
            System.out.println("4. Show All Order Data");
            System.out.println("5. Back");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter order details (userId, productId, status, paymentMode):");
                Order order = new Order(0, Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine()),null, scanner.nextLine(), 0, scanner.nextLine());
                orderDAO.addOrder(order);
            } else if (choice.equals("2")) {
                System.out.println("Enter orderId to update:");
                int orderId = Integer.parseInt(scanner.nextLine());
                Order order = orderDAO.getOrderById(orderId);
                if (order != null) {
                    System.out.println("Enter new details (userId, productId, status, paymentMode):");
                    order.setUserId(Integer.parseInt(scanner.nextLine()));
                    order.setProductId(Integer.parseInt(scanner.nextLine()));
                    order.setStatus(scanner.nextLine());
                    order.setPrice(0);
                    order.setPaymentMode(scanner.nextLine());
                    orderDAO.updateOrder(order);
                } else {
                    System.out.println("Order not found.");
                }
            } else if (choice.equals("3")) {
                System.out.println("Enter orderId to delete:");
                int orderId = Integer.parseInt(scanner.nextLine());
                orderDAO.deleteOrder(orderId);
            } else if (choice.equals("4")) {
                List<Order> orders = orderDAO.getAllOrders();
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println(Order.getHeader());
                System.out.println("----------------------------------------------------------------------------------------");
                for (Order order : orders) {
                    System.out.println(order);
                }
                System.out.println("----------------------------------------------------------------------------------------");
            } else if (choice.equals("5")) {
                back = true;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (!back);
    }

    private static void handleOrderItemSection(OrderItemDAOImpl orderItemDAO) {
        boolean back = false;
        do {
            System.out.println("OrderItem Section:");
            System.out.println("1. Insert OrderItem Data");
            System.out.println("2. Update OrderItem Data");
            System.out.println("3. Delete OrderItem Data");
            System.out.println("4. Show All OrderItem Data");
            System.out.println("5. Back");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter orderItem details (orderId, quantity):");
                OrderItem orderItem = new OrderItem(0, Integer.parseInt(scanner.nextLine()), 0, Integer.parseInt(scanner.nextLine()), 0);
                orderItemDAO.addOrderItem(orderItem);
            } else if (choice.equals("2")) {
                System.out.println("Enter orderItemId to update:");
                int orderItemId = Integer.parseInt(scanner.nextLine());
                OrderItem orderItem = orderItemDAO.getOrderItemById(orderItemId);
                if (orderItem != null) {
                    System.out.println("Enter new details (orderId, quantity):");
                    orderItem.setOrderId(Integer.parseInt(scanner.nextLine()));
                    orderItem.setProductId(0);
                    orderItem.setQuantity(Integer.parseInt(scanner.nextLine()));
                    orderItem.setPrice(0);
                    orderItemDAO.updateOrderItem(orderItem);
                } else {
                    System.out.println("OrderItem not found.");
                }
            } else if (choice.equals("3")) {
                System.out.println("Enter orderItemId to delete:");
                int orderItemId = Integer.parseInt(scanner.nextLine());
                orderItemDAO.deleteOrderItem(orderItemId);
            } else if (choice.equals("4")) {
            	System.out.println("Enter Order Id to fetch the data");
                List<OrderItem> orderItems = orderItemDAO.getOrderItemsByOrderId(Integer.parseInt(scanner.nextLine()));
                System.out.println("-------------------------------------------------------");
                System.out.println(OrderItem.getTableHeader());
                System.out.println("-------------------------------------------------------");
                for (OrderItem orderItem : orderItems) {
                    System.out.println(orderItem);
                }
                System.out.println("-------------------------------------------------------");
            } else if (choice.equals("5")) {
                back = true;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        } while (!back);
    }
}

