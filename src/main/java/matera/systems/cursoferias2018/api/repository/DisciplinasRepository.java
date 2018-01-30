package matera.systems.cursoferias2018.api.repository;

import java.util.List;
import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;

public interface DisciplinasRepository {
	
	DisciplinaEntity findBy(UUID id);
	
	void update(DisciplinaEntity disciplina, String descricao);
	
	DisciplinaEntity delete(UUID id);
	
	UUID create(DisciplinaEntity disciplina);
	
	List<DisciplinaEntity> findAll();
	
}
