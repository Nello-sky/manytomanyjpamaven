package it.manytomanyjpamaven.dao;

import java.util.List;

import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.Utente;

public interface RuoloDAO extends IBaseDAO<Ruolo> {
	
	 Ruolo findByDescrizioneAndCodice(String descrizione, String codice) throws Exception;

}
