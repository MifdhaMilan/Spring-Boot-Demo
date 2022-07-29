package com.sun.travels.controller;

import com.sun.travels.model.Profile;
import com.sun.travels.request.ProfileRequest;
import com.sun.travels.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/create-profile")
    public ResponseEntity<Profile> createProfile(@RequestBody ProfileRequest profileRequest){
        return profileService.createProfile(profileRequest);
    }

    @GetMapping("/get-profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable int id){
        return profileService.getProfileById(id);
    }

    @PutMapping("/update-profile")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile){
        return profileService.updateProfile(profile);
    }
}
