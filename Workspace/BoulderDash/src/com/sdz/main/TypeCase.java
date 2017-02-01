package com.sdz.main;

public enum TypeCase {
	Roc(0,0,false),//boolen chute
	Vide(0,0,false),//bollean inutiile
	Poussiere(0,0,false),//bollean inutiile
	Diamant(0,0,false),//booleen chute
	Mur(0,0,false),//bollean inutiile
	TitanMur(0,0,false),//bollean inutiile
	Sortie(0,0,false);//Le boolean servira a savoir si c'est ouvert
	
	int x;
	int y;
	boolean chute ;
	
	private TypeCase(int x,int y, boolean c,char d){
		
		switch (d){
		case ' ' :
			this = new enum Vide;
			break;
			
		case '.' :
			break;

		case 'r' :
			break;

		case 'd' :
			break;

		case 'w' :
			break;
			
		case 'W' :
			break;
		
		case 'M' :
			break;
			
		default:
			
			break;
		}
		this.x=x;
		this.y=y;
		this.chute=c;	
		
	}
	
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public boolean getChute(){
		return this.chute;
	}
}
