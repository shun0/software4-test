package kadai1;
import java.io.*;
import java.util.*;


public class MainShopCharger {

	Date date;
	Calendar calendar ;
	StudentCard insertedStudentCard;

	static void printAccountBalance(StudentCard card){
		System.out.println("Student ID:"+card.stuId+"\n"
						  +"Student Name :"+card.stuName+"\n"
						  +"Money :"+card.getMoney()+"\n"
						  +"-------History--------");
		for(int i=0;i<card.getDate().size();i++){
			System.out.println(card.getDate().get(i));
		}
		System.out.println("\n");
	}
	
	void insertStudentCard(StudentCard Card){
		insertedStudentCard = Card;
		chargeMoney(insertedStudentCard);
	}
	
	void chargeMoney(StudentCard card){
		int money = 0;
		System.out.println("How much money input:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		money = Integer.parseInt(readText(br));
		
		card.setMoney(money);
		calendar = Calendar.getInstance();
		date = calendar.getTime();
		card.setDate(date);
		System.out.println("Do you want to buy anything?  yes=1/no=0");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		int buy = Integer.parseInt(readText(br1));
		if(buy == 1 ){
			buySome(card);
		}else if(buy != 0){
			System.out.println("Error");
		}
		System.out.println("\nLastest Charge Date：" + date);
		printAccountBalance(card);
	}
	
	void buySome(StudentCard card){
		System.out.println("1:drink 150yen	2:food 100yen 3:non \nPlease input 1~3:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int in = Integer.parseInt(readText(br));
		switch(in){
			case 1: 
				if(card.getMoney() < 150){
				System.out.println("Don't have enough money");
				}else{
					card.setMoney(-150);
				}
				break;
			case 2:
				if(card.getMoney() < 100){
					System.out.println("Don't have enough money");
				}else{
					card.setMoney(-100);
				}
				break;
			case 3: break;
			default:
				System.out.println("Error");
				break;
		}
	}
	
	String readText(BufferedReader br){
		String str = null;
		try{
			str = br.readLine();
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		MainShopCharger charger = new MainShopCharger();
		StudentCard StudentCard1 = new StudentCard("a163300","Toyohashi Gijutsu");
		StudentCard StudentCard2 = new StudentCard("b163399","Kagaku Daigaku");
		charger.insertStudentCard(StudentCard1);
		charger.insertStudentCard(StudentCard2);
		for(int i=0;i<5;i++){
				charger.insertStudentCard(StudentCard1);
		}
		//System.out.println(StudentCard1.date_list);
		//System.out.println(StudentCard.StudentCardList_.size());//ArrayListにstaticを付けることでStudentCard1，2
																//毎ではなく共通のStudentCardクラスで呼び出せる
	}
	
}


