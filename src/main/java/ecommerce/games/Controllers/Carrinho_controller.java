package ecommerce.games.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ecommerce.games.Entitys.Item;
import ecommerce.games.Entitys.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import ecommerce.games.Services.Carrinho_svc.Create_carrinho_svc;
import ecommerce.games.Services.Produto_svc.Get_produto_svc;

@Controller
@RequestMapping("carrinho")
public class Carrinho_controller {

    @Autowired
    private Create_carrinho_svc create_carrinho_svc;

    @Autowired
    private Get_produto_svc get_produto_svc;
		
    public ResponseEntity criaCarrinho(@RequestParam(required = true) Long id_cliente, Long id_produto){
        create_carrinho_svc.create(id_cliente, id_produto);
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap, HttpSession session){
        modelMap.put("valorTotal", somaTotal(session));
        return "carrinho";
    }

    @RequestMapping(value = "checkout", method = RequestMethod.GET)
    public String checkout(HttpSession session){
        if (session.getAttribute("username") == null){
            return "list_product";
        } else {
            return "checkout";
        }
    }

    @RequestMapping(value="comprar/{id_produto}", method = RequestMethod.GET)
    public String add(@PathVariable(name = "id_produto") Long id, ModelMap modelMap, HttpSession session){
        if(session.getAttribute("carrinho") == null){
            List<Item> carrinho = new ArrayList<Item>();
            carrinho.add(new Item(get_produto_svc.execute(id), 1));
            session.setAttribute("carrinho", carrinho);
        } else {
            List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
            int index = ExisteNoCarrinho(id, carrinho);
            if (index == -1){
                carrinho.add(new Item(get_produto_svc.execute(id), 1));
            } else {
                int qnt = carrinho.get(index).getQuantidade() + 1;
                carrinho.get(index).setQuantidade(qnt);
            }
            session.setAttribute("carrinho", carrinho);
        }
        return "redirect:/carrinho";
    }


    @RequestMapping(value="update", method = RequestMethod.POST)
    public String update(HttpServletRequest req, HttpSession session){
        String[] quantidades = req.getParameterValues("quantidade");
        List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
        for(int i = 0; i < carrinho.size(); i++){
            carrinho.get(i).setQuantidade(Integer.parseInt(quantidades[i]));
        }
        session.setAttribute("carrinho", carrinho);
        return "carrinho";
    }

    @RequestMapping(value="remove/{id_produto}", method = RequestMethod.GET)
    public String remove(@PathVariable(name = "id_produto") Long id, HttpSession session){
        List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
        int index = ExisteNoCarrinho(id, carrinho);
        carrinho.remove(index);
        session.setAttribute("carrinho", carrinho);
        return "carrinho";
    }

    private double somaTotal(HttpSession session){
        List<Item> carrinho = (List<Item>) session.getAttribute("carrinho");
        double soma = 0;
        for(Item item : carrinho){
            soma += (item.getQuantidade() * item.getProduto().getPreco().doubleValue());
        }
        return soma;
    }

    private int ExisteNoCarrinho(Long id, List<Item> carrinho){
        for(int i = 0; i < carrinho.size(); i++){
            if (carrinho.get(i).getProduto().getId_produto() == id){
                return i;
            }
        }
        return -1;
    }
    
}
