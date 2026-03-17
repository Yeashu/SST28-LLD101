public class DriverAllocator implements IDriverAllocator {
    public String allocate(String studentId) {
        // fake deterministic driver
        return "DRV-17";
    }
}

interface IDriverAllocator {
    String allocate(String studentId);
}
