public class Main {

    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        System.out.println(myLinkedList);

        myLinkedList.add(2, 2);
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(1));

    }

}