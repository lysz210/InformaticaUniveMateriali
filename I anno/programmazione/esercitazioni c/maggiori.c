
int maggiori(float a[], int dim, float k){

	int i,count;
	count =0;
	for(i=0;i<dim;i++)
		if(a[i] > k)
			count ++;
	
	return count;


}
