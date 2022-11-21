package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Dasha", "Morozova", "daramorozova619@gmail.com");
      User user2 = new User("Akim", "Parish", "akimp@gmail.com");
      User user3 = new User("Alena", "Seliverstova", "alenas@gmail.com");
      User user4 = new User("Oleg", "Doronin", "olegd@gmail.com");

      Car car1 = new Car("Lada", 2107);
      Car car2 = new Car("Lada", 2108);
      Car car3 = new Car("Lada", 2109);
      Car car4 = new Car("Lada", 2110);


      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));

    for (User user : userService.listUsers()) {
       System.out.println("select");
         System.out.println(user + " " + user.getCar());
      }

      System.out.println("getuser");
      System.out.println(userService.getUserByCar("Lada", 2108));


      context.close();
   }
}
