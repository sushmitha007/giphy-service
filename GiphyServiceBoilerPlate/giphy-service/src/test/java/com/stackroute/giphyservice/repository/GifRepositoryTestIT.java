package com.stackroute.giphyservice.repository;


import com.stackroute.giphyservice.domain.Gif;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GifRepositoryTestIT {

    @Autowired
    private  GifRepository gifRepository;

    private Gif gif;

    @Before
    public void setUp() {
        gif = new Gif();
        gif.setGifId(10l);
        gif.setGiphyId("gif123");
        gif.setType("gif");
        gif.setGifUrl("http:url");
        gif.setGifDetails("https:details");
        gif.setTitle("cheeseburger");
        gif.setCaption("awesome");
        gif.setUserName("user1");
        gif.setRating("g");
        gif.setCreatedOn("2018-10-11");

    }

    @After
    public void tearDown() {
        gif = null;
        gifRepository.deleteAll();
    }
    @Test
    public void testSaveGifSuccess() {
        gifRepository.save(gif);
        Gif fetchGif =gifRepository.findByGiphyId(gif.getGiphyId());
        Assert.assertEquals(fetchGif.getTitle(),gif.getTitle());
    }

    @Test
    public void testUpdateCaptionSuccess(){
        gifRepository.save(gif);
        Gif fetchGif = gifRepository.findByGiphyId(gif.getGiphyId());
        fetchGif.setCaption("updating the caption");
        gifRepository.save(fetchGif);
        Gif newGif = gifRepository.findByGiphyId(gif.getGiphyId());
        Assert.assertEquals("updating the caption" , newGif.getCaption());
    }
    @Test
    public void testDeleteGifSuccess() {
        gifRepository.save(gif);
        Gif fetchGif = gifRepository.findByGiphyId(gif.getGiphyId());
        gifRepository.delete(fetchGif);
        Assert.assertEquals(Optional.empty(), gifRepository.findById(gif.getGifId()));
    }

    @Test
    public void testGetAllGifs() {
        gifRepository.save(gif);
        gif.setGifId(20l);
        gif.setGiphyId("gif125");
        gif.setType("gif");
        gif.setGifUrl("http:url");
        gif.setGifDetails("https:details");
        gif.setTitle("burgerking");
        gif.setCaption("awesome");
        gif.setUserName("user2");
        gif.setRating("g");
        gif.setCreatedOn("2017-03-11");
        gifRepository.save(gif);
        List<Gif> gifList = gifRepository.findAll();
        Assert.assertEquals(2,gifList.size());
        Assert.assertEquals("gif125",gifList.get(0).getGiphyId());

    }


}
