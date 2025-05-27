package sv.edu.udb.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private boolean nuevo;
    private String imagenUrl;
}
