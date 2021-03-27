package com.codegym.cart.services;

import com.codegym.cart.models.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> findAll();
    Item findById(int id);
}
