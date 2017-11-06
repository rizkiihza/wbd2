package ws;

import javax.xml.ws.Endpoint;

public class OjekWSPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/OjekWS", new OjekWSImpl());
    }
}
