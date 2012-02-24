/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.odkconnector.clinic.data;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Patient;
import org.openmrs.module.odkconnector.clinic.Serializable;
import org.openmrs.module.odkconnector.clinic.utils.SerializationUtils;

public class PatientData implements Serializable {

	private static final Log log = LogFactory.getLog(PatientData.class);

	private Patient patient;

	private List<PatientObs> observations;

	private List<PatientForm> forms;

	/**
	 * Get the internal patient for the patient data
	 *
	 * @return the internal for the patient data
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * Set the internal patient for this patient data
	 *
	 * @param patient the internal patient for the patient data
	 */
	public void setPatient(final Patient patient) {
		this.patient = patient;
	}

	/**
	 * Get all observations information from the patient data
	 *
	 * @return list of all observations for the patient data
	 */
	public List<PatientObs> getObservations() {
		if (observations == null)
			observations = new ArrayList<PatientObs>();
		return observations;
	}

	/**
	 * Set all the observations information for the patient data
	 *
	 * @param observations list of all observations for the patient data
	 */
	public void setObservations(final List<PatientObs> observations) {
		this.observations = observations;
	}

	/**
	 * Add the patient observation into the list of all patient observations
	 *
	 * @param patientObs the patient observation
	 */
	public void addObservation(final PatientObs patientObs) {
		getObservations().add(patientObs);
	}

	/**
	 * Add the patient observation into the list of all patient observations
	 *
	 * @param observations the patient observations
	 */
	public void addObservations(final List<PatientObs> observations) {
		getObservations().addAll(observations);
	}

	/**
	 * Get all forms applicable for the patient data
	 *
	 * @return list of all forms information for the patient data
	 */
	public List<PatientForm> getForms() {
		if (forms == null)
			forms = new ArrayList<PatientForm>();
		return forms;
	}

	/**
	 * Set all applicable forms information for the patient data
	 *
	 * @param forms list of all forms information for the patient data
	 */
	public void setForms(final List<PatientForm> forms) {
		this.forms = forms;
	}

	/**
	 * Add the patient form into the list of all patient forms
	 *
	 * @param patientForm the patient form
	 */
	public void addForm(final PatientForm patientForm) {
		getForms().add(patientForm);
	}

	/**
	 * Add the patient form into the list of all patient forms
	 *
	 * @param forms the patient forms
	 */
	public void addForms(final List<PatientForm> forms) {
		getForms().addAll(forms);
	}

	/**
	 * Method to write the object to the output stream
	 *
	 * @param stream the output stream
	 */
	@Override
	public void write(final DataOutputStream stream) throws IOException {
		SerializationUtils.serialize(getPatient(), stream);
		SerializationUtils.serialize(getObservations(), stream);
		SerializationUtils.serialize(getForms(), stream);
	}
}
