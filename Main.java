
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(printBinary(0.25));
		
		int num=8;
		System.out.println(getPrev(num));
		System.out.println(getNext(num));

	}
	
	public static int getNext(int num){//a little bit bigger
		//01111000 count 0s first, then 1s
		int c=num;
		int c0=0,c1=0;
		while((c&1)==0 && c!=0){
			c0++;
			c>>=1;
		}
		
		while((c&1)==1){
			c1++;
			c>>=1;
		}
		if((c0+c1)==0 || (c0+c1)==31)return -1;//the 32th is for sign
		
		int p=c0+c1;
		//put 1 at position p
		//11111000
		num=num|(1<<p);
		//clear c0+c1 at the rightmost
		//10000000
		num=num & (~((1<<p)-1));
		//put c1-1 1s at the rightmost
		//10000111
		num=num|((1<<(c1-1))-1);
		return num;
		
	}
	
	public static int getPrev(int num){//a little bit smaller, change 1 to 0
		
		int c=num;
		int c0=0,c1=0;
		//count 1s first, then 0s
		//10001111
		while((c&1)==1){
			c1++;
			c>>=1;
		}
		if(c==0)return -1;
		while((c&1)==0 && c!=0){
			c0++;
			c>>=1;
		}
		int p=c0+c1;
		
		//change 1 to 0 at position p
		//00001111
		num=num&(~(1<<p));
		
		//set all co+c1 to 1
		//01111111
		num=num|((1<<p)-1);
		//set c0-1 0s at the rightmost
		//01111100
		num=num&(~((1<<(c0-1))-1));
		return num;
	}

}
