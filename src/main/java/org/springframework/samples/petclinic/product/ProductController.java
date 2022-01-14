package org.springframework.samples.petclinic.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    private static final String CREATE_PRODUCT = "products/createOrUpdateProductForm";

    @GetMapping(path = "/create")
    public String createProduct(ModelMap model ){
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productService.findAllProductTypes());
        
        return CREATE_PRODUCT;

    }

}
