package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.model.Brinquedo;
import br.com.fiap.checkpoint2.service.BrinquedoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;

    // GET - listar todos
    @GetMapping
    public List<Brinquedo> listarTodos() {
        return brinquedoService.listarTodos();
    }

    // GET - buscar por ID
    @GetMapping("/{id}")
    public Optional<Brinquedo> buscarPorId(@PathVariable Long id) {
        return brinquedoService.buscarPorId(id);
    }

    // POST - cadastrar
    @PostMapping
    public Brinquedo salvar(@RequestBody Brinquedo brinquedo) {
        return brinquedoService.salvar(brinquedo);
    }

    // PUT - atualizar
    @PutMapping("/{id}")
    public Brinquedo atualizar(@PathVariable Long id,
                               @RequestBody Brinquedo brinquedo) {
        return brinquedoService.atualizar(id, brinquedo);
    }

    // DELETE - deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        brinquedoService.deletar(id);
    }
}
