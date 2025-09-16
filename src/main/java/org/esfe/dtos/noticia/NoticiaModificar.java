package org.esfe.dtos.noticia;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticiaModificar implements Serializable {
    private Integer id;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;
    private Integer categoriaId;
}
