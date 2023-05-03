class Course {  
    int id;  
    String name;  
    Course(int i,String n){  
    id = i;  
    name = n;  
    }  
    void display(){
	System.out.println(id+" "+name);}  
 public static void main(String[] args){  
    Course s1 = new Course(111,"Computer Engineering");  
    Course s2 = new Course(222,"Civil Engineering");  
    s1.display();  
    s2.display();  
   }
}