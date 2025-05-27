package sv.edu.udb.controller.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoRequest {
    private String nombre;
    private String correo;
    private String puesto;
    private boolean enTurno;
}