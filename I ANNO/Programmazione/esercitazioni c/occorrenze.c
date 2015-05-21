
float occorrenze(int a[], int dim){

	int i,count, max;
	max =1;	
		for(i=0;i<dim;i++){
			count =1;
			while(a[i]==a[i+1]){
					count++;
					i++;
					}
			if(count > max)
					max =count;

		}
	return max;
}
