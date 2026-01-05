package com.bankcorp.sanction.service;

import com.bankcorp.sanction.model.Sanction;

public interface SanctionServiceI {

	public Sanction saveSanctionData(Sanction sanction);

	public Sanction getSanctionDataById(Integer sanctionId);

	public Sanction acceptLoanStatus(Integer sanctionId);

	public Sanction rejectLoanStatus(Integer sanctionId);

}
