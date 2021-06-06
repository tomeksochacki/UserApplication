package pl.ts.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ComponentScan("pl.ts")
public class AppConfiguration {
    //połączenie z bazą danych
    /*
    @Bean
    public Connection connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");     //ładoanie jakiejś klasy do aplikacji, czyli ładujemy  // klasę do aplikacji z pakietu który pobraliśmy zależnościami
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/zts?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8", "root", "");
            //connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
