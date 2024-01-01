package com.example.securityproject.Seeder;

import com.example.securityproject.entity.Tag;
import com.example.securityproject.repository.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class TagSeeder {
    private final TagRepo tagRepository;

    private final Tag[] tags = {
            Tag.builder().name("tag1").build(),
            Tag.builder().name("tag2").build(),
            Tag.builder().name("tag3").build(),
            Tag.builder().name("tag4").build(),
            Tag.builder().name("tag5").build(),
            Tag.builder().name("tag6").build(),
    };

    public void seed(){
        if(tagRepository.findAll().isEmpty()){
            tagRepository.saveAll(Arrays.asList(tags));
        }
    }



}
