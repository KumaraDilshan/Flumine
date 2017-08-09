import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> phone_book = new HashMap<String, ArrayList<String>>();

        try {
            String line;

            BufferedReader  br = new BufferedReader(new FileReader("contacts.csv"));   //open the csv file

            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");   //put items seperated by commas in a line to a array
                ArrayList<String> values = new ArrayList<String>();   //declare and add information of the person to Arraylist
                values.add(item[2]);
                values.add(item[3]);
                values.add(item[4]);
                values.add(item[5]);
                phone_book.put(item[1],values);   //add first Name and Last Name to the hashmap
            }
			
			
			int condition;
        Scanner keyboard=new Scanner(System.in);
        System.out.print("Enter the search name :");

        do {
            String input_text=keyboard.next();
            String[] x = input_text.split("(?=[A-Z])");   //seperating the input into parts if there are two names in the input(considering the uppercase letters inside the input
            String text;

            for (int counter = 0; counter < x.length; counter++) {
                text = x[counter];
                condition=0;
                for (String key : phone_book.keySet()) {   //reading the hashmap
                    if (text.equals(key))     //comparing the names and output corresponding information
                    {
                        ArrayList value = phone_book.get(key);
                        System.out.print("First Name: " + key + "\nLast Name: " + value.get(0) + "\nPhone: " + value.get(1) + "\nEmail: " + value.get(2) + "\nCompany: " + value.get(3)+"\n");
                        condition=1;
                    }
                }
                if(condition==0)
                    System.out.println(text+" is not in the list");
					
				System.out.print("\n");	
            }
            System.out.print("Enter the search name :");
        }while(keyboard.hasNext());
		
		
        } catch (IOException e) {
            System.out.print(e);
        }

    }
}