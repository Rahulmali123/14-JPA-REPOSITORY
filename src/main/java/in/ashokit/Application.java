package in.ashokit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.ashokit.entity.User;
import in.ashokit.repo.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) 
	{
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);

		UserRepository repo = run.getBean(UserRepository.class);
		
		User u4=new User(104, "Rohit", "Male", 30, "India");
		User u5=new User(105, "Ganesh", "Male", 33, "India");
		User u6=new User(106, "Orlen", "Male", 34, "Germany");
		User u7=new User(107, "Charles", "Male", 35, "Mexico");
		User u8=new User(108, "Buttler", "Male", 36, "Australia");
		User u9=new User(109, "Cathy", "Fe-Male", 29, "USA");
		User u10=new User(110, "Tanny", "Fe-Male", 28, "Canada");
		
		List<User> saveAll = repo.saveAll(Arrays.asList(u4,u5,u6,u7,u8,u9,u10));
		
		/* List<User> users = repo.findAll(Sort.by("age").ascending()); */
		
		/* List<User> users = repo.findAll(Sort.by("age").descending()); */
		
		/* List<User> users = repo.findAll(Sort.by("username").ascending()); */
		
		/* List<User> users = repo.findAll(Sort.by("username","age").ascending()); */
		
		/*
		 * users.forEach(user-> { System.out.println(user); });
		 */
		
		/*
		 * PageRequest pageRequest = PageRequest.of(0, 3);
		 * 
		 * Page<User> pageData = repo.findAll(pageRequest);
		 * 
		 * List<User> users = pageData.getContent();
		 * 
		 * users.forEach(user-> { System.out.println(user); });
		 */
		
		/*
		 * int pageNo = 0; // first page (0-based) int pageSize = 5; // records per page
		 * 
		 * PageRequest pageRequest = PageRequest.of(pageNo, pageSize); Page<User>
		 * pageData = repo.findAll(pageRequest);
		 * 
		 * int totalPages = pageData.getTotalPages();
		 * System.out.println("Total Pages:: "+totalPages);
		 * 
		 * List<User> users = pageData.getContent();
		 * 
		 * users.forEach(user -> { System.out.println(user); });
		 */
		
//		dynamically add remove page number 
		
		/*
		 * int pageNo = 1; // first page (0-based) int pageSize = 5; // records per page
		 * 
		 * PageRequest pageRequest = PageRequest.of(pageNo-1, pageSize); Page<User>
		 * pageData = repo.findAll(pageRequest);
		 * 
		 * int totalPages = pageData.getTotalPages();
		 * System.out.println("Total Pages:: "+totalPages);
		 * 
		 * List<User> users = pageData.getContent();
		 * 
		 * users.forEach(user -> { System.out.println(user); });
		 */
		
		
		User user = new User();
		
		user.setCountry("India");  // set
		user.setAge(29);
		
		Example<User> example = Example.of(user);
		
		List<User> users = repo.findAll(example);
		
		users.forEach(use -> {
			System.out.println(use);
		});
		
		

		
	}

}
