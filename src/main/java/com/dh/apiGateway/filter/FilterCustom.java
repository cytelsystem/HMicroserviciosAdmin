
package com.dh.apiGateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;

@Component
public class FilterCustom extends AbstractGatewayFilterFactory<FilterCustom.Config> {

    public FilterCustom() {
        super(FilterCustom.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        //filtro previo a la invocación del servicio real asociado al gateway

        return (exchange, chain) -> chain.filter(exchange).then(Mono.fromRunnable(() -> {
            //filtro posterior a la invocación del servicio asociado al gateway

            System.out.printf("\nTime response " + Calendar.getInstance().getTime());
        }));
    }

    public static class Config {

    }
}