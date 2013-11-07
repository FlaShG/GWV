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
    "x      x x xxxxxxxxx",
    "x xx xxxxx         x",
    "x     x       g    x",
    "x     x            x",
    "xxxxxxxxxxxxxxxxxxxx",
};


void zeige_labyrinth(void);
int pfad_finden_a_star(int x, int y);



int main(void)
{
	zeige_labyrinth(); //zeigt Das Labyrinth im Augangszustand.
    
    if ( pfad_finden_a_star(3, 4) == 1 )
		cout << "Success!\n";
	else                        //Wenn ein Weg gefunden wurde wird "Success!" ausgegeben, wenn nicht "Failed!".
		cout << "Failed\n";

	zeige_labyrinth(); //zeigt das durchsuchte Labyrinth
    
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
int pfad_finden_a_star(int x, int y)
{
    

    return 0;
}