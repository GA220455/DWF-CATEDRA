package sv.edu.udb.service;

import sv.edu.udb.controller.request.ProductoRequest;
import sv.edu.udb.controller.response.ProductoResponse;

import java.util.List;

public interface ProductoService {
    List<ProductoResponse> getAllProductos();
    ProductoResponse getProductoById(Long id);
    ProductoResponse createProducto(ProductoRequest request);
    ProductoResponse updateProducto(Long id, ProductoRequest request);
    void deleteProducto(Long id);
}
