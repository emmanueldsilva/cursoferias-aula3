package matera.systems.cursoferias2018.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import matera.systems.cursoferias2018.api.domain.request.AtualizarDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.request.CriaDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.services.DisciplinaService;

@RestController
@RequestMapping(path = "/disciplinas")
public class DisciplinasRS {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping(value = "{id}",
				produces = { "application/json", "application/xml" })
	public ResponseEntity<DisciplinaResponse> findBy(@PathVariable String id) {
		DisciplinaResponse response = null;
		try {
			response = disciplinaService.findBy(UUID.fromString(id));
		} catch (IllegalStateException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping(value = "{id}",
				consumes = {"application/json"})
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody AtualizarDisciplinaRequest request) {
		try {
			disciplinaService.update(UUID.fromString(id), request);
		} catch (IllegalStateException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			disciplinaService.delete(UUID.fromString(id));
		} catch (IllegalStateException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(path = "{id}/alunos")
	public ResponseEntity<List<UsuarioResponse>> findUsuarios(@PathVariable String id) {
		List<UsuarioResponse> response = new ArrayList<>();
		try {
			response = disciplinaService.listAlunosByDisciplina(UUID.fromString(id));
		} catch (IllegalStateException e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody CriaDisciplinaRequest request) {
		final UUID id = disciplinaService.create(request);
		
		return ResponseEntity.created(URI.create("/disciplinas/" + id.toString())).build();
	}
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<DisciplinaResponse>> findAll() {
		return ResponseEntity.ok().body(disciplinaService.findAll());
	}
	
}
