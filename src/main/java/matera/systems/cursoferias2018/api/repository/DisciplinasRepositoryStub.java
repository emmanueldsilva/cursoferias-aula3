package matera.systems.cursoferias2018.api.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.DisciplinaEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

@Service
@Profile("stub")
public class DisciplinasRepositoryStub implements DisciplinasRepository {

	public static final UUID DISCIPLINA_1 = UUID.fromString("8f6e4a64-bbb3-44c9-a537-d0b1dc8cedb5");
	
	public static final UUID DISCIPLINA_2 = UUID.fromString("af78bfe5-10fb-4232-99d7-5bdabb085f22");
	
	public static final UUID DISCIPLINA_3 = UUID.fromString("353b7475-13fc-4b0a-89de-05bb830a9d14");
	
	private static Map<UUID, DisciplinaEntity> disciplinas = new HashMap<>();
	
	static {
        {
        	DisciplinaEntity disciplina = new DisciplinaEntity();
        	disciplina.setId(DISCIPLINA_1);
        	disciplina.setDescricao("Biologia");
        	disciplina.setDataInicio("01/01/2005");
        	disciplina.setDataTermino("01/01/2006");
        	disciplina.setSegmento("Ciências");
        	disciplina.setUrlLogo("logo qualquer");
        	
        	disciplinas.put(DISCIPLINA_1, disciplina);
        }
        
        {
        	DisciplinaEntity disciplina = new DisciplinaEntity();
        	disciplina.setId(DISCIPLINA_2);
        	disciplina.setDescricao("Matemática");
        	disciplina.setDataInicio("01/01/2000");
        	disciplina.setDataTermino("01/01/2000");
        	disciplina.setSegmento("Exatas");
        	disciplina.setUrlLogo("logo qualquer");
        	
        	UsuarioEntity usuarioEntity = new UsuarioEntity();
        	usuarioEntity.setUuid(UUID.randomUUID());
        	usuarioEntity.setEmail("email@email.com");
        	usuarioEntity.setLogin("novoLogin");
        	usuarioEntity.setNome("Novo Usuário");
        	usuarioEntity.setPerfil("Novo Perfil");
        	usuarioEntity.setSenha("novaSenha");
        	usuarioEntity.setUrlPhoto("novo URL");
        	disciplina.addUsuario(usuarioEntity);
        	
        	disciplinas.put(DISCIPLINA_2, disciplina);
        }
        
        {
        	DisciplinaEntity disciplina = new DisciplinaEntity();
        	disciplina.setId(DISCIPLINA_3);
        	disciplina.setDescricao("Geografia");
        	disciplina.setDataInicio("01/01/1999");
        	disciplina.setDataTermino("01/01/2001");
        	disciplina.setSegmento("Humanas");
        	disciplina.setUrlLogo("logo qualquer");
        	
        	disciplinas.put(DISCIPLINA_3, disciplina);
        }
    }

	@Override
	public DisciplinaEntity findBy(UUID id) {
		return disciplinas.get(id);
	}

	@Override
	public void update(DisciplinaEntity disciplina, String descricao) {
		disciplina.setDescricao(descricao);
		
		disciplinas.put(disciplina.getId(), disciplina);
	}
	
	@Override
	public DisciplinaEntity delete(UUID id) {
		return disciplinas.remove(id);
	}
	
	@Override
	public UUID create(DisciplinaEntity disciplina) {
		final UUID id = UUID.randomUUID();
		disciplina.setId(id);
		
		disciplinas.put(id, disciplina);
		return id;
	}
	
	@Override
	public List<DisciplinaEntity> findAll() {
		return new ArrayList<>(disciplinas.values());
	}
	
}
