package nfp135Projet;
import java.util.Scanner;

public class ProjetNFP135 {

	static Scanner read = new Scanner(System.in);
	//a)
	static void enrNom(String[]nomPart,int[][] caracteristiques){
		//Permet d'enregistrer les noms des participants dans un tableau de String
		//Enregistre le numéro de dossard en [i][0]
		for(int i=0;i<nomPart.length;i++){
			System.out.printf("Entrez le nom du participant n°%s : ",(i+1));
			nomPart[i]=read.nextLine();
			caracteristiques[i][0]=(i+1);
		}
	}

	static void afficherCoureurs(String[]tab,int[][] caracteristiques){
		//Affiche le nom et le numéro de dossard du cycliste
		for (int i=0;i<=tab.length-1;i++){
			System.out.printf("Dossard n°%s : %s\n",caracteristiques[i][0],tab[i]);
		}
	}
	//b)
	static void afficherMenu(){
		//Affiche le menu et les choix possibles
		System.out.println("------------------------------------------------------------");
		System.out.println("\tMenu\nPressez le nombre correspondant à votre choix");
		System.out.println("0 : Quitter le programme");
		System.out.println("1 : Affichez les coureurs");
		System.out.println("2 : Afficher le classement provisoire");
		System.out.println("3 : Enregistrer une arrivée");
		System.out.println("4 : Enregistrer un abandon");
		System.out.println("5 : Enregistrer une disqualification");
		System.out.println("6 : Enregistrer le temps d'un coureur");
		System.out.println("7 : Obtenir le temps d'un coureur");
		System.out.println("8 : Obtenir l'écart de temps entre deux coureurs donnés");
		System.out.println("9 : Afficher classement des arrivés");
		System.out.println("------------------------------------------------------------");
	}

	public static void classementProvisoire(String[] tab, int[][]caracteristiques){
		//Affiche le classement provisoire avec l'état du coureur
		for (int i=0;i<=tab.length-1;i++){
			if(caracteristiques[i][1]==1){//arrivée
				System.out.printf("Dossard n°%s : %s : arrivée\n",(i+1),tab[i]);
			}
			else if (caracteristiques[i][1]==2){//abandon
				System.out.printf("Dossard n°%s : %s : abandon \n",(i+1),tab[i]);
			}
			else if (caracteristiques[i][1]==3){//disqualification
				System.out.printf("Dossard n°%s : %s : disqualification\n",(i+1),tab[i]);
			}
			else{//0 : toujours sur la piste
				System.out.printf("Dossard n°%s : %s : sur la piste\n",(i+1),tab[i]);
			}
		}
	}

	static int[] tabArrivee(int[]old,int nDossard){
		//tableau qui répertorie numéro dossard des arrivées
		int[] arrivee=new int[old.length+1];
		for(int i=0;i<=arrivee.length-2;i++){
			arrivee[i]=old[i];
		}
		arrivee[arrivee.length-1]=nDossard;
		return arrivee;
	}
	static void afficherClassement(int[] tab){
		//affiche les arrivées contenues dans tabArrivee
		System.out.print("Le classement : ");
		for(int i=0;i<=tab.length-1;i++){
			System.out.print(tab[i]+" | ");
		}
		System.out.println();
	}

	public static void enregistrerArrivée(int[][]tab,int[]arr,int nDossard){
		//Enregistre arrivée 
		if(tab[nDossard-1][1]==1){
			System.out.println("Le canditat est déjà arrivé");
		}
		else{
			tab[nDossard-1][1] = 1;
		}
	}

	public static int[][] enregistrerAbandon(int[][] tab){
		//enregistre abandon 
		System.out.println("Enregistrer un abandon\nEntrez le numero de dossard du candidat : ");
		int numero=read.nextInt();
		read.nextLine();
		tab[numero-1][1] = 2;
		return tab;
	}

	public static int[][] enregistrerdisqualification(int[][] tab){
		//enregistre disqualification
		System.out.println("Enregistrer une disqualification\nEntrez le numero de dossard du candidat : ");
		int numero=read.nextInt();
		read.nextLine();
		tab[numero-1][1] = 3;
		return tab;
	}

