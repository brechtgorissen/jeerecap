package gorissen.brecht.jeerecap.controllers;

import gorissen.brecht.jeerecap.model.Product;
import gorissen.brecht.jeerecap.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class NewController {

    @Autowired
    private ProductRepository repo;

    @ModelAttribute("newP")
    public Product newProduct(){
        return new Product();
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNew(ModelMap map){
        return "new";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(@Valid @ModelAttribute("newP") Product newProduct, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "new";
        }
        repo.save(newProduct);
        return "redirect:/index";
    }
}
