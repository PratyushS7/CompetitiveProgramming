/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class test
{
	public static void main(String[] args) throws Exception {
        // your code goes here
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            int counter=1;
            while (t > 0) {
                int n = Integer.parseInt(br.readLine());
                int prevCarSpeed = Integer.parseInt(br.readLine());
                for (int i = 1; i < n; i++) {
                    int currentCarSpeed = Integer.parseInt(br.readLine());
                    if (prevCarSpeed >= currentCarSpeed)
                    {
                        counter = counter + 1;
                        prevCarSpeed = currentCarSpeed;
                    }
                    else if (prevCarSpeed < currentCarSpeed)
                    {
                        int diff = currentCarSpeed - prevCarSpeed;
                        currentCarSpeed = currentCarSpeed - diff;
                    }
                }
                System.out.println(counter);
                counter=1;
                t = t - 1;
            }
            //br.close();
        } catch (Exception e) {
            return;
        }

    }

}


