class MiThread extends Thread {
    private String nombre;

    public MiThread(String nombre) {
        this.nombre = nombre;
        System.out.println(nombre + " está en estado NEW (Creado).");
    }

    @Override
    public void run() {
        System.out.println(nombre + " está en estado RUNNABLE (Listo para ejecutar).");

        try {
            // Simular ejecución de tareas
            for (int i = 0; i < 3; i++) {
                System.out.println(nombre + " está ejecutando una tarea...");
                Thread.sleep(1000); // Simula el thread en TIMED_WAITING
            }

            synchronized(this) {
                System.out.println(nombre + " entra en estado WAITING (Esperando notificación).");
                wait(); // Simula el estado WAITING
            }

        } catch (InterruptedException e) {
            System.out.println(nombre + " fue interrumpido.");
        }

        System.out.println(nombre + " ha terminado y está en estado TERMINATED.");
    }

    public void despertar() {
        synchronized(this) {
            notify(); // Notifica para continuar después del estado WAITING
        }
    }
}
