import java.util.Scanner;
 import java.io.*;
public class main {
public static void main(String args[]) throws IOException
{
InputStreamReader in= new InputStreamReader(System.in);
 BufferedReader br= new BufferedReader(in);
 int choice;
 System.out.println("Iveskite viena is dveju");
 System.out.println("1-busto kreditas | 2-vartotojo kreditas");
 choice=Integer.parseInt(br.readLine());
 System.out.println("Jusu ivestas pasirinkimas:" + choice);
switch(choice){
 case 1:
 bustoKreditas();
 break; 
 case 2:
vartojimoKreditas();
 break;
 default:
 throw new FileNotFoundException("Iterptas simbolius nezinomas(reikejo iveskite 1 arba 2)"); 
}
} 
private static void vartojimoKreditas() throws IOException {
 Scanner klaviatura = new Scanner(System.in);
  double palukanos= 0.0;
 double Paskola= 0.0;
 int laikotarpis = 0;
 double MonthPmt= 0.0;
 double R = 0.0;
 double F = 0.0;
 double Total= 0.0;
 double Pajamos = 0.0;
 double Pelnas = 0.0;
 double vaikuislaidos =0.0;
 double isiskolinimai=0.0;
 int vaikukiekis= 0; 
System.out.println("Iveskite seimos pajamas: ");
 Pajamos = klaviatura.nextDouble();
 System.out.println("Jusu seimos pajamos: " + Pajamos);
  System.out.println("Seimos ﬁnansiniai isipareigojimai (isiskolinimai):");
 isiskolinimai = klaviatura.nextDouble();
 System.out.println("Palukanos bus: " + isiskolinimai);
 if(dideliIsiskolinimai2(isiskolinimai))
 throw new FileNotFoundException("Paskola jums nebus suteikiama del palukanu");  
 System.out.println("Iveskite vaiku skaiciu: ");
 vaikukiekis = klaviatura.nextInt();
 System.out.println("Vaiku yra: " + vaikukiekis);
 if(BlogasVaikuKiekis(vaikukiekis)) 
throw new FileNotFoundException("Blogai ivedete vaiku skaiciu");
 System.out.println("Iveskite islaidos skirti vaikams: ");
 vaikuislaidos = klaviatura.nextInt();
 System.out.println("Vaikui skirti  islaidos: " + vaikuislaidos);
  System.out.println("Vartotojo kredito paskola: ");
 Paskola = klaviatura.nextDouble();
 System.out.println("Jus norite pasiskolinti: " + Paskola);
 if(limitas(isiskolinimai))
 throw new FileNotFoundException("Paskola jums nebus suteikiama del paskolos limito"); 
 System.out.println("Iveskite palukanos per menesi pvz.: 3,3");
 palukanos = klaviatura.nextDouble();
 System.out.println("Jusu palukanos: " + palukanos);
  System.out.println("Iveskite ant kiek menesiu imsite paskola");
 laikotarpis= klaviatura.nextInt();
 System.out.println("Jus ivedete " +laikotarpis);
 if (laikotarpis > 60) 
throw new FileNotFoundException("Paskola tokiam ilgam laikotarpiui nesuteikiama");
 else{
 System.out.println("   ");
 if(mazosPajamos(Paskola, Pajamos, isiskolinimai, vaikukiekis,vaikuislaidos))
 throw new FileNotFoundException("Paskola nesuteikiama!");
 else if (!mazosPajamos(Paskola, Pajamos, isiskolinimai, vaikukiekis,vaikuislaidos))       
System.out.println("Paskola suteikiama!");           
System.out.println(" ");              
if(sutartiesMokestis(Paskola))       
System.out.println("Kredito sutarties sudarymo mokestis bus: " +0.0013*Paskola);       
else if (!sutartiesMokestis(Paskola))       
System.out.println("Kredito sutarties sudarymo mokestis bus: " +144.81);
System.out.println("");    
R = palukanos/1200;    
F = Math.pow(1+R, laikotarpis);    
MonthPmt = Paskola * (R*F/(-1 + F));    
System.out.printf("Jusu menesinis mokestis bus: %.2f",MonthPmt);    
System.out.println("   ");        
Pelnas= Pajamos -  MonthPmt - (vaikuislaidos * vaikukiekis)- isiskolinimai; 
System.out.printf("Seimos pajamos atskaicius mokescius:  %.2f",Pelnas); 
System.out.println("   "); 
if(Pelnas > 10000 || Pelnas <0) 
throw new FileNotFoundException("Paskola jums nebus suteikiama");          
else     
System.out.println(""); 
Total = MonthPmt * laikotarpis;    
System.out.println("   ");    
System.out.printf("Total amount to pay: %.2f",Total);    
System.out.println("   "); 
System.out.println("Good Bye");} 
// TODO Auto-generated method stub
}
private static void bustoKreditas() throws IOException { 
double palukanos= 0.0; 
double Paskola= 0.0; 
int laikotarpis = 0; 
double MonthPmt= 0.0; 
double R = 0.0; 
double F = 0.0; 
double Total= 0.0; 
double Pajamos = 0.0; 
double Pelnas = 0.0; 
double vaikuislaidos =0.0; 
double isiskolinimai=0.0; 
int vaikukiekis= 0;
Scanner klaviatura = new Scanner(System.in); 
System.out.println("Iveskite seimos pajamas: "); 
Pajamos = klaviatura.nextDouble(); 
System.out.println("Jusu seimos pajamos: " + Pajamos);  
System.out.println("Seimos ﬁnansiniai isipareigojimai (isiskolinimai):"); 
isiskolinimai = klaviatura.nextDouble(); 
System.out.println("Palukanos bus: " + isiskolinimai); 
if(dideliIsiskolinimai(isiskolinimai)) 
throw new FileNotFoundException("Paskola jums nebus suteikiama del palukanu");       
System.out.println("Iveskite vaiku skaiciu: "); 
vaikukiekis = klaviatura.nextInt(); 
System.out.println("Vaiku yra: " + vaikukiekis); 
if(BlogasVaikuKiekis(vaikukiekis)){ 
throw new FileNotFoundException("Blogai ivedete vaiku skaiciu");  
} 
 System.out.println("Iveskite islaidos skirti vaikams: "); 
vaikuislaidos = klaviatura.nextInt(); 
System.out.println("Vaikui skirti  islaidos: " + vaikuislaidos);  
System.out.println("Busto kredito paskola: "); 
Paskola = klaviatura.nextDouble(); 
System.out.println("Jus norite pasiskolinti: " + Paskola);  
System.out.println("Iveskite palukanos per menesi pvz.: 3,3"); 
palukanos = klaviatura.nextDouble(); 
System.out.println("Jusu palukanos: " + palukanos);  
System.out.println("Iveskite ant kiek menesiu imsite paskola"); 
laikotarpis= klaviatura.nextInt(); 
System.out.println("Jus ivedete " +laikotarpis); 
 if (laikotarpis > 960) 
throw new FileNotFoundException("Paskola tokiam ilgam laikotarpiui nesuteikiama"); 
else{ 
System.out.println("   ");            
if(mazosPajamos(Paskola, Pajamos, isiskolinimai, vaikukiekis,vaikuislaidos))            
throw new FileNotFoundException("Paskola nesuteikiama!");            
else if (!mazosPajamos(Paskola, Pajamos, isiskolinimai, vaikukiekis,vaikuislaidos))            
System.out.println("Paskola suteikiama!");                                    
if(sutartiesMokestis(Paskola))            
System.out.println("Kredito sutarties sudarymo mokestis bus: " +0.0013*Paskola);            
else if (!sutartiesMokestis(Paskola))            
System.out.println("Kredito sutarties sudarymo mokestis bus: " +144.81); 
System.out.println("");    
R = palukanos/1200;    
F = Math.pow(1+R, laikotarpis);    
MonthPmt = Paskola * (R*F/(-1 + F));    
System.out.printf("Jusu menesinis mokestis bus: %.2f",MonthPmt);   
 System.out.println("   ");
Pelnas= Pajamos -  MonthPmt - (vaikuislaidos * vaikukiekis)- isiskolinimai; 
System.out.printf("Seimos pajamos atskaicius mokescius:  %.2f",Pelnas); 
System.out.println("   "); 
if(mazasPelnas(Pelnas)) 
throw new FileNotFoundException("Paskola jums nebus suteikiama");
     else
     System.out.println("");    
    Total = MonthPmt * laikotarpis;    
System.out.println("   ");    
System.out.printf("Total amount to pay: %.2f",Total);    
System.out.println("   ");
 System.out.println("Good Bye");
}
}
private static boolean limitas(double isiskolinimai) { 
if (isiskolinimai > 2600 || isiskolinimai <300){return true;}
 return false;
}
private static boolean mazasPelnas(double Pelnas) { 
if (Pelnas > 30000 || Pelnas <0) {return true;} 
return false; 
} 
private static boolean sutartiesMokestis(double Paskola) { 
if (0.0013*Paskola > 144.81 ) {return true;} 
else 
return false; 
} 
private static boolean mazosPajamos(double Paskola, double Pajamos, double isiskolinimai, int vaikukiekis, double vaikuislaidos) {
 if(Paskola>=0.4* Pajamos*(isiskolinimai-(vaikukiekis*vaikuislaidos))) 
{return true;} 
else 
return false; 
} 
private static boolean BlogasVaikuKiekis(int vaikukiekis) { 
if (vaikukiekis > 10 || vaikukiekis <0) {return true;}
 else
return false;
}
public static Boolean dideliIsiskolinimai(double isiskolinimai){ 
if ( isiskolinimai > 15000 || isiskolinimai <0) {return true;} 
else 
return false; 
} 
public static Boolean dideliIsiskolinimai2(double isiskolinimai){ 
if ( isiskolinimai > 5000 || isiskolinimai <0) {return true;} 
else 
return false; 
}
}

