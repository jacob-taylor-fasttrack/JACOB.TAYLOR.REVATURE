package com.revature.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.revature.models.GradingFormats;
import com.revature.repos.GradingFormatsHBImpl;
import com.revature.repos.GradingFormatsRepo;

public class GradingFormatsRepoTest {
	public static GradingFormats gf;

	@Before
	public void init() {
		gf.setDefaultgrade("A");
		gf.setDesc("standard grading format");
		gf.setFormatname("standard");
		gf.setId(1);
	}

	@Test
	public void testCreateGradingFormats() {
		GradingFormatsRepo gfr = new GradingFormatsHBImpl();
		GradingFormats test = gfr.addGradingFormats(gf);
		assertNotNull(test);
		assertEquals(test.getFormatname(), "standard");
	}

	@Test
	public void testGetGradingFormats() {
		GradingFormatsRepo gfr = new GradingFormatsHBImpl();
		GradingFormats test = gfr.getGradingFormat(1);
		assertNotNull(test);
		assertEquals(test.getId(), 1);
	}

	@Test
	public void testGetAllEGradingFormats() {
		GradingFormatsRepo gfr = new GradingFormatsHBImpl();
		List<GradingFormats> tests = gfr.getAllGradingFormats();
		assertNotNull(tests);
	}

	@Test
	public void testUpdateGradingFormats() {
		GradingFormatsRepo gfr = new GradingFormatsHBImpl();
		GradingFormats test = gfr.updateGradingFormats(gf);
		assertNotNull(test);
		assertEquals(test.getFormatname(), "standard");
	}

	@Test
	public void testDeleteGradingFormats() {
		GradingFormatsRepo gfr = new GradingFormatsHBImpl();
		GradingFormats test = gfr.deleteGradingFormats(gf);
		assertEquals(null, test);

	}
}
