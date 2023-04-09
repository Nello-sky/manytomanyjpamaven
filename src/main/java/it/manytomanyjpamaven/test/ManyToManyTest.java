package it.manytomanyjpamaven.test;

import java.time.LocalDate;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;
import it.manytomanyjpamaven.service.MyServiceFactory;
import it.manytomanyjpamaven.service.RuoloService;
import it.manytomanyjpamaven.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
//			initRuoli(ruoloServiceInstance);
			
			
			


//********* RUOLO CRUD ***********************************************************************************

//			System.out.println("In tabella Ruolo ci sono " + ruoloServiceInstance.listAll().size() + " elementi.");

//			testGetRuolo(ruoloServiceInstance);
//			System.out.println(ruoloServiceInstance.caricaSingoloElemento(1L));

//			testAggiornaRuolo(ruoloServiceInstance);
			
//			testInserisciNuovo(ruoloServiceInstance);

//			testDeleteRuolo(ruoloServiceInstance);

//			
//********* RUOLO extra ***********************************************************************************

//			testCercaPerDescrizioneECodice(ruoloServiceInstance);

//********* UTENTE CRUD ***********************************************************************************

//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");

//			testGetUtente(utenteServiceInstance);
//			System.out.println(utenteServiceInstance.caricaSingoloElemento(1L));			

//			testAggiornaUtente(utenteServiceInstance);
			
//			testInserisciNuovoUtente(utenteServiceInstance);
 //			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
			
//			testDeleteUtente(utenteServiceInstance);
			

//********* UTENTE extra ***********************************************************************************



//			testCollegaUtenteARuoloEsistente(ruoloServiceInstance, utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");

//			testModificaStatoUtente(utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
//
//			testRimuoviRuoloDaUtente(ruoloServiceInstance, utenteServiceInstance);
//			System.out.println("In tabella Utente ci sono " + utenteServiceInstance.listAll().size() + " elementi.");
			
//			testCercaByMonthAndYear(utenteServiceInstance);
//			System.out.println("In tabella Utente(m,y) ci sono " + utenteServiceInstance.cercaByMonthAndYear(4,2023).size() + " elementi.");
//			System.out.println("In tabella Utente(m,y) ci sono " + utenteServiceInstance.cercaByMonthAndYear(11,1998).size() + " elementi.");
			
			//assegno il nuovo ruolo ADMIN ad un utente e controllo
//			System.out.println(utenteServiceInstance.contaUtentiAdmin());
			
			System.out.println(utenteServiceInstance.listaDescrizioniDistinteRuoliConUtenti());
			

		
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

