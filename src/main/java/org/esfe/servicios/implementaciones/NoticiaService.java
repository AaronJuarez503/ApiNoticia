package org.esfe.servicios.implementaciones;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.esfe.dtos.noticia.NoticiaGuardar;
import org.esfe.dtos.noticia.NoticiaModificar;
import org.esfe.dtos.noticia.NoticiaSalida;
import org.esfe.modelos.Noticia;
import org.esfe.repositorios.INoticiaRepository;
import org.esfe.servicios.interfaces.INoticiaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService implements INoticiaService {

    @Autowired
    private INoticiaRepository noticiaRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NoticiaSalida crear(NoticiaGuardar noticiaGuardar) {
        Noticia noticia = modelMapper.map(noticiaGuardar, Noticia.class);
        noticia.setId(null);

        return modelMapper.map(noticiaRepository.save(noticia), NoticiaSalida.class);
    }



    @Override
    public NoticiaSalida editar(NoticiaModificar noticiaModificar) {
        Noticia noticia = noticiaRepository.save(modelMapper.map(noticiaModificar, Noticia.class));
        
        return modelMapper.map(noticia, NoticiaSalida.class);
    }

    @Override
    public void eliminarPorId(Integer id) {
        noticiaRepository.deleteById(id);
    }

    @Override
    public NoticiaSalida obtenerPorId(Integer id) {
        Optional<Noticia> noticia = noticiaRepository.findById(id);

        if (noticia.isPresent()) {
            return modelMapper.map(noticia.get(), NoticiaSalida.class);
        }
        return null;
    }


    @Override
    public List<NoticiaSalida> obtenerTodos() {
        List<Noticia> noticias = noticiaRepository.findAll();

        return noticias.stream()
            .map(noticia -> modelMapper.map(noticia, NoticiaSalida.class))
            .collect(Collectors.toList());
    }


    @Override
    public Page<NoticiaSalida> obtenerTodosPaginado(Pageable pageable) {
        Page<Noticia> page = noticiaRepository.findAll(pageable);

        List<NoticiaSalida> noticiasDto = page.stream()
            .map(noticia -> modelMapper.map(noticia, NoticiaSalida.class))
            .collect(Collectors.toList());

        return new PageImpl<>(noticiasDto, page.getPageable(), page.getTotalElements());
    }


}
