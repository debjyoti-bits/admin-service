package org.bits.adminservice.service;


import org.bits.adminservice.model.User;
import org.bits.adminservice.model.Order;
import org.bits.adminservice.model.Report;
import org.bits.adminservice.repositories.UserRepository;
import org.bits.adminservice.repositories.OrderRepository;
import org.bits.adminservice.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReportRepository reportRepository;

    // Manage Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setName(userDetails.getName());
            user.setPassword(userDetails.getPassword());
            user.setUsername(userDetails.getUsername());
            return userRepository.save(user);
        });
    }

    public void deactivateUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            userRepository.save(user);
        });
    }

    // Manage Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> updateOrder(Long id, Order orderDetails) {
        return orderRepository.findById(id).map(order -> {
            order.setStatus(orderDetails.getStatus());
            order.setTotalAmount(orderDetails.getTotalAmount());
            order.setCustomerId(orderDetails.getCustomerId());
            return orderRepository.save(order);
        });
    }

    // Generate Reports
    public List<Report> generateReports() {
        return reportRepository.findAll();
    }

    // Monitor Platform Activity
    public String monitorPlatformActivity() {
        // Placeholder for real implementation
        return "Activity log data";
    }
}
