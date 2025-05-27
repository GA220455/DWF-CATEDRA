package sv.edu.udb.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;
import sv.edu.udb.model.Empleado;
import sv.edu.udb.repository.EmpleadoRepository;

import sv.edu.udb.service.EmpleadoService;
import sv.edu.udb.service.mapper.EmpleadoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper empleadoMapper;

    @Override
    public List<EmpleadoResponse> getAll() {
        return empleadoMapper.toResponseList(empleadoRepository.findAll());
    }

    @Override
    public EmpleadoResponse create(EmpleadoRequest request) {
        Empleado nuevo = empleadoMapper.toEmpleado(request);
        return empleadoMapper.toResponse(empleadoRepository.save(nuevo));
    }

    @Override
    public EmpleadoResponse update(Long id, EmpleadoRequest request) {
        Empleado empleado = empleadoRepository.findById(id).orElseThrow();
        empleado.setNombre(request.getNombre());
        empleado.setCorreo(request.getCorreo());
        empleado.setPuesto(request.getPuesto());
        empleado.setEnTurno(request.isEnTurno());
        return empleadoMapper.toResponse(empleadoRepository.save(empleado));
    }

    @Override
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }
}