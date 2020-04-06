package Userprogram;

import java.util.ArrayList;

public class UserrInterfaceImplementation implements userInterface{

	Userr us=new Userr();
	ArrayList<Userr> list=new ArrayList<>();
	@Override
	public void Register(Userr user) {
		list.add(user);
	}
	
}
