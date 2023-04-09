package it.manytomanyjpamaven.dao;

import java.util.List;

import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	List<Utente> findAllByRuolo(Ruolo ruoloInput);

	Utente findByIdFetchingRuoli(Long id);

	List<Utente> listByMonthAndYear(int mese, int anno) throws Exception;

	int countUtentiAdmin() throws Exception; // generico per utilizzi vari volendo

	//List<Utente> listDescrizioniDistinteRuoliConUtenti() throws Exception;
}
