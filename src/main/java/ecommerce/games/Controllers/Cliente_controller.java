package ecommerce.games.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ecommerce.games.Entitys.Cliente;
import ecommerce.games.Services.Cliente_svc.Add_cliente_svc;
import ecommerce.games.Services.Cliente_svc.Del_cliente_svc;
import ecommerce.games.Services.Cliente_svc.Get_cliente_svc;

@RestController
public class Cliente_controller {
    

    @Autowired
    private Del_cliente_svc del_cliente_svc;

    @Autowired 
    private Add_cliente_svc add_cliente_svc;

    @Autowired
    private Get_cliente_svc get_cliente_svc;

    @GetMapping("/get_client")
    public ResponseEntity<List<Cliente>> getCliente(@RequestParam(required = false) Long id) {
        List<Cliente> lista_cli = get_cliente_svc.execute();
        return ResponseEntity.ok(lista_cli);
    }
    
    @RequestMapping(value="/add_client", method=RequestMethod.POST)
    public ResponseEntity<Cliente> addCliente(@RequestBody(required=true) Cliente cliente){
        return add_cliente_svc.execute(cliente);
    }

    @RequestMapping(value="/delete_client", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteCliente(@RequestParam(required=true) long id){
        return del_cliente_svc.execute(id);
    }
} 
