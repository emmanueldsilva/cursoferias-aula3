package matera.systems.cursoferias2018.api.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.response.DisciplinaResponse;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;

public class DisciplinaEntity {
	
	private UUID id;

	private String descricao;
	
	private String dataInicio;
	
	private String dataTermino;
	
	private String segmento;
	
	private String urlLogo;
	
	private List<UsuarioEntity> usuarios = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getUrlLogo() {
		return urlLogo;
	}

	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	
	public void addUsuario(UsuarioEntity usuarioEntity) {
		this.usuarios.add(usuarioEntity);
	}
	
	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}
	
	public DisciplinaResponse toResponse() {
		final DisciplinaResponse response = new DisciplinaResponse();
		response.setDescricao(getDescricao());
		response.setSegmento(getSegmento());
		response.setDataInicio(getDataInicio());
		response.setDataTermino(getDataTermino());
		response.setUrlLogo(getUrlLogo());
		
		final List<UsuarioResponse> usuariosResponse = new ArrayList<>();
		for (UsuarioEntity usuarioEntity : usuarios) {
			final UsuarioResponse usuarioResponse = new UsuarioResponse();
			usuarioResponse.setNome(usuarioEntity.getNome());
			usuarioResponse.setLogin(usuarioEntity.getLogin());
			usuarioResponse.setEmail(usuarioEntity.getEmail());
			usuarioResponse.setPerfil(usuarioEntity.getPerfil());
			usuarioResponse.setUrlPhoto(usuarioEntity.getUrlPhoto());
			
			usuariosResponse.add(usuarioResponse);
		}

		response.setUsuarios(usuariosResponse);
		
		return response;
	}
	
}
