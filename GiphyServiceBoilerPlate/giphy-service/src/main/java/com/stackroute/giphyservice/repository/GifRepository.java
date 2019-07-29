package com.stackroute.giphyservice.repository;

import com.stackroute.giphyservice.domain.Gif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GifRepository extends JpaRepository<Gif, Long> {

    /*
     * Apart from the standard CRUD methods already available in Jpa Repository,
     * based on our requirements, we might need to create few methods for getting
     * specific data from the datasource.
     */

    /*
     * This method will search for gif of given giphyId
     */

    Gif findByGiphyId(String GiphyId);
}
