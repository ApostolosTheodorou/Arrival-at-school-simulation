#ifndef NAMES_H
#define NAMES_H

#include <iostream>
#include <string>


using namespace std;

class Names {
private:
	string names[60]=
   	{"Georgios", "Ioannis", "Kostas", "Dimitris", "Nikolas",
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
	string surnames[75]=
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

	string classesIDs[18]=
	{ "A1", "A2", "A3", "A4", "A5", "A6",
	  "B1", "B2", "B3", "B4", "B5", "B6",
	  "C1", "C2", "C3", "C4", "C5", "C6"};

public:
	void give_me_names(string * &, int, int);
};

#endif
