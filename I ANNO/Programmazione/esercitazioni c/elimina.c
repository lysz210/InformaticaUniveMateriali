int elimina(int a){

	int b=0, i=1;
	
	while(a != 0){
		if(a%2 != 0){			
			b = b+i*(a%10);
			i *=10;}
		a = a/10;
	}
	
	
	return b;
	

}

