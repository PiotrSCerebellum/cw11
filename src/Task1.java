
public class Task1 implements Runnable {
    Thread thread;

//tworzy nowy wqtek
Task1(String name){
    thread = new Thread(this, name);}
    //w momencie tworzenle wątek otrzymum nazwę
    // metodn wytwórcz, ktora tworzy i startuje wqtek
    public static Task1 createAndStart(String name){
        Task1 Task1 = new Task1(name);
        Task1.thread.start();
        return Task1;
    } //rozpoczyna wykonywanie nowego wątku

    public void run() {
        System.out.println(thread.getName() +" rozpoczyna dziatanie");
     try {
         for (int count = 0; count < 10; count++) {
             Thread.sleep(400);
             System.out.println(thread.getName() + " jest wykonywany, wartość licznika: " + count);
         }
     }catch (InterruptedException e){
            System.out.println(thread.getName() + " zostat przerwany");

         }
        System.out.println(thread.getName() + " kończy dziatanie.");
        }
}
class moreThreads2 {
    public static void main(String[] args) {
        System.out.println("Gtowny wątek rozpoczyna dziatanie.");
        //teroz wątek zostaje uruchomiony w trakcie tworzenia
        Task1 myThread1 = Task1.createAndStart("watek potomny nr 1");
        Task1 myThread2 = Task1.createAndStart("Wątek potomny nr 2");
        Task1 myThread3 = Task1.createAndStart("Watek potomny nr 3");
            try {
                myThread1.thread.join();
                System.out.println("Watek potomny został przerwany");
                myThread2.thread.join();
                System.out.println("Watek potomny został przerwany");
                myThread3.thread.join();
                System.out.println("Watek potomny został przerwany");
            } catch (InterruptedException e) {
                System.out.println("Watek gtowny zostat przerwany");
            }

            System.out.println("watek główny kończy działanie");

    }}
