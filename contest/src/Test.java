import java.util.LinkedList;

public class Test {


    public static void main(String[] args) {
        new Test().testLinkedList();
    }

    public void testLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0);
        list.remove(6);
        System.out.println(list);
    }
}
