package com.foodorderingapp.repository;

import com.foodorderingapp.model.DeliveryAgent;
import com.foodorderingapp.model.Order;
import com.foodorderingapp.model.OrderStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeliveryRepositoryImpl implements DeliveryRepository {
    private Map<Long, DeliveryAgent> deliveryAgents;
    private Map<Long, List<Order>> agentOrders;

    public DeliveryRepositoryImpl() {
        this.deliveryAgents = new HashMap<>();
        this.agentOrders = new HashMap<>();
        // Initialize delivery agents and their orders
    }





    public Order getOrderByID(long orderID) {
        return null;
    }


    @Override
    public void assignOrderToAgent(long orderId, long agentId) {
        // Check if the agent exists
        DeliveryAgent agent = deliveryAgents.get(agentId);
        if (agent != null) {
            // Get the list of orders for the agent
            List<Order> orders = agentOrders.computeIfAbsent(agentId, k -> new ArrayList<>());
            // Add the order to the list
           // orders.add(OrderRepository.getOrderById(orderId));
        } else {
            throw new RuntimeException("Delivery agent not found with ID: " + agentId);
        }
    }

    @Override
    public void updateOrderStatus(long orderId, OrderStatus status) {
        List<Order> orders = agentOrders.values().stream()
                .flatMap(List::stream)
                .filter(order -> order.getOrderId() == orderId)
                .toList();

        if (!orders.isEmpty()) {
            orders.forEach(order -> order.setStatus(status));
        } else {
            throw new RuntimeException("Order not found with ID: " + orderId);
        }
    }

    @Override
    public List<Order> getPendingOrdersByAgent(long agentId) {
        return agentOrders.getOrDefault(agentId, new ArrayList<>());
    }

    @Override
    public DeliveryAgent getDeliveryAgentById(long agentId) {
        DeliveryAgent agent = deliveryAgents.get(agentId);
        if (agent != null) {
            return agent;
        } else {
            throw new RuntimeException("Delivery agent not found with ID: " + agentId);
        }
    }

}
