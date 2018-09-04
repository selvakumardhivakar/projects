import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {
	    
static String electionWinner(String[] votes) 
{
	Arrays.sort(votes);
	String[] candidate=new String[votes.length];
	int max,index=0,i,j=0,count=1,k=0;
	for (i=0;i<votes.length-1;i++)
	{
		if(!(votes[i].equalsIgnoreCase(votes[i+1])))
		{
			candidate[j++]=votes[i];
		}
	}

	candidate[j++]=votes[votes.length-1];
	for(i=0;i<votes.length;i++)
	{
		if(candidate[i] != null)
			k+=1;
	}
	int[] noofvotes=new int[k];
	j=0;
	for(i=0;i<votes.length-1;i++){
		if(votes[i].equalsIgnoreCase(votes[i+1]))
		{
			count=count+1;
}		else
		{
			noofvotes[j]=count;
			count=1;
			j=j+1;
		}
	}
	noofvotes[k-1]=count;
	max = noofvotes[0];
        for(i = 0; i < k; i++)
        {
            if(max <= noofvotes[i]){
                max = noofvotes[i];
                index=i;
            }

        }
	return (candidate[index].toUpperCase());
}

public static void main(String[] args) throws IOException {
	Scanner s=new Scanner(System.in);
        int votesCount = s.nextInt();
        s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] votes = new String[votesCount];

        for (int i = 0; i < votesCount; i++) {
            String votesItem = s.nextLine();
            votes[i] = votesItem;
        }

        String res=electionWinner(votes);
        System.out.println("WINNER OF THIS ELECTION IS");
        System.out.println(" * * *  "+res+" * * * ");
        System.out.println("CONGRATULATIONS");
        s.close();
    }
}
