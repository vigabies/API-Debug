package br.com.bidu.escolaapi.resource;

import br.com.bidu.escolaapi.model.Aluno;
import br.com.bidu.escolaapi.model.Curso;
import br.com.bidu.escolaapi.repository.AlunoRepository;
import br.com.bidu.escolaapi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/todos")
    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll(Sort.by("nomealuno").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPeloId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.isPresent() ? ResponseEntity.ok(aluno.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        Aluno alunoSalvo = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }


}
