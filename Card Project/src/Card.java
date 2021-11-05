
public class Card
	{
		private String rank;
		private String suit;
		private boolean special;
		public Card (String r, String s, boolean sp) 
		{
			rank = r;
			suit = s;
			special = sp;
		}
		public String getRank()
			{
				return rank;
			}
		public void setRank(String rank)
			{
				this.rank = rank;
			}
		public String getSuit()
			{
				return suit;
			}
		public void setSuit(String suit)
			{
				this.suit = suit;
			}
		public boolean isSpecial()
			{
				return special;
			}
		public void setSpecial(boolean special)
			{
				this.special = special;
			}
		
		
	}
