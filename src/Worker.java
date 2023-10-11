

public class Worker {
    boolean isStudent;
    boolean isSenior;

    public Worker(boolean isStudent, boolean isSenior) {
        this.isStudent = isStudent;
        this.isSenior = isSenior;
    }

    public int netWage(int wage) {
        int net = wage;
        if (! isStudent) net *= 0.85;
        // Pokud není student, vynásob mzdu 85 %.
        if (isSenior) net *= 1.1;
        // Pokud je senior, vynásob mzdu 110 %.
        return net;
    }
}