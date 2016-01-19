import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {
	
	static ArrayList<String> ar1 = new ArrayList<String>();
	static int l,k,g,z,q,v;

	public static void main(String[] args) throws Exception{
	
	//Read file
	//File filetest1 = new File("C:\\Users\\Oguz's pc\\Desktop\\problem1_test_cases\\test1.dat");
	File filetest1 = new File(args[0]);
	Scanner inputtest1 = new Scanner(filetest1);
	
	while(inputtest1.hasNext()){

		String test1 = inputtest1.next();
		ar1.add(test1);

	}
	//Close file
	inputtest1.close();
	
	int n,m,x;
	//Obtain matrix sizes
	n = Integer.parseInt(ar1.get(0));
	m = Integer.parseInt(ar1.get(1));
	String arraytest1 [][]=new String[n][m];
	x=2;
	
	//Create n*m matrix
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
			
			arraytest1[i][j]= ar1.get(x);
			x++;
			
		}

	}
	
	//Assign smallest number for calculate maximum coin
	for(int a=0;a<n;a++){		
		for(int b=0;b<m;b++){		
			if( arraytest1[a][b].compareTo("X") == 0){
				arraytest1[a][b] = "-99";				
			}				
	    }
	}
	
	int arraytotal[][] = new int[n][m];
	
	//Collect coins one by one from arraytest1[0][0] to arraytest1[0][m-1]
	l = Integer.parseInt(arraytest1[0][0]);
	
	for(int b=0;b<m;b++){
		
		if(b+1<m){
		q = Integer.parseInt(arraytest1[0][b+1]);
		}
		
		if(l<0){
			arraytotal[0][b]=-99;
			break;
			
		}
		
		arraytotal[0][b] = l;		
		l = l+q;			

    }
	
	//Collect coins one by one from arraytest1[0][0] to arraytest1[n-1][0]
	g = Integer.parseInt(arraytest1[0][0]);
	for(int a=0;a<n;a++){
		
		if(a+1<n){		
		k = Integer.parseInt(arraytest1[a+1][0]);
		}
		
		if(g<0){
			arraytotal[a][0]=-99;
			break;
		}		
		arraytotal[a][0] = g;
		
		g = g + k;
	}
	
	//Collect coins one by one from arraytest1[1][1] to arraytest1[n-1][m-1]
	//Find most coin at arraytest1[n-1][m-1]
	for(int b=1;b<m;b++){
			for(int a=1;a<n;a++){
			v = Integer.parseInt(arraytest1[a][b]);
			arraytotal[a][b] =Math.max(arraytotal[a][b-1], arraytotal[a-1][b])+v;

	    }
	}
		
		System.out.println("Maximum total number of coin : "+arraytotal[n-1][m-1]);

		int c = n-1;
		int d = m-1;
		int f ;
		
		
		//Find path by begin to look last element
		while(c>=1 && d>=1){
			
		arraytest1[0][0] = "P";
		arraytest1[n-1][m-1] = "P";
			if(arraytotal[c][d-1]>arraytotal[c-1][d]){
				
				arraytotal[c][d] =Math.max(arraytotal[c][d-1], arraytotal[c-1][d]);
				arraytest1[c][d-1] = "P";
				d--;
			}
			
			
			else if(arraytotal[c][d-1]<arraytotal[c-1][d]){
			
				f =Math.max(arraytotal[c][d-1], arraytotal[c-1][d]);
				arraytest1[c-1][d] = "P";
				c--;
				
			}
			else if(arraytotal[c][d-1]==arraytotal[c-1][d]){
				
				f =Math.max(arraytotal[c][d-1], arraytotal[c-1][d]);
				arraytest1[c-1][d] = "P";
				c--;

			}
			
			if(c==0){
				while(d!=0){
					arraytest1[c][d-1] = "P";	
					d--;
				}
					
			}
			if(d==0){
				while(c!=0){
					arraytest1[c-1][d] = "P";	
					c--;
				}
				
			}
			
		}

		for(int a=0;a<n;a++){
			
			for(int b=0;b<m;b++){
				if(arraytest1[a][b] == "-99"){
					arraytest1[a][b] = "X";
				}
			System.out.print(arraytest1[a][b]+"  ");
	    }
			System.out.print("\n");
		}
	}
			
	

}
