import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileContact {
    private static ReadWriteFileContact readWriteFileContact;
    private ReadWriteFileContact() {
    }
    public static ReadWriteFileContact getInstance(){
        if (readWriteFileContact == null){
            readWriteFileContact = new ReadWriteFileContact();
        }
        return readWriteFileContact;
    }

    public List<Contact> readFile() throws IOException, ClassNotFoundException {
        File file = new File("listContact.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        if (file.length() >0){
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            List<Contact> list = (List<Contact>) object;
            objectInputStream.close();
            fileInputStream.close();
            return list;
        }
        else return new ArrayList<>();
    }
    public void writeFile(List<Contact> contactList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream("listContact.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(contactList);
        objectOutputStream.close();
        fileOutputStream.close();

    }
}
