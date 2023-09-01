package com.programmingtechie.inventoryservice.controller;


import com.programmingtechie.inventoryservice.dto.InventoryResponse;
import com.programmingtechie.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    // http://localhost:8082/api/inventory/iphone-13

    // http://localhost:8082/api/inventory/sku-code=iphone-13
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> instock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);

    }
}
