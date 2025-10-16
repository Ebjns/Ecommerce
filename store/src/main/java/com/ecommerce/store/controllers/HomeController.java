package com.ecommerce.store.controllers;

import com.ecommerce.store.repository.OrderRepository;
import com.ecommerce.store.models.Order;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // allow React access
@RequestMapping("/orders")
public class HomeController {
    private final OrderRepository repo;

    public HomeController(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Order> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Order add(@RequestBody Order order) {
        return repo.save(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order updatedOrder) {
        return repo.findById(id)
                .map(o -> {
                    o.setItemName(updatedOrder.getItemName());
                    o.setCompleted(updatedOrder.isCompleted());
                    return repo.save(o);
                })
                .orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
