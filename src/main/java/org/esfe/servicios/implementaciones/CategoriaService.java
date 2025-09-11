package org.esfe.servicios.implementaciones;

import java.util.List;

import org.esfe.dtos.categoria.CategoriaGuardar;
import org.esfe.dtos.categoria.CategoriaModificar;
import org.esfe.dtos.categoria.CategoriaSalida;
import org.esfe.servicios.interfaces.ICategoriaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.esfe.repositorios.ICategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Override
    public CategoriaSalida crear(CategoriaGuardar categoriaGuardar) {
        return null;
    }

    @Override
    public CategoriaSalida editar(CategoriaModificar categoriaModificar) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        
    }

    @Override
    public Page<CategoriaSalida> obtenerPaginado(Pageable pageable) {
        return null;
    }

    @Override
    public CategoriaSalida obtenerPorId(Integer id) {
        return null;
    }

    @Override
    public List<CategoriaSalida> obtenertodos() {
        return null;
    }
}
