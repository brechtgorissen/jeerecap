package gorissen.brecht.jeerecap.controllers;

import gorissen.brecht.jeerecap.model.Product;
import gorissen.brecht.jeerecap.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailsController {

    @Autowired
    private ProductRepository repo;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetailsForID(ModelMap map, @PathVariable(value = "id") int id) {

        Product p = repo.findById(id).get();
        map.addAttribute("product", p);

        return "details";
    }
}
