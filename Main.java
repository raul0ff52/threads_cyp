public class Main {
    public static void main(String[] args) {
        // Crear el objeto del thread
        MiThread thread1 = new MiThread("Thread 1");

        // Estado NEW: Thread creado, pero no iniciado aún
        System.out.println("Estado actual de Thread 1: " + thread1.getState());

        // Iniciar el thread
        thread1.start();

        // Estado RUNNABLE: El thread está listo para ejecutarse
        try {
            Thread.sleep(500); // Esperar un poco para observar los estados
            System.out.println("Estado actual de Thread 1: " + thread1.getState());

            // Simular el tiempo de ejecución del thread
            Thread.sleep(3500);
            System.out.println("Estado actual de Thread 1: " + thread1.getState());

            // Despertar el thread después de un tiempo en WAITING
            thread1.despertar();

            // Dar tiempo para finalizar la ejecución del thread
            Thread.sleep(1000);
            System.out.println("Estado final de Thread 1: " + thread1.getState());
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}