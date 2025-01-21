package vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.models.Song;
import vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.services.SongsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/songs")
public class SongsController {
    @Autowired
    private SongsService ss;

    //TO LOAD THE PAGE
    @GetMapping("/search")
    public String displaySongsSearchForm(Model model) {
        
        List<Integer> resultsYears = ss.getAllSongsDistinctYears();

        model.addAttribute("results", resultsYears);
        return "search";
    }

    //ON FORM SUBMISSION
    @PostMapping("/search")
    public String formPost(@RequestParam("selectedYear") String selectedYear, Model model) {

        System.out.println(selectedYear);
        int sub = Integer.parseInt(selectedYear);
        //selectedYear=1952
        // String subo = selectedYear.substring(13);
        // System.out.println(subo);

        // int sub = Integer.parseInt(subo);

        List<Document> allSongsSelectedYear = ss.getSongsSelectedYear(sub); 

        List<Song> songResults = new ArrayList<>();

        //process the List<Document> into List<Song>
        for (int i = 0; i < allSongsSelectedYear.size();i++){
            Song s = new Song();

            Document aSong = allSongsSelectedYear.get(i);
            
            int ryear = Integer.parseInt(aSong.get("released_year").toString());
            String artiste = aSong.get("artist(s)_name").toString();
            String song = aSong.get("track_name").toString();

            s.setYear(ryear);
            s.setArtiste(artiste);
            s.setSongName(song);

            songResults.add(s);

            System.out.println(songResults.toString());
        }
        model.addAttribute("year", sub);
        model.addAttribute("results", songResults);
        return "list";
    }
    
    
}
