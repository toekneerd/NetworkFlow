/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networkflow;

/**
 *
 * @author Tony
 */
public class NetworkFlow {

    /**
     * @param args the command line arguments
     */
    	//==============================================================
	// Ford-Fulkerson Algorithm
	//==============================================================
	// <Anthony DeCarlo>
	// <COSC 336.001>
	// <05/10/2016>
	//--------------------------------------------------------------

    public static void main(String[] args) {
        // TODO code application logic here
        int graph[][] = new int[][]{{0,0,6,0,0,0 },
                                    {10,0,2,0,2,0},
                                    {4,0,0,0,5,0 },
                                    {0,4,0,0,0,6 },
                                    {0,6,4,6,0,0 },
                                    {0,0,0,4,10,0} };
        FordFulkerson FF = new FordFulkerson();
        System.out.println("Max flow is: "+ FF.Ford_Fulkerson(graph, 0, 5) );
    }
    
    
    
}
