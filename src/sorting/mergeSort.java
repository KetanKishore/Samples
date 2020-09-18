package sorting;

public class mergeSort {
public void merge(int[] arr,int p,int q,int r) {
	int n1=q-p+1;
	int n2=r-q;
	int[] L=new int[n1+1];
	int[] M=new int[n2+1];
	for(int i=0;i<n1;i++)
		L[i]=arr[p+i];
	for(int j=0;j<n2;j++)
		M[j]=arr[q+j+1];
	L[n1]=1000;
	M[n2]=1000;
	int x=0,y=0;
	for(int k=p;k<=r && x<=n1 && y<=n2;k++) {
		if(L[x]<=M[y]) {
			arr[k]=L[x];
			x++;
		}
		else {
			arr[k]=M[y];
			y++;
		}
	}
}
	 void sort(int arr[], int l, int r) 
	    { 
	        if (l < r) 
	        { 
	            int m = (l+r)/2; 
	            sort(arr, l, m); 
	            sort(arr , m+1, r); 
	            merge(arr, l, m, r); 
	        } 
	    } 

public static void main(String[] args) {
	int[] arr= {9,8,7,6,5,4,3,2,1,0};
mergeSort ms=new mergeSort();
ms.sort(arr, 0, 9);
for(int i=0;i<arr.length;i++) {
	System.out.println(arr[i]);
}
}
}
