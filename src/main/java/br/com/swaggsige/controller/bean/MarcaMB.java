package br.com.swaggsige.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.swaggsige.controller.service.MarcaLocalService;
import br.com.swaggsige.model.domain.ContasReceber;
import br.com.swaggsige.model.domain.Marca;
import br.com.swaggsige.model.service.exception.PersistenceException;
import br.com.swaggsige.model.service.repository.ContasPagarReceberLocalRepository;

@ManagedBean(name = "marcaMB")
@RequestScoped
@Stateless
public class MarcaMB implements Serializable {

	@EJB(beanName = "MarcaService")
	private MarcaLocalService marcaService;
	
	@EJB(beanName="ContasReceberService")
	private ContasPagarReceberLocalRepository<ContasReceber> cr;
	

	
	private List<Marca> marcas = new ArrayList<Marca>();

	@PostConstruct
	public void populaMarcas() {
		marcas.addAll(marcaService.getAll());
		
		
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	private static Log log = LogFactory.getLog(Marca.class);

	private Marca marca = new Marca();

	public MarcaMB() {
		// TODO Auto-generated constructor stub
	}

	public void salvar() throws PersistenceException {
		marcaService.save(marca);
		log.info("Cadastro salvo com sucesso");

	}

	public void mostraMarcas() {
		Collection<Marca> all = marcaService.getAll();

		for (Marca marca : all) {
			System.out.println(marca.getId());
			System.out.println(marca.getDescricao());
		}
	}

	public final Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
