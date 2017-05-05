package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.ConsultorBO;
import br.com.fiap.entity.Consultor;
import br.com.fiap.exception.DBException;

@ManagedBean
public class ConsultorBean {
	private Consultor consultor;

	private ConsultorBO bo;
	
	@PostConstruct //inicializar os objetos (Pode ter qualquer nome de método, o importante é a anotação!!!!
	private void init(){
		consultor = new Consultor();
		bo = new ConsultorBO();
	}
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			bo.cadastrar(consultor);
			msg = new FacesMessage("Cadastrado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (DBException e) {
			msg = new FacesMessage("Deu Ruim!!!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}
}
