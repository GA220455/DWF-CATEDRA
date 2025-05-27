package sv.edu.udb.service.mapper;


import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import sv.edu.udb.model.Empleado;


import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    Empleado toEmpleado(EmpleadoRequest request);
    EmpleadoResponse toResponse(Empleado empleado);
    List<EmpleadoResponse> toResponseList(List<Empleado> empleados);
}