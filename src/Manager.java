import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager implements Serializable {
    public static final String REGEX_NUMBER = "^\\d{3,11}$";
    public static final String REGEX_EMAIL = "^[a-z[0-9]]+@\\w+\\.\\w+$";
    List<Contact> contactList;
    ReadWriteFileContact readWriteFileContact = ReadWriteFileContact.getInstance();

    public Manager() {
            this.contactList = new ArrayList<>();
    }

    public Manager(List<Contact> contactList, ReadWriteFileContact readWriteFileContact) {
        this.contactList = contactList;
        this.readWriteFileContact = readWriteFileContact;
    }

    public void displayContact(){
        for (Contact contact :contactList ) {
            System.out.println(contact);
        }
    }
    public boolean validatePhoneNumber(String sđt){
        Pattern pattern = Pattern.compile(REGEX_NUMBER);
        Matcher matcher = pattern.matcher(sđt);
        if((matcher.find())){
            System.out.println("Số điện thoại đúng r");
            return true;
        }
        else{
            System.out.println("Số điện thoại sai r");
            return false;
        }
    }
    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        if((matcher.find())){
            return true;
        }
        else{
            return false;
        }
    }

    public void addContact() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoai: ");
        String phonenumber = scanner.nextLine();
        check = check && validatePhoneNumber(phonenumber);
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateofbirth = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        check = check && validateEmail(email);
        if(check == true){
            Contact contact = new Contact(phonenumber, group, name, gender, address, dateofbirth, email);
            add(contact);
        }
        else {
            System.out.println("Bạn nhập sai email hoặc số điện thoại");
        }
    }
    public void add(Contact contact){
        contactList.add(contact);
    }
    public Contact findPhoneNumber(String phoneNumber){
        for (Contact contact: contactList) {
            if(contact.getPhoneNumber().equals(phoneNumber)){
                return contact;
            }
        }
        return null;
    }
    public void edit(Contact contact)  {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập thông tin: ");
        System.out.println("Nhập nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateofbirth = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        check = check && validateEmail(email);
        if(check == true){
            contact.setGroup(group);
            contact.setName(name);
            contact.setAddress(address);
            contact.setDateofbirth(dateofbirth);
            contact.setGender(gender);
            contact.setEmail(email);
            System.out.println("Sửa thành công");
        }
        else {
            System.out.println("Bạn đã nhập sai email");
        }

    }
    public boolean editContact(String phoneNumber){
        boolean check = true;
        Contact contact = findPhoneNumber(phoneNumber);
        if(contact != null){
                edit(contact);
                check = true;
        }
        else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            check = false;
        }
        return check;
        }

    public void deleteContact(String phoneNumber) {
        Contact contact = findPhoneNumber(phoneNumber);
        if (contact != null) {
            String choose = "Y";
            System.out.println("Bạn có muốn xóa số điện thoại này không? (Y/N)");
            while (choose.equals("Y")){
                Scanner scanner = new Scanner(System.in);
                choose = scanner.nextLine();
                if(choose.equals("Y")){
                    contactList.remove(contact);
                    System.out.println("Xóa thành công");
                    break;
                }
            }
        }
        else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }
    public void findContact(String phoneNumber){
        Contact contact = findPhoneNumber(phoneNumber);
        if(contact != null){
            System.out.println(contact);
        }
        else {
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }
    }
    public void writeFile(){
        try {
            readWriteFileContact.writeFile(contactList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public ReadWriteFileContact getReadWriteFileContact() {
        return readWriteFileContact;
    }

    public void setReadWriteFileContact(ReadWriteFileContact readWriteFileContact) {
        this.readWriteFileContact = readWriteFileContact;
    }
}
