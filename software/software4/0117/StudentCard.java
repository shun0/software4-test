package kadai1;
import java.util.*;

public class StudentCard {
	
	int money = 0;
	int i=0;
	String stuId;
	String stuName;
	String[] cale;
	String year,month,day;
	
	static ArrayList<StudentCard> StudentCardList_ = new ArrayList<StudentCard>();
	ArrayList<Date> date_list = new ArrayList<Date>(); 
	
	Calendar calendar = Calendar.getInstance();
	
	StudentCard(String Id,String Name){
		setId(Id);
		setName(Name);
		StudentCardList_.add(this);
	}
	
	String getName(){
		return this.stuName;
	}
	void setName(String name){
		this.stuName = name;
	}
	
	String getId(){
		return this.stuId;
	}
	void setId(String id){
		this.stuId = id;
	}
	
	int getMoney(){
		return this.money;
	}
	void setMoney(int Money){
		this.money += Money;
	}
	
	ArrayList<Date> getDate() {
		return date_list;
	}
	public void setDate(Date date) {
		if(date_list.size() > 4){
			date_list.add(date);
			date_list.remove(0);
		}else{
			date_list.add(date);
		}
		
	}
}
