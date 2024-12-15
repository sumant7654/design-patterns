package dev.sumantakumar.designpatterns.structural;

public class ProxyDesignPatternTest {
    public static void main(String[] args) {
        Service service = new ProxyService();
        service.request();
    }
}


interface Service{
    void request();
}

class RealService implements Service{

    @Override
    public void request() {
        System.out.println("RealService: Processing request");
    }
}

class ProxyService implements Service{
    private RealService realService;


    @Override
    public void request() {
        if(realService == null) {
            realService = new RealService();
        }
        System.out.println("ProxyService: Login request");
        authenticate();
        realService.request();
    }

    private void authenticate() {
        System.out.println("ProxyService: Performing Authentication");
    }
}