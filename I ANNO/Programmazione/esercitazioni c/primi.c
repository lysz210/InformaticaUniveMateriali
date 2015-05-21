int primi(int n){

	int primes[n+1];
	int i,j, count;
	count =0;

	for(i=2;i<=n;i++)
		primes[i]=1;
	i=2;
	while(i*i < n){
		for(j=i+2;j<=n;j++){
			if((j % i) == 0){
			primes[j]=0;}
		}
	i++;
	}

	for(i=2;i<=n;i++)
		count = count + primes[i];
		
	return count;
	
	}
	

