package com.example.usedstaffsaleapplication.controller;

import com.example.usedstaffsaleapplication.model.Entity.Advert;
import com.example.usedstaffsaleapplication.model.DTO.AdvertDTO;
import com.example.usedstaffsaleapplication.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/advert")
@RestController
public class AdvertController {
    @Autowired
    private AdvertService advertService;

    @PreAuthorize(("hasRole('ROLE_ADMIN') or hasRole('ROLE_STANDARD_CLIENT')"))
    @GetMapping("/all")
    public ResponseEntity getAllAdverts(){
        List<Advert>Alladverts=advertService.getAllAdverts();
        return ResponseEntity.ok(Alladverts);
    }
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity getAdvertbyId(@PathVariable("id") Long id){
        Advert byid = advertService.getByid(id);
        return ResponseEntity.status(HttpStatus.OK).body(byid);



    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_STANDARD_CLIENT')")
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AdvertDTO advert) {
        Advert repsAdvert = advertService.create(advert);
        if (repsAdvert == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Advert cold not be created");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(repsAdvert);

    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_STANDARD_CLIENT')")
   @DeleteMapping
    public ResponseEntity deleteAdvert (@RequestParam(name = "id")Long id){
       advertService.delete(id);
       return ResponseEntity.status(HttpStatus.OK).body("Advert was deleted");
    }

    @PreAuthorize("hasRole('ROLE_STANDARD_CLIENT')")
        @PutMapping("/{title}")
    public ResponseEntity update(
            @PathVariable String title,
            @RequestBody AdvertDTO advertdto) {
            Advert update=advertService.update(title,advertdto);
        if (update == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Advert cold not be updated");
            }
        return ResponseEntity.status(HttpStatus.OK).body(update);

        }


}




