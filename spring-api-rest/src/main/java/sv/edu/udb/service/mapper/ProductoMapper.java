package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.ProductoRequest;
import sv.edu.udb.controller.response.ProductoResponse;
import sv.edu.udb.model.Producto;


@Mapper(componentModel = "spring")
public interface ProductoMapper {
    Producto toEntity(ProductoRequest request);
    ProductoResponse toResponse(Producto producto);
}
