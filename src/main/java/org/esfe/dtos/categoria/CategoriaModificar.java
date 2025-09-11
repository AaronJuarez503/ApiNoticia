package org.esfe.dtos.categoria;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaModificar implements Serializable {
    private Integer id;
    private String nombre;

}
