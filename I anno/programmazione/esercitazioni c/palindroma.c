
float palindroma(char a[], int dim){

	int i,j;

		for(i=0,j=dim-1;i<j;i++,j--){
			if(a[i] != a[j])
			return 0;
					
			}
	return 1;
}
