package sorting;

public class insertionSort {
public static void main(String[] args) {
	
	int a[]= {2,5,32,12,3,17,20,7,15,28};
	for(int j=1;j<a.length;j++) {
		int key=a[j];
		int i=j-1;
		while(i>=0 && a[i]>key) {
			a[i+1]=a[i];
			i=i-1;;
		}
		a[i+1]=key;
	}			
for(int k=0;k<a.length;k++) {
	System.out.println(a[k]);
}
}
}
