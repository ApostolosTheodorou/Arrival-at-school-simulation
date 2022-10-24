package JavaSimulation;

import java.util.Random;

public final class Names {
	
	
	 String[] names= {"Georgios", "Ioannis", "Kostas", "Dimitris", "Nikolas",
		 "Panagiotis", "Vasilis", "Christos", "Athanasios", "Mixalis",
		 "Evangelos", "Spyros", "Antonis", "Anastasios", "Thodoris",
		 "Andreas", "Charalabos", "Alexandros", "Manolis", "Ilias", 
		 "Stavros", "Petros", "Sotiris", "Stelios", "Lefteris",
		 "Apostolos", "Fotis", "Dionisis", "Grigoris", "Aggelos",
		 "Stefanos", "Stathis", "Paulos", "Paraskevas", "Aristeidis",
		 "Leonidas", "Pantelis", "Thomas", "Kyriakos", "Eythumis",
		 "Stamatis", "Argyris", "Lampros", "Savvas", "Stratos",
		 "Lazaros", "Charilaos", "Gerasimos","Filippos", "Periklis",
		 "Theofanis", "Markos", "Miltiadis", "Achilleas", "Dimosthenis",
		 "Christoforos", "Iraklis", "Iordanis", "Aristotelis", "Loukas"};
		
	 String[] surnames=
		{ "Arvanitis", "Arnaoutis", "Veliouras", "Vellas", "Veskousis",
		  "Vigos", "Votsis", "Voutsas", "Vouniotis", "Vourakis",
		  "Galanis", "Gekas", "Gizas", "Gioulekas", "Gionis",
		  "Gogolis", "Grivas", "Dagalis", "Doukouris", "Ziakas",
		  "Katselis", "Katsis", "Kepas", "Kokas", "Kordas",
		  "Korovesis", "Krieziotis", "Lalas", "Laliotis", "Latsis",
		  "Lekas", "Lotzas", "Lioumis", "Likourezos", "Mazis",
		  "Mpastas", "Mpithikotsis", "Mpletsas", "Mpoukouras", "Mpouras",
		  "Ntalis", "Ntouskas", "Ntragas", "Paganis",  "Palas",
		  "Pantzas", "Petas", "Pikeas", "Prekas", "Rallis",
		  "Renesis", "Repas", "Rousis", "Saras", "Seftelis",
		  "Skouzes", "Skourtis", "Sokolis", "Soulis", "Soutas",
		  "Stapas", "Strigos", "Tatoulis", "Tatsis", "Tzamouranis",
		  "Togas", "Tountas", "Toufas", "Tragas", "Tsapogas",
		  "Tsikas", "Tsitouras", "Tsounis", "Fortis", "Flokas"};

		String[] classesIDs=
		{ "A1", "A2", "A3", "A4", "A5", "A6",
		  "B1", "B2", "B3", "B4", "B5", "B6",
		  "C1", "C2", "C3", "C4", "C5", "C6"};
		
		Names(){
			
		}
		
		
		void give_me_names(String[] teachers_names, int count, int random_number)
		{
			int i, j, k;

			Random rand = new Random();
						
			for (i=0 ; i < count ; i++) {
				j= rand.nextInt(60);
				k= rand.nextInt(75);
				teachers_names[i]=names[j]+" "+surnames[k];
			}

		}
}