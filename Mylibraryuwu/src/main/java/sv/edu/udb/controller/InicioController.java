package sv.edu.udb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "index"; // Carga index.html
    }

    @GetMapping("/login-cliente")
    public String loginCliente() {
        return "login-cliente"; // Formulario de login para cliente
    }

    @GetMapping("/login-empleado")
    public String loginEmpleado() {
        return "login-empleado"; // Formulario de login para admin/empleado
    }


}
