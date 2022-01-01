package studentVerwaltung;

import java.text.ParseException;

interface Istudenten {

	void schulerAnmeldung() throws ParseException;
	void schulerNotizEintrag();
	void schulerRekordAnsehen();
	void schulerNoteAnsehen();
}
