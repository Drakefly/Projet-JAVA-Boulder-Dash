package com.sdz.main;

import java.util.ArrayList;

public class Map {
	private String name;
	private int[] caveTime;
	private int diamondsRequired;
	private int diamondValue; //= valeur du diamant + le bonus
	private int amoebaTime;
	private int magicWallTime;
	private Object [][] laMap;
	
	public Map(String name, ArrayList<Integer> caveTime, int diamondsRequired, ArrayList<Integer> diamondValue, int amoebaTime, int magicWallTime, ArrayList<String> laMap){
		this.name = name;
		this.caveTime = new int[caveTime.size()];
		for(int i = 0 ; i < caveTime.size() ; i++) this.caveTime[i] = caveTime.get(i); //on transforme l'arrayList en tableau
		this.diamondsRequired = diamondsRequired;
		this.diamondValue = 0;
		for(int i = 0 ; i < diamondValue.size() ; i++) this.diamondValue += diamondValue.get(i);
		this.amoebaTime = amoebaTime;
		this.magicWallTime = magicWallTime;
		this.laMap = new Object[laMap.size()][laMap.get(0).length()];
		//création du tableau aux bonnes dimensions et double boucle pour le remplir
		for(int j = 0 ; j < laMap.size() ; j++){
			for(int i = 0 ; i < laMap.get(j).length() ; i++){
				this.laMap[j][i] = formatageCaractere(laMap.get(j).charAt(i));
				//Ici on a une map de caractere mais on veut une map d'elements
			}
		}
	}
	
	public char formatageCaractere(char a){//Afin qu'il n'y est qu'un caractere par element
		if (a=='F'||a=='Q'||a=='o'||a=='O'||a=='Q') return 'F';//Dans tout ces cas c'est une luciole alors il y a qu'un caractere
		else if(a=='B'||a=='b'||a=='c'||a=='C') return 'C';
		else return a;
	}
	
	public String toString(){
		String s = "Name : "+name+" | CaveTime : ";
		for(int i = 0 ; i < caveTime.length ; i++) s += caveTime[i]+" ";
		s += "| Diamonds required : "+diamondsRequired+" | Diamond value : "+diamondValue+" | Amoeba Time : "+amoebaTime+" | Magic Wall Time : "+magicWallTime+"\n\n";
		for(int i = 0 ; i < laMap.length ; i++){
			for(int j = 0 ; j < laMap[i].length ; j++){
				s += laMap[i][j];
			}
			s += "\n";
		}
		return s;
	}
	

	/*
	 * NE PEUT PAS FONCTION BESOIN D'INFORMATIONS NON CONTENUES DANS UN CARACTERES
	 * EXEMPLE ROC DOIT AVOIR UN ATTRIBUT BOOLEEN DE CHUTE CAR IL PRENDS UN TOUR A COMMENCER A TOMBER ET SI IL NE CHUTAIS PAS IL N'EST PAS ENCORE LETAL
	 public Map gravite (){//Il faut donner un unique cout de gravitée a chaque tours de la map
	 
		for(int i = laMap.length-2 ; i >0 ; i--){//Il faut aller de bas en haut pour eviter des bugs stupides.
			for(int j = 0 ; j < laMap[i].length ; j++){
				if((laMap[i][j]=='r'||laMap[i][j]=='d')&&laMap[i+1][j]==' '){
					laMap[i+1][j]=laMap[i][j];
					laMap[i][j]=' ';
				}else if (laMap[i][j]=='r'&&laMap[i+1][j]=='R'){
					//Mort du joueur
				}else if (laMap[i][j]=='r'&&(laMap[i+1][j]=='F'||laMap[i+1][j]=='B')){
					//Mort du mob, explosion?
				}
			}	
		}
		return this;	
	}
	*/
}