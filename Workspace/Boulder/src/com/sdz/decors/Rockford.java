package com.sdz.decors;
import com.sdz.main.Element;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

final public class Rockford extends Element{

	static void seDeplace(){
		boolean abouge=false;
		//Sélectionne la direction (Surement autre fonction)
		Scanner sc= new Scanner(System.in);
		
		do{
			int direction =sc.nextInt();//8456 up le dw ri
			//Verif si c'est possible
			switch (direction){
			case 8:
			
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				abouge=false;
			}
		}while(!abouge);
		
		//Actions
		
	}
		
	
	boolean victoire(){
		//TODO Verif si c'est gagné
		return false;
	}

}
