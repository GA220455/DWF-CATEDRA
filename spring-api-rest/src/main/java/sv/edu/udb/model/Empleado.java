package sv.edu.udb.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String puesto;

    @Column(name = "turno_actual")
    private boolean turnoActual;

    public boolean isTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(boolean turnoActual) {
        this.turnoActual = turnoActual;
    }

    public void setEnTurno(boolean enTurno) {
    }
    @Column(name = "imagen_url")
    private String imagenUrl;
}