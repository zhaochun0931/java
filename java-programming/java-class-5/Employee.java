public class Employee extends Thread{

    public Employee(String name){
        super(name);
    }

    public void work(){
        for(int i = 1; i<= 10; i++){
            System.out.println(getName() + " finished " + i + " task");
        }
    }

    public void run(){
        work();
    }

}
