

%Testprädikat für Aufgabe 1.2, die einzelnen Werte stellen die Wahrscheinlichkeiten dar, das ein Teil in Ordnung ist
%teste_alles(battery, ignition_key, efl, starter, engine, filter, fuel_pump, fuel_tank, Battery_w, Starter_w, Engine_w, Engine_w_if_fuel_pump_w).

teste_alles(Battery, Ignition_key, Efr, Starter, Engine, Filter, Fuel_pump, Fuel_tank, 	Battery_w, Ignition_key_w, Efr_w, Fuel_pump_w, Fuel_tank_w, Filter_w, Starter_w, Engine_w, Engine_w_if_fuel_pump_w) :-

	Battery_w is Battery,	%1.2.1
	Ignition_key_w is Battery_w * Ignition_key,
	Efr_w is Battery_w * Efr,
	Fuel_tank_w is Fuel_tank,	
	Fuel_pump_w is Efr_w * Fuel_pump * Fuel_tank_w,
	Filter_w is Fuel_pump_w * Filter,
	Starter_w is Battery * Ignition_key * Starter, %1.2.2	
	Engine_w is Starter_w * Filter_w * Engine, %1.2.3
	Engine_w_if_fuel_pump_w is Starter_w * Filter * Engine * 1. %1.2.4


/*
?- teste_alles(0.9, 0.9, 0.9, 0.9, 0.9, 0.9, 0.9, 0.9, Battery_w, Ignition_key_w, Efr_w, Fuel_pump_w, Fuel_tank_w, Filter_w, Starter_w, Engine_w, Engine_w_if_fuel_pump_w).
Battery_w = Fuel_tank_w, Fuel_tank_w = 0.9,
Ignition_key_w = Efr_w, Efr_w = 0.81,
Fuel_pump_w = 0.6561000000000001,
Filter_w = Engine_w_if_fuel_pump_w, Engine_w_if_fuel_pump_w = 0.5904900000000002,
Starter_w = 0.7290000000000001,
Engine_w = 0.3874204890000002.


Hieraus ergeben sich folgende Lösungen für 1.2:
1.2.1: 0,9
1.2.2: 0,729
1.2.3: 0,3874
1.2.4: 0,5904
