package com.sdz.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ListeMap {
private ArrayList<Map> lesNiveaux;
	
	public ListeMap(String fichier) throws FileFormatException{
		//on vérifie qu'on a bien un fichier .bdcff
		lesNiveaux = new ArrayList<Map>();
		StringTokenizer str = new StringTokenizer(fichier,".");
		String extension = "";
		while(str.hasMoreElements()){
			extension = str.nextToken();
		}
		if(!extension.equals("bdcff")) throw new FileFormatException();
		
		File fichierNiveau = new File(fichier);
		String ligne = "";
		
		//booléens pour savoir entre quelles balises on se situe 
		boolean cave = false, map = false;
		
		//variables intermédiaires pour récuperer les données du fichier
		String name = "";
		ArrayList<Integer> caveTime = new ArrayList<Integer>();
		int diamondsRequired = 0;
		ArrayList<Integer> diamondValue = new ArrayList<Integer>();
		int amoebaTime = 0;
		int magicWallTime = 0;
		
		//variable intermédiaire pour les champs ou il peut y avoir plusieurs valeurs
		String valeurs = "";
		
		//à ce stade, la map est récupérée dans une arrayList de String
		ArrayList<String> laMap = new ArrayList<String>();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(fichierNiveau));
			
			String token = "";
			
			while((ligne = br.readLine()) != null){
				
				if(ligne.contains("[/cave]")){
					cave = false;
					//A la fermeture de la balise on crée un niveau avec les infos récupérées
					lesNiveaux.add(new Map(name,caveTime,diamondsRequired,diamondValue,amoebaTime,magicWallTime,laMap));
				}
				if(ligne.contains("[/map]")) map = false;
				
				if(cave && !map){
					str = new StringTokenizer(ligne,"=");
					if(str.hasMoreElements()){
						/*switch(str.nextToken()){     INCOMPATIBLE JAVA J2SE DONC REMPLACE PAR LE ELSE IF QUI SUIT
						case "Name":
							name = str.nextToken();
							break;
						case "CaveTime":
							valeurs = str.nextToken();
							str = new StringTokenizer(valeurs," ");
							//on stocke les valeurs une à une dans l'arrayList
							while(str.hasMoreElements()) caveTime.add(Integer.parseInt(str.nextToken()));
							break;
						case "DiamondsRequired":
							diamondsRequired = Integer.parseInt(str.nextToken());
							break;
						case "DiamondValue":
							valeurs = str.nextToken();
							str = new StringTokenizer(valeurs," ");
							while(str.hasMoreElements()) diamondValue.add(Integer.parseInt(str.nextToken()));
							break;
						case "AmoebaTime":
							amoebaTime = Integer.parseInt(str.nextToken());
							break;
						case "MagicWallTime":
							magicWallTime = Integer.parseInt(str.nextToken());
							break;
						default:
							break;
						}*/
						token = str.nextToken();
						
						if(token.equals("Name")) name = token;
						else if(token.equals("CaveTime")){
							valeurs = token;
							str = new StringTokenizer(valeurs," ");
							//on stocke les valeurs une à une dans l'arrayList
							while(str.hasMoreElements()) caveTime.add(Integer.parseInt(token));
							}
						else if(token.equals("DiamondsRequired")) diamondsRequired = Integer.parseInt(token);
					
						else if(token.equals("DiamondValue")){
							valeurs = token;
							str = new StringTokenizer(valeurs," ");
							while(str.hasMoreElements()) diamondValue.add(Integer.parseInt(str.nextToken()));
						}
						else if(token.equals("AmoebaTime"))	amoebaTime = Integer.parseInt(token);
						else if(token.equals("MagicWallTime")) magicWallTime = Integer.parseInt(token);
				}
				
				if(cave && map){
					laMap.add(ligne);
				}
				
				if(ligne.contains("[cave]")){
					cave = true;
					//Réinitialisation des variables intermédiaires
					name = "";
					caveTime = new ArrayList<Integer>();
					diamondsRequired = 0;
					diamondValue = new ArrayList<Integer>();
					amoebaTime = 0;
					magicWallTime = 0;
					laMap = new ArrayList<String>();
				}
				
				if(ligne.contains("[map]")){
					map = true;
					laMap = new ArrayList<String>();
				}
			}
		}
		br.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public String toString(){
		String s = "";
		for(int i = 0 ; i < lesNiveaux.size() ; i++) s += lesNiveaux.get(i).toString() + "\n\n\n";
		return s;
	}
}