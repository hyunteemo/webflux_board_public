package rboard.client;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.data.r2dbc.core.DatabaseClient;
import rboard.entity.RNumber;

import java.util.concurrent.TimeUnit;

public class RNumberClient {

    public static void main(String[] args) throws InterruptedException {

        final PostgresqlConnectionFactory postgresqlConnectionFactory = new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder().host("127.0.0.1")
                        .database("webflux")
                        .username("teemo")
                        .password("password").build());
        DatabaseClient client = DatabaseClient.create(postgresqlConnectionFactory);

        client.select()
                .from(RNumber.class)
                .fetch().all()
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);
    }
}
