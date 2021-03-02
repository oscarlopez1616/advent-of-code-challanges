package com.advent.challenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
class ChallengeApplicationTests {

	@Test
	void contextLoads() {
		assertThat(true,equalTo(true));
	}

}
