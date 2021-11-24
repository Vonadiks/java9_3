public class PingPongTask {
    private volatile boolean myPingPong;

    {
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    if (myPingPong)
                    System.out.println("Pong");
                    else
                    System.out.println("Ping");
                    Thread.sleep(1000);
                    myPingPong = !myPingPong;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        PingPongTask pingPongTask = new PingPongTask();
    }
}
