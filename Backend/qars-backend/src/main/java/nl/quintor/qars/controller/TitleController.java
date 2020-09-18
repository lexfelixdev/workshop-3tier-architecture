package nl.quintor.qars.controller;

import nl.quintor.qars.repository.Title;
import nl.quintor.qars.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
//@CrossOrigin("http://localhost:4200")
public class TitleController {

    private TitleRepository titleRepository;

    @Autowired
    public TitleController(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping("/pageTitles/{id}")
    public String getPageTitles(@PathVariable("id") Integer id){
        Optional<Title> optionalTitle = this.titleRepository.findById(id);
        if(optionalTitle.isPresent()){
            return optionalTitle.get().getTitle();
        }
        return "No String found";
    }
}
