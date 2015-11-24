/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagationnet;

/**
 *
 * @author malepanda
 */
public class Edge {
    private float weight;
    private Node node1, node2;
    
    public Edge(Node node1, Node node2){
        this.node1=node1;
        this.node2=node2;
        this.weight=(float)Math.random() - (float)Math.random();
    }

    /**
     * @return the weight
     */
    public float getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * @return the node1
     */
    public Node getNode1() {
        return node1;
    }

    /**
     * @param node1 the node1 to set
     */
    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    /**
     * @return the node2
     */
    public Node getNode2() {
        return node2;
    }

    /**
     * @param node2 the node2 to set
     */
    public void setNode2(Node node2) {
        this.node2 = node2;
    }
}
