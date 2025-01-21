package vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.repositories.SongsRepository;

@Service
public class SongsService {
    
    @Autowired
    private SongsRepository sr;

    public List<Integer> getAllSongsDistinctYears(){
        return sr.getAllSongsDistinctYears();
    }

    public List<Document> getSongsSelectedYear(Integer year) {
        return sr.getSongsSelectedYear(year);
    }
}
