/*GWV Aufgbabenblatt 3
Sascha Graef & Felix Templin */
#include <stdio.h>
#include <iostream>
#include <queue>
using namespace std;

//Festlegung der Zeilen- und Spaltenanzahl.
#define ZEILEN 10
#define SPALTEN 21

//Aufgabe 1: Interne Repräsentation des Labyrinths im System.
char labyrinth[ZEILEN][SPALTEN] = {
    "xxxxxxxxxxxxxxxxxxxx",
    "x                  x",
    "x      xxx         x",
    "x      x xxxxx     x",
    "x  s     x         x",
    "x      x xxxxxxxxxxx",
    "x xx xxxxx         x",
    "x     x       g    x",
    "x     x            x",
    "xxxxxxxxxxxxxxxxxxxx",
};


void zeige_labyrinth(void);
int pfad_finden_breite(int x, int y); //Aufgabe 2
int pfad_finden_tiefe(int x, int y); // Aufgabe 3



int main(void)
{
	zeige_labyrinth(); //zeigt Das Labyrinth im Augangszustand.
	cout << "1: Breitensuche \n2: Tiefensuche \n";
    int auswahl = 0;
    cin >> auswahl; //Auswahlmöglichkeit, ob Breiten- oder Tiefensuche durchgeführt werden soll.

    if(auswahl == 1) //Breitensuche
    {
    if ( pfad_finden_breite(3, 4) == 1 )
		cout << "Success!\n";
	else                        //Wenn ein Weg gefunden wurde wird "Success!" ausgegeben, wenn nicht "Failed!".
		cout << "Failed\n";

	zeige_labyrinth(); //zeigt das durchsuchte Labyrinth
    }

    if(auswahl == 2) //Tiefensuche
    {

	if ( pfad_finden_tiefe(3, 4) == 1 )
		cout << "Success!\n";
	else                        //s.o.
		cout << "Failed\n";

	zeige_labyrinth();
    }
	return 0;
}

//Methode, die das Labyrinth auf der Konsole ausgibt.
void zeige_labyrinth(void)
{
	for (int i = 0; i < ZEILEN; i++ )
		printf("%.*s\n", SPALTEN, labyrinth[i]);
	cout << "\n";

	return;
}

//Aufgabe 2: Methode, die per Breitensuche einen Pfad zum Zielpunkt 's' findet.
int pfad_finden_breite(int x, int y)
{
    queue<pair<int, int>> q; //Eine queue aus zwei int Werten, um Positionen im Labyrinth einreihen zu können.

    q.push(make_pair(x,y)); //Der Startzustand wird in die queue gepusht.

    while(!q.empty()) //Solange die queue nicht leer oder der Zielzustand gefunden ist, wird dies durchgeführt.
    {
        pair<int, int>& ort = q.front();  //die Variable ort referenziert das zur Zeit erste Objekt in der queue.
        q.pop();

        char& zeichen = labyrinth[ort.second][ort.first]; //das char an der Position von ort wird ausgelesen und von der char Variable zeichen referenziert.

        if ( zeichen == 'g' ) return 1; //Wie oben wird 1 zurückgegeben, wenn das Zielfeld 'g' gefunden wurde.


        //Solange das gelesene Zeichen kein 'x', also eine Wand ist (oder der Zielzustand) wird ein '+' als Wegmarkierung gesetzt und alle Nachbarn von Ort
        //werden in die queue eingereiht.
        if ( zeichen == ' ' || zeichen == 's')
        {
            zeichen = '+';

            q.push(make_pair(ort.first-1, ort.second));
            q.push(make_pair(ort.first, ort.second+1));
            q.push(make_pair(ort.first+1, ort.second));
            q.push(make_pair(ort.first, ort.second-1));
        }
        }
	return 0;
}
//Aufgabe 3: Methode, die per rekursiver Tiefensuche einen Pfad zum Zielpunkt 's' findet.
//int marker = 0; Variable zur erweiterten Markierung (siehe unten).
int pfad_finden_tiefe(int x, int y)
{

	if ( labyrinth[y][x] == 'g' ) return 1; //Wenn an der aktuellen Position das char 'g' liegt, so haben wir unser Ziel erreicht und können den Vorgang mit
                                            //dem Rückgabewert 1 verlassen.
	if ( labyrinth[y][x] != ' ' && labyrinth[y][x] != 's' ) return 0;

    labyrinth[y][x] = '+' ;//Die aktuelle Position wird mit einem '+' markiert, um den bereits zurückgelegten Weg kenntlich zu machen.

    /*labyrinth[y][x] = (char)(marker % 10 + '0') ; Erweiterte Markierung mit Zahlen von 0 bis 9. Sehr unübersichtlicht, daher auskommentiert.
    ++marker; */

    //Die Reihenfolge in der der Sucher die Richtungen, die ihm zur Verfügung stehen durchprobiert. Mit welcher Richtung begonnen wird ist egal (in diesem Fall
    //beginnt die Suche mit der Bewegungsrichtung 'oben'.
	if ( pfad_finden_tiefe(x, y - 1) == 1 ) return 1; //Bewegung nach oben.
	if ( pfad_finden_tiefe(x + 1, y) == 1 ) return 1; //Bewegung nach rechts.
	if ( pfad_finden_tiefe(x, y + 1) == 1 ) return 1; //Bewegung nach unten.
	if ( pfad_finden_tiefe(x - 1, y) == 1 ) return 1; //Bewegung nach links.

	return 0; //
}

