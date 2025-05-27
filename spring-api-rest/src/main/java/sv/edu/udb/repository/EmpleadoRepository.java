package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.model.Empleado;


import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    Optional<Empleado> findByTurnoActualTrue();
}