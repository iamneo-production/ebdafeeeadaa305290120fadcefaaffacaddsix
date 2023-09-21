package com.examly.springapp;
import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc

class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc ;

	@Test
    public void add() throws Exception {
		 
		String st = "{\"foodId\": 1008,\"foodName\": \"Donutfruit\", \"foodCusine\": \"Demo\", \"cookingTime\": \"Min\", \"foodOrigin\": \"poor\"}";
	 	mockMvc.perform(MockMvcRequestBuilders.post("/")
	 			.contentType(MediaType.APPLICATION_JSON)
	 			.content(st)
	 			.accept(MediaType.APPLICATION_JSON))
	        	.andExpect(status().isOk())
				.andExpect(jsonPath("$").value(true))
	        	.andReturn();
	    
    }


	@Test
	void getid() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/food/1008")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						// .andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getOrigin() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/origin/poor")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						// .andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void getname() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/name/Donutfruit")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						// .andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	@Test
	void get() throws Exception{	

		 mockMvc.perform(MockMvcRequestBuilders.get("/Donutfruit/Demo")
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$").isArray())
						.andReturn();
	}

	 @Test

    public void controllerfolder() {

        String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

	@Test

    public void controllerfile() {

        String filePath = "src/main/java/com/examly/springapp/controller/FoodController.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


	@Test

    public void testModelFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

	@Test

    public void testModelFile() {

        String filePath = "src/main/java/com/examly/springapp/model/Food.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }

	@Test

    public void testrepositoryfolder() {

        String directoryPath = "src/main/java/com/examly/springapp/repository"; // Replace with the path to your directory

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testrepositoryFile() {

        String filePath = "src/main/java/com/examly/springapp/repository/FoodRepo.java";

        // Replace with the path to your file

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }


    @Test

    public void testServiceFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/service"; 

        File directory = new File(directoryPath);

        assertTrue(directory.exists() && directory.isDirectory());

    }

   

    @Test

    public void testServieFile() {

        String filePath = "src/main/java/com/examly/springapp/service/Apiservice.java";

        File file = new File(filePath);

        assertTrue(file.exists() && file.isFile());

    }




	

}
