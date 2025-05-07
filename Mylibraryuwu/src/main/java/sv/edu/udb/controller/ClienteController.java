package sv.edu.udb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sv.edu.udb.service.ProductoService;

@Controller
public class ClienteController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/cliente/productos")
    public String verCatalogo(Model model) {
        model.addAttribute("productos", productoService.obtenerTodos());
        return "catalogo-cliente";
    }
}
