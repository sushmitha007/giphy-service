package com.stackroute.giphyservice.repository;

import com.stackroute.giphyservice.domain.Gif;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GifRepository extends JpaRepository<Gif, Long> {
    Gif findByGiphyId(String GiphyId);
}
