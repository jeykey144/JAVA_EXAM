import java.io.*;
import java.util.*;

import static java.lang.Thread.sleep;

public class STT6_HoangLong_1 {
    public static void main(String[] args) throws IOException {
        System.out.println("==========Câu 1===========================================");
       // cau1();
        System.out.println("==========Câu 2===========================================");
        //cau2();
        System.out.println("==========Câu 3===========================================");
        //cau3();
        System.out.println("==========Câu 4===========================================");
        cau4();
        System.out.println("==========Câu 5===========================================");
       // cau5();
    }
//---------------------------cau 1-----------------------------
    interface IShape{
        public void showInfo();//Khai báo hàm showInfo để hiển thị thông tin ra màn hình
        float getArea();//Khai báo hàm tính diện tích
        float getPerimeter();//khai báo hàm tính chu vi
        final double PI = 3.1416;//khai báo hằng số Pi
    }

    public static class Circle implements IShape{
        private float radius;//Khai báo biến radius để nhận giá trị từ bàn phím

        public float getRadius() {//hàm trả về giá trị tính bán kính của hình tròn
            return radius;//giá trị trả về là thuộc tính radius
        }
        public void setRadius(float radius) {//hàm dán giá trị cho bán kính
            this.radius = radius;//dán giá trị
        }

        @Override
        public void showInfo() {
            System.out.println("Hinh tron co dien tich: "+ getArea());//hiển thị giá trị diện tích ra màn hình
            System.out.println("Hinh tron co chu vi: "+ getPerimeter());//hiển thị giá trị chu vi ra màn hình
        }

        @Override
        public float getArea() {
            return (float) (radius*radius*PI);//trả về giá trị của diện tích hình tròn
        }

        @Override
        public float getPerimeter() {
            return (float) (2*radius*PI);//trả về giá trị của chu vi hình tròn
        }

        public Circle(float radius) {//hàm tạo
            this.radius = radius;//dán giá trị vào biến radius
        }
    }

    public static class Rectangle implements IShape{
        public double witdh;//khai báo thuộc tính chiều rộng
        public double length;//khai báo thuocj tính chiều dài

        @Override
        public void showInfo() {
            System.out.println("Hinh chu nhat co dien tich: "+ getArea());//hiển thị giá trị diện tích ra màn hình
            System.out.println("Hinh chu nhat co chu vi: "+ getPerimeter());//hiển thị giá trị chu vi ra màn hình
        }

        @Override
        public float getArea() {
            return (float) (witdh*length);//hàm trả về giá trị tính diện tích
        }

        @Override
        public float getPerimeter() {
            return (float) (witdh+witdh+length+length);//hàm trả về giá trị tính chu vi
        }

        public Rectangle(double witdh, double length) {//hàm tạo
            this.witdh = witdh;//dán giá trị vào biến chiều dài
            this.length = length;//dán giá trị vào biến chiều rộng
        }
    }

    public static void cau1(){
            IShape C= new Circle(25.5F);//khai báo đối tượng C và khỏi tạo giá trị dùng hàm tạo
            IShape R= new Rectangle(5,12);//khai báo đối tượng R và khỏi tạo giá trị dùng hàm tạo
            C.showInfo();//gọi hàm showInfo để hiển thị thông tin ra màn hình
            R.showInfo();//gọi hàm showInfo để hiển thị thông tin ra màn hình
    }

//----------------------------------cau2--------------------------------
    public static void cau2() throws IOException {
        try{
            Scanner s= new Scanner(System.in);//Sử dụng đối tuong scanner để nhập dữliệu từ bàn phím
            int n;//khai báo biến n là số lượng của phần tử trong mảng
            System.out.println("Nhap số phàn tử trong mang: ");//hiển thị thông báo nhập só lượng phần tử
            n = s.nextInt();//Nhập só nguyên vào cho biến n bằng hàm nextInt()
            double A[] = new double[n];//Khai báo mảng n só nguyên
            for (int i=0; i <n; i++){//tạo vòng lặp for để nhập giá trị các phàn tử
                System.out.println("Nhap phan tu thu "+ i +" : ");//hiển thị thông báo nhập giá trị các phân tử
                A[i]= s.nextDouble();//Nhập số nguyên từ vào cho các giá trị trong mảng bằng hàm nextInt()
            }

            double tong= 0;//khai báo biến tính tổng
            for (int i=0; i <n; i++){//vòng lặp để tính tổng
                tong= tong+A[i];//tính tổng, cộng lần lượt các giá trị vào tổng
            }

            if (tong>20) throw new Exception("Tong lon hon 20");//tạo lỗi tong lớn hơn 20
            System.out.println("tong: "+ tong);//hiển thị ra màn hình gia trị của tổng
        }catch (NegativeArraySizeException EX1){//bắt lỗi số âm
            System.out.println("Số lượng phần tử không duoc là so âm");//hiển thị thông báo lôi số âm
        } catch (InputMismatchException e){//bắt lôi sai kiểu dữ liệu
            System.out.println("Loi ki tu vua nhap khong thuoc kieu int");//hiển thị thông báo sai kiểu dữ liệu
        }catch (Exception e){//bắt các lỗi khác
            System.out.println("Loi: "+ e.getMessage());//hiển thị thông báo các lỗi khác
        }

    }

