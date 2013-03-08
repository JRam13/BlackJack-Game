

import java.util.HashMap;
import java.util.Map;

/**
 * This class is a simple bean used to store face values for a card in a
 * blackjack game.
 * 
 * @author Adam Gerber
 * @version 1.0
 */
public class Card {

	// ===============================================
	// ==FIELD
	// ===============================================+
	/**
	 * @uml.property name="face"
	 */

	private String cFace;
	/**
	 * This map is static.
	 */
	private static Map<String, Integer> cardMap = new HashMap<String, Integer>();
	static {

		cardMap.put("2S", 2);
		cardMap.put("3S", 3);
		cardMap.put("4S", 4);
		cardMap.put("5S", 5);
		cardMap.put("6S", 6);
		cardMap.put("7S", 7);
		cardMap.put("8S", 8);
		cardMap.put("9S", 9);
		cardMap.put("TS", 10);
		cardMap.put("JS", 10);
		cardMap.put("QS", 10);
		cardMap.put("KS", 10);
		cardMap.put("AS", 11);

		cardMap.put("2H", 2);
		cardMap.put("3H", 3);
		cardMap.put("4H", 4);
		cardMap.put("5H", 5);
		cardMap.put("6H", 6);
		cardMap.put("7H", 7);
		cardMap.put("8H", 8);
		cardMap.put("9H", 9);
		cardMap.put("TH", 10);
		cardMap.put("JH", 10);
		cardMap.put("QH", 10);
		cardMap.put("KH", 10);
		cardMap.put("AH", 11);

		cardMap.put("2C", 2);
		cardMap.put("3C", 3);
		cardMap.put("4C", 4);
		cardMap.put("5C", 5);
		cardMap.put("6C", 6);
		cardMap.put("7C", 7);
		cardMap.put("8C", 8);
		cardMap.put("9C", 9);
		cardMap.put("TC", 10);
		cardMap.put("JC", 10);
		cardMap.put("QC", 10);
		cardMap.put("KC", 10);
		cardMap.put("AC", 11);

		cardMap.put("2D", 2);
		cardMap.put("3D", 3);
		cardMap.put("4D", 4);
		cardMap.put("5D", 5);
		cardMap.put("6D", 6);
		cardMap.put("7D", 7);
		cardMap.put("8D", 8);
		cardMap.put("9D", 9);
		cardMap.put("TD", 10);
		cardMap.put("JD", 10);
		cardMap.put("QD", 10);
		cardMap.put("KD", 10);
		cardMap.put("AD", 11);

	}// end static

	// ===============================================
	// ==CONSTRUCTOR
	// ===============================================
	public Card(String face) {
		this.cFace = face;
	}

	// ===============================================
	// ==METHODS
	// ===============================================

	/**
	 * This method lorem ipsum.
	 * 
	 * @uml.property name="face"
	 * @return String representing the face of the card.
	 */
	public String getFace() {
		return this.cFace;
	}

	/**
	 * @param cFace
	 * @uml.property name="face"
	 */
	public void setFace(String cFace) {
		this.cFace = cFace;
	}

	public int getValue() {
		return cardMap.get(getFace());
	}

	public void setAceValue(int val) {
		cardMap.put("AS", val);
		cardMap.put("AH", val);
		cardMap.put("AC", val);
		cardMap.put("AD", val);

	}

	@Override
	public String toString() {
		return getFace() + ":" + getValue();
	}

}