///////////// METODI TEST INTERMEDI ///////////////////////////////////////////////////////////////////////////////////////////////////
///////////// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//   +++ RUOLO CRUD +++

	public static void testListRuolo(RuoloService ruoloServiceInstance) throws Exception {
		System.out.println(".......testListRuolo inizio.............");
		ruoloServiceInstance.listAll();

	}

	public static void testGetRuolo(RuoloService ruoloServiceInstance) throws Exception {
		System.out.println(".......testGetRuolo inizio.............");
		if (ruoloServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testGetRuolo fallito: non ci sono ruoli a cui collegarci ");
		// ne controllo uno presente, osservando la table....
		ruoloServiceInstance.caricaSingoloElemento(1L);

		System.out.println(".......testGetRuolo fine: PASSED.............");
	}

	public static void testAggiornaRuolo(RuoloService ruoloServiceInstance) throws Exception {
		System.out.println(".......testAggiornaRuolo start.............");
		if (ruoloServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testAggiornaRuolo failed: no utents to connect ");
		// ne controllo uno presente
		Ruolo ruoloTestUpdate = ruoloServiceInstance.listAll().get(0);
		ruoloTestUpdate.setCodice("SRG");
		ruoloTestUpdate.setDescrizione("sergente");
		ruoloServiceInstance.aggiorna(ruoloTestUpdate);
		System.out.println(".......testAggiornaRuolo end: PASSED.............");
	}

	private static void testInserisciNuovo(RuoloService ruoloServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovo inizio.............");

		Ruolo ruoloNuovo = new Ruolo("sergente", "SRG");
		ruoloServiceInstance.inserisciNuovo(ruoloNuovo);
		if (ruoloNuovo.getId() == null)
			throw new RuntimeException("testInserisciNuovo fallito ");

		System.out.println(".......testInserisciNuovo fine: PASSED.............");
	}

	public static void testDeleteRuolo(RuoloService ruoloServiceInstance) throws Exception {
		System.out.println(".......testDeleteRuolo inizio.............");
		if (ruoloServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testDeleteRuolo fallito: non ci sono ruoli da eliminare. ");
		Long idToDelete = ruoloServiceInstance.listAll().get(0).getId();
		ruoloServiceInstance.rimuovi(idToDelete); // per vedere l'eccezione custom
		//// per togliere devi provare un ruolo non collegato ad alcun utente, ne
		//// aggiungi uno nuovo e lo togli subito...handmade
		System.out.println(".......testDeleteRuolo fine: PASSED.............");
	}

//	+++ RUOLO EXTRA +++ 	

	public static void testCercaPerDescrizioneECodice(RuoloService ruoloServiceInstance) throws Exception {
		System.out.println(".......testCercaPerDescrizioneECodice inizio.............");
		if (ruoloServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testGetRuolo fallito: non ci sono ruoli a cui collegarci ");
		// ne controllo uno presente, ora posso usare get
		String desc = ruoloServiceInstance.listAll().get(0).getDescrizione();
		String cod = ruoloServiceInstance.listAll().get(0).getCodice();
//		String desc = "s";
//		String cod  = "s";
		if (ruoloServiceInstance.cercaPerDescrizioneECodice(desc, cod) == null)
			throw new RuntimeException("testCercaPerDescrizioneECodice fallito: non ci sono ruoli a cui collegarci ");

		System.out.println(".......testCercaPerDescrizioneECodice fine: PASSED.............");

	}

	private static void initRuoli(RuoloService ruoloServiceInstance) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
		}
	}

//	+++ UTENTE CRUD +++ 

	public static void testGetUtente(UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testGetUtente start.............");
		if (utenteServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testGetUtente failed: no utents to connect ");
		// ne controllo uno presente, osservando la table....
		utenteServiceInstance.caricaSingoloElemento(1L);

		System.out.println(".......testGetUtente end: PASSED.............");
	}

	public static void testAggiornaUtente(UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testAggiornaUtente start.............");
		if (utenteServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testAggiornaUtente failed: no utents to connect ");
		// ne controllo uno presente
		Utente utenteTestUpdate = utenteServiceInstance.listAll().get(0);
		utenteTestUpdate.setCognome("red");
		utenteTestUpdate.setNome("ken");
		utenteServiceInstance.aggiorna(utenteTestUpdate);
		System.out.println(".......testAggiornaUtente end: PASSED.............");
	}

	private static void testInserisciNuovoUtente(UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testInserisciNuovoUtente inizio.............");

		Utente utenteNuovo = new Utente("lino.paoli", "zzz", "lino", "paoli", LocalDate.now());
		utenteServiceInstance.inserisciNuovo(utenteNuovo);
		if (utenteNuovo.getId() == null)
			throw new RuntimeException("testInserisciNuovoUtente fallito ");

		System.out.println(".......testInserisciNuovoUtente fine: PASSED.............");
	}

	public static void testDeleteUtente(UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testDeleteUtente inizio.............");
		if (utenteServiceInstance.listAll().isEmpty())
			throw new RuntimeException("testDeleteUtente fallito: non ci sono ruoli da eliminare. ");
		utenteServiceInstance.rimuovi(2L); // per vedere l'eccezione custom: ne trovo uno presente nalla join.table
		// per testare la delete 1)inserissco un nuovo utente(niente join.table) e lo tolgo subito)
		// per il delete real verifico che tolga il ruolo e anche tutto quello presente sulla join table...vediamolo in atleta
		System.out.println(".......testDeleteUtente fine: PASSED.............");
	}
	
	
	
	
//	Utente utenteNuovo = new Utente("lino.paoli", "zzz", "lino", "paoli", LocalDate.of(1998, 12, 1));
//	utenteServiceInstance.inserisciNuovo(utenteNuovo);
	
//	+++ UTENTE EXTRA +++ 	

	private static void testCollegaUtenteARuoloEsistente(RuoloService ruoloServiceInstance,
			UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testCollegaUtenteARuoloEsistente inizio.............");

		Ruolo ruoloEsistenteSuDb = ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN");
		if (ruoloEsistenteSuDb == null)
			throw new RuntimeException("testCollegaUtenteARuoloEsistente fallito: ruolo inesistente ");

		// mi creo un utente inserendolo direttamente su db
		Utente utenteNuovo = new Utente("mario.bianchi", "JJJ", "mario", "bianchi", LocalDate.now());
		utenteServiceInstance.inserisciNuovo(utenteNuovo);
		if (utenteNuovo.getId() == null)
			throw new RuntimeException("testInserisciNuovoUtente fallito: utente non inserito ");

		utenteServiceInstance.aggiungiRuolo(utenteNuovo, ruoloEsistenteSuDb);
		// per fare il test ricarico interamente l'oggetto e la relazione
		Utente utenteReloaded = utenteServiceInstance.caricaUtenteSingoloConRuoli(utenteNuovo.getId());
		if (utenteReloaded.getRuoli().size() != 1)
			throw new RuntimeException("testInserisciNuovoUtente fallito: ruoli non aggiunti ");

		System.out.println(".......testCollegaUtenteARuoloEsistente fine: PASSED.............");
	}

	private static void testModificaStatoUtente(UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testModificaStatoUtente inizio.............");

		// mi creo un utente inserendolo direttamente su db
		Utente utenteNuovo = new Utente("mario1.bianchi1", "JJJ", "mario1", "bianchi1", LocalDate.now());
		utenteServiceInstance.inserisciNuovo(utenteNuovo);
		if (utenteNuovo.getId() == null)
			throw new RuntimeException("testModificaStatoUtente fallito: utente non inserito ");

		// proviamo a passarlo nello stato ATTIVO ma salviamoci il vecchio stato
		StatoUtente vecchioStato = utenteNuovo.getStato();
		utenteNuovo.setStato(StatoUtente.ATTIVO);
		utenteServiceInstance.aggiorna(utenteNuovo);

		if (utenteNuovo.getStato().equals(vecchioStato))
			throw new RuntimeException("testModificaStatoUtente fallito: modifica non avvenuta correttamente ");

		System.out.println(".......testModificaStatoUtente fine: PASSED.............");
	}

	private static void testRimuoviRuoloDaUtente(RuoloService ruoloServiceInstance, UtenteService utenteServiceInstance)
			throws Exception {
		System.out.println(".......testRimuoviRuoloDaUtente inizio.............");

		// carico un ruolo e lo associo ad un nuovo utente
		Ruolo ruoloEsistenteSuDb = ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN");
		if (ruoloEsistenteSuDb == null)
			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: ruolo inesistente ");

		// mi creo un utente inserendolo direttamente su db
		Utente utenteNuovo = new Utente("aldo.manuzzi", "pwd@2", "aldo", "manuzzi", LocalDate.now());
		utenteServiceInstance.inserisciNuovo(utenteNuovo);
		if (utenteNuovo.getId() == null)
			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: utente non inserito ");
		utenteServiceInstance.aggiungiRuolo(utenteNuovo, ruoloEsistenteSuDb);

		// ora ricarico il record e provo a disassociare il ruolo
		Utente utenteReloaded = utenteServiceInstance.caricaUtenteSingoloConRuoli(utenteNuovo.getId());
		boolean confermoRuoloPresente = false;
		for (Ruolo ruoloItem : utenteReloaded.getRuoli()) {
			if (ruoloItem.getCodice().equals(ruoloEsistenteSuDb.getCodice())) {
				confermoRuoloPresente = true;
				break;
			}
		}

		if (!confermoRuoloPresente)
			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: utente e ruolo non associati ");

		// ora provo la rimozione vera e propria ma poi forzo il caricamento per fare un
		// confronto 'pulito'
		utenteServiceInstance.rimuoviRuoloDaUtente(utenteReloaded.getId(), ruoloEsistenteSuDb.getId());
		utenteReloaded = utenteServiceInstance.caricaUtenteSingoloConRuoli(utenteNuovo.getId());
		if (!utenteReloaded.getRuoli().isEmpty())
			throw new RuntimeException("testRimuoviRuoloDaUtente fallito: ruolo ancora associato ");

		System.out.println(".......testRimuoviRuoloDaUtente fine: PASSED.............");
	}
	
	
	public static void testCercaByMonthAndYear(UtenteService utenteServiceInstance) throws Exception {
		System.out.println(".......testCercaByMonthAndYear inizio.............");
		
		
		
		utenteServiceInstance.cercaByMonthAndYear(4,2023);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
