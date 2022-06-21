package org.example.eshop.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

import static org.example.eshop.EshopEndpoints.CART_ROOT_PATH;
import static org.example.eshop.EshopEndpoints.PRODUCT_UPDATE_PATH;

@ControllerAdvice
public class GlobalModelAttributeAdvice {

    @ModelAttribute("modelDate")
    public Date now() {
        return new Date();
    }

    @ModelAttribute("currency")
    public char currency() {
        return '$';
    }

    @ModelAttribute("cartPath")
    public String cartPath() {
        return CART_ROOT_PATH;
    }

    @ModelAttribute("productUpdatePath")
    public String productUpdatePath() {
        return PRODUCT_UPDATE_PATH;
    }
}
