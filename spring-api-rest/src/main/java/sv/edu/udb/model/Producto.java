package sv.edu.udb.model;



    import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "productos")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Producto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;
        private boolean nuevo;
        private String imagenUrl;
    }