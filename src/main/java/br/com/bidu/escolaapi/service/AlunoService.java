package br.com.bidu.escolaapi.service;

import br.com.bidu.escolaapi.model.Aluno;
import br.com.bidu.escolaapi.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

     @Autowired
     private AlunoRepository alunoRepository;

     public Aluno salvar(Aluno aluno) {

         return alunoRepository.save(aluno);
     }

}
