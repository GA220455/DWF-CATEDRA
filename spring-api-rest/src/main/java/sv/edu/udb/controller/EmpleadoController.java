package sv.edu.udb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import sv.edu.udb.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoResponse> listar() {
        return empleadoService.getAll();
    }

    @PostMapping
    public EmpleadoResponse crear(@RequestBody EmpleadoRequest request) {
        return empleadoService.create(request);
    }

    @PutMapping("/{id}")
    public EmpleadoResponse actualizar(@PathVariable Long id, @RequestBody EmpleadoRequest request) {
        return empleadoService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        empleadoService.delete(id);
    }
}