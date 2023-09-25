package com.github.takeoutspace18.RestIntervalMerger;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RestIntervalMergerApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads() {
	}

	@Test
	public void minDigitIntervalIsReturned() throws Exception {
		String mockJsonIntervals = "[[1, 4], [2, 6], [8, 10], [10, 11]]";
		String expectedResult = "[1, 6]";
		String kind = "digits";

		postMergeMockIntervals(kind, mockJsonIntervals);
		checkGetMinInterval(kind, expectedResult);
	}
	@Test
	public void minLetterIntervalIsReturned() throws Exception {
		String mockJsonIntervals = "[[\"a\", \"c\"], [\"b\", \"d\"], [\"e\", \"g\"], [\"h\", \"i\"]]";
		String expectedResult = "[\"a\", \"d\"]";
		String kind = "letters";

		postMergeMockIntervals(kind, mockJsonIntervals);
		checkGetMinInterval(kind, expectedResult);
	}

	@Test
	public void minIntervalIsReturnedWithDoubleMerge() throws Exception {
		String kind = "digits";
		postMergeMockIntervals(kind, "[[33, 56]]");
		checkGetMinInterval(kind, "[33, 56]");
		postMergeMockIntervals(kind, "[[33, 40]]");
		checkGetMinInterval(kind, "[33, 40]");
	}

	private void postMergeMockIntervals(String kind, String mockJsonIntervals) throws Exception {
		this.mockMvc.perform(post("/api/v1/intervals/merge?kind={kind}", kind).contentType(MediaType.APPLICATION_JSON).content(mockJsonIntervals))
				.andDo(print()).andExpect(status().isOk());
	}

	private void checkGetMinInterval(String kind, String expectedJsonResult) throws Exception {
		this.mockMvc.perform(get("/api/v1/intervals/min?kind={kind}", kind)).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(expectedJsonResult));
	}
}
