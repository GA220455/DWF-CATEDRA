package sv.edu.udb.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequest {
    @NotBlank
    private String nombre;

    private String descripcion;
    private double precio;
    private String categoria;
    private boolean nuevo;
    private String imagenUrl;
}
