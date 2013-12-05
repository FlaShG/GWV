

battery_w       :- battery_ok(0.9)
ignition_key_w  :- ignition_key_ok(0.9)
efl_w           :- efl_ok(0.9) * battery_w
starter_w       :- starter_ok(0.9) * ignition_key_w
engine_w        :- engine_ok(0.9) * starter_w * filter_w
filter_w        :- filter_ok(0.9) * fuel_pump_w
filter_pump_w   :- fuel_pump_ok(0.9) * efl_w * fuel_tank_w
fuel_tank_w     :- fuel_tank_ok(0.9)