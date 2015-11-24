/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagationnet;


/**
 *
 * @author Muhammad Fakhrian Noor
 */
public class Node {
    private float value, error;
    private Edge[] pervNode, nextNode;
    private float t;
    private final float LEARNING_RATE = 0.1f;
    
    
    public void calculateValue(){
        int n=this.getPervNode().length;
        float res = 0;
        
        for (int i=0; i<n; i++){
            res = res + (this.getPervNode()[i].getNode1().getValue() * this.getPervNode()[i].getWeight());
        }
        
        this.value = res;
    }
    
    public void calculateErrorK(){
        this.error= this.value*(1-this.value) * (getT()-this.value);
    }
    
    public void calculateErrorH(){
        int n=this.getNextNode().length;
        float sig = 0;
        
        for (int i=0; i<n; i++){
            sig = sig + (this.getNextNode()[i].getNode1().getError() * this.getNextNode()[i].getWeight());
        }
        
        this.error= this.value*(1-this.value) * sig;
    }
    
    public void updateWeight(){
        int n=this.getNextNode().length;
        
        for(int i=0; i<n; i++){
            this.getNextNode()[i].setWeight(this.getNextNode()[i].getWeight() + LEARNING_RATE * this.value * this.getNextNode()[i].getNode2().error);
        } 
    }
    /**
     * @return the value
     */
    public float getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(float value) {
        this.value = value;
    }

    /**
     * @return the error
     */
    public float getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(float error) {
        this.error = error;
    }

    /**
     * @return the nextNode
     */
    public Edge[] getNextNode() {
        return nextNode;
    }

    /**
     * @param nextNode the nextNode to set
     */
    public void setNextNode(Edge[] nextNode) {
        this.nextNode=nextNode;
    }

    /**
     * @return the pervNode
     */
    public Edge[] getPervNode() {
        return pervNode;
    }

    /**
     * @param pervNode the pervNode to set
     */
    public void setPervNode(Edge[] pervNode) {
        this.pervNode = pervNode;
    }

    /**
     * @return the t
     */
    public float getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(float t) {
        this.t = t;
    }

}
