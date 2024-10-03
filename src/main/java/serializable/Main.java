package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Need List of Dogs
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(4,"Canela"));
        dogs.add(new Dog(8,"Bubba"));
        dogs.add(new Dog(8,"Forrest"));
        dogs.add(new Dog(3,"Lucas"));

//        Need To Save List in Disk
        try(FileOutputStream fos = new FileOutputStream("Out.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
//            Method Save List
            oos.writeObject(dogs);

        }catch (Exception e) {
            e.fillInStackTrace();
        }


//        Recover List to show in Screen
        List<Dog> dogList = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream("Out.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){

            //noinspection unchecked
            dogList =(List<Dog>) ois.readObject();


        } catch (Exception e) {
            e.fillInStackTrace();
        }

        for(Dog dogOutput: dogList){
            System.out.println(dogOutput);
        }
    }
}
