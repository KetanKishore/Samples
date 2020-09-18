package sorting;

public class quicksort {
public int Partition(int[] arr,int p,int r) {
	int x=arr[r];
	int i=p-1;
	for(int j=p;j<r-1;j++) {
		if(x>=arr[j]) {
			i=i+1;
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
	}
		int temp1=arr[i+1];
		arr[i+1]=arr[r];
		arr[r]=temp1;
		return i+1;
	
}
public void sort(int[] arr,int p,int r) {
	if(p<r) {
	int q=Partition(arr,p,r);
	sort(arr,p,q-1);
	sort(arr,q+1,r);	
	}
}
public static void main(String args[]) {
	int arr[] ={21,4,8,34,5,56,2,86,50,43};
	quicksort a=new quicksort();
	a.sort(arr, 0, 9);
	for(int j=0;j<10;j++) {
	System.out.println(arr[j]);
	}
}
}
