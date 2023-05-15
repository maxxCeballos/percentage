package com.tenpo.profit;

import com.tenpo.profit.infraestructure.adapters.input.rest.ProfitRestAdapter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProfitApplicationTests {

	@Autowired
	private ProfitRestAdapter profitRestAdapter;

	@Test
	void contextLoads() {
		assertThat(profitRestAdapter).isNotNull();
	}

}
