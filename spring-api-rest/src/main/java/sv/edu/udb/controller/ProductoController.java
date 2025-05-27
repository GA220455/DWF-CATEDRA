package sv.edu.udb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.ProductoRequest;
import sv.edu.udb.controller.response.ProductoResponse;
import sv.edu.udb.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping
    public List<ProductoResponse> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ProductoResponse getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public ProductoResponse createProducto(@RequestBody @Valid ProductoRequest request) {
        return productoService.createProducto(request);
    }

    @PutMapping("/{id}")
    public ProductoResponse updateProducto(@PathVariable Long id, @RequestBody @Valid ProductoRequest request) {
        return productoService.updateProducto(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}
