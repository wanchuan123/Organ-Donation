package CentralizedDataCenter.Entities;

public class Organ{

	private int _hp;
	private String _name;
	public Organ(String name,int hp){
		_name = name;
		_hp = hp;
	}
	public int getHP(){
		return _hp;
	}
	public String getName(){
		return _name;
	}
	public void setHP(int hp){
		_hp = hp;
	}
	
}
