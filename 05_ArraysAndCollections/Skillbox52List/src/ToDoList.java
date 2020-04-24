import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    //homerwork done
    public static void main(String[] args) {
        ArrayList<String> toDoList = new ArrayList<>() {{
            add("Проснуться утром");
            add("Позавтракать");
            add("Посмотреть рабочую почту");
            add("Поехать на работу");
        }};
        System.out.println("Вот список ваших дел :");
        for (String item : toDoList) {
            System.out.println(item);
        }
        System.out.println("");

        System.out.println("Что хотите сделать с вашим списком ? ADD - добавить дело , DELETE - удалить дело , EDIT - заменить дело.");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (command.length() <= 0 ){
            System.out.println("Ошибка Ввода");
        }

        if (command.equals("ADD")) {
            System.out.println("Запишите новое дело");
            String add = scanner.nextLine();
            if (add.length() <= 0 ){
                System.out.println("Ошибка Ввода");
                return;
            }
            System.out.println("Укажите номер нового дела" + " " + toDoList.size());
            int addToIndex = scanner.nextInt();
            if(addToIndex > toDoList.size()){
                System.out.println("Вы вышли за пределы списка");
                return;
            }
            toDoList.add(addToIndex, add);
            for (String item1 : toDoList) {
                System.out.println(item1);
            }
        }if (command.equals("DELETE")){
            System.out.println("Введите номер дела который хотите удалить , от 0 до " + " " + toDoList.size());
            int indexOfList = scanner.nextInt();
            if (indexOfList > toDoList.size()){
                System.out.println("Вы вышли за пределы списка");
                return;
            }
            toDoList.remove(indexOfList);
            for (String item2 : toDoList){
                System.out.println(item2);
            }
        }
        if (command.equals("EDIT")){
            System.out.println("Запишите новое дело");
            String newList = scanner.nextLine();
            if (newList.length() <= 0 ){
                System.out.println("Ошибка Ввода");
                return;
            }
            System.out.println("Введите номер дела который хотите заменить , от 0 до " + " " + toDoList.size());
            int editIndex = scanner.nextInt();
            if (editIndex > toDoList.size()){
                System.out.println("Вы вышли за пределы списка");
                return;
            }
            toDoList.set(editIndex , newList);
            for (String item3 : toDoList){
                System.out.println(item3);
            }
        }
    }
}