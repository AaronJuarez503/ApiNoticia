package org.esfe.Controladores;

import java.util.List;

import org.esfe.dtos.noticia.NoticiaGuardar;
import org.esfe.dtos.noticia.NoticiaModificar;
import org.esfe.dtos.noticia.NoticiaSalida;
import org.esfe.servicios.interfaces.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    @Autowired
    private INoticiaService noticiaService;

    @GetMapping
    public ResponseEntity<Page<NoticiaSalida>> mostrarTodosPaginados(Pageable pageable){
        Page<NoticiaSalida> noticias = noticiaService.obtenerTodosPaginado(pageable);

        if(noticias.hasContent()){
            return ResponseEntity.ok(noticias);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lista")
    public ResponseEntity<List<NoticiaSalida>> mostrarTodos() {
        List<NoticiaSalida> noticias = noticiaService.obtenerTodos();

        if (!noticias.isEmpty()) {
            return ResponseEntity.ok(noticias);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticiaSalida> mostrarPorId(@PathVariable Integer id){
        NoticiaSalida noticia = noticiaService.obtenerPorId(id);

        if(noticia != null){
            return ResponseEntity.ok(noticia);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<NoticiaSalida> crear(@RequestBody NoticiaGuardar noticiaGuardar){
        NoticiaSalida noticia = noticiaService.crear(noticiaGuardar);

        if(noticia != null){
            return ResponseEntity.ok(noticia);
        }

        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NoticiaSalida> editar(@PathVariable Integer id, @RequestBody NoticiaModificar noticiaModificar) {
        NoticiaSalida noticia = noticiaService.editar(noticiaModificar);

        if (noticia != null) {
            return ResponseEntity.ok(noticia);
        }

        return ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id){
        noticiaService.eliminarPorId(id);
        return ResponseEntity.ok().body("Noticia eliminada correctamente");
    }
}
