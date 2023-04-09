package it.manytomanyjpamaven.service;

import java.util.List;

import it.manytomanyjpamaven.dao.RuoloDAO;
import it.manytomanyjpamaven.dao.UtenteDAO;
import it.manytomanyjpamaven.model.Ruolo;

public interface RuoloService {
	
	 List<Ruolo> listAll() throws Exception;                        // tested - no interference       ✓

	 Ruolo caricaSingoloElemento(Long id) throws Exception;         // tested - no interference       ✓

	 void aggiorna(Ruolo ruoloInstance) throws Exception;            //* tested - no interference       ✓ 

	 void inserisciNuovo(Ruolo ruoloInstance) throws Exception;       // tested - no interference       ✓

	 void rimuovi(Long idRuoloToRemove) throws Exception;             //*tested - control interference       ✓
	 
	 
	 Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception;  // tested but... - no interference       ✓
	
		
	// per injection
	 void setRuoloDAO(RuoloDAO ruoloDAO);
	 void setUtenteDAO(UtenteDAO utenteDAO);
}
