package matera.systems.cursoferias2018.api.domain.response;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaResponse {

	private String descricao;
	
	private String dataInicio;
	
	private String dataTermino;
	
	private String segmento;
	
	private String urlLogo;
	
	private List<UsuarioResponse> usuarios = new ArrayList<>();

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
	
	public List<UsuarioResponse> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<UsuarioResponse> usuarios) {
		this.usuarios = usuarios;
	}
	
}
