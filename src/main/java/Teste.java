import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.swaggsige.model.domain.Cliente;
import br.com.swaggsige.model.domain.EnderecoCliente;

import com.google.gson.Gson;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("postgres");
		;
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		/*
		 * //String sql =
		 * " select c from cliente c inner join usuario u on c.usuario_id = u.id inner join enderecocliente ed on c.id = ed.cliente_id"
		 * ;
		 * 
		 * String sql =
		 * "select c from Cliente c  join c.usuario u WHERE c.usuario_id = u.id AND join c.EnderecoCliente ec WHERE ec.cliente_id = c.id "
		 * ; //
		 * " select c from Cliente c JOIN c.enderecoCliente ec JOIN c.usuario u  WHERE c.usuario.id = u.id AND c.id = ec.cliente"
		 * ; //select c from Cliente c JOIN c.usuario u WHERE c.usuario.id =
		 * u.id TypedQuery<Cliente> query = em.createQuery(sql, Cliente.class);
		 * 
		 * List<Cliente> clientes = query.getResultList();
		 * 
		 * for (Cliente cliente : clientes) { System.out.println("Nome" +
		 * cliente.getNome()); System.out.println("Usuario" +
		 * cliente.getUsuario().getLogin()); //System.out.println("Endereco" +
		 * cliente.getEnderecoCliente());
		 * 
		 * List<EnderecoCliente> enderecoCliente = cliente.getEnderecoCliente();
		 * for (EnderecoCliente enderecoCliente2 : enderecoCliente) {
		 * System.out.println("Bairro " + enderecoCliente2.getBairro());
		 * 
		 * }
		 */

		/*
		 * CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		 * CriteriaQuery<Cliente> cquery =
		 * criteriaBuilder.createQuery(Cliente.class); Root<Cliente> fromCliente
		 * = cquery.from(Cliente.class); //Root<EnderecoCliente> fromEndereco =
		 * cquery.from(EnderecoCliente.class); ///Root<Usuario> fromEndereco =
		 * cquery.from(EnderecoCliente.class); Join<Cliente, EnderecoCliente>
		 * theJoin = fromCliente.join("enderecoCliente"); cquery =
		 * cquery.select(fromCliente);
		 */

		/*
		 * CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		 * CriteriaQuery<Cliente> cquery =
		 * criteriaBuilder.createQuery(Cliente.class); Root<Cliente> fromCliente
		 * = cquery.from(Cliente.class); Root<Usuario> fromUsuario =
		 * cquery.from(Usuario.class); Root<EnderecoCliente> fromEndereco =
		 * cquery.from(EnderecoCliente.class); Join<Cliente, EnderecoCliente>
		 * theJoin = fromCliente.join("enderecoCliente");
		 * 
		 * cquery =
		 * cquery.select(fromCliente).where(criteriaBuilder.like(fromCliente
		 * .<String>get("nome"),"Sergio Junior"+"%"));
		 * 
		 * 
		 * Cliente singleResult = em.createQuery(cquery).getSingleResult();
		 * 
		 * System.out.println("Nome" + singleResult.getNome());
		 * System.out.println("Usuario" + singleResult.getUsuario().getLogin());
		 * List<EnderecoCliente> enderecoCliente =
		 * singleResult.getEnderecoCliente(); for (EnderecoCliente
		 * enderecoCliente2 : enderecoCliente) { System.out.println("Bairro " +
		 * enderecoCliente2.getBairro()); }
		 */
		/*
		 * CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		 * CriteriaQuery<Marca> cquery =
		 * criteriaBuilder.createQuery(Marca.class); Root<Marca> fromMarca =
		 * cquery.from(Marca.class); cquery = cquery.select(fromMarca);
		 * 
		 * List<Marca> resultList = em.createQuery(cquery).getResultList(); for
		 * (Marca marca2 : resultList) {
		 * 
		 * System.out.println("Marca " + marca2.getDescricao()); }
		 */

		/*
		 * //Cliente cliente = em.createQuery(cquery).getSingleResult();
		 * List<Cliente> clientes = em.createQuery(cquery).getResultList();
		 * 
		 * for (Cliente cliente : clientes) { System.out.println("Nome" +
		 * cliente.getNome()); System.out.println("Usuario" +
		 * cliente.getUsuario().getLogin()); //System.out.println("Endereco" +
		 * cliente.getEnderecoCliente());
		 * 
		 * List<EnderecoCliente> enderecoCliente = cliente.getEnderecoCliente();
		 * for (EnderecoCliente enderecoCliente2 : enderecoCliente) {
		 * System.out.println("Bairro " + enderecoCliente2.getBairro());
		 * 
		 * } }
		 */

		/*
		 * Query createNamedQuery = em.createNamedQuery("cliente.getAll");
		 * //em.createQuery(hql, Cliente.class);
		 * 
		 * List<Cliente> resultList = createNamedQuery.getResultList();
		 * em.getTransaction().commit(); em.close();
		 * 
		 * System.out.println(resultList.size()); Gson gson = new Gson();
		 * 
		 * Map<Cliente, EnderecoCliente> mapa = new HashMap<Cliente,
		 * EnderecoCliente>();
		 * 
		 * for (Cliente cliente : resultList) {
		 * 
		 * 
		 * List<EnderecoCliente> enderecoCliente = cliente.getEnderecoCliente();
		 * for (EnderecoCliente endereco : enderecoCliente) { mapa.put(cliente,
		 * endereco) ; } }
		 * 
		 * GsonBuilder gb = new GsonBuilder(); Gson create = gb.create();
		 * create.toJson(mapa);
		 */
		/* //Gson gson = new Gson(); */
		// String json = gson.toJson(mapa);
		// System.out.println(obj.getAsString());

		/*
		 * List<EnderecoCliente> listaEnd = new ArrayList<EnderecoCliente>();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Usuario usuario = new Usuario(); usuario.setLogin("teste");
		 * usuario.setSenha("junu");
		 * usuario.setPermissao(PermissaoAcesso.CLIENTE);
		 * 
		 * Cliente cliente = new Cliente(); cliente.setNome("Sergio Junior");
		 * Date dataCadastro =
		 * ConverterDateTime.getConverterStringDate("06/02/2016"); Date
		 * dataNascimento =
		 * ConverterDateTime.getConverterStringDate("03/04/1991");
		 * System.out.println(dataNascimento); //cliente.(dataCadastro);
		 * //cliente.setDatNascimento(dataNascimento);
		 * cliente.setUsuario(usuario);
		 * 
		 * //cliente.setEnderecoCliente(listaEnd);
		 * 
		 * EnderecoCliente endCliente = new EnderecoCliente();
		 * endCliente.setBairro("Planalto"); endCliente.setCep("13485084");
		 * endCliente.setCidade("Limeira-SP");
		 * endCliente.setComplemento("Casa"); endCliente.setCliente(cliente);
		 * listaEnd.add(endCliente); em.persist(usuario); em.persist(cliente);
		 * em.persist(endCliente); em.getTransaction().commit(); em.close();
		 */

		/*
		 * em.getTransaction().begin(); em.getTransaction().commit();
		 * em.close();
		 * 
		 * em.getTransaction().begin(); em.getTransaction().commit();
		 * em.close();
		 */
		/*
		 * new BaseRepository<Usuario>(Usuario.class).saveOrUpdate(usuario); new
		 * BaseRepository<Cliente>(Cliente.class).saveOrUpdate(cliente); new
		 * BaseRepository
		 * <EnderecoCliente>(EnderecoCliente.class).saveOrUpdate(endCliente);
		 */
		/*
		 * String sql =
		 * "select * from Cliente c INNER JOIN usuario u ON c.usuario_id = u.id INNER JOIN enderecoCliente ec ON c.enderecoCliente.id = ec.cliente_id"
		 * ;
		 * 
		 * Query createNamedQuery = em.createNativeQuery(sql, Cliente.class);
		 * 
		 * // em.createQuery(hql, Cliente.class);
		 * 
		 * List<Cliente> resultList = createNamedQuery.getResultList();
		 * JSONObject jsonObject = null; JSONArray jsonArray = new JSONArray();
		 * 
		 * 
		 * for (Cliente cliente : resultList) {
		 * 
		 * jsonObject = new JSONObject();
		 * 
		 * jsonObject.put("id", cliente.getId());
		 * 
		 * jsonObject.put("nome", cliente.getNome()); jsonObject.put("situacao",
		 * cliente.getSituacao()); jsonObject.put("tipoPessoa",
		 * cliente.getTipo()); jsonObject.put("telefone",
		 * cliente.getTelefone()); jsonObject.put("celular",
		 * cliente.getCelular()); jsonObject.put("email", cliente.getEmail());
		 * jsonObject.put("dataNascimento", cliente.getDataNascimento());
		 * jsonObject.put("razaoSocial", cliente.getRazaoSocial());
		 * jsonObject.put("cpf", cliente.getCpf()); jsonObject.put("cnpj",
		 * cliente.getCnpj()); jsonObject.put("inscEstadual",
		 * cliente.getInscEstadual()); jsonObject.put("rg", cliente.getRg());
		 * jsonObject.put("dataCadastro", cliente.getDatCadastrado());
		 * 
		 * jsonArray.put(jsonObject); }
		 * System.out.println(jsonArray.toString());
		 */

		/*
		 * GsonBuilder gb = new GsonBuilder(); Gson gson = gb.create();
		 * 
		 * System.out.println(cliente.getNome()); String json =
		 * gson.toJson(cliente); System.out.println(json);
		 */
		/*
		 * System.out.println("Tamanho "+ resultList.size()); for (Cliente
		 * cliente : resultList) { }
		 */

		/*
		 * ObjectMapper mapper = new ObjectMapper(); Gson gson = new Gson(); for
		 * (Cliente cliente : resultList) {
		 * 
		 * try { mapper.writeValue(new File("c:\\cliente.json"), cliente);
		 * String jsonInString = mapper.writeValueAsString(cliente); String json
		 * = gson.toJson(jsonInString); System.out.println(json); } catch
		 * (JsonGenerationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } }
		 */

		// Cliente cliente = createDummyObject();

		// Convert object to JSON string and save into a file directly

		// Convert object to JSON string

		// Cliente cliente = em.find(Cliente.class, 1L);

		String sql = "select * from Cliente c INNER JOIN usuario u ON c.usuario_id = u.id INNER JOIN enderecoCliente ec ON c.id = ec.cliente_id";

		 Query createNativeQuery = em.createNativeQuery(sql, Cliente.class);

		// em.createQuery(hql, Cliente.class);

		List<Cliente> resultList = createNativeQuery.getResultList();
		
		
		
		JSONObject jsonObject = null;
		JSONArray jsonArray = new JSONArray();

		for (Cliente cliente : resultList) {
            jsonObject = new JSONObject();
			jsonObject.put("id", cliente.getId());
			jsonObject.put("nome", cliente.getNome());
			jsonObject.put("situacao", cliente.getSituacao());
			jsonObject.put("tipoPessoa", cliente.getTipo());
			jsonObject.put("telefone", cliente.getTelefone());
			jsonObject.put("celular", cliente.getCelular());
			jsonObject.put("email", cliente.getEmail());
			jsonObject.put("dataNascimento", cliente.getDataNascimento());
			jsonObject.put("razaoSocial", cliente.getRazaoSocial());
			jsonObject.put("cpf", cliente.getCpf());
			jsonObject.put("cnpj", cliente.getCnpj());
			jsonObject.put("inscEstadual", cliente.getInscEstadual());
			jsonObject.put("rg", cliente.getRg());
			jsonObject.put("dataCadastro", cliente.getDataCadastro());

			List<EnderecoCliente> enderecoCliente = cliente
					.getEnderecoCliente();
			for (EnderecoCliente endereco : enderecoCliente) {
				jsonObject.put("id", endereco.getId());
				jsonObject.put("logradouro", endereco.getLogradouro());
				jsonObject.put("numero", endereco.getNumero());
				jsonObject.put("complemento", endereco.getComplemento());
				jsonObject.put("bairro", endereco.getBairro());
				jsonObject.put("cidade", endereco.getCidade());
				jsonObject.put("cep", endereco.getCep());
				// jsonObject.put("uf", endereco.getUf() ? endereco.getUf() :
				// "UF Não Informada");
				jsonObject.put("pais", endereco.getPais());
				// jsonObject.put("cliente_id", endereco.getCliente().getId());

			}
			jsonObject.put("usuario_id", cliente.getUsuario().getId());
			jsonObject.put("login", cliente.getUsuario().getLogin());
			jsonObject.put("senha", cliente.getUsuario().getSenha());
			// jsonObject.put("permissaoAcesso",
			// cliente.getUsuario().getPermissao());

			jsonArray.put(jsonObject);
		}

		System.out.println(jsonArray);

	}

}
