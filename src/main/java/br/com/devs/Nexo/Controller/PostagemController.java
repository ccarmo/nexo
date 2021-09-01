package br.com.devs.Nexo.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.devs.Nexo.Repository.PostagemRepository;
import br.com.devs.Nexo.model.Postagem;


@RequestMapping("/postagem")
@RestController
@CrossOrigin("*")
public class PostagemController 
{
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Postagem> getbyId (@PathVariable Long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nomePostagem}")
	public ResponseEntity<List<Postagem>> getbyNomePostagem (@PathVariable String nomePostagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomePostagemContainingIgnoreCase(nomePostagem));
	}
	
	@PostMapping("/novapostagem")
	public ResponseEntity<Postagem> post (@RequestBody Postagem nomePostagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(nomePostagem));
	}
	
	@PutMapping("/alterarpostagem")
	public ResponseEntity<Postagem> put (@RequestBody Postagem nomePostagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(nomePostagem));
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id)
	{
		Optional<Postagem> postagemExistente = repository.findById(id);
		if(postagemExistente.isPresent())
		{
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("POSTAGEM DELETADA!!!");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("POSTAGEM NÃO ENCONTRADA!!!");
		}
	}

}