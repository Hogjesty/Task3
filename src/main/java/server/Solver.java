package server;

import interfaces.Function;
import interfaces.SolverInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Solver extends UnicastRemoteObject implements SolverInterface {
    public Solver() throws RemoteException {
    }

    @Override
    public double solve(double a, double b, Function f) throws RemoteException {
        final double eps = 1E-9;
        int n=2;
        double h=(b-a)*0.5;
        double ss=0;
        double s1=h*(f.compute(a)+f.compute(b));
        double s2=0;
        double s4=4*h*f.compute(a+h);
        double s=s1+s2+s4;
        do {
            ss=s;
            n*=2;
            h/=2;
            s1*=0.5;
            s2=0.5*s2+0.25*s4;
            s4=0;
            int i=1;
            do {
                s4=s4+f.compute(a+i*h);
                i+=2;
            } while(i<=n);
            s4=4*h*s4;
            s=s1+s2+s4;
        } while(Math.abs(s-ss)>eps);
        return s/3;
    }
}
