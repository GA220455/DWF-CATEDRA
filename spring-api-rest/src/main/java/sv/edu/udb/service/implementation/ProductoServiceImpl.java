package sv.edu.udb.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.ProductoRequest;
import sv.edu.udb.controller.response.ProductoResponse;

import sv.edu.udb.model.Producto;
import sv.edu.udb.repository.ProductoRepository;
import sv.edu.udb.service.ProductoService;
import sv.edu.udb.service.mapper.ProductoMapper;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public List<ProductoResponse> getAllProductos() {
        return productoRepository.findAll()
                .stream()
                .map(productoMapper::toResponse)
                .toList();
    }

    @Override
    public ProductoResponse getProductoById(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + id));
        return productoMapper.toResponse(producto);
    }

    @Override
    public ProductoResponse createProducto(ProductoRequest request) {
        Producto producto = productoMapper.toEntity(request);
        producto = productoRepository.save(producto);
        return productoMapper.toResponse(producto);
    }

    @Override
    public ProductoResponse updateProducto(Long id, ProductoRequest request) {
        Producto existente = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + id));

        existente.setNombre(request.getNombre());
        existente.setDescripcion(request.getDescripcion());
        existente.setCategoria(request.getCategoria());
        existente.setPrecio(request.getPrecio());
        existente.setNuevo(request.isNuevo());
        existente.setImagenUrl(request.getImagenUrl());

        Producto actualizado = productoRepository.save(existente);
        return productoMapper.toResponse(actualizado);
    }

    @Override
    public void deleteProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto no encontrado con ID: " + id));
        productoRepository.delete(producto);
    }
}