    //----------------------------------------cau3-----------------------------------------
    public static void cau3() throws IOException {
        FileOutputStream o= new FileOutputStream("./int.txt");//khai bao biến thuộc FileOutputStream
        FileInputStream i= new FileInputStream("./int.txt");// khai báo biến thuộc  FileInputStream
        DataOutputStream o1= new DataOutputStream(o);//khai báo biến thuộc DataOutputStream
        DataInputStream i1= new DataInputStream(i);//khai báo biến thuộc DataInputStream
        int a= 2;// khai báo biến a và dán giá trị bằng 2
        int b= 5;// khai báo biến b và dán giá trị bằng 5
        o1.write(a);//ghi biến a vào file int.txt
        o1.write(b);//ghi biến b vào file int.txt
        o.close();// đóng file int

        int c,d; //khai báo 2 biến c, d
        c= i1.read();//dán giá trị cho biến c lấy từ file int
        d= i1.read();//dán giá trị cho biến d lấy từ file int
        System.out.println("Tong 2 so:" + (c+d));// hiển thị tổng 2 biến c, d ra màn hình
        i.close();// đóng file int
    }

    //------------------------------------------cau4------------------------------
    public static void cau4(){
        Thread t1 = new Thread(new Runnable() {//khai báo t1 là thread thứ nhất
            @Override
            public void run() {
                while (true){//vòng lặp vô hạn
                    Random r = new Random(10);//khai báo biến r là biến ngau nhiên
                    System.out.println(r.nextInt());//hiển thị ra màn hình số nguyên ngẫu nhiên
                    try {
                        sleep(15000);//thời gian chờ là 15giay
                    } catch (InterruptedException e) {//xử lí ngoại lệ của hàm sleep()
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {//khai báo t2 là thread thứ hai chạy song song với thread thứ nhất
            @Override
            public void run() {
                while (true){// vofg lặp vo hạn
                    long tong = 0;//khai báo biến tính tổng
                    for (int i= 1; i<=1000000000; i++){//vòng lặp số nguyên từ 1 đến 1 tỉ
                        tong = (long) (tong+ i);//tính tổng, cổng lần lượt các giá trị
                    }

                    System.out.println("Tong: "+ tong);//hiển thị ra màn hình giá trị của biến tổng
                }
            }
        });
        t1.start();//gọi hàm start để chạy t1
        t2.start();//gọi hàm start để chạy t1
    }

    //---------------------------------------------cau 5-------------------------------
    public static void cau5(){
        List<IShape> L= new LinkedList<>();//khai báo đối tượng L thuộc LinkedList
        IShape A = new Circle((float) 2.4);//khai báo lần lượt đối tượng thuộc lớp IShape và khỏi tạo giá trị dùng hàm tạo
        IShape B = new Circle(3);
        IShape C = new Rectangle(3,2);
        IShape D = new Rectangle(4,1);
        IShape E = new Rectangle(1,7);

        L.add(A);//thêm làn lượt các giá trị vào L
        L.add(B);
        L.add(C);
        L.add(D);
        L.add(E);

        Map<Integer,IShape> M = new HashMap<>();//khai báo đối tượng M thuộc Map

        int i=1;//khai báo biến i để dùng làm key
        for(IShape r: L ) {// vòng lặp lần lượt truy cập vào các phần tử trong L
            M.put(i,r);//thêm lần lượt các đối tượng của L vào M
            i++;//tăng dàn key
        }

        System.out.println("So phan tu trong map: " + M.size());//thông báo số lượng phân tử trong M
        for(Map.Entry<Integer, IShape> e : M.entrySet()) { //duyệt các phần tử trong M
            System.out.println("-------------------------------------");
            e.getValue().showInfo();//dùng hàm showInfo để hiển thị thông tin từng phân tử trong M
        }
    }

}
// ===================================== ĐÊF 2=======================================================
Đã dùng 76% bộ nhớ … Nếu hết bộ nhớ, thì bạn không thể lưu tệp vào Drive hoặc sao lưu vào Google Photos. Sử dụng 100 GB dung lượng với giá 45.000 ₫ 11.250 ₫/tháng trong 2 tháng.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;
import static javax.print.attribute.standard.MediaSizeName.*;

public class STT6_HoangLong_2 {
    public static void main(String[] args) throws IOException {
        //cau1();
        //cau2();
        //cau3();
        //cau4();
        cau5();

    }
//--------------------------------------cau 1-----------------------------
    public static abstract class Animal{
        public int age;//Khai báo biến age để nhận giá trị từ bàn phím
        public String gender;//Khai báo biến gender để nhận giá trị từ bàn phím

        public boolean isMammal() {//Hàm isMammal trả về giá trị false
            return false;
        }

        public abstract void showInfo(); //hàm trừu trựong showInfo

        public Animal(int age, String gender) {//Hàm tạo
            this.age = age;//dán giá trị vào thuộc tính age
            this.gender = gender;// dán giá trị vào thuộc tính gender
        }
    }

    public static class Duck extends Animal{

        public String color;//Khai báo biến color nhập từ bàn phím
        void swim(){ //hàm swim
        }

        void quack(){

        }

        public Duck(String color, int age, String gender) {//hàm tạo
            super(age, gender);//dán các biến vào các thuộc tính ở lớp cha
            this.color= color;// dán giá trị vào thuộc tính color
        }

        @Override
        public void showInfo() {
            System.out.println("Duck{" +              //hiển thị các giá trị của thuộc tính ra màn hình
                    "age=" + age +
                    ", gender='" + gender + '\'' +
                    ", color='" + color + '\'' +
                    '}');
        }
    }

    public static class Fish extends Animal{
        int size;//Khai báo biến size nhập từ bàn phím
        boolean canEat;//Khai báo biến canEat nhập từ bàn phím

        public Fish(int size, int age, String gender) { //hàm tạo
            super(age, gender);//dán các biến vào các thuộc tính ở lớp cha
            this.size= size;// dán giá trị vào thuộc tính size
        }

        void swim(){

        }

        @Override
        public void showInfo() {
            System.out.println("Fish{" +    //hiển thị các giá trị của thuộc tính ra màn hình
                    "age=" + age +
                    ", gender='" + gender + '\'' +
                    ", size=" + size +
                    ", canEat=" + canEat +
                    '}');
        }
    }

    public static class Horse extends Animal{
        boolean isWild;//Khai báo biến isWild nhập từ bàn phím

        public Horse(int age, String gender) {
            super(age, gender);//dán các biến vào các thuộc tính ở lớp cha
        }

        void run(){ //hàm run của lớp Horse

        }

        @Override
        public boolean isMammal() { // hàm isMammal trả về giá trị true
            return true;
        }


        @Override
        public void showInfo() {  //Hàm hiển thị các giá trị của thuộc tính ra màn hình
            System.out.println("Horse{" +     //hiển thị lần lượt các giá trị
                    "age=" + age +
                    ", gender='" + gender + '\'' +
                    ", isWild=" + isWild +
                    '}');
        }

    }

    public static void cau1(){
        Animal A = new Duck("Vang", 2, "male");//khai báo và dùng hàm tạo
        Animal B = new Fish(5, 3, "female");//khai báo và dùng hàm tạo
        Animal C = new Horse(5, "male");//khai báo và dùng hàm tạo
        A.showInfo();//hiển thị đối tượng ra màn hình
        B.showInfo();//hiển thị đối tượng ra màn hình
        C.showInfo();//hiển thị đối tượng ra màn hình
    }

    //-----------------------------------cau2---------------------------------
    public static void cau2(){
        try {
            System.out.println("Nhap vao hai so nguyen, mot so am, mot so duong ");//hiển thị thông báo nhập 2 số
            Scanner s = new Scanner(System.in); //Sử dụng đối tượng scanner để nhập dữ liệu từ bàn phím
            int so1, so2; //khai báo 2 biến số
            so1 = s.nextInt(); //Nhập số nguyên từ vào cho biến so1 bằng hàm nextInt()
            so2 = s.nextInt(); //Nhập số nguyên từ vào cho biến so2 bằng hàm nextInt()

            if (so1*so2>0) System.err.println("Phai nhap mot so am, mot so duong");//kiểm tra 2 số có thỏa mãn điều kiện âm, dương không
            else System.out.println("Tong: "+ (so1+so2)); //Nếu thỏa mãn thì tính tổng


        } catch (InputMismatchException e){
            System.out.println("Loi ki tu vua nhap khong thuoc kieu int");//thông báo lỗi khi không thuộc kiểu int
        } catch (Exception e){
            System.out.println("Loi: "+ e.getMessage());// thông báo các lỗi khác
        }

    }

    //-----------------------------------cau 3-----------------------------------------
    public static void cau3() throws IOException {
        FileOutputStream o= new FileOutputStream("./raw.txt");//khai bao biến thuộc FileOutputStream
        FileInputStream i= new FileInputStream("./raw.txt");// khai báo biến thuộc  FileInputStream
        int a= 2;// khai báo biến a và dán giá trị bằng 2
        int b= 5;// khai báo biến b và dán giá trị bằng 5
        o.write(a); //ghi a vào file raw.txt
        o.write(b);// ghi b vào file raw.txt
        o.close();// đóng file raw

        int c,d; //khai báo 2 biến c, d
        c= i.read();//dán giá trị cho c từ file raw
        d= i.read();//dán giá trị cho c từ file raw
        System.out.println(c+","+ d);// hiển thị lần lượt c, d ra màn hình
        i.close();// đóng file raw
    }


    //-------------------------------cau4------------------------
    public static void cau4(){
        Thread t1 = new Thread(new Runnable() {  //khai báo luồng thứ nhất
            @Override
            public void run() {
                while (true){
                    System.out.println("Deo khau trang");// hiển thị thông báo đeo khẩu trang
                    try {
                        sleep(10000); //câu lệnh chờ 10 giây
                    } catch (InterruptedException e) { //xử lí ngoại lệ
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {//khai báo luồng thứ 2
            @Override
            public void run() {
                Scanner s= new Scanner(System.in);
                while (true){
                    System.out.println("Nhap vao so nguyen: ");//hiển thị thông báo nhập một số nguyên để kiểm tra chẵn lẻ
                    int x = s.nextInt();//Nhập số nguyên từ vào cho biến x bằng hàm nextInt()
                    if (x%2==0) System.out.println("So vua nhap la so chan");//kiểm tra chẵn lẻ
                    else System.out.println("So vua nhap la so le");// hiển thị nếu là số lẻ
                }
            }
        });
        t1.start();//chạy luồng thứ nhất
        t2.start();// chạy luồng thứ 2
    }
//-------------------------cau5----------------------------
    public static void cau5(){
        Map<Integer, Animal> M= new LinkedHashMap<>();//khai báo đối tượng M dùng lớp LinkedHashMap

        Animal A = new Duck("Vang", 2, "male");//khai báo lần lượt 3 đối tượng thuộc lớp Animal
        Animal B = new Fish(5, 3, "female");
        Animal C = new Horse(5, "male");

        M.put(1, A); //thêm lần lượt 3 đối tượng Animal vào M
        M.put(3, B);
        M.put(4, C);

        Set S = new HashSet<Animal>();//khai báo đối tượng S dùng lớp HashSet

        for(Map.Entry<Integer, Animal> entry : M.entrySet()) { //duyệt các phần tử trong M
            S.add(entry.getValue());//thêm lần lượt các giá trị từ M vào S
        }

        System.out.println("So phan tu trong HashSet = " + S.size());//Hiển thị ra màn hình số phàn tử
    }



}

