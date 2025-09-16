package org.esfe.modelos;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "noticias")
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
