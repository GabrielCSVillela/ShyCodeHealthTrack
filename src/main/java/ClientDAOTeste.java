import java.util.Calendar;
import java.util.List;

import br.com.shycode.healthtrack.bean.Client;
import br.com.shycode.healthtrack.dao.ClientDAO;
import br.com.shycode.healthtrack.exception.DBException;
import br.com.shycode.healthtrack.factory.DAOFactory;

public class ClientDAOTeste {

	public static void main(String[] args) {
		ClientDAO dao = DAOFactory.getClientDAO();

		// Cadastrar um produto
		Client client = new Client(0, "Pedro", "Pedrosa", "pedro@pedros.com", "pedrosecreto", "19991822347",
				Calendar.getInstance(), 100, Calendar.getInstance());
		try {
			dao.insert(client);
			System.out.println("Cliente cadastrado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// Buscar um produto pelo código e atualizar
		client = dao.selectById(1);
		client.setName("Caderno capa dura");
		client.setHeight(160);
		try {
			dao.update(client);
			System.out.println("Cliente atualizado.");
		} catch (DBException e) {
			e.printStackTrace();
		}

		// Listar os produtos
		List<Client> list = dao.select();
		for (Client item : list) {
			System.out.println(item.getName() + " " + item.getLastName() + " " + item.getEmail() + " " + item.getPassword()
					+ " " + item.getPhone() + " " + item.getDateOfBirth() + " " + item.getHeight() + " " + item.getDateRecord());
		}

		// Remover um produto
		try {
			dao.delete(1);
			System.out.println("Cliente removido.");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
}