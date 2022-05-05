package com.radom.eshop_ra_dom;

import com.radom.eshop_ra_dom.exception.ProductNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;


@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public String productNotFoundException(ProductNotFoundException e, Model model){
        model.addAttribute("productId", e.getProductId());
        return "product/error/productNotFound";
    }
    @ModelAttribute("modelDate")
    public Date now() {
        return new Date();
    }

}
