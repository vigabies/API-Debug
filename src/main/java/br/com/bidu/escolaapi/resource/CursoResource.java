package br.com.bidu.escolaapi.resource;

import br.com.bidu.escolaapi.model.Curso;
import br.com.bidu.escolaapi.repository.CursoRepository;
import br.com.bidu.escolaapi.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoResource {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;

    @GetMapping("/todos")
    public List<Curso> listarTodosCursos() {
        return cursoService.listarTodosCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPeloId(@PathVariable Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.isPresent() ? ResponseEntity.ok(curso.get()) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        cursoRepository.deleteById(id);
    }

    @PostMapping()
    public ResponseEntity<Curso> criar(@RequestBody Curso curso, HttpServletResponse response) {
       Curso cursoSalvo = cursoService.salvar(curso);
       return ResponseEntity.status(HttpStatus.CREATED).body(cursoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        Curso cursoSalvo = cursoService.atualizar(id, curso);
        return ResponseEntity.ok(cursoSalvo);
    }
}
