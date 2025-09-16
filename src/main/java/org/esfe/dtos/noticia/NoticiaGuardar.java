package org.esfe.dtos.noticia;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticiaGuardar implements Serializable {
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;
    private Integer categoriaId;
}
