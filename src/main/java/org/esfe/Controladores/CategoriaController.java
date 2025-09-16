package org.esfe.Controladores;

import java.util.List;

import org.esfe.dtos.categoria.CategoriaGuardar;
import org.esfe.dtos.categoria.CategoriaModificar;
import org.esfe.dtos.categoria.CategoriaSalida;
import org.esfe.servicios.implementaciones.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PreAuthorize("hasAnyRole('ADMINISTRADOR','USUARIO')")
    @GetMapping
    public ResponseEntity<Page<CategoriaSalida>> mostrarTodosPaginados(Pageable pageable) {
        Page<CategoriaSalida> categorias = categoriaService.obtenerPaginado(pageable);
        
        if (categorias.hasContent()) {
            return ResponseEntity.ok(categorias);
        }

        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR','USUARIO')")
    @GetMapping("/lista")
    public ResponseEntity<List<CategoriaSalida>> mostrarTodos() {
        List<CategoriaSalida> categorias = categoriaService.obtenertodos();

        if (!categorias.isEmpty()) {
            return ResponseEntity.ok(categorias);
        }

        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAnyRole('ADMINISTRADOR','USUARIO')")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSalida> buscarPorId(@PathVariable Integer id) {
        CategoriaSalida categoria = categoriaService.obtenerPorId(id);

        if (categoria != null) {
            return ResponseEntity.ok(categoria);
        }

        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    public ResponseEntity<CategoriaSalida> crear(@RequestBody CategoriaGuardar categoriaGuardar) {
        CategoriaSalida categoria = categoriaService.crear(categoriaGuardar);
        return ResponseEntity.ok(categoria);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaSalida> editar(@PathVariable Integer id, @RequestBody CategoriaModificar categoriaModificar) {
        CategoriaSalida categoria = categoriaService.editar(categoriaModificar);
        return ResponseEntity.ok(categoria);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return ResponseEntity.ok("Categoria eliminada correctamente");
    }

}
