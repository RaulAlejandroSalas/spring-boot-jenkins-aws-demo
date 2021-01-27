package de.rauldev.springbootjenkinsawsdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootJenkinsAwsDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAllProductsTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products"))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	public void getProductByIdTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products/2"))
				.andExpect(status().isOk())
				.andReturn();

	}

	@Test
	public void getProductByIdNotFoundTest() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/products/10"))
				.andExpect(status().isNotFound())
				.andReturn();
	}


	@Test
	public void postCreateProductTest() throws Exception{
		String newProduct="{\"name\":\"New Product\",\"price\":\"300.0\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(newProduct)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();

	}
}
