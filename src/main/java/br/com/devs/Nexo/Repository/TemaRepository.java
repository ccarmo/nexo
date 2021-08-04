package br.com.devs.Nexo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.devs.Nexo.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>
{
	public List<Tema> findAllByNomeTemaContainingIgnoreCase (String nomeTema);
}
