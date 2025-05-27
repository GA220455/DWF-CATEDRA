package sv.edu.udb.service;


import sv.edu.udb.controller.request.EmpleadoRequest;
import sv.edu.udb.controller.response.EmpleadoResponse;

import java.util.List;

public interface EmpleadoService {
    List<EmpleadoResponse> getAll();
    EmpleadoResponse create(EmpleadoRequest request);
    EmpleadoResponse update(Long id, EmpleadoRequest request);
    void delete(Long id);
}