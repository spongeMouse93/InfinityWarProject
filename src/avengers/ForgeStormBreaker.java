package avengers;

import java.util.*;
import java.io.*;

public class ForgeStormBreaker{
  public static void main(String[] args){
    if (args.length < 2){
      System.out.println("Execute: java ForgeStormBreaker <INput file> <OUTput file>");
      return;
    }
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    try{
      sc = new Scanner(new File(args[0]), "UTF-8");
    }catch (IOException e){
      e.printStackTrace();
    }
    try{
      out = new PrintWriter(new FileOutputStream(new File(args[1])), true);
    }catch (IOException e){
      try{
        File f = new File(args[1]);
        f.createNewFile();
        out = new PrintWriter(new FileOutputStream(f), true);
      }catch (IOException e2){
        e2.printStackTrace();
      }
    }
    int flux = 0, r = sc.nextInt(), c = sc.nextInt();
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        flux += sc.nextInt();
    out.println(flux);
    out.flush();
  }
}
