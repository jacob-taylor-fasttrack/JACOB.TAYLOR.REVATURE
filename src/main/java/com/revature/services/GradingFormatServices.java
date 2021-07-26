package com.revature.services;

import java.util.List;

import com.revature.models.GradingFormats;

public interface GradingFormatServices {
	public GradingFormats addGradingFormats(GradingFormats gf);

	public List<GradingFormats> getAllGradingFormats();

	public GradingFormats getGradingFormat(int id);

	public GradingFormats updateGradingFormats(GradingFormats change);

	public GradingFormats deleteGradingFormats(GradingFormats gf);
}
