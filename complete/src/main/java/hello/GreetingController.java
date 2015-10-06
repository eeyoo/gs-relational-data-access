package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		System.out.println("greeting service called.");
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping("/getDepartById")
    public List<Department> getDepartById(@RequestParam(value="id", defaultValue="10") String id) {
    	return JdbcHelper.getDeptById(new Long(id));
    }
    
    @RequestMapping("/getDeptByName")
    public List<Department> getDeptByName(@RequestParam(value="name", defaultValue="市场部") String name) {
    	return JdbcHelper.getDeptByName(name);
    }
    
}