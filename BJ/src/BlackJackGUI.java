import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class BlackJackGUI {

	private JLabel lblPHandVal, lblPlayerCard3, lblPlayerCard4, lblDealerCard3,
			lblDealerCard4, lblWinLose, lblNumCards, lblCash, lblPlayerCard5,
			lblPlayerCard2, lblPlayerCard6, lblPlayerCard1, lblDealerCard5,
			lblDealerCard6, lblDealerCard2, lblDealerCard1, lblDHandVal,
			lblWinLose2;
	private JButton btnDeal, btnHit, btnStay, btnDD, btnPlay;
	private static Map<String, String> imageMap = new HashMap<String, String>();
	private Chute cht;
	private String card1, card2, card3, card4, card5, card6, card7, card8,
			card9, card10, card11, card12;
	private Player plyPlayer, plyDealer;
	private JFrame frame;
	private JTextField textField;
	static {

		imageMap.put("2S", "/cards/2S.png");
		imageMap.put("3S", "/cards/3S.png");
		imageMap.put("4S", "/cards/4S.png");
		imageMap.put("5S", "/cards/5S.png");
		imageMap.put("6S", "/cards/6S.png");
		imageMap.put("7S", "/cards/7S.png");
		imageMap.put("8S", "/cards/8S.png");
		imageMap.put("9S", "/cards/9S.png");
		imageMap.put("TS", "/cards/TS.png");
		imageMap.put("JS", "/cards/JS.png");
		imageMap.put("QS", "/cards/QS.png");
		imageMap.put("KS", "/cards/KS.png");
		imageMap.put("AS", "/cards/AS.png");

		imageMap.put("2H", "/cards/2H.png");
		imageMap.put("3H", "/cards/3H.png");
		imageMap.put("4H", "/cards/4H.png");
		imageMap.put("5H", "/cards/5H.png");
		imageMap.put("6H", "/cards/6H.png");
		imageMap.put("7H", "/cards/7H.png");
		imageMap.put("8H", "/cards/8H.png");
		imageMap.put("9H", "/cards/9H.png");
		imageMap.put("TH", "/cards/TH.png");
		imageMap.put("JH", "/cards/JH.png");
		imageMap.put("QH", "/cards/QH.png");
		imageMap.put("KH", "/cards/KH.png");
		imageMap.put("AH", "/cards/AH.png");

		imageMap.put("2C", "/cards/2C.png");
		imageMap.put("3C", "/cards/3C.png");
		imageMap.put("4C", "/cards/4C.png");
		imageMap.put("5C", "/cards/5C.png");
		imageMap.put("6C", "/cards/6C.png");
		imageMap.put("7C", "/cards/7C.png");
		imageMap.put("8C", "/cards/8C.png");
		imageMap.put("9C", "/cards/9C.png");
		imageMap.put("TC", "/cards/TC.png");
		imageMap.put("JC", "/cards/JC.png");
		imageMap.put("QC", "/cards/QC.png");
		imageMap.put("KC", "/cards/KC.png");
		imageMap.put("AC", "/cards/AC.png");

		imageMap.put("2D", "/cards/2D.png");
		imageMap.put("3D", "/cards/3D.png");
		imageMap.put("4D", "/cards/4D.png");
		imageMap.put("5D", "/cards/5D.png");
		imageMap.put("6D", "/cards/6D.png");
		imageMap.put("7D", "/cards/7D.png");
		imageMap.put("8D", "/cards/8D.png");
		imageMap.put("9D", "/cards/9D.png");
		imageMap.put("TD", "/cards/TD.png");
		imageMap.put("JD", "/cards/JD.png");
		imageMap.put("QD", "/cards/QD.png");
		imageMap.put("KD", "/cards/KD.png");
		imageMap.put("AD", "/cards/AD.png");
	}

	/**
	 * Launch the application.
	 */
	
	
	//============================================================
	//MAIN METHOD / WINDOW BUILDER CODE
	//============================================================

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			
			@Override
			public void run() {
				try {
					BlackJackGUI window = new BlackJackGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BlackJackGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//============================================================
		//Labels and Buttons
		//============================================================
		frame = new JFrame();
		//frame.setResizable(false);
		//frame.requestFocus(false);
		frame.setBounds(50, 0, 1350, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("BlackJack Game");
		
		textField = new JTextField();
		textField.setBounds(22, 609, 388, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
				JMenuBar menuBar = new JMenuBar();
				menuBar.setForeground(Color.BLACK);
				menuBar.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
				menuBar.setBackground(Color.BLACK);
				menuBar.setBounds(0, 0, 1350, 16);
				frame.getContentPane().add(menuBar);
				
						JMenu mnFile = new JMenu("File");
						mnFile.setBackground(Color.BLACK);
						mnFile.setFont(new Font("Dialog", Font.PLAIN, 12));
						menuBar.add(mnFile);
						
								JMenuItem mntmExit = new JMenuItem("Exit");
								mntmExit.setSelected(true);
								mntmExit.setBackground(Color.LIGHT_GRAY);
								mntmExit.setFont(new Font("Dialog", Font.PLAIN, 12));
								mntmExit.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent arg0) {
										System.exit(0);
									}
								});
								mntmExit.setIcon(new ImageIcon(BlackJackGUI.class
										.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
								mnFile.add(mntmExit);

		
		//============================================================
		//CARDS AND LABELS
		//============================================================						
		lblDealerCard1 = new JLabel("");
		lblDealerCard1.setBounds(515, 153, 72, 108);
		frame.getContentPane().add(lblDealerCard1);		
		
		lblDealerCard2 = new JLabel("");
		lblDealerCard2.setBounds(566, 133, 72, 103);
		frame.getContentPane().add(lblDealerCard2);
		
		lblDealerCard3 = new JLabel("");
		lblDealerCard3.setBounds(617, 153, 72, 103);
		frame.getContentPane().add(lblDealerCard3);
		
		lblDealerCard4 = new JLabel("");
		lblDealerCard4.setBounds(678, 133, 72, 103);
		frame.getContentPane().add(lblDealerCard4);		
		
		lblDealerCard5 = new JLabel("");
		lblDealerCard5.setBounds(719, 153, 72, 103);
		frame.getContentPane().add(lblDealerCard5);
		
		lblDealerCard6 = new JLabel("");
		lblDealerCard6.setBounds(770, 133, 72, 103);
		frame.getContentPane().add(lblDealerCard6);
		
		lblPlayerCard1 = new JLabel("");
		lblPlayerCard1.setBounds(515, 498, 72, 103);
		frame.getContentPane().add(lblPlayerCard1);		
		
		lblPlayerCard2 = new JLabel("");
		lblPlayerCard2.setBounds(566, 520, 72, 103);
		frame.getContentPane().add(lblPlayerCard2);		
		
		lblPlayerCard3 = new JLabel("");
		lblPlayerCard3.setBounds(617, 498, 72, 103);
		frame.getContentPane().add(lblPlayerCard3);		
		
		lblPlayerCard4 = new JLabel("");
		lblPlayerCard4.setBounds(678, 520, 72, 103);
		frame.getContentPane().add(lblPlayerCard4);		
		
		lblPlayerCard5 = new JLabel("");
		lblPlayerCard5.setBounds(719, 498, 72, 103);
		frame.getContentPane().add(lblPlayerCard5);

		lblPlayerCard6 = new JLabel("");
		lblPlayerCard6.setBounds(770, 520, 72, 103);
		frame.getContentPane().add(lblPlayerCard6);

		lblWinLose2 = new JLabel("");// ("Win  $      +100");
		lblWinLose2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWinLose2.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblWinLose2.setBackground(Color.BLACK);
		lblWinLose2.setBounds(863, 508, 141, 24);
		frame.getContentPane().add(lblWinLose2);

		lblWinLose = new JLabel("");
		// lblWinLose.setForeground(new Color(255, 0, 0));
		lblWinLose.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinLose.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		// lblWinLose.setForeground(new Color(244, 164, 96));
		lblWinLose.setBounds(540, 434, 264, 32);
		frame.getContentPane().add(lblWinLose);

		lblNumCards = new JLabel("");
		lblNumCards.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumCards.setForeground(new Color(255, 250, 250));
		lblNumCards.setBounds(1070, 258, 108, 16);
		frame.getContentPane().add(lblNumCards);

		lblCash = new JLabel("Balance $    1000.0");
		lblCash.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCash.setBackground(new Color(0, 0, 0));
		lblCash.setFont(new Font("Monospaced", Font.BOLD, 15));
		lblCash.setForeground(Color.WHITE);
		lblCash.setBounds(814, 489, 190, 24);
		frame.getContentPane().add(lblCash);

		lblPHandVal = new JLabel("");
		lblPHandVal.setForeground(Color.ORANGE);
		lblPHandVal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPHandVal.setBounds(635, 479, 169, 16);
		frame.getContentPane().add(lblPHandVal);

		lblDHandVal = new JLabel("");
		lblDHandVal.setForeground(Color.ORANGE);
		lblDHandVal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDHandVal.setBounds(635, 115, 169, 16);
		frame.getContentPane().add(lblDHandVal);

		btnDeal = new JButton("");
		btnDeal.setBorder(UIManager.getBorder("Button.border"));
		btnDeal.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/dealBTN.png")));
		btnDeal.setBounds(690, 666, 108, 122);
		frame.getContentPane().add(btnDeal);
		ActionDealCards handler = new ActionDealCards(); // listener object
		btnDeal.addActionListener(handler);
		btnDeal.setVisible(false);

		btnPlay = new JButton("");
		btnPlay.addActionListener(new ActionNewGame());
		btnPlay.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/playBTN.png")));
		btnPlay.setBounds(550, 664, 108, 122);
		frame.getContentPane().add(btnPlay);

		btnHit = new JButton("");
		btnHit.addActionListener(new ActionHit());
		btnHit.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/hitBTN.png")));
		btnHit.setBounds(623, 662, 108, 122);
		frame.getContentPane().add(btnHit);
		btnHit.setVisible(false);

		btnDD = new JButton("");
		btnDD.addActionListener(new ActionDoubleDown());
		btnDD.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/ddBTN.png")));
		btnDD.setBounds(739, 662, 108, 122);
		frame.getContentPane().add(btnDD);
		btnDD.setVisible(false);

		btnStay = new JButton("");
		btnStay.addActionListener(new ActionStay());
		btnStay.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/stayBTN.png")));
		btnStay.setBounds(507, 662, 108, 122);
		frame.getContentPane().add(btnStay);
		btnStay.setVisible(false);

		JLabel bjBackground = new JLabel("");
		bjBackground.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/Table3.jpg")));
		bjBackground.setBounds(0, 0, 1350, 800);
		frame.getContentPane().add(bjBackground);
	}

	//============================================================
	//Action Listeners
	//============================================================
	public class ActionNewGame implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			cht = new Chute();
			cht.shuffle();
			plyPlayer = new Player("Player 1", 1000.0);
			plyDealer = new Player("Dealer", 0.0);
			btnPlay.setVisible(false);
			btnDeal.setVisible(true);
			btnDD.setVisible(false);
		}
	}

	public class ActionDealCards implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			
			//Resets game after every hand
			gameReset();
			
			//Deals
			dealCards();

			//Do game Logic after dealing
			getTieOrBlackjack();
			
			//Find any aces dealt
			if (findAce(plyPlayer)) {
				lblPHandVal.setText("Player:  " + plyPlayer.getHandValue()
						+ " / " + (plyPlayer.getHandValueAce()));
			}
		}

		private void gameReset() {
			// game resets
			lblPlayerCard2.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblPlayerCard1.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblPlayerCard5.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblPlayerCard6.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblDealerCard2.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblDealerCard1.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblDealerCard5.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));
			lblDealerCard6.setIcon(new ImageIcon(BlackJackGUI.class.getResource("")));

			lblDHandVal.setText("");
			lblWinLose.setText("");
			lblWinLose2.setText("");
		}
		
		private void dealCards() {
			//Deal cards
			plyPlayer.hit(cht.deal());
			plyDealer.hit(cht.deal());
			plyPlayer.hit(cht.deal());
			plyDealer.hit(cht.deal());

			lblNumCards.setText("Cards: " + cht.getNunCardsRemainingBeforeShuffle());
			
			plyDealer.setHidden(true);

			//Set images / display buttons
			card1 = plyPlayer.getHand().getCards().get(0).toString().substring(0, 2);
			card2 = plyPlayer.getHand().getCards().get(1).toString().substring(0, 2);
			card3 = plyDealer.getHand().getCards().get(0).toString().substring(0, 2);
			card4 = plyDealer.getHand().getCards().get(1).toString().substring(0, 2);
			lblPlayerCard3.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card1))));
			lblPlayerCard4.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card2))));
			lblDealerCard3.setIcon(new ImageIcon(BlackJackGUI.class.getResource("/cards/RB.png")));
			lblDealerCard4.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card4))));
			lblPHandVal.setText("Player: " + plyPlayer.getHandValue());
			//Hide or show buttons
			btnDeal.setVisible(false);
			btnHit.setVisible(true);
			btnStay.setVisible(true);
			btnDD.setVisible(true);
		}
		
		private void getTieOrBlackjack() {
			// if both player and dealer have 21
			if (plyPlayer.getHandValue() == 21
					&& plyDealer.getHandValue() == 21) {
				updateGraphics("PUSH", Color.YELLOW);
				winLoseMoney(1, 0);

			}
			// dealer has blackjack
			else if (plyDealer.getHandValue() == 21) {
				updateGraphics("DEALER HAS BLACKJACK", Color.RED);
				winLoseMoney( 0, 100);
			}
			// player has blackjack
			else if (plyPlayer.getHandValue() == 21) {
				updateGraphics("YOU HAVE BLACKJACK", Color.GREEN);
				winLoseMoney( 1, 150);
			}
		}
	}
	
	
	public class ActionStay implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			// dealers turn to autodeal
			dealerAutoDeal();
			
			// dealer busts
			if (plyDealer.getHandValue() > 21) {
				//Dealers busts, update graphics
				updateGraphics("DEALER BUSTS", Color.GREEN);
				// player wins 100 dollars
				winLoseMoney( 1, 100);
			}
			// player loses
			else if (plyDealer.getHandValue() > plyPlayer.getHandValue()) {
				// player loses 100 dollars
				updateGraphics("YOU LOSE", Color.RED);
				winLoseMoney( 0, 100);
			}
			// player wins
			else if (plyDealer.getHandValue() < plyPlayer.getHandValue()) {
				//Player wins 100
				updateGraphics("YOU WIN", Color.GREEN);
				winLoseMoney(1, 100);
			}
			// tie
			else if (plyDealer.getHandValue() == plyPlayer.getHandValue()) {
				//Player TIES
				updateGraphics("PUSH", Color.YELLOW);
				winLoseMoney(1, 0);
			}

		}
	}
	
	public class ActionDoubleDown implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			card3 = plyDealer.getHand().getCards().get(0).toString().substring(0, 2);
			plyPlayer.hit(cht.deal());

			if (plyPlayer.getHand().getCards().size() == 3) {
				card5 = plyPlayer.getHand().getCards().get(2).toString().substring(0, 2);
				lblPlayerCard5.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card5))));
			} 
			else if (plyPlayer.getHand().getCards().size() == 4) {
				card6 = plyPlayer.getHand().getCards().get(3).toString().substring(0, 2);
				lblPlayerCard2.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card6))));
			} 
			else if (plyPlayer.getHand().getCards().size() == 5) {
				card7 = plyPlayer.getHand().getCards().get(4).toString().substring(0, 2);
				lblPlayerCard6.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card7))));
			} 
			else if (plyPlayer.getHand().getCards().size() == 6) {
				card8 = plyPlayer.getHand().getCards().get(5).toString().substring(0, 2);
				lblPlayerCard1.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card8))));
			}
			lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
			lblPHandVal.setText("Player:  " + plyPlayer.getHandValue());
			
			
			// player busts
			if (plyPlayer.getHandValue() > 21) {
				updateGraphics("YOU BUST", Color.RED);
				winLoseMoney( 0, 200);
			} 
			else {
				// dealers turn to autodeal
				dealerAutoDeal();
				// dealer busts
				if (plyDealer.getHandValue() > 21) {
					updateGraphics("DEALER BUSTS", Color.GREEN);
					winLoseMoney( 1, 200);
				}
				// player loses
				else if (plyDealer.getHandValue() > plyPlayer.getHandValue()) {
					updateGraphics("YOU LOSE", Color.RED);
					winLoseMoney( 0, 200);
				}
				// player wins
				else if (plyDealer.getHandValue() < plyPlayer.getHandValue()) {
					updateGraphics("YOU WIN", Color.GREEN);
					winLoseMoney(1, 200);
				}
				// tie
				else if (plyDealer.getHandValue() == plyPlayer.getHandValue()) {
					updateGraphics("PUSH", Color.YELLOW);
					winLoseMoney(1, 0);
				}
			}
		}
	}
	
	public class ActionHit implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			card3 = plyDealer.getHand().getCards().get(0).toString()
					.substring(0, 2);
			plyPlayer.hit(cht.deal());

			if (plyPlayer.getHand().getCards().size() == 3) {
				card5 = plyPlayer.getHand().getCards().get(2).toString().substring(0, 2);
				lblPlayerCard5.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card5))));
				lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
				if (findAce(plyPlayer)) {
					if (plyPlayer.getHandValue() > 21) {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValueAce());
					} 
					else {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue() + " / "+ (plyPlayer.getHandValueAce()));
					}
				} 
				else {
					lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue());
				}
			} 
			
			else if (plyPlayer.getHand().getCards().size() == 4) {
				card6 = plyPlayer.getHand().getCards().get(3).toString().substring(0, 2);
				lblPlayerCard2.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card6))));
				lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
				if (findAce(plyPlayer)) {
					if (plyPlayer.getHandValue() > 21) {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValueAce());
					} 
					else {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue() + " / "+ (plyPlayer.getHandValueAce()));
					}
				} 
				else {
					lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue());
				}
			} 
			
			else if (plyPlayer.getHand().getCards().size() == 5) {
				card7 = plyPlayer.getHand().getCards().get(4).toString().substring(0, 2);
				lblPlayerCard6.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card7))));
				lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
				if (findAce(plyPlayer)) {
					if (plyPlayer.getHandValue() > 21) {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValueAce());
					} 
					else {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue() + " / "+ (plyPlayer.getHandValueAce()));
					}
				} 
				else {
					lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue());
				}
			} 
			else if (plyPlayer.getHand().getCards().size() == 6) {
				card8 = plyPlayer.getHand().getCards().get(5).toString().substring(0, 2);
				lblPlayerCard1.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card8))));
				lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
				if (findAce(plyPlayer)) {
					if (plyPlayer.getHandValue() > 21) {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValueAce());
					} 
					else {
						lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue() + " / "+ (plyPlayer.getHandValueAce()));
					}
				} 
				else {
					lblPHandVal.setText("Player:  "+ plyPlayer.getHandValue());
				}
			}
			// player busts (with ace)
			if (findAce(plyPlayer)) {
				if (plyPlayer.getHandValueAce() > 21) {
					updateGraphics("YOU BUST", Color.RED);
					winLoseMoney( 0, 100);
				}
				// player has 21
				else if (plyPlayer.getHandValueAce() == 21) {
					updateGraphics("YOU WIN", Color.GREEN);
					winLoseMoney(1, 100);
				}
			} 
			else {
				// player busts
				if (plyPlayer.getHandValue() > 21) {
					updateGraphics("YOU BUST", Color.RED);
					winLoseMoney( 0, 100);
				}
				// player has 21
				else if (plyPlayer.getHandValue() == 21) {
					updateGraphics("YOU WIN", Color.GREEN);
					winLoseMoney(1, 100);
				}
			}
		}
	}
	
	public void dealerAutoDeal() {
		while (plyDealer.getHandValue() < 17) {
			card3 = plyDealer.getHand().getCards().get(0).toString().substring(0, 2);
			plyDealer.hit(cht.deal());

			if (plyDealer.getHand().getCards().size() == 3) {
				card9 = plyDealer.getHand().getCards().get(2).toString().substring(0, 2);
				lblDealerCard5.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card9))));
				
			} 
			else if (plyDealer.getHand().getCards().size() == 4) {
				card10 = plyDealer.getHand().getCards().get(3).toString().substring(0, 2);
				lblDealerCard2.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card10))));
			} 
			else if (plyDealer.getHand().getCards().size() == 5) {
				card11 = plyDealer.getHand().getCards().get(4).toString().substring(0, 2);
				lblDealerCard6.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card11))));
			} 
			else if (plyDealer.getHand().getCards().size() == 6) {
				card12 = plyPlayer.getHand().getCards().get(5).toString().substring(0, 2);
				lblDealerCard1.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card12))));
			}
			lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
			lblDHandVal.setText("Dealer:  "+ plyDealer.getHandValue());
			
		}
	}

	public void updateGraphics(String winLose, Color color) {
		//update graphics
		lblWinLose.setForeground(color);
		lblWinLose.setText(winLose);
		plyDealer.setHidden(false);
		lblDealerCard3.setIcon(new ImageIcon(BlackJackGUI.class.getResource(imageMap.get(card3))));
		lblNumCards.setText("Cards: "+ cht.getNunCardsRemainingBeforeShuffle());
		btnDeal.setVisible(true);
		btnDD.setVisible(false);
		btnHit.setVisible(false);
		lblDHandVal.setText("Dealer:  " + plyDealer.getHandValue());
	}

	public void winLoseMoney(int winLose, int amount) {
		//winLose 0=Lose, 1=Win
		if(winLose == 1){
			plyPlayer.setMoney(plyPlayer.getMoney() + amount);
			lblWinLose2.setForeground(Color.GREEN);
			lblWinLose2.setText("Win $  +"+amount);
		}
		else {
			plyPlayer.setMoney(plyPlayer.getMoney() - amount);
			lblWinLose2.setForeground(Color.RED);
			lblWinLose2.setText("Lose $  -"+amount);
		}
		
		lblCash.setText("Balance $   " + plyPlayer.getMoney());
		cht.recapture(plyDealer.returnCards());
		cht.recapture(plyPlayer.returnCards());
		btnStay.setVisible(false);
	}
	
	private boolean findAce(Player ply) {
		for (int i = 0; i < ply.getHand().getCards().size(); i++) {
			String ace = plyPlayer.getHand().getCards().get(i).toString()
					.substring(0, 1);
			if (ace.charAt(0) == 'A') {
				return true;
			}

		}
		return false;
	}
}
