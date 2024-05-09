package FileHandling.serialization;

import java.io.*;

public class SerializationImplementation {
    public static void serializeObject(Object object) {
        try(OutputStream outputStream = new FileOutputStream("Emp.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            objectOutputStream.writeObject(object);
        }
        catch (IOException ex){
            System.err.println(ex);
        }

    }

    public static Object deSerializeObject(String filename){
        try(InputStream inputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Object obj = objectInputStream.readObject();
            return obj;
        }
        catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static void main(String[] args) {

//            Employee emp = new Employee(101, "Raj", 45000);

//////            // Serialize the emp object
//            serializeObject(emp);
//            System.out.println("Employee object serialized successfully: " + emp);

//////            // Another employee deserializes the object
            Employee emp1 = (Employee) deSerializeObject("Emp.ser");
            System.out.println("Employee object deserialized successfully: " + emp1);

    }

}
