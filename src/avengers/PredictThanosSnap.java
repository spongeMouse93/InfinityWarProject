package avengers;

import java.util.*;
import java.io.*;

public class PredictThanosSnap{
  public static void main(String[] args){
    if (args.length < 2){
      System.err.println("Execute: java PredictThanosSnap <INput file> <OUTput file>");
      return;
    }
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    try{
      sc = new Scanner(new File(args[0]), "UTF-8");
      sc.useLocale(Locale.US);
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
    long seed = sc.nextLong();
    Random r = new Random(seed);
    int d = sc.nextInt();
    int[][] adjacency = new int[d][d];
    for (int i = 0; i < d; i++)
      for (int j = 0; j < d; j++)
        adjacency[i][j] = sc.nextInt();
    Graph g = new Graph(d);
    for (int i = 0; i < d; i++)
      for (int j = 0; j < d; j++)
        if (i != j && adjacency[i][j] == 1)
          g.addEdge(i, j);
    for (int i = 0; i < d; i++)
      if (r.nextDouble() <= 0.5)
        g.removeVertex(i);
    out.println(g.isConnected());
    out.flush();
  }
}
