package MixOfAll;

import java.util.Scanner;

class Node {
    int data;
    Node next, prev;
    Node(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}


class DoublyLinkedList {
    Node head;
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }


    // Reverse function
    void reverse() {
        Node temp = null;
        Node current = head;

        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev; // move to the next node (which is prev now)
        }

        // After loop, temp is at the node before new head
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Utility to push at front
//void push(int data) {
  //      MixOfAll.Node newNode = new MixOfAll.Node(data);
    //    newNode.next = head;
      //  if (head != null) head.prev = newNode;
        //head = newNode;
   // }

    // Print MixOfAll.list
    void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ->");
            node = node.next;
        }
        System.out.println();
    }
}

// Usage
public class reversedll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            dll.insertEnd(val);
        }
        dll.reverse();
        dll.printList();
    }
}
