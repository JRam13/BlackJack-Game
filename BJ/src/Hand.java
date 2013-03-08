

import java.util.ArrayList;

public class Hand {
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
	 * @uml.property name="hidden"
	 */
	private boolean bHidden;

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public Hand() {
		crdCards = new ArrayList<Card>();
	}

	public ArrayList<Card> getCards() {
		return this.crdCards;
	}

	public void setCards(ArrayList<Card> crdCards) {
		this.crdCards = crdCards;
	}

	/**
	 * @return
	 * @uml.property name="hidden"
	 */
	public boolean isHidden() {
		return this.bHidden;
	}

	/**
	 * @param hidden
	 * @uml.property name="hidden"
	 */
	public void setHidden(boolean hidden) {
		this.bHidden = hidden;
	}

	public ArrayList<Card> returnCards() {

		ArrayList<Card> crdReturns = new ArrayList<Card>();
		while (!crdCards.isEmpty()) {
			crdReturns.add(crdCards.remove(0));
		}

		return crdReturns;
	}

	public void display(String strName) {
		System.out.print(strName + ": ");

		if (!isHidden()) {

			for (Card crd : crdCards) {
				System.out.print(crd.getFace() + " ");
			}
			System.out.print("| ");
			System.out.println(getValue() + " ");

		} else {
			for (int nC = 0; nC < crdCards.size(); nC++) {
				if (nC == 0) {
					System.out.print("# ");
				} else {
					System.out.print(crdCards.get(nC).getFace() + " ");
				}

			}
			System.out.println();

		}

	}// end displayHand()

	@SuppressWarnings("unused")
	private String getStatus() {

		int nState = getValue();
		if (nState < 21)
			return "PLAYING";
		else if (nState == 21)
			return "TWENTY-ONE";
		else
			return "BUST";

	}

	public int getValue() {

		// sum the hand's value; Ace is always 11
		int nVal = 0;
		for (Card crd : crdCards)
			nVal += crd.getValue();
		return nVal;

	}

	public int getValueAce() {

		int nVal = 0;
		for (Card crd : crdCards)
			nVal += crd.getValue();
		return (nVal - 10);

	}

	public void add(Card crd) {
		crdCards.add(crd);
	}

}