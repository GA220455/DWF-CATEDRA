package sv.edu.udb.controller.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoResponse {
    private Long id;
    private String nombre;
    private String correo;
    private String puesto;
    private boolean enTurno;
    private String imagenUrl;

}