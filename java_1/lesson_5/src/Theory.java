import java.util.*;

public class Theory {
    public void check () {

        ArrayList<Integer> numbers = new ArrayList<>();

        for(int i = 0; i<100; i++) {
            numbers.add(i);
        }
        numbers.get(15);
        numbers.remove(15);

        int[] array = new int[10];
        for (int i =0; i<10; i++) {
            array[i] = i;
        }
        for (Integer i: array) {
            System.out.print(i+"\t");
        }
        System.out.println();

        //99% ������ ��������, ������� ����� �������� �����������
        ArrayList<Integer> r = new ArrayList<>();

        //1% ������, ��������� �� �����, ������ �� ������� �������� ������ �� ���������� � ��������� ��������
        LinkedList<Integer> r1 = new LinkedList<>();

        //Set uses if need only unic element

        //��������� ���������� ���������, ���������� �� ���-��������
        HashSet<Integer> integerHashSet = new HashSet<>();
        integerHashSet.add(10);
        integerHashSet.add(4);
        integerHashSet.add(9);
        //for each in java
        for (Integer i: integerHashSet) {
            System.out.println(i);
        }
        System.out.println("HashSet");
        System.out.println(integerHashSet);

        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("asd");
        stringHashSet.add("asdgdfbcvb");
        stringHashSet.add("we3 32 dfs ");
        System.out.println(stringHashSet);

        //�����������
        LinkedHashSet<Integer> integerLinkedHashSet = new LinkedHashSet<>();
        integerLinkedHashSet.add(10);
        integerLinkedHashSet.add(4);
        integerLinkedHashSet.add(9);
        System.out.println("LinkedHashSet");
        System.out.println(integerLinkedHashSet);

        //��������� ���������� ���������, ��������������� �� ����������� ��� ��������
        TreeSet<Integer> integersTreeSet = new TreeSet<>();
        integersTreeSet.add(10);
        integersTreeSet.add(4);
        integersTreeSet.add(9);
        System.out.println("TreeSet");
        System.out.println(integersTreeSet);

        //Map ������ ����-������

        //���-�������, �������� ���� ����-��������
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("stas", 23);
        System.out.println(integerHashMap.get("stas"));
        System.out.println(integerHashMap);

        //�����������
        LinkedHashMap<String, Integer> integerLinkedHashMap = new LinkedHashMap<>();

        //������, �������� ���� ����-�������� � ��������������� �������
        TreeMap<String, Integer> integerTreeMap = new TreeMap<>();

        //������� � �����������, �������� �������� � ��������������� �������
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        System.out.println("priorityQueue");
        priorityQueue.add(10);
        System.out.println(priorityQueue);
        priorityQueue.offer(4);
        System.out.println(priorityQueue);
        priorityQueue.add(9);
        System.out.println(priorityQueue);
        priorityQueue.remove();
        System.out.println(priorityQueue);
        priorityQueue.offer(100);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());

    }
}
