package avengers;

import java.util.*;
import java.io.*;

public class LocateTitan{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    if (args.length != 2){
      System.out.println("Execute: java LocateTitan <INput file> <OUTput file>");
      return;
    }
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
    int numGenerators = sc.nextInt();
    int[] generators = new int[numGenerators];
    double[] functionalities = new double[numGenerators];
    for (int i = 0; i < numGenerators; i++){
      generators[i] = sc.nextInt();
      functionalities[i] = sc.nextDouble();
    }
    int[][] adjancency = new int[numGenerators][numGenerators];
    for (int i = 0; i < numGenerators; i++)
      for (int j = 0; j < numGenerators; j++)
        adjacency[i][j] = sc.nextInt();
    for (int i = 0; i < numGenerators; i++)
      for (int j = 0; j < numGenerators; j++){
        int energyCost = adjancency[i][j];
        double funs = functionalities[i] * functionalities[j], x = energyCost / funs;
        adjacency[i][j] = (int) x;
      }
    int[] dist = new int[numGenerators];
    boolean[] djikstra = new boolean[numGenerators];
    for (int i = 0; i < numGenerators; i++){
      dist[i] = Integer.MAX_VALUE;
      djikstra[i] = false;
    }
    dist[0] = 0;
    for (int i = 0; i < numGenerators - 1; i++){
      int u = minCost(dist, djikstra);
      djikstra[u] = true;
      for (int j = 0; j < numGenerators; j++)
        if (!djikstra[j] && adjancency[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + adjancency[u][j] < dist[j])
          dist[j] = dist[u] + adjancency[u][j];
    }
    out.println(dist[dist.length - 1]);
    out.flush();
  }
  private static int minCost(int[] dist, boolean[] djikstra){
    int minI = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < dist.length; i++)
      if (!djikstra[i] && dist[i] <= min){
        min = Math.min(min, dist[i]);
        minI = i;
      }
    return minI;
  }
}
