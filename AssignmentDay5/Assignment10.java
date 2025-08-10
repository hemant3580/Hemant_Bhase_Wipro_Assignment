package AssignmentDay5;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class TimeServer {
    public static interface Client {
        void updateTime(LocalDateTime now);
    }

    List<Client> clients = new ArrayList<>();

    public void registerClient(Client client) {
        clients.add(client);
    }

    public void notifyClients() {
        LocalDateTime now = LocalDateTime.now();
        for (Client client : clients) {
            client.updateTime(now);
        }
    }
}

class Clock implements TimeServer.Client {
    public void updateTime(LocalDateTime now) {
        System.out.println("Clock updated to: " + now);
    }
}

class Watch implements TimeServer.Client {
    public void updateTime(LocalDateTime now) {
        System.out.println("Watch synced at: " + now);
    }
}

public class Assignment10 {
    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        server.registerClient(new Clock());
        server.registerClient(new Watch());
        server.notifyClients();
    }
}
