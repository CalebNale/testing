package com.company;
 // a simple program that tests the listfriends function
public class Main {

    public static void main(String[] args) {
	// write your code here
        NetworkAdjList net = new NetworkAdjList();
        net.createAdjacencyList();
        net.listFriends(4038);
    }
}
