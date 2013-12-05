
battery_w       :- battery_ok
ignition_key_w  :- ignition_key_ok
efl_w           :- efl_ok * battery_w
starter_w       :- starter_ok * ignition_key_w
engine_w        :- engine_ok * starter_w * filter_w
filter_w        :- filter_ok * fuel_pump_w
filter_pump_w   :- fuel_pump_ok * efl_w * fuel_tank_w
fuel_tank_w     :- fuel_tank_ok