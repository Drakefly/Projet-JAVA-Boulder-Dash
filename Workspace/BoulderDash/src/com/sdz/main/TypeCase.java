package com.sdz.main;

public enum TypeCase {
	Roc,
	Vide,
	Poussiere,
	Diamant,
	Mur,
	TitanMur,
	Sortie;
	
	int x;
	int y;
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}
