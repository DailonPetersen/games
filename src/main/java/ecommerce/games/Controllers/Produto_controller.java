package ecommerce.games.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ecommerce.games.Entitys.Produto;
import ecommerce.games.Services.Produto_svc.Add_produto_svc;
import ecommerce.games.Services.Produto_svc.Del_produto_svc;
import ecommerce.games.Services.Produto_svc.Get_produto_svc;

@Controller
public class Produto_controller {
    
    @Autowired
    private Add_produto_svc add_produto_svc;

    @Autowired
    private Get_produto_svc get_produto_svc;

    @Autowired
    private Del_produto_svc del_produto_svc;

    //@RequestMapping("add_product")
    //public ResponseEntity<Produto> addProduto(@RequestBody(required = true) Produto produto) {
    //    return add_produto_svc.execute(produto);
    //}

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute Produto produto, Model model) {
        add_produto_svc.execute(produto);
        model.addAttribute("produto", produto);
        return "produto";
    }

    @GetMapping("/add_product")
    public String getProductForm(Model model){
        model.addAttribute("produto", new Produto());
        return "produto";
    }

    @GetMapping("/produtos")
    public String getGridProducts(ModelMap modelMap){

        modelMap.put("produtos", get_produto_svc.execute());
        return "list_product";
        
        //List<Produto> lista = get_produto_svc.execute();
        //ModelAndView modelAndView = new ModelAndView("list_product");		
        //modelAndView.addObject("produtos", lista);
        //return modelAndView;
    }


    @GetMapping(value="/get_list")
    public ResponseEntity<List<Produto>> getProduto(@RequestParam(required=false) Long id){
        List<Produto> lista = get_produto_svc.execute();
        return ResponseEntity.ok(lista);
    }

    //@GetMapping(value="/get_list")
    //public ModelAndView getProduto(){
    //    ModelAndView list_product = new ModelAndView("list_product");
    //    return list_product;
    //}

    @RequestMapping("del_product")
    public ResponseEntity deleteProduto(@PathVariable(required = true) Long id){
        return del_produto_svc.execute(id);
    }
}
