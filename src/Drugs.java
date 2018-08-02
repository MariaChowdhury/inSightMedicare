import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
/**
 * @author mariachowdhury
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Drugs implements Comparable<Drugs> {

	String name;
	int price;
	String prescriber;
	public Drugs(String name, int price){
		this.name=name;
		this.price=price;
	}
	public Drugs(String prescriber,String name, int price){
		this.prescriber=prescriber;
		this.name=name;
		this.price=price;
	}
	public String getName(){
		return this.name;
	}
	public int getPrice(){
		return this.price;
	}
	public String getPrescriber(){
		return this.prescriber;
	}
	public int compareTo(Drugs o) {
		int comparePrice = ((Drugs) o).getPrice();
		int diff= comparePrice - this.price;
		if(diff==0) {
			String compareName = ((Drugs) o).getName();
			int diffName=(this.getName().charAt(0)-'a')-(compareName.charAt(0)-'a');
			return diffName;
		}
		else {
			return diff;
		}
		
	}
	public static void main(String[] args) throws Exception {
		
		//output file creation
		File outputFile=new File(args[1]);
		
		//delete output file if already exists
		outputFile.delete();
		
		//map to contain drugs and costs
		HashMap<String,Integer>map=new HashMap<String,Integer>();
		
		//map to contain drugs and prescriber
		HashMap<String,ArrayList<String>>prescribers=new HashMap<String,ArrayList<String>>();
		
		//input data file
		File inputFile=new File(args[0]);
		
		//reading input data file and populating both maps of the above
		Scanner sc=new Scanner(inputFile);
		while(sc.hasNext()){
			String s=sc.nextLine();
			String[]line=s.split(",");
		if(!map.containsKey(line[3])){
			map.put(line[3], Integer.parseInt(line[4]));
			ArrayList<String>plist=new ArrayList<String>();
			plist.add(line[0]);
			prescribers.put(line[3],plist);
		}
		else{
			int val=map.get(line[3]);
			map.put(line[3], val+Integer.parseInt(line[4]));
			ArrayList<String>plist=prescribers.get(line[3]);
			if(!plist.contains(line[0])){
				plist.add(line[0]);
			}
			prescribers.put(line[3],plist);
		}
		
		}
		//closing scanner
		sc.close();
		
		//total drug cost in descending order based on cost and if there is a tie, drug name
		ArrayList<Drugs> Drugss = new ArrayList<Drugs>();
		for(String key:map.keySet()){
			Drugss.add(new Drugs(key,map.get(key)));
		}
		Drugs[] DrugsArr = Drugss.toArray(new Drugs[0]);
		Arrays.sort(DrugsArr);
		ArrayList<Drugs> DrugsList = new ArrayList<Drugs>(
				Arrays.asList(DrugsArr));
		
		//creating output list 
		ArrayList<String>out=new ArrayList<String>();
		for (int i = 0; i < DrugsList.size(); i++) {
			out.add(DrugsList.get(i).getName() + ","+(prescribers.get(DrugsList.get(i).getName()).size())
					+","+ DrugsList.get(i).getPrice());

	}
		
		PrintWriter printWriter = null;
		 
		try {
			Writer fileWriter = new FileWriter(outputFile, true);
			printWriter = new PrintWriter(fileWriter);
 
			for (int i=0;i<out.size();i++) {
				printWriter.println(out.get(i));
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Closing the file
			if (printWriter != null) {
				printWriter.close();
			}
		}
}
}

