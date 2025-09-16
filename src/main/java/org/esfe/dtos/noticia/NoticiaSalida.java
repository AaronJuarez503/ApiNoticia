package org.esfe.dtos.noticia;

import java.io.Serializable;
import java.time.LocalDate;
import org.esfe.dtos.categoria.CategoriaSalida;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticiaSalida implements Serializable {
    private Integer id;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;
    private CategoriaSalida categoria;
}
