package com.bankcorp.sanction.service;

import com.bankcorp.sanction.model.Sanction;

public interface SanctionServiceI {

	public void saveSanctionData(Sanction sanction);

	public Sanction getSanctionDataById(Integer sanctionId);

}
