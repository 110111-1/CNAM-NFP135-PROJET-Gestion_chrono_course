package nfp135Projet;
import java.util.Date;
public class Test {

	public static void main(String[] args) {
		Date[] arrivee = new Date[4];
		for (int i=0;i<=arrivee.length-1;i++) {
			arrivee[i]=new Date();
		}
		System.out.println(arrivee[3].getDate()-arrivee[0].getDate());
		int jour = arrivee[2].getDay()-arrivee[1].getDay();
		int heure = arrivee[2].getHours()-arrivee[1].getHours();
		int minute = arrivee[2].getMinutes()-arrivee[1].getMinutes();
		int seconde = arrivee[2].getSeconds()-arrivee[1].getSeconds();
		System.out.println(jour+" : "+heure+"h"+minute+"mn"+seconde+"seconde");
	}

}
