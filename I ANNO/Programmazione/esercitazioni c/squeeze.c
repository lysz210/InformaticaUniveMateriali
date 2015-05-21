
int squeeze(int n, int c){

	int i=1, ris=0;
	
	while(n>0){
		if(n%10 != c){
			ris += i*(n%10);
			i *=10;
	}
		n /=10;
	}
	
	return ris;
	
	
	


}

