package org.esfe.servicios.interfaces;

import java.util.List;

import org.esfe.dtos.noticia.NoticiaSalida;
import org.esfe.dtos.noticia.NoticiaGuardar;
import org.esfe.dtos.noticia.NoticiaModificar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface INoticiaService {
    List<NoticiaSalida> obtenerTodos();

    Page<NoticiaSalida> obtenerTodosPaginado(Pageable pageable);

    NoticiaSalida obtenerPorId(Integer id);

    NoticiaSalida crear(NoticiaGuardar noticiaGuardar);

    NoticiaSalida editar(NoticiaModificar noticiaModificar);

    void eliminarPorId(Integer id);
}
