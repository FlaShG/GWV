%Damit der Motor überhaupt keine Geräusche macht, darf weder noise1, noch noise2 oder noise3
%true sein.
no_noise :-
	\+ noise1,
	\+ noise2,
	\+ noise3.

%Damit nur der Starter ein Geräusch macht, müssen noise2 und noise3 false sein.
only_noise1 :- 
	   noise1,
	\+ noise2,
	\+ noise3.
%Damit nur die Benzinpumpe ein Geräusch macht, müssen noise1 und noise3 false sein.
only_noise2 :-
	\+ noise1,
	   noise2,
	\+ noise3.
%Damit noise1 und noise2 hörbar sind, müssen die entsprechenden Prädikate true sein,
%während noise3 false sein mus. 	
noise1_and_2 :-
	noise1,
	noise2,
	\+ noise3.

%Damit noise1 true wird, müssen die Batterie, der Zündschlüssel und der Starter fehlerfrei 
%funktionieren (also 1 sein).
noise1 :-
	battery(1),
	ignition_key(1),
	starter(1).

%Damit noise2 true wird, müssen Batterie, efr, Benzinpumpe und Tank in Ordnung sein.
noise2 :-
	battery(1),
	efr(1),		
	fuel_pump(1),
	fuel_tank(1).

%Die Voraussetzungen dafür, dass unser Motor "vroom" macht.
%Wir sehen also, dass nur ein Prädikat unerfüllt sein muss, damit der Motor nicht
%läuft.
noise3 :-
	noise1,
	noise2,
	filter(1),
	engine(1).

%Die Zustände der einzelnen Bestandteile des Motors. 1 steht für funktionsfähig, 0 steht für kaputt. Möchte man die Auswirkungen eines kaputten Teils testen, so kann man an dieser Stelle die Einsen durch Nullen oder umgekehrt ersetzen. Bei der Standardbelegung aller Teile mit 1 werden alle Geräusche zu hören sein

battery(1).
ignition_key(1).
efr(1). %kurz für electronic fuel regulation.
starter(1).
fuel_pump(1).
fuel_tank(1).
filter(1).
engine(1).

