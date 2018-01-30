package matera.systems.cursoferias2018.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.request.AtualizarDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.request.CriaDisciplinaRequest;
import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.repository.DisciplinasRepositoryStub;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinasRepositoryStub disciplinasRepository;
	
	public DisciplinaResponse findBy(UUID id) {
		final DisciplinaEntity disciplina = disciplinasRepository.findBy(id);
		if (disciplina == null) {
			throw new IllegalStateException("Nenhuma disciplina cadastrada com esse id");
		}
		
		return disciplina.toResponse();
	}
	
	public void update(UUID id, AtualizarDisciplinaRequest request) {
		final DisciplinaEntity disciplina = disciplinasRepository.findBy(id);
		if (disciplina == null) {
			throw new IllegalStateException("Nenhuma disciplina cadastrada com esse id");
		}
		
		disciplinasRepository.update(disciplina, request.getDescricao());
	}
	
	public DisciplinaEntity delete(UUID id) {
		final DisciplinaEntity disciplina = disciplinasRepository.delete(id);
		if (disciplina == null) {
			throw new IllegalStateException("Nenhuma disciplina cadastrada com esse id");
		}
		
		return disciplina;
	}

	public List<UsuarioResponse> listAlunosByDisciplina(UUID id) {
		final DisciplinaEntity disciplina = disciplinasRepository.findBy(id);
		if (disciplina == null) {
			throw new IllegalStateException("Nenhuma disciplina cadastrada com esse id");
		}
		
		return disciplina.toResponse().getUsuarios();
	}
	
	public UUID create(CriaDisciplinaRequest request) {
		final DisciplinaEntity disciplina = new DisciplinaEntity();
		disciplina.setDescricao(request.getDescricao());
		disciplina.setSegmento(request.getSegmento());
		disciplina.setDataInicio(request.getDataInicio());
		disciplina.setDataTermino(request.getDataTermino());
		disciplina.setUrlLogo(request.getUrlLogo());
		
		return disciplinasRepository.create(disciplina);
	}
	
	public List<DisciplinaResponse> findAll() {
		final List<DisciplinaResponse> response = new ArrayList<>();
		for (DisciplinaEntity disciplina : disciplinasRepository.findAll()) {
			response.add(disciplina.toResponse());
		}
		
		return response;
	}
	
}
