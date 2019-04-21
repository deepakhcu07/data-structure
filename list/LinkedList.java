
public class LinkedList<E>{

  private Node<E> head;

  public LinkedList(){
    this.head = null;
  }

  public boolean isEmpty(){
    return head == null;
  }

  public void add(E data){
    if(head == null){
      head = new Node<E>(data,null);
      return;
    }
    Node<E> temp = new Node<>(data,head);
    head = temp;
  }

  public void addAt(E data, int position){
    if(head == null){
      head = new Node<E>(data,null);
      return;
    }
    int counter = 1;
    Node<E> temp = head;
    while(temp.next!=null && counter<position){

      temp = temp.next;
      counter++;
    }
    Node<E> newNode = new Node<E>(data,temp.next);
    temp.next = newNode;
  }

  public void remove(E data){
    if(head.data.equals(data)){
      Node temp = head;
      head = head.next;
      temp = null;
      return;
    }

    Node<E> previous = head;
    Node<E> current = head.next;

    while(current != null){
        if(current.data.equals(data)){
          break;
        }
        previous = current;
        current = current.next;
    }

    if(current!=null && current.data.equals(data)){
      previous.next = current.next;
      current = null;
    }
  }

  public void display(){
    Node<E> temp = head;
    while(temp!=null){
      System.out.println("\t" + temp.data);
      temp = temp.next;
    }
  }


  private class Node<E>{
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next){
      this.data = data;
      this.next = next;
    }
  }


  // Test Method
  public static void main(String []args){
    // Creating LinkedList
    LinkedList<String> list = new LinkedList<>();
    list.add("One");
    list.addAt("Two",2);
    list.addAt("Three",3);
    list.add("Zero");

    list.display();

    System.out.println("Deleting First Element");
    list.remove("Zero");
    list.display();


    System.out.println("Deleting Last Element");
    list.remove("Three");
    list.display();

  }
}
