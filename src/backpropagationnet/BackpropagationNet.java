/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagationnet;

import backpropagationnet.Edge;
/**
 *
 * @author Muhammad Fakhrian Noor
 */
public class BackpropagationNet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[][] dataset = getDataset(); 
        int n = dataset.length;
        int epoch = 100000;
        
        Node[] inputNode = new Node[5];
        for(int i=0; i<5; i++)
            inputNode[i] = new Node();
        
        Node[] hiddenNode = new Node[2];
        for(int i=0; i<2; i++)
            hiddenNode[i] = new Node();
        
        Node[] outputNode  = new Node[2];
        for(int i=0; i<2; i++)
            outputNode[i] = new Node();
        

        
        for (int j=0; j<epoch; j++){
            for (int i=0; i<n; i++){
                for(int k=0; k<5; k++){
                    if (j==0){
                        Edge[] edge1 = new Edge[2];
                        edge1[0] = new Edge(inputNode[k], hiddenNode[0]);
                        edge1[1] = new Edge(inputNode[k], hiddenNode[1]);
                        inputNode[k].setNextNode(edge1);
                    }
                    if (k==4)
                        inputNode[k].setValue(1);
                    else
                        inputNode[k].setValue(dataset[i][k]);    
                }
                
                for (int k=0; k<2; k++){
                    if (j==0){
                        Edge[] edge1 = new Edge[5];
                        Edge[] edge2 = new Edge[2];                    
                        edge1[0] = new Edge(inputNode[0], hiddenNode[k]);
                        edge1[1] = new Edge(inputNode[1], hiddenNode[k]);
                        edge1[2] = new Edge(inputNode[2], hiddenNode[k]);
                        edge1[3] = new Edge(inputNode[3], hiddenNode[k]);
                        edge1[4] = new Edge(inputNode[4], hiddenNode[k]);
                        hiddenNode[k].setPervNode(edge1);                   
                        edge2[0] = new Edge(hiddenNode[k], outputNode[0]);
                        edge2[1] = new Edge(hiddenNode[k], outputNode[1]);
                        hiddenNode[k].setNextNode(edge2);
                    }
                    hiddenNode[k].calculateValue();
                }
                
                for (int k=0; k<2; k++){
                    if (j==0){
                        Edge[] edge1 = new Edge[2];
                        Edge[] edge2 = new Edge[2];                    
                        edge1[0] = new Edge(hiddenNode[0], outputNode[k]);
                        edge1[1] = new Edge(hiddenNode[1], outputNode[k]);
                        outputNode[k].setPervNode(edge1);
                    }
                    outputNode[k].setT(dataset[i][4+k]);
                    outputNode[k].calculateValue();
                    outputNode[k].calculateErrorK();
                }
                
                for (int k=0; k<2; k++){
                    hiddenNode[k].calculateErrorH();
                }
                
                for (int k=0; k<2; k++){
                    hiddenNode[k].updateWeight();
//                    System.out.println("wh"+(k+1)+"1: "+hiddenNode[k].getNextNode()[0].getWeight() + " | wh"+(k+1)+"2: "+hiddenNode[k].getNextNode()[1].getWeight());
                }
                
                for (int k=0; k<4; k++){
                    inputNode[k].updateWeight();
//                    System.out.println("w"+(k+1)+"1: "+inputNode[k].getNextNode()[0].getWeight() + " | w"+(k+1)+"2: "+inputNode[k].getNextNode()[1].getWeight()
//                     + " | w"+(k+1)+"3: "+inputNode[k].getNextNode()[1].getWeight() + " | w"+(k+1)+"4: "+inputNode[k].getNextNode()[1].getWeight());
                }
            }
        }
        
        for (int k=0; k<4; k++){
                    System.out.println("w"+(k+1)+"1: "+inputNode[k].getNextNode()[0].getWeight() + " | w"+(k+1)+"2: "+inputNode[k].getNextNode()[1].getWeight()
                     + " | w"+(k+1)+"3: "+inputNode[k].getNextNode()[1].getWeight() + " | w"+(k+1)+"4: "+inputNode[k].getNextNode()[1].getWeight());
        }
        for (int k=0; k<2; k++){
                    System.out.println("wh"+(k+1)+"1: "+hiddenNode[k].getNextNode()[0].getWeight() + " | wh"+(k+1)+"2: "+hiddenNode[k].getNextNode()[1].getWeight());
                }
    }
    
    public static float[][] getDataset(){
        float[][] dataset = { {1, 1, 1, 1, 1, 0},
                              {1, 1, 1, 2, 1, 0},
                              {2, 1, 1, 1, 0, 1},
                              {3, 2, 1, 1, 0, 1},
                              {3, 3, 2, 1, 0, 1},
                              {3, 3, 2, 2, 1, 0},
                              {2, 3, 2, 2, 0, 1},
                              {1, 2, 1, 1, 1, 0},
                              {1, 3, 2, 1, 0, 1},
                              {3, 2, 2, 1, 0, 1},
                              {1, 2, 2, 2, 0, 1},
                              {2, 2, 1, 2, 0, 1},
                              {2, 1, 2, 1, 0, 1},
                              {3, 2, 1, 2, 1, 0},
                            };
        
        return dataset;
    }
    
}
