

import java.util.ArrayList;
import java.util.Collections;

public class Chute {

	// ===============================================
	// ==FIELDS
	// ===============================================
	/**
	 * @uml.property name="crdCards"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 *                     elementType="edu.uchicago.cs.java.lec03.console21.Card"
	 */
	private ArrayList<Card> crdCards;
	/**
	 * @uml.property name="remaining"
	 */
	private int nRemaining;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public Chute() {
		// instantiate the arrayList
		crdCards = new ArrayList<Card>();
		nRemaining = 308;

		String[] cCards = { "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S",
				"TS", "JS", "QS", "KS", "AS", "2H", "3H", "4H", "5H", "6H",
				"7H", "8H", "9H", "TH", "JH", "QH", "KH", "AH", "2C", "3C",
				"4C", "5C", "6C", "7C", "8C", "9C", "TC", "JC", "QC", "KC",
				"AC", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "TD",
				"JD", "QD", "KD", "AD" };

		// load the chute
		for (int nC = 0; nC < 6; nC++) {
			for (int nD = 0; nD < cCards.length; nD++)
				add(new Card(cCards[nD]));
		}

	}// end constructor

	// ===============================================
	// ==METHODS
	// ===============================================
	public ArrayList<Card> getCards() {
		return this.crdCards;
	}

	public void setCards(ArrayList<Card> crdCards) {
		this.crdCards = crdCards;
	}

	public void recapture(ArrayList<Card> crdParams) {

		for (Card crd : crdParams) {
			crdCards.add(crd);
		}
	}

	private void add(Card crd) {
		crdCards.add(crd);

	}

	public Card deal() {

		if (nRemaining == 0) {
			shuffle();
			nRemaining = 308;
		}

		Card crd;
		crd = crdCards.remove(0);
		nRemaining--;
		return crd;

	}

	public int getNumCards() {
		return crdCards.size();
	}

	public int getNunCardsRemainingBeforeShuffle() {
		return nRemaining;
	}

	public void shuffle() {
		Collections.shuffle(crdCards);
	}

}
