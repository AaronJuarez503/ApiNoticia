package org.esfe.servicios.interfaces;

import org.esfe.dtos.categoria.CategoriaSalida;
import org.esfe.dtos.categoria.CategoriaGuardar;
import org.esfe.dtos.categoria.CategoriaModificar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ICategoriaService {
    List<CategoriaSalida> obtenertodos ();

    Page<CategoriaSalida> obtenerPaginado(Pageable pageable);

    CategoriaSalida obtenerPorId(Integer id);

    CategoriaSalida crear(CategoriaGuardar categoriaGuardar);

    CategoriaSalida editar(CategoriaModificar categoriaModificar);

    void eliminar(Integer id);
}
