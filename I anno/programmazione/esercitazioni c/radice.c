
float radice(float a){
	float x,y = 1.0;
	
	if(a<0)
		return 0;
	do{
		x=y;
		y = (x + a/x)/2;
		
	}while((x-y) > 0.0001 || (x-y) < -0.0001);
	
	
	
	return y;
	}

