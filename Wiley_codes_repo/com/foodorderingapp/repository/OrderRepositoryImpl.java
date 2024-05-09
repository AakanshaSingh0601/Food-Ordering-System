package com.foodorderingapp.repository;

import com.foodorderingapp.model.Order;
import com.foodorderingapp.model.OrderStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {

    private Map<Long, Order> orders;
    private Map<Long, List<Order>> ordersByDeliveryAgent;
    private Map<Long, List<Order>> ordersByCustomer;
    private Map<Long, List<Order>> ordersByRestaurant;

    public OrderRepositoryImpl() {
        this.orders = new HashMap<>();
        this.ordersByDeliveryAgent = new HashMap<>();
        this.ordersByCustomer = new HashMap<>();
        this.ordersByRestaurant = new HashMap<>();
    }


    public void placeOrder(Order order) {
        orders.put(order.getOrderId(), order);
        addToMap(order.getDeliveryAgentId(), order, ordersByDeliveryAgent);
        addToMap(order.getCustomerId(), order, ordersByCustomer);
        addToMap(order.getRestaurantId(), order, ordersByRestaurant);
    }


    public void updateOrderStatus(long orderId, Long id, OrderStatus status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(status);
        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
    }


    public List<Order> getOrdersByDeliveryAgent(long deliveryAgentId) {
        return ordersByDeliveryAgent.getOrDefault(deliveryAgentId, new ArrayList<>());
    }


    public List<Order> getOrdersByCustomerId(long customerId) {
        return ordersByCustomer.getOrDefault(customerId, new ArrayList<>());
    }

    @Override
    public void addToCart(Long customerId, long menuItemId, int quantity, String specialInstructions) {

    }

    @Override
    public void placeOrder(long l, String deliveryAddress, String cardNumber, String expiryDate, String cvv) {

    }


    public Order getOrderById(long orderId) {
        Order order = orders.get(orderId);
        if (order != null) {
            return order;
        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
    }

   public Order getOrderByRepository(long orderId) {
        return null;
    }




    public List<Order> getOrdersByCustomer(long customerId) {
        return ordersByCustomer.getOrDefault(customerId, new ArrayList<>());
    }


    public List<Order> getOrdersByRestaurant(long restaurantId) {
        return ordersByRestaurant.getOrDefault(restaurantId, new ArrayList<>());
    }

    private void addToMap(long id, Order order, Map<Long, List<Order>> map) {
        map.computeIfAbsent(id, k -> new ArrayList<>()).add(order);
    }
}
