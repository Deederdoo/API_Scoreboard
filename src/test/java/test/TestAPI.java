package test;

import org.junit.jupiter.api.Test;

import dao.GPU_DaoImpl;
import model_parts.GPU;

public class TestAPI {
	
	@Test
	public void testInsertGPU() {
		
		GPU_DaoImpl dao = new GPU_DaoImpl();
		
		GPU newGPU = new GPU();
		
		newGPU.setBrand("testBrand");
		newGPU.setType("typeTest");
		newGPU.setTier("testTier");
		newGPU.setPrice("testPrice");
		newGPU.setDate_start("2021-06-06");
		newGPU.setTime_start("21:06:21");
		newGPU.setDate_end(null);
		newGPU.setTime_end(null);
		
		dao.createNewGPU(newGPU);
	}
}
