package cdi;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class TransportFactory {

    @Produces
    ATMTransport createTransport(InjectionPoint injectionPoint){
        System.out.println("annotated " + injectionPoint.getAnnotated());
        System.out.println("bean " + injectionPoint.getBean());
        System.out.println("qualifiers " + injectionPoint.getQualifiers());
        return new StandardATMTransport();
    }
}
