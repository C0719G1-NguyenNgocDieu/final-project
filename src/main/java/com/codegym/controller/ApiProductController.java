package com.codegym.controller;

import com.codegym.model.Products;
import com.codegym.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ApiProductController {
    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Products>> listProduct(Pageable pageable) {
        Page<Products> products = productsService.findByAll(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<Page<Products>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Page<Products>>(products, HttpStatus.OK);
    }

//    @RequestMapping(value = "/product", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity
}
