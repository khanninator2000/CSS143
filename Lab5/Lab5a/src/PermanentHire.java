public class PermanentHire extends SalariedWorker {
    public PermanentHire() {
    }

    public PermanentHire(String name, int social) {
        super(name, social);
    }

    public PermanentHire(String name, int social, double pay) {
        super(name, social, pay);
    }

    @Override
    public double calculateWeeklyPay() {
        return super.calculateWeeklyPay()+10.01;
    }
}
