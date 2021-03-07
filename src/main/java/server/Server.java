package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        System.setProperty("java.rmi.server.hostname", "localhost");
        int port = 5050;
        try {
            LocateRegistry.createRegistry(port);
            Naming.rebind("rmi://localhost:" + port + "/getSolver", new Solver());
            System.out.println("Server started");
        } catch (RemoteException | MalformedURLException  e) {
            System.err.println("Server not started. " + e.getMessage());
        }
    }
}
