package sv.edu.udb.service;

import org.springframework.stereotype.Service;
import sv.edu.udb.model.Producto;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Override
    public List<Producto> obtenerTodos() {
        return Arrays.asList(
                new Producto("Libro de Java", "Aprende Java desde cero", 15.99),
                new Producto("Kit de Manualidades", "Incluye tijeras, papel, pegamento", 9.50),
                new Producto("Silla de Oficina", "Silla ergonómica negra", 89.00),
                new Producto("Almohada Decorativa", "Almohada para sala o cuarto", 12.00)
        );
    }
}
