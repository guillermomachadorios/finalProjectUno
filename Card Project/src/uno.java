import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;

public class uno
	{
		private static final long serialVersionUID = 1L;
		static Scanner userIntInput = new Scanner(System.in);
		static String pause;
		static String name;
		static ArrayList <Card> playerHand1 = new ArrayList <Card>( ); 
		static ArrayList <Card> playerHand2 = new ArrayList <Card>( ); 
		static int player1Choice = 0;
		static boolean player1Turn = true;
		static boolean player2Turn = true;
		static int player2Card;
		static boolean canPlayCard = false;
		static boolean gamePlaying = true;
		static Card topCard;
		static int counter = 0;
		static JFrame frame = new JFrame();
		static ImageIcon wildCard = new ImageIcon(("wild_card.png"));
		public static void main(String[] args)
			{
				Deck.fillDeck();
				Deck.shuffle();
				fillHand();
				genTopCard();
				nameGetter();
				while(gamePlaying) {
					displayHand();
					showTopCard();
					player1Round();
					winCheck();
					player2Round();
					winCheck();
				}
			}
		public static void nameGetter() {
		name = JOptionPane.showInputDialog(
				"What is your name?");  
		JOptionPane.showMessageDialog(
				frame, 
				"Welcome to Uno, " + name + "!");
		}
		public static void fillHand(){
			for(int i=0; i<7; i++) {
				playerHand1.add(Deck.deck.get(i));
				Deck.deck.remove(i);
				playerHand2.add(Deck.deck.get(i));
				Deck.deck.remove(i);
			}
		}
		public static void displayHand() {
			System.out.println("Your cards are:");
			for(int i = 0; i<playerHand1.size(); i++) {
				System.out.println(i + 1 + "." + playerHand1.get(i).getSuit() + " " + playerHand1.get(i).getRank());
			}
			System.out.println(" ");
		}
		public static void genTopCard() {
			topCard=Deck.deck.get(0);
			Deck.deck.remove(0);
		}
		public static void player1Round() {
			player1Turn=true;
			while(player1Turn) {
				canPlayCard=false;
				Object[] options = {"Play Card", "Draw"};
				player1Choice = JOptionPane.showOptionDialog(
						frame, 
						"What would you like to do, " + name + "?",
						"Your Turn",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, 
						options, 
						options[1]);
					switch(player1Choice)
					{
					case 0:
							{
						String[] selectCard = new String [playerHand1.size()];
						for(int i = 0; i<playerHand1.size(); i++) {
							if (playerHand1.get(i).getSuit()==topCard.getSuit()) {
								canPlayCard=true;
								selectCard[i] = playerHand1.get(i).getSuit() + " " + playerHand1.get(i).getRank();
							} else if (playerHand1.get(i).getRank()==topCard.getRank()) {
								canPlayCard=true;
								selectCard[i] = playerHand1.get(i).getSuit() + " " + playerHand1.get(i).getRank();
							}	
							selectCard[i] = playerHand1.get(i).getSuit() + " " + playerHand1.get(i).getRank();
						}
						if (canPlayCard==true) {
							String cardType = (String) JOptionPane.showInputDialog(
									frame, 
									"Card Choosing",
									"Your Turn",
									JOptionPane.QUESTION_MESSAGE, 
									wildCard, 
									selectCard, 
									null);
									if (cardType.substring(0,1).equals(topCard.getSuit().substring(0,1))||cardType.substring(cardType.length()-1,cardType.length()).equals(topCard.getRank().substring(topCard.getRank().length()-1,topCard.getRank().length()))) {
										System.out.println("You play a " + cardType + ".");
										for(int i = 0; i<playerHand1.size(); i++) {
											if (cardType.substring(0,1).equals(playerHand1.get(i).getSuit().substring(0,1))&&cardType.substring(cardType.length()-1,cardType.length()).equals(playerHand1.get(i).getRank().substring(playerHand1.get(i).getRank().length()-1,playerHand1.get(i).getRank().length()))) {
												counter = i;
											}
										}
										Deck.deck.add(topCard);
										topCard = playerHand1.get(counter);
										playerHand1.remove(counter);
										player1Turn=false;
									} else {
										JOptionPane.showMessageDialog(
												frame, 
												"You can't play that card. Try matching it to the color or number of the top card.");
									}
						} else if (canPlayCard==false) {
							JOptionPane.showMessageDialog(
									frame, 
									"You don't have any cards you can play!");
						}
						break;
					} 
						case 1: 
					{
						playerHand1.add(Deck.deck.get(0));
						JOptionPane.showMessageDialog(
								frame, 
								"You draw a card. It's a " + Deck.deck.get(0).getSuit() + " " + Deck.deck.get(0).getRank() + ".");
						Deck.deck.remove(0);
						displayHand();
						showTopCard();
					}
				}
			}
		}
		public static void player2Round() {
			int player2CardCounter = 0;
			player2Turn=true;
			while(player2Turn) {
				canPlayCard=false;
				for(int i = 0; i<playerHand2.size(); i++) {
					if (playerHand2.get(i).getSuit()==topCard.getSuit()) {
						canPlayCard=true;
						player2Card = i;
					} else if (playerHand2.get(i).getRank()==topCard.getRank()&&canPlayCard==false) {
						canPlayCard=true;
						player2Card = i;
					} else if (canPlayCard==false){
						canPlayCard=false;
					}
				}
				if (canPlayCard==true) {
						if (playerHand2.get(player2Card).getSuit()==topCard.getSuit()) {
							System.out.println("They play a " + playerHand2.get(player2Card).getSuit() + " " + playerHand2.get(player2Card).getRank() + ".");
							topCard = playerHand2.get(player2Card);
							Deck.deck.add(topCard);
							playerHand2.remove(player2Card);
							player2Turn=false;
						} else if (playerHand2.get(player2Card).getRank()==topCard.getRank()) {
							System.out.println("They play a " + playerHand2.get(player2Card).getSuit() + " " + playerHand2.get(player2Card).getRank() + ".");
							topCard = playerHand2.get(player2Card);
							Deck.deck.add(topCard);
							playerHand2.remove(player2Card);
							player2Turn=false;
						} 
				} else if (canPlayCard==false) {
					System.out.println("They draw a card.");
					playerHand2.add(Deck.deck.get(0));
					Deck.deck.remove(0);
				}
			}
			for (int i = 0;i<playerHand2.size(); i++) {
				player2CardCounter=player2CardCounter+1;
			}
			if (player2CardCounter>1) {
				System.out.println("Player 2 has " + player2CardCounter + " cards left.");
			} else if (player2CardCounter==1) {
				System.out.println("Player 2 has an Uno!");
			}
			
		}
		public static void winCheck() {
			if (playerHand1.size()==0){
				System.out.println("All of your cards are gone. You win, " + name + "!");
				System.exit(0);
			} else if (playerHand2.size()==0) {
				System.out.println("All of the opponent's cards are gone. You lose.");
				System.exit(0);
			} else {
				System.out.println(" ");
			}
		}
		public static void showTopCard(){
			System.out.println("The top card is:");
			System.out.println(topCard.getSuit() + " " + topCard.getRank());
			System.out.println(" ");
		}
	}
