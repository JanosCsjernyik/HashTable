import com.codecool.hashMap.HashMap;

public class Launch {


    public static void main(String args[]){

        HashMap hashMap = new HashMap();


        hashMap.add("kecske", 29);
        hashMap.add("Anna", 27);

        System.out.println("Search for kecske: " + hashMap.getValue("kecske"));

        hashMap.clearAll();

        hashMap.add("kecske", 28);

        System.out.println("Search for kecske: " + hashMap.getValue("kecske"));



    }





}
