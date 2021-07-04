package com.costa.luiz.grocery.orders;

import com.costa.luiz.grocery.parsers.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class FindOrders {

    @GetMapping("{id}")
    List<OrderDTO> findOrdersById(@PathVariable String id) {
       return Collections.emptyList();
    }

    @GetMapping
    List<OrderDTO> findOrders() {
        return Collections.emptyList();
    }
}
