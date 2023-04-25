package br.com.apirestjavaspring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.apirestjavaspring.model.Usuario;
import br.com.apirestjavaspring.repository.UsuarioRepository;

@RestController // Annotation que define que o mesmo será uma Rota de requisições REST, ou seja,
                // uma API
public class UsuarioControler {

    @Autowired
    UsuarioRepository usuarioRepository;

    // Método GET
    @GetMapping("/usuarios") // Mapeia uma requisição GET na rota definida para o Método a seguir.
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Método DELETE
    @DeleteMapping("/usuarios/delete/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
        // Verifica se o cliente com o ID fornecido existe no banco de dados
        if (!usuarioRepository.existsById(id)) {
            // Se não existir retorna resposta HTTP notFound
            return ResponseEntity.notFound().build();
        }

        // Caso o cliente exista, deleta-o do banco de dados
        usuarioRepository.deleteById(id);
        // Retorna resposta HTTP ok
        return ResponseEntity.ok().build();
    }

    // Método POST
    @PostMapping("/usuarios/save")
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

    // Método PUT
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setSexo(usuarioAtualizado.getSexo());
            usuario.setLogin(usuarioAtualizado.getLogin());
            usuario.setSenha(usuarioAtualizado.getSenha());

            Usuario usuarioSalvo = usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}