	public static int[][] enregistrerTemps(int[][] caracteristiques){
		//Enregistre le temps des coureurs dans int[][] donc pas de date[] 
		//- methode avec return caracteristique possible
		System.out.println("Enregistrer le chrono\nEntrez le numero de dossard du candidat : ");
		int numero=read.nextInt();
		read.nextLine();
		if(caracteristiques[numero-1][1]==1) {
			System.out.print("Entrez les minutes : \n");
			int mn=read.nextInt();
			caracteristiques[numero-1][2]=mn;
			System.out.print("Entrez les secondes : \n");
			int s=read.nextInt();
			caracteristiques[numero-1][3]=s;
		}	
		else{
			System.out.println("Le candidat n'est pas arrivé\nEnregistrez d'abord son arrivée");
		}
		return caracteristiques;
	}
	public static void afficherTemps(int[][]caracteristiques) {
		//affiche le chrono du cycliste contenue [][2]=minutes et [][3]=seconde
		System.out.println("Voir le chrono\nEntrez le numero de dossard du candidat : ");
		int numero=read.nextInt();
		read.nextLine();
		System.out.println("candidat "+caracteristiques[numero-1][0]+" : "+caracteristiques[numero-1][2]+"mm "+caracteristiques[numero-1][3]+"s");

	}
	public static void EcartEntreJoueurs(int[][]caracteristiques){
		//Calcule l'écart entre 2 joueur et affiche cet écart 
		int joueur1, joueur2, ecartMin,ecartSec;
		System.out.print("Entrez le numéro de dossard du joueur 1 : ");
		joueur1=read.nextInt()-1;//indice joueur
		System.out.print("Entrez le numéro de dossard du joueur 2 : ");
		joueur2=read.nextInt()-1;//indice joueur
		ecartMin= abs(caracteristiques[joueur2][2]-caracteristiques[joueur1][2]);
		ecartSec=abs(caracteristiques[joueur2][3]-caracteristiques[joueur1][3]);
		System.out.printf("L'écart entre les deux joueurs est de %smn et %ssecondes",ecartMin,ecartSec);
		System.out.println();
	}

	static int abs(int x) {
		//retourne la valeur absolue de la valeur entrée
		if(x<0){
			return-x;
		}
		else{
			return x;
		}
	}

	public static void main(String[]args){
		System.out.printf("Entrez le nombre de participants : ");
		int nbPart = read.nextInt();
		read.nextLine();
		String[]nomPart = new String[nbPart];
		int[][]caracteristiques = new int[nbPart][4];//0:en course/1: abandon/2:disqualifié/3.arrivée
		int[] arrivee=new int[0];
		enrNom(nomPart,caracteristiques);
		int choix = -1;

		do{
			try{
				afficherMenu();
				System.out.println("Entrez votre choix : ");
				choix = read.nextInt();
				read.nextLine();
				switch(choix)
				{
				case 0 :
					System.out.println("Fin");
					break;
				case 1 :
					afficherCoureurs(nomPart,caracteristiques);
					break;
				case 2 : 
					classementProvisoire(nomPart, caracteristiques);
					break;
				case 3 : 
					System.out.println("Enregistrement des Arrivées\nEntrez le numero de dossard du candidat : ");
					int nDossard=read.nextInt();
					read.nextLine();
					enregistrerArrivée(caracteristiques, arrivee,nDossard);
					arrivee=tabArrivee(arrivee, nDossard);
					break;
				case 4:
					caracteristiques = enregistrerAbandon(caracteristiques);
					break;
				case 5:
					caracteristiques = enregistrerdisqualification(caracteristiques);
					break;
				case 6:
					caracteristiques = enregistrerTemps(caracteristiques);
					break;
				case 7:
					afficherTemps(caracteristiques);
					break;
				case 8:
					EcartEntreJoueurs(caracteristiques);
					break;
				case 9 : 
					afficherClassement(arrivee);
				}
			}
			catch (ArrayIndexOutOfBoundsException e){
				System.out.println("Erreur de saisie");	
			}
		}
		while(choix!=0);
		read.close();
	}
}


