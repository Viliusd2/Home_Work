package com.radom.eshop_ra_dom;

import com.radom.eshop_ra_dom.product.exception.ProductNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.beans.PropertyEditor;
import java.util.Date;


@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public String productNotFound(ProductNotFoundException e, Model model) {
        model.addAttribute("productId", e.getProductId());
        return "product/error/productNotFound";
    }

    @ModelAttribute("modelDate")
    public Date now() {
        return new Date();
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        PropertyEditor stringTrimmer = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmer);
    }
}
