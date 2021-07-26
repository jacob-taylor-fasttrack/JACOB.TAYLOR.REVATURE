package com.revature.services;

import java.util.List;

import com.revature.models.GradingFormats;
import com.revature.repos.GradingFormatsRepo;

public class GradingFormatServiceImpl implements GradingFormatServices {
	public GradingFormatsRepo gdfr;

	public GradingFormatServiceImpl(GradingFormatsRepo gdfr) {
		this.gdfr = gdfr;
	}

	@Override
	public GradingFormats addGradingFormats(GradingFormats gf) {
		return gdfr.addGradingFormats(gf);
	}

	@Override
	public List<GradingFormats> getAllGradingFormats() {
		return gdfr.getAllGradingFormats();
	}

	@Override
	public GradingFormats getGradingFormat(int id) {
		return gdfr.getGradingFormat(id);
	}

	@Override
	public GradingFormats updateGradingFormats(GradingFormats change) {
		return gdfr.updateGradingFormats(change);
	}

	@Override
	public GradingFormats deleteGradingFormats(GradingFormats gf) {
		return gdfr.deleteGradingFormats(gf);
	}

}
