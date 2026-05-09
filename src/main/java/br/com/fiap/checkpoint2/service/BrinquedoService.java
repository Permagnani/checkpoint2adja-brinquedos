package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.model.Brinquedo;
import br.com.fiap.checkpoint2.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    // Método para listar todos
    public List<Brinquedo> listarTodos() {
        return brinquedoRepository.findAll();
    }

    // Método para buscar por ID
    public Optional<Brinquedo> buscarPorId(Long id) {
        return brinquedoRepository.findById(id);
    }

    // Método para salvar
    public Brinquedo salvar(Brinquedo brinquedo) {
        return brinquedoRepository.save(brinquedo);
    }

    // Método para atualizar
    public Brinquedo atualizar(Long id, Brinquedo brinquedoDetalhes) {
        return brinquedoRepository.findById(id).map(brinquedo -> {
            brinquedo.setNome(brinquedoDetalhes.getNome());
            brinquedo.setTipo(brinquedoDetalhes.getTipo());
            brinquedo.setClassificacao(brinquedoDetalhes.getClassificacao());
            brinquedo.setTamanho(brinquedoDetalhes.getTamanho());
            brinquedo.setPreco(brinquedoDetalhes.getPreco());
            return brinquedoRepository.save(brinquedo);
        }).orElseThrow(() -> new RuntimeException("Brinquedo não encontrado com o ID: " + id));
    }

    // Método para deletar
    public void deletar(Long id) {
        brinquedoRepository.deleteById(id);
    }
}
