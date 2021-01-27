package org.acme;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ConferenceService {

    @Inject
    private ConferenceRepository conferenceRepository;

    @Inject
    @RestClient
    CountryClient countryClient;

    public List<Conference> getAll() {
        return conferenceRepository.findAll();
    }

    public void create(Conference conference) {
        conferenceRepository.save(conference);
    }
}
