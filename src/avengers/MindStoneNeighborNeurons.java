package avengers;

import java.util.*;
import java.io.*;

public class MindStoneNeighborNeurons{
  public static void main(String[] args){
    if (args.length != 2){
      System.err.println("Execute: java MindStoneNeighborNeurons <INput file> <OUTput file>");
      return;
    }
    Scanner sc = new Scanner(System.in);
    try{
      sc = new Scanner(new File(args[0]), "UTF-8");
    }catch (IOException e){
      System.err.println("Could not find input file.");
      return;
    }
    PrintWriter out = new PrintWriter(System.out);
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
    int numNeurons = sc.nextInt();
    String[] neurons = new String[numNeurons];
    for (int i = 0; i < numNeurons; i++)
      neurons[i] = sc.next();
    int numSynapses = sc.nextInt();
    String[] synapses1 = new String[numSynapses], synapses2 = new String[numSynapses];
    for (int i = 0; i < numSynapses; i++){
      synapses[i] = sc.next();
      synapses[i] = sc.next();
    }
    for (int i = 0; i < numSynapses; i++)
      if (synapses2[i].equals(neurons[neurons.length - 1])){
        out.println(synapses1[i]);
        out.flush();
      }
  }
}
