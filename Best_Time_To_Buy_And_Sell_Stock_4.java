//Grind 75 problem #4
//Finds the greatest possible profit given stock prices and days they occur on
import java.util.*;

class Best_Time_To_Buy_And_Sell_Stock_4{
	
	public static void main(String[] args){
		Best_Time_To_Buy_And_Sell_Stock_4 bttbass = new Best_Time_To_Buy_And_Sell_Stock_4();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter prices in the following format: [x,y,z]");
		System.out.print(" prices = ");
		String s = in.nextLine();
		int[] prices = bttbass.makeArray(s);
		bttbass.solve(prices);
	}
	
	private int[] makeArray(String s){
		String y = s.substring(s.indexOf("["), s.indexOf("]"));
		y = y.substring(1, y.length());
		String[] z = y.split(",");
		int[] prices = new int[z.length];
		for(int i=0; i<z.length; i++){
				if(z[i] != "["){
					prices[i] = Integer.parseInt(z[i]);
				}
		}
		return prices;
	}
	
	private void solve(int[] prices){
		int mostProfit = 0;
		int buyIndex = 0;
		int sellIndex = 0;
		
		//[7,1,5,3,6,4]
		for(int i=0; i<prices.length; i++){
			for(int j=i; j<prices.length; j++){
				int difference = prices[j] - prices[i];
				if(difference > mostProfit){
					mostProfit = difference;
					buyIndex = i;
					sellIndex = j;
				}
			}
		}
		System.out.println(mostProfit);
	}
}
