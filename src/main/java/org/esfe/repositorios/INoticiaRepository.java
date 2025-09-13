package org.esfe.repositorios;

import org.esfe.modelos.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INoticiaRepository extends JpaRepository<Noticia, Integer> {
}
