import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import .jave.io.FileReader;
import java.io.FileWriter;

// Giao diện IProduct định nghĩa các phương thức để lấy thông tin của 1 sản phẩmphẩm
// ---------------------------------------------CÂU 1-------------------------------------------------
interface IProduct {
    String getName();
    String getDescription();
    float getPrice();

}
// Lớp Phone triển khai giao diện IProduct , đại diện cho sản phẩn điện thoại

class Phone implements IProduct {
    private String model ;
    private float screenSize;
    private float price;



    public Phone(String model ,float screenSize , float pice){
        this.model = model;
        this.screenSize = screenSize;
        this.price = price;
    }

    @Override
    public String getName(){
        return model;
    }
    @Override
    public String getDescription(){
        return "Phone with" + screenSize + "inches screen";
    }
    @Override
    public float getPrice(){
        return price;
    }

}
// Lớp Computer triển khai giao diện IProduct , đại diện cho sản phẩm máy tính
class Computer implements IProduct{
    private String model;
    private String Resolution ;
    private float price;
    
    public Computer(String model , String screenResolution,float price){
        this.model = model;
        this.sceenResolution = screenResolution;
        this.price = price ;

    }
    @Override
    public String getName(){
        return model;
    }
    @Override
    public String getDescription(){
        return "Computer with" + screenResolution + "resolution";
    }
    @Override 
    public float getPrice(){
        return price;
    }

}
public class CAU1{
    public static void main(String[] args){
        IProduct phone = new Phone("IPhone 16",6.9f,999.99f);
        IProduct Computer = new computer("Dell XP500", "1920x1080", 1299.99f); 

        System.out.print("Phone information:");
        System.out.print("Name: " + phone.getName());
        System.out.print("Description: " + phone.getDescription());
        System.out.print("Price: " + phone.getPrice() + "USD");

        System.out.print("Computer information:");
        System.out.print("Name: " + computer.getName());
        System.out.print("Description: " + computer.getDescription());
        System.out.print("Price: " + computer.getPrice() + "USD");



    }
}
// ========================================CÂU 2========================================================
import java.io.*;

public class CAU2 {
    public static void main(Sting[] args){
        try (FileWriter writer = new FileWriter("text.txt") ){
            writer.write("Kết nối tri thức\n");
            writer.write("Đại học kinh tế quốc dân\n");
            writer.write("Vững bước tương lai\n");
            System.out.println("Ghi file thành công");
        }catch(IOException e){
            System.out.println("Lỗi ghi file: " + e.getMessage());

        }
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))){
            String line;
            while ((line = reader.readline()) !=null){
                System.out.println(line);
                lineCount++;

            }catch (IOException e){
                System.out.println("Lỗi đọc file: " + e.getMessage());
            }
        }
        System.out.println("Số dòng trong file: " + lineCount);

        }
    }
// =========================================CÂU 3========================================================

public class CAU3 {
    public static void main(String[] args){
    //     Tạo luông để in các số nguyên tăng dần từ 1 đến 1000
        Thread tangdan = new Thread(() -> {
            for (int i = 1 ; i<=1000 ; i++){
                System.out.print(i + " ");
            }
        });
        // Tạo luông để in các số nguyên giảm dần từ 1000 đến 1
        Thread giamdan = new Thread(() -> {
            for (int i = 1000 ; i=>1 ;i--){
                System.out.print(i + " ");
            }
        });

        tangdan.start();
        giamdan.start();



    }
}
// ========================================CÂU 4========================================================
// Chương trình đảo ngược một mảng sử dụng phương thức tông quát (Genneric method)
public class CAU4 {
    public static <T> void reverseArray(T[] array) {
        int start = 0;
        int end = array.length -1;
        while (start < end) {
            T temp = array[start];
            array[stat] = array[end];
            array[end] = temp;
            start++;
            end--;

        }
    }
    // Phương thức tổng quát để in ra các phần tử trong một mảng
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integerArray = {1,2,3,4,5};
        System.out.println("Mảng nguyên trước khi đảo ngược:");
        printArray(integerArray);
        reverseArray(integerArray);
        System.out.println("Mảng nguyên sau khi đảo ngược:");
        printArray(integerArray); 

        String[] stringArray = {"Hello", "World", "Java"};
        System.out.println("Mảng chuỗi trước khi đảo ngược:");
        printArray(stringArray);
        reverseArray(stringArray);
        System.out.println("Mảng chuỗi sau khi đảo ngược:");
        printArray(stringArray);
    }

}
// ========================================CÂU 5========================================================
import java.util.*;
import java.util.stream.*;

// Chương trình tính tổng quát các số lẻ tong danh sách số nguyên sử dụng tham chiếu phương thức và Stream API
public class CAU5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream()
                .filter(n -> n % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Tổng các số lẻ trong danh sách: " + sum);
    }
}
