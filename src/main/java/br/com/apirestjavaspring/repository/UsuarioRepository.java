package br.com.apirestjavaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.apirestjavaspring.model.Usuario;

// Criação da interface para manipular os dados na DB
// Extende a classe que possui os métodos JPA e informa a Entidade (E seu tipo) que será Manipulada
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
