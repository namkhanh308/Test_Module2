import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        int choose = -1;
        while (choose != 8) {
            System.out.println("---QUẢN LÝ DANH BẠ V1---");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách điện thoại");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng: ");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Chức năng xem danh sách");
                    manager.displayContact();
                    break;
                case 2:
                    System.out.println("Chức năng thêm mới số điện thoại");
                    manager.addContact();
                    break;
                case 3:
                    System.out.println("Chức năng cập nhật số điện thoại");
                    while (true){
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Mời bạn nhập số điện thoại cần cập nhật");
                        String phoneNumber = scanner1.nextLine();
                        manager.editContact(phoneNumber);
                        break;

                    }
                    break;
                case 4:
                    System.out.println("Chức năng xóa số điện thoại");
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Mời bạn nhập số điện thoại cần xóa");
                    String phoneNumber1 = scanner2.nextLine();
                    manager.deleteContact(phoneNumber1);
                    break;
                case 5:
                    System.out.println("Chức năng tìm số điện thoại");
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Mời bạn nhập số điện thoại cần tìm");
                    String phoneNumber2 = scanner3.nextLine();
                    manager.findContact(phoneNumber2);
                    break;
                case 6:
                    System.out.println("Chức năng đọc từ file");
                    try {
                        manager.setContactList(ReadWriteFileContact.getInstance().readFile());
                        System.out.println("Đọc thành công");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Chức năng ghi từ file");
                    manager.writeFile();
                    System.out.println("Ghi thành công");
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }

    }
}
