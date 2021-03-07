package client;

import interfaces.SolverInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static void main(String[] args) {
        SolverInterface solver;
        try {
            solver = (SolverInterface) Naming.lookup("rmi://localhost:5050/getSolver");
            double r = solver.solve(0, 1, Math::cos);
            System.out.println("Result = " + r);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
