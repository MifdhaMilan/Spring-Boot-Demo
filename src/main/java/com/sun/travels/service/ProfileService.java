package com.sun.travels.service;

import com.sun.travels.model.Profile;
import com.sun.travels.repository.ProfileRepository;
import com.sun.travels.request.ProfileRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public ResponseEntity<Profile> createProfile(ProfileRequest profileRequest){
        Profile profile = new Profile();
        profile.setQualification(profileRequest.getQualification());
        profile.setGpa(profileRequest.getGpa());
        return ResponseEntity.ok(profileRepository.save(profile));
    }
    public ResponseEntity<Profile> getProfileById(int id){
        return ResponseEntity.ok(profileRepository.findById(id).orElse(null));
    }

    public ResponseEntity<Profile> updateProfile(Profile profile){
        Profile existingProfile = getProfileById(profile.getId()).getBody();
        try {
            existingProfile.setQualification(profile.getQualification());
            existingProfile.setGpa(profile.getGpa());
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok(profileRepository.save(existingProfile));
    }


}
