package it.manytomanyjpamaven.service;

import java.util.List;

import it.manytomanyjpamaven.dao.RuoloDAO;
import it.manytomanyjpamaven.dao.UtenteDAO;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.Utente;

public interface UtenteService {

	 List<Utente> listAll() throws Exception;                                          //  tested - no interference   ✓

	 Utente caricaSingoloElemento(Long id) throws Exception;                          //   tested - no interference   ✓

	 void aggiorna(Utente utenteInstance) throws Exception;                           //   tested - no interference   ✓

	 void inserisciNuovo(Utente utenteInstance) throws Exception;                    // tested - no interference      ✓

	 void rimuovi(Long idUtente) throws Exception;                                         //* xxxxx -  interference  
	
	

	 void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception;     //*ready to control    ✓
	
	 void rimuoviRuoloDaUtente(Long idUtente,Long idRuolo) throws Exception;               //*ready to control     ✓

	 Utente caricaUtenteSingoloConRuoli(Long id) throws Exception;                         //*ready to control      ✓

	 List<Utente> cercaByMonthAndYear(int mese, int anno) throws Exception;                 //  tested - no interference   ✓
	 
	 int contaUtentiAdmin() throws Exception;                                                //  tested - no interference   ✓
	 
	 List<String> listaDescrizioniDistinteRuoliConUtenti() throws Exception;                //  tested - no interference   ✓
	 
	// per injection
	 void setUtenteDAO(UtenteDAO utenteDAO);
	 void setRuoloDAO(RuoloDAO ruoloDAO);

}
