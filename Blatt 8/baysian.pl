
depends(dogBarks, [smuggler]
	[	[  [t], [f],
		[t, 0.8,  0.05],			
		[f, 0.2,  0.95]	]).
depends(sweat, [fever, smuggler]
	[	[  [t,t], [f,t], [t,f], [f,f]
		[t,	0.8,   0.4,	  0.6,	 0.0], 
		[f,	0.2,   0.6,   0.4,   1.0]] ).
input_node(smuggler, [t:0,01,f:0,99]).
input_node(fever, [t:0,013, f: 0.987]).
