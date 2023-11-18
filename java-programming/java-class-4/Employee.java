public class Employee {

    private String name;
    public Employee(String name){
        this.name = name;
    }

    public void work(){
        for(int i = 1; i<= 10; i++){
            System.out.println(name + " finished " + i + " task");
        }
    }

}
