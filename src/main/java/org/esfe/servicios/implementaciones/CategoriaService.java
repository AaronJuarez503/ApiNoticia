package org.esfe.servicios.implementaciones;

import java.util.List;
import java.util.stream.Collectors;

import org.esfe.dtos.categoria.CategoriaGuardar;
import org.esfe.dtos.categoria.CategoriaModificar;
import org.esfe.dtos.categoria.CategoriaSalida;
import org.esfe.modelos.Categoria;
import org.esfe.repositorios.ICategoriaRepository;
import org.esfe.servicios.interfaces.ICategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoriaSalida crear(CategoriaGuardar categoriaGuardar) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaGuardar, Categoria.class));
        return modelMapper.map(categoria, CategoriaSalida.class);
    }  

    @Override
    public CategoriaSalida editar(CategoriaModificar categoriaModificar) {
        Categoria categoria = categoriaRepository.save(modelMapper.map(categoriaModificar, Categoria.class));
        return modelMapper.map(categoria, CategoriaSalida.class);
    }

    @Override
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Page<CategoriaSalida> obtenerPaginado(Pageable pageable) {
    Page<Categoria> page = categoriaRepository.findAll(pageable);

    List<CategoriaSalida> categoriasDto = page.stream()
        .map(categoria -> modelMapper.map(categoria, CategoriaSalida.class))
        .collect(Collectors.toList());

    return new PageImpl<>(categoriasDto, page.getPageable(), page.getTotalElements());
    }


    @Override
    public CategoriaSalida obtenerPorId(Integer id) {
        return modelMapper.map(categoriaRepository.findById(id).get(), CategoriaSalida.class);
    }

    @Override
    public List<CategoriaSalida> obtenertodos() {
    List<Categoria> categorias = categoriaRepository.findAll();

    return categorias.stream()
        .map(categoria -> modelMapper.map(categoria, CategoriaSalida.class))
        .collect(Collectors.toList());
    }
}
