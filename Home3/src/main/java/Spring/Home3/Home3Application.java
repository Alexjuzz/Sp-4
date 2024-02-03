package Spring.Home3;
/*
Задание: Используя Spring
, создайте серверное приложение, которое обрабатывает HTTP-запросы и возвращает JSON-ответы.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Home3Application {

	public static void main(String[] args) {

		SpringApplication.run(Home3Application.class, args);
		System.out.println("test run");
	}

}
