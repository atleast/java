package net.lastone.interview;

public class Node{
    private String name;
    private Node next;

    public Node(String name){
        this.name=name;
    }

    public Node reverseLink(Node head){
        Node result=null;
        Node tmp=null;
        if (head==null){
            return head;
        }
        tmp=head.next;
        while (tmp!=null){
            result=tmp;
            tmp=result.next;
        }
        return result;

    }

    public static void main(String [] args){

    }
}