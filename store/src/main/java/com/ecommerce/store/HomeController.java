package com.ecommerce.store;

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
    public List<Orders> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Orders add(@RequestBody Orders order) {
        return repo.save(order);
    }

    @PutMapping("/{id}")
    public Orders update(@PathVariable Long id, @RequestBody Orders updatedOrder) {
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
