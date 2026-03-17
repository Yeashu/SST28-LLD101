How I solved the issues:
There was dependency inversion issue which I solved by creating abstraction and injecting dependency in TransportBookingService through constructor
```java
interface IPaymentGateway {
    String charge(String studentId, double amount);
}
interface IDriverAllocator {
    String allocate(String studentId);
}
interface IDistanceCalculator {
    double km(GeoPoint a, GeoPoint b);
}
```
```java

private IDistanceCalculator dist;
private IDriverAllocator alloc;
private IPaymentGateway pay;

public TransportBookingService(IDistanceCalculator dist, IDriverAllocator alloc, IPaymentGateway pay) {
    this.dist = dist;
    this.alloc = alloc;
    this.pay = pay;
}
```
