import java.util.*;
import java.io.*;

class Fraction{
	// variables to store numerator and denominators of input fractions
	double n1,n2,d1,d2;
	
	// building a method to parse a string to double values of its numerator and denominators
	void parse(String a, String b){
		if(a.contains("/")){
			//splitting string in accordance to the presence of '/'
			String[] atemp = a.split("/");
			// converting the splitted string to double value and storing in respective variables
			n1 = Double.parseDouble(atemp[0]); d1 = Double.parseDouble(atemp[1]);
		}
		else{
			n1 = Double.parseDouble(a);
			d1 = 1.0;
		}
		
		if(b.contains("/")){
			//splitting string in accordance to the presence of '/'
			String[] btemp = b.split("/");
			// converting the splitted string to double value and storing in respective variables
			n2 = Double.parseDouble(btemp[0]); d2 = Double.parseDouble(btemp[1]);
		}
		else{
			n2 = Double.parseDouble(a);
			d2 = 1.0;
		}

	}
	
		
	//  simple function to evaluate gcd of two nos.
	double gcd(double a, double b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}
	
	
	// A function to add two fractions and return a string denoting the result
	String add(String x, String y){
		parse(x,y);
		double den = (d1*d2);
		double num = n1*d2 + n2*d1;
		
		// normalize
		double g = gcd(num,den);
		num /= g;
		den /= g;
		
		if(den!=1.0 && num!=0)return num + "/" + den;
		else return ""+num;
		
	}
	
	// A function to subtract two fractions
	String sub(String x, String y){
		parse(x,y);
		double den = (d1*d2);
		double num = n1*d2 - n2*d1;
		
		// normalize
		double g = gcd(num,den);
		num /= g;
		den /= g;
		if(den!=1.0 && num!=0)return num + "/" + den;
		else return ""+num;
	}
	
	
	// A function to multiply two fractions
	String mul(String x, String y){
		parse(x,y);
		double den = (d1*d2);
		double num = n1*n2;
		
		// normalize
		double g = gcd(num,den);
		num /= g;
		den /= g;
		if(den!=1.0 && num!=0)return num + "/" + den;
		else return ""+num;
	}
	
	
	// A function to multiply two fractions
	String div(String x, String y){
		parse(x,y);
		double den = (d1*n2);
		double num = n1*d2;
		
		// normalize
		double g = gcd(num,den);
		num /= g;
		den /= g;
		if(den!=1.0 && num!=0)return num + "/" + den;
		else return ""+num;
	}
		
}



class Grading{
	String line;
	int student, test;
	double studentAvg,  overallAvg, testAvg;
	int[] studentsum = new int[test];
	PrintWriter pw = new PrintWriter("Sort.txt","UTF-8");
	double[] studentaverage = new double[student];
	double[] testaverage = new double[test];
	int[] testsum = new int[student];
	int score[][] = new int[student][test];
	String name[] = new String[student];
	
	FileReader fr = new FileReader("Sort.txt");
	BufferedReader br = new BufferedReader(fr);
	
	
	void readFile(){
		try{
			line = br.readLine();
		}
		catch(Exception e){
			System.out.println("Error reading file");
		}
		String[] temp = line.split(" ");
		student = Integer.parseInt(temp[0]); test = Integer.parseInt(temp[1]);
		int counter = 0;
		try{
			while((line = br.readLine())!=null){
				temp = line.split(" ");
				name[counter] = temp[0];
				
				for(int i = 0; i<temp.length-2; i++){
					score[counter][i] = Integer.parseInt(temp[i]);
					studentsum[counter]+= Integer.parseInt(temp[i]);
					testsum[i]+= Integer.parseInt(temp[i]);
				}
				counter++;
			}
		}
		catch(Exception e){
			System.out.println("Error reading file somewhere");
		}
	}
	
	void calculateAverage(){
		for(int i = 0; i<test; i++)
			studentaverage[i] = studentsum[i]/test;
		
	}
	
	char calculateGrade(double average, double total){
		if(average>=.9*total)
			return 'A';
		else if(average>=.8*total)
			return 'B';
		else if(average>=.7*total)
			return 'C';
		else if(average>=.6*total)
			return 'D';
		return 'E';
	}
	
	
	void calculateTestAvg(){
		for(int i =0; i<student; i++)
			testaverage[i] = testsum[i]/student;
		
		double totalavg =0;
		for(int i  =0;  i<student; i++){
			totalavg+=studentaverage[i];
		}
		overallAvg =  totalavg/student;
	}
	
	
	void printGrades(){
		System.out.println("Overall Average: " +overallAvg);
		for(int i =0; i<student; i++){
			System.out.println("Average Score:- " + studentaverage[i] + "\nGrade Obtained: " + calculateGrade(studentaverage[i], testsum[i] ));
		}
	}
	
	
	void closeFile(){
		br.close();
	}
	
	
}

class Assignment2{
	
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Fraction Calculator");
		System.out.println("2.Grading Scheme");
		System.out.println("Enter Your Choice:");
		int ip = sc.nextInt();
		String frac1, frac2;
		Grading grad = new Grading();
		grad.readFile();
		grad.calculateAverage();
		grad.calculateTestAvg();
		// creating an object of Fraction class
		Fraction frac = new Fraction();
		

		switch(ip){
			case 1: System.out.println("Enter two fractions:");
					//  input of the two fractions
					frac1 = sc.next(); frac2 = sc.next();
					// displaying the result table
					System.out.println("Addition: " + frac.add(frac1, frac2) + "\nSubtraction: " + frac.sub(frac1,frac2) + "\nMultiplication: " + frac.mul(frac1,frac2) + "\nDivision: " + frac.div(frac1, frac2));
					break; 
			
			case 2: grad.printGrades(); break;
			
			default : break;
		}
		
	}
	
	
}