package vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static vttp.b5.paf.day6.classworkshop.Day6.Class.Workshop.Spotify.Songs.repositories.Constants.*;

@Repository
public class SongsRepository {

    @Autowired
    private MongoTemplate template; 

    public List<Integer> getAllSongsDistinctYears(){
        
        // db.songs.distinct("released_year")
        // to get the list of year to populate the form dropdown selection options

        Criteria criterial = new Criteria();
        Query query = new Query();
        query.addCriteria(criterial);

        return template.findDistinct(query, F_RELEASED_YEAR, F_COLLECTION, Integer.class);
    }

    public List<Document> getSongsSelectedYear(Integer year) {

        //  db.songs.find({
        //  "released_year": {$eq: 2022}
        // })

        Criteria criterial = Criteria.where(F_RELEASED_YEAR).is(year);
        
        Query query = Query.query(criterial);

        List<Document> results = template.find(query,Document.class, "songs");

        return results;
    }
}
