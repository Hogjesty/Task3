package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SolverInterface extends Remote {
    double solve(double a, double b, Function f) throws RemoteException;
}
