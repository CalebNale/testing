package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
 /*
 // a basic network adjacency list, implements is friends and list friends
  */
public class NetworkAdjList {
    private static int max_num_vertices = 301; // number of vertices in the file
    private static Node[] adjacencyList;

    public static void createAdjacencyList() { // creates the data for that would have been from the file, because I had trouble reading from it.
        adjacencyList = new Node[5];

        adjacencyList[0] = new Node(4038, new Node(4014)); // creates the first  we will check
        adjacencyList[1] = new Node(4014, new Node(4037)); // creates the second we will check
        adjacencyList[2] = new Node(4030, new Node(4017)); // creates the third we  will check
        adjacencyList[3] = new Node(4003, new Node(3980)); // creates the fourth we will check
        adjacencyList[4] = new Node(1, new Node(3980)); // creates the fourth we will check

    }

    public static boolean areFriends(int A, int B) {
        for (int i = 0; i < 5; i++) {
            if (adjacencyList[i].getName() == A && adjacencyList[i].getNext().getName() == B) { // because it is undirected, we only have to search one way
                return true;
            } else {
            }
        }
        return false;
    }

    public static void listFriends(int A) { // lists the friends that this user has
        Queue<Node> theque = new LinkedList<Node>(); // create the queue
        for (int i = 0; i < 5; i++) { // go through every node
            if (adjacencyList[i].getName() == A) { // for every instance of the node
                theque.add(adjacencyList[i]); // add the node to the list
                adjacencyList[i].visited = true; // we visited this node
                int x = 0;// the distance, starts at 0 for the initial self.
                while (!theque.isEmpty()) { // while there is something in the queue
                    Node e = theque.remove(); // pop off the element
                    System.out.println(e.getName() + " is a friend at distance " + x);
                    e.visited = true;
                    x++;
                    if(e.getNext()!=null) { // if we have anext
                        if (e.getNext().visited == false) { // if we havent visited it
                            theque.add(e.getNext()); // add that friend to the queue
                            e.getNext().visited=true; // say that we visited it
                        }// if
                    }// if
                }// while
            }// if


        }// for
    }// listfriends
}