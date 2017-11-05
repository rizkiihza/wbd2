package publisher;


import ws.DriverWSImpl;

import javax.xml.ws.Endpoint;

public class   DriverWSPublisher {
    public static void main(String[] args) {
        try {
            Endpoint.publish("http://localhost:8080/ws/driver", new DriverWSImpl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
