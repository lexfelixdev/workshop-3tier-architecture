package nl.quintor.qars.controller;

import nl.quintor.qars.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("http://localhost:4200")
public class TitleController {

    private TitleRepository titleRepository;

    @Autowired
    public TitleController(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping("/pageTitles")
    public String getPageTitles(){
        return titleRepository.findById(1).get().getTitle();
    }

    @GetMapping("/pageTitles/{id}")
    public String getPageTitle(@PathVariable Integer id){
        return titleRepository.findById(id).get().getTitle();
    }

}